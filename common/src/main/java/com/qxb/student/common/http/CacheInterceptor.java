package com.qxb.student.common.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author winky
 * @date 2018/7/30
 */
public class CacheInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//        if (!SysUtils.getInstance().isConnected()) {
//            request = request.newBuilder()
//                    .cacheControl(new CacheControl
//                            .Builder()
//                            .maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS)
//                            .onlyIfCached()
//                            .build()
//                    )
////                    .header("Cache-Control", "public, only-if-cached, max-stale=" + offlineCacheTime)
//                    .build();
//        }
        Response response = chain.proceed(request);
        return response;
    }
}
