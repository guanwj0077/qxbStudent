package com.qxb.student.common.http;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.InternalCache;

/**
 * @author winky
 * @date 2018/7/30
 */
public class HttpCache implements InternalCache {
    @Override
    public Response get(Request request) throws IOException {
        return null;
    }

    @Override
    public CacheRequest put(Response response) throws IOException {
        return null;
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
}
