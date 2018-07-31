package com.qxb.student.common;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qxb.student.common.http.AuthInterceptor;
import com.qxb.student.common.http.JsonConverterFactory;
import com.qxb.student.common.module.TestApi;
import com.qxb.student.common.module.bean.ApiModel;

import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.qiuxuebao.com/api/")
                .callFactory(new OkHttpClient.Builder().addInterceptor(new AuthInterceptor()).build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(new JsonConverterFactory())
                .build();

        TestApi testApi = retrofit.create(TestApi.class);
        try {
            ApiModel<String> apiModel = testApi.getLiveHomeAd().execute().body();
            System.out.println(apiModel.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}