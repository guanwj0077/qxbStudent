package com.qxb.student.common.http;

import android.content.Context;
import android.support.annotation.Nullable;

import com.qxb.student.common.Config;
import com.qxb.student.common.utils.Encrypt;

import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

import static java.net.HttpURLConnection.HTTP_OK;

/**
 * DiskLruCache缓存数据实现
 *
 * @author winky
 * @date 2018/7/30
 */
public class HttpCache implements InternalCache {

    private static final String CACHE_DIR = "httpCache";

    /**
     * Synthetic response header: the local time when the request was sent.
     */
    private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";

    /**
     * Synthetic response header: the local time when the response was received.
     */
    private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";

    private static final int VERSION = 20180731;
    private static final int ENTRY_METADATA = 0;

    private final DiskLruCache cache;

    public HttpCache(Context context) {
        File file = new File(context.getExternalCacheDir(), CACHE_DIR);
        this.cache = DiskLruCache.create(FileSystem.SYSTEM, file, VERSION, 2, 10 * 1024 * 1024);
    }

    @Override
    public Response get(Request request) {
        String key = judgeUrl(request);
        DiskLruCache.Snapshot snapshot = null;
        BufferedSource source = null;
        try {
            snapshot = cache.get(key);
            if (snapshot == null) {
                return null;
            }
            source = Okio.buffer(snapshot.getSource(ENTRY_METADATA));
            ResponseBody responseBody = ResponseBody.create(Config.MEDIA_TYPE, source.readUtf8LineStrict());
            Headers.Builder varyHeadersBuilder = new Headers.Builder();
            int varyRequestHeaderLineCount = readInt(source);
            for (int i = 0; i < varyRequestHeaderLineCount; i++) {
                varyHeadersBuilder.add(source.readUtf8LineStrict());
            }
            Headers.Builder responseHeadersBuilder = new Headers.Builder();
            int responseHeaderLineCount = readInt(source);
            for (int i = 0; i < responseHeaderLineCount; i++) {
                responseHeadersBuilder.add(source.readUtf8LineStrict());
            }
            String sendRequestMillisString = responseHeadersBuilder.get(SENT_MILLIS);
            String receivedResponseMillisString = responseHeadersBuilder.get(RECEIVED_MILLIS);
            responseHeadersBuilder.removeAll(SENT_MILLIS);
            responseHeadersBuilder.removeAll(RECEIVED_MILLIS);
            Handshake handshake = null;
            if (isHttps(request)) {
                String cipherSuiteString = source.readUtf8LineStrict();
                CipherSuite cipherSuite = CipherSuite.forJavaName(cipherSuiteString);
                List<Certificate> peerCertificates = readCertificateList(source);
                List<Certificate> localCertificates = readCertificateList(source);
                TlsVersion tlsVersion = !source.exhausted()
                        ? TlsVersion.forJavaName(source.readUtf8LineStrict())
                        : TlsVersion.SSL_3_0;
                handshake = Handshake.get(tlsVersion, cipherSuite, peerCertificates, localCertificates);
            }

            Request cacheRequest = request.newBuilder()
                    .headers(varyHeadersBuilder.build())
                    .build();
            return new Response.Builder()
                    .request(cacheRequest)
                    .protocol(Protocol.HTTP_1_1)
                    .code(HTTP_OK)
                    .message("Unsatisfiable Request (only-if-cached)")
                    .headers(responseHeadersBuilder.build())
                    .body(responseBody)
                    .handshake(handshake)
                    .sentRequestAtMillis(sendRequestMillisString != null
                            ? Long.parseLong(sendRequestMillisString)
                            : 0L)
                    .receivedResponseAtMillis(receivedResponseMillisString != null
                            ? Long.parseLong(receivedResponseMillisString)
                            : 0L)
                    .build();
        } catch (IOException e) {
            // Give up because the cache cannot be read.
            return null;
        } finally {
            if (source != null) {
                try {
                    source.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Util.closeQuietly(snapshot);
        }
    }

    @Override
    public CacheRequest put(Response response) {
        String key = judgeUrl(response.request());
        DiskLruCache.Editor editor = null;
        try {
            editor = cache.edit(key);
            if (editor == null) {
                return null;
            }
            BufferedSink sink = Okio.buffer(editor.newSink(ENTRY_METADATA));
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                //写返回json数据写入流
                sink.write(responseBody.source(), responseBody.contentLength()).writeUtf8("\n");
                //写响应头  仿Cache
                Headers varyHeaders = HttpHeaders.varyHeaders(response);
                sink.writeDecimalLong(varyHeaders.size()).writeByte('\n');
                for (int i = 0, size = varyHeaders.size(); i < size; i++) {
                    sink.writeUtf8(varyHeaders.name(i))
                            .writeUtf8(": ")
                            .writeUtf8(varyHeaders.value(i))
                            .writeByte('\n');
                }
                Headers responseHeaders = response.headers();
                sink.writeDecimalLong(responseHeaders.size() + 2).writeByte('\n');
                for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                    sink.writeUtf8(responseHeaders.name(i))
                            .writeUtf8(": ")
                            .writeUtf8(responseHeaders.value(i))
                            .writeByte('\n');
                }
                sink.writeUtf8(SENT_MILLIS)
                        .writeUtf8(": ")
                        .writeDecimalLong(response.sentRequestAtMillis())
                        .writeByte('\n');
                sink.writeUtf8(RECEIVED_MILLIS)
                        .writeUtf8(": ")
                        .writeDecimalLong(response.receivedResponseAtMillis());
                //写handshake  仿Cache
                if (isHttps(response.request())) {
                    sink.writeByte('\n');
                    sink.writeUtf8(response.handshake().cipherSuite().javaName())
                            .writeByte('\n');
                    writeCertList(sink, response.handshake().peerCertificates());
                    writeCertList(sink, response.handshake().localCertificates());
                    sink.writeUtf8(response.handshake().tlsVersion().javaName()).writeByte('\n');
                }
            }
            sink.close();
            return new CacheRequestImpl(editor);
        } catch (IOException e) {
            abortQuietly(editor);
            return null;
        }
    }

