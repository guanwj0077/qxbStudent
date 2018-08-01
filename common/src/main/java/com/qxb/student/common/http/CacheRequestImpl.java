package com.qxb.student.common.http;

import android.support.annotation.NonNull;

import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.JsonUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

import static com.qxb.student.common.http.MyCache.ENTRY_METADATA;

/**
 * @author winky
 * @date 2018/8/1
 */
public class CacheRequestImpl implements CacheRequest {

    private static final Object OBJECT = new Object();
    private final DiskLruCache.Editor editor;
    private final Sink cacheOut;
    private final ForwardingSink body;
    private boolean done;
    private static final Charset charset = Charset.forName("UTF-8");

    CacheRequestImpl(@NonNull DiskLruCache diskLruCache, @NonNull String key) throws IOException {
        this.editor = diskLruCache.edit(key);
        if (editor == null) {
            throw new IllegalArgumentException();
        }
        this.cacheOut = editor.newSink(ENTRY_METADATA);
        this.body = new ForwardingSink(cacheOut) {

            @Override
            public void flush() throws IOException {
                super.flush();
            }

            @Override
            public void write(@NonNull Buffer source, long byteCount) throws IOException {
                Buffer buffer = source.clone();
                super.write(source, byteCount);
                String bodyContent = buffer.clone().readString(charset);
                ApiModel apiModel = JsonUtils.getInstance().toBean(bodyContent, ApiModel.class);
                if (apiModel != null) {
                    long cacheTime = System.currentTimeMillis() + apiModel.getCacheTime();
                    buffer.writeString(String.valueOf(cacheTime), charset);
                    buffer.writeString(apiModel.toString(), charset);
                    cacheOut.write(buffer, buffer.size());
                }
                cacheOut.close();
            }

            @Override
            public void close() throws IOException {
                synchronized (OBJECT) {
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
        synchronized (OBJECT) {
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
