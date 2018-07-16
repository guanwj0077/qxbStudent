package com.qxb.student.common.http;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qxb.student.common.Config;
import com.qxb.student.common.utils.ContextUtils;

import java.io.File;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpConfigure {

    private final HttpUrl httpUrl;
    private final Call.Factory callFactory;
    private final Retrofit retrofit;
    private final Context context;

    public HttpConfigure(Context context, HttpUrl httpUrl, Call.Factory callFactory, Retrofit retrofit) {
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
        private Call.Factory callFactory;
        private Retrofit retrofit;
        private CookieJar cookieJar;

        public Builder baseUrl(String url) {
            httpUrl = HttpUrl.parse(url);
            return this;
        }

        public Builder callFactory(Call.Factory callFactory) {
            this.callFactory = callFactory;
            return this;
        }

        public Builder retrofit(Retrofit retrofit) {
            this.retrofit = retrofit;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            this.cookieJar = cookieJar;
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
            if (callFactory == null) {
                if (cookieJar == null) {
                    cookieJar = new CookieManager(context);
                }
                try {
                    File cacheDirectory = new File(context.getCacheDir().getAbsolutePath(), "cache");
                    Cache cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
                    SSLContext sslContext = SSLContext.getInstance("SSL");
                    sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
                    callFactory = new OkHttpClient.Builder()
                            //设置一个自动管理cookies的管理器
                            .cookieJar(cookieJar)
                            //设置套接字工厂
                            .sslSocketFactory(sslContext.getSocketFactory(), trustManager)
                            //设置计算机验证
                            .hostnameVerifier(hostnameVerifier)
                            //添加日志拦截器
                            .addInterceptor(new AuthInterceptor())
                            //添加网络连接器
                            //.addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                            //设置请求读写的超时时间
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .cache(cache)
                            .build();
                } catch (Exception e) {
                    e.printStackTrace();
                    callFactory = new OkHttpClient();
                }
            }
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(httpUrl)
                        .callFactory(callFactory)
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return new HttpConfigure(context, httpUrl, callFactory, retrofit);
        }

        private HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };

        private X509TrustManager trustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;
            }
        };
    }

}