    private boolean isHttps(Request request) {
        return request.url().toString().startsWith("https://");
    }

    @Override
    public void remove(Request request) throws IOException {
        cache.remove(judgeUrl(request));
    }

    @Override
    public void update(Response cached, Response network) {

    }

    @Override
    public void trackConditionalCacheHit() {

    }

    @Override
    public void trackResponse(CacheStrategy cacheStrategy) {

    }

    private void abortQuietly(@Nullable DiskLruCache.Editor editor) {
        // Give up because the cache cannot be written.
        try {
            if (editor != null) {
                editor.abort();
            }
        } catch (IOException ignored) {
        }
    }

    private void writeCertList(BufferedSink sink, List<Certificate> certificates) throws IOException {
        try {
            sink.writeDecimalLong(certificates.size()).writeByte('\n');
            for (int i = 0, size = certificates.size(); i < size; i++) {
                byte[] bytes = certificates.get(i).getEncoded();
                String line = ByteString.of(bytes).base64();
                sink.writeUtf8(line).writeByte('\n');
            }
        } catch (CertificateEncodingException e) {
            throw new IOException(e.getMessage());
        }
    }

    private List<Certificate> readCertificateList(BufferedSource source) throws IOException {
        int length = readInt(source);
        if (length == -1) return Collections.emptyList(); // OkHttp v1.2 used -1 to indicate null.
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            List<Certificate> result = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                String line = source.readUtf8LineStrict();
                Buffer bytes = new Buffer();
                bytes.write(ByteString.decodeBase64(line));
                result.add(certificateFactory.generateCertificate(bytes.inputStream()));
            }
            return result;
        } catch (CertificateException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * 读取一行  内容为标记长度
     *
     * @param source
     * @return
     * @throws IOException
     */
    private int readInt(BufferedSource source) throws IOException {
        try {
            long result = source.readDecimalLong();
            String line = source.readUtf8LineStrict();
            if (result < 0 || result > Integer.MAX_VALUE || !line.isEmpty()) {
                throw new IOException("expected an int but was \"" + result + line + "\"");
            }
            return (int) result;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * 缓存key
     *
     * @param request 请求
     * @return key
     */
    private String judgeUrl(Request request) {
        try {
            Buffer buffer = new Buffer();
            Objects.requireNonNull(request.body()).writeTo(buffer);
            byte[] buff = new byte[(int) buffer.size()];
            buffer.inputStream().read(buff);
            String params = new String(buff, "UTF-8");
            String[] strings = params.split("&");
            StringBuilder builder = new StringBuilder();
            for (String str : strings) {
                //如果参数是  签名，时间戳，或key则剔除
                if (str.contains("sign=") || str.contains("timestamp=") || str.contains("secretKey=")) {
                    continue;
                }
                builder.append(str).append("&");
            }
            return Encrypt.md5(request.url().toString() + "?" + builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    private class CacheRequestImpl implements CacheRequest {
        private final DiskLruCache.Editor editor;
        private final Sink cacheOut;
        private final ForwardingSink body;
        boolean done;
        private static final int ENTRY_BODY = 1;

        CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.editor = editor;
            this.cacheOut = editor.newSink(ENTRY_BODY);
            this.body = new ForwardingSink(cacheOut) {
                @Override
                public void close() throws IOException {
                    synchronized (HttpCache.this) {
                        if (done) {
                            return;
                        }
                        done = true;
                    }
                    super.close();
                    editor.commit();
                }
            };
        }

        @Override
        public void abort() {
            synchronized (HttpCache.this) {
                if (done) {
                    return;
                }
                done = true;
            }
            Util.closeQuietly(cacheOut);
            try {
                editor.abort();
            } catch (IOException ignored) {
            }
        }

        @Override
        public Sink body() {
            return body;
        }
    }
}
