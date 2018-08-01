package com.qxb.student.common.http;

import android.content.Context;

import com.qxb.student.common.utils.Encrypt;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;

/**
 * @author winky
 * @date 2018/8/1
 */
public class MyCache implements InternalCache {

    private final int VERSION = 20180801;
    public static final int ENTRY_METADATA = 0;
    private final DiskLruCache diskLruCache;

    private static final Object OBJECT = new Object();

    MyCache(Context context) {
        File file = new File(context.getExternalCacheDir(), "httpCache");
        this.diskLruCache = DiskLruCache.create(FileSystem.SYSTEM, file, VERSION, 2, 10 * 1024 * 1024);
    }

    public MyCache(File file) {
        this.diskLruCache = DiskLruCache.create(FileSystem.SYSTEM, file, VERSION, 2, 10 * 1024 * 1024);
    }

    @Override
    public Response get(Request request) throws IOException {
        String key = judgeUrl(request);
        DiskLruCache.Snapshot snapshot = null;
        BufferedSource source = null;
        try {
            snapshot = diskLruCache.get(key);
            if (snapshot == null) {
                return null;
            }
            source = Okio.buffer(snapshot.getSource(ENTRY_METADATA));

            return null;
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
        try {
            return new CacheRequestImpl(diskLruCache, judgeUrl(response.request()));
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void remove(Request request) throws IOException {

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

}
