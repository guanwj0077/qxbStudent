package com.qxb.student.common;

import com.qxb.student.common.http.AuthInterceptor;
import com.qxb.student.common.http.JsonConverterFactory;
import com.qxb.student.common.module.TestApi;
import com.qxb.student.common.module.bean.ApiModel;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.internal.Internal;
import retrofit2.Retrofit;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor());
            File file = new File("cache");
            Internal.instance.setCache(builder, new HttpCache(file));
            OkHttpClient okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.qiuxuebao.com/api/")
                    .callFactory(okHttpClient)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(new JsonConverterFactory())
                    .build();

            TestApi testApi = retrofit.create(TestApi.class);
            ApiModel<String> apiModel = testApi.getLiveHomeAd().execute().body();
//            Request request = new Request.Builder()
//                    .url("https://api.qiuxuebao.com/api/")
//                    .post(new FormBody.Builder().build())
//                    .addHeader("Authorization", Config.AUTH_COMMON_SECRET)
//                    .build();
//            Call call = okHttpClient.newCall(request);
            if (apiModel != null) {
                System.out.println(apiModel.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}