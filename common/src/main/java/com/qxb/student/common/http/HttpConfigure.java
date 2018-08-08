package com.qxb.student.common.http;

import android.annotation.SuppressLint;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qxb.student.common.Config;
import com.qxb.student.common.utils.ContextUtils;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.internal.Internal;
import retrofit2.Retrofit;

/**
 * http初始化缓存
 *
 * @author winky
 */
public class HttpConfigure {

    private final HttpUrl httpUrl;
    private final Call.Factory callFactory;
    private final Retrofit retrofit;
    private final Context context;

    HttpConfigure(Context context, HttpUrl httpUrl, Call.Factory callFactory, Retrofit retrofit) {
        this.context = context;
        this.httpUrl = httpUrl;
        this.callFactory = callFactory;
        this.retrofit = retrofit;
    }

    public Context getContext() {
        return context;
    }

    public HttpUrl getHttpUrl() {
        return httpUrl;
    }

    public Call.Factory getCallFactory() {
        return callFactory;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class Builder {
        private HttpUrl httpUrl;

        public Builder baseUrl(String url) {
            httpUrl = HttpUrl.parse(url);
            return this;
        }

        public HttpConfigure build() {
            Context context = ContextUtils.getInstance().getContext();
            if (context == null) {
                throw new IllegalArgumentException("context must be not empty");
            }
            if (httpUrl == null) {
                httpUrl = HttpUrl.parse(Config.SERVER_URL);
            }
            OkHttpClient okHttpClient;
            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
                OkHttpClient.Builder builder = new OkHttpClient.Builder()
                        //设置一个自动管理cookies的管理器
                        .cookieJar(new CookieManager(context))
                        //设置套接字工厂
                        .sslSocketFactory(sslContext.getSocketFactory(), trustManager)
                        //设置计算机验证
                        .hostnameVerifier(hostnameVerifier)
                        .addInterceptor(new AuthInterceptor())
                        //设置请求读写的超时时间
                        .connectTimeout(60, TimeUnit.SECONDS)
                        .writeTimeout(60, TimeUnit.SECONDS)
                        .readTimeout(60, TimeUnit.SECONDS);
                Internal.instance.setCache(builder, HttpCache.getInstance());
                okHttpClient = builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                okHttpClient = new OkHttpClient();
            }
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Objects.requireNonNull(httpUrl))
                    .callFactory(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(new JsonConverterFactory())
                    .build();
            return new HttpConfigure(context, httpUrl, okHttpClient, retrofit);
        }

        private HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @SuppressLint("BadHostnameVerifier")
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        private X509TrustManager trustManager = new X509TrustManager() {
            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

}
