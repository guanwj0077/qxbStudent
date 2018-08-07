package com.qxb.student.common;

import com.qxb.student.common.http.AuthInterceptor;
import com.qxb.student.common.http.JsonConverterFactory;
import com.qxb.student.common.module.TestApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.Encrypt;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addInterceptor(new AuthInterceptor());
            OkHttpClient okHttpClient = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.qiuxuebao.com/api/")
                    .callFactory(okHttpClient)
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(new JsonConverterFactory())
                    .build();

            TestApi testApi = retrofit.create(TestApi.class);
            Map<String, String> params = new HashMap<>();
            params.put("type", "1");
            params.put("newsId", "7312");
            params.put("tag", "1");
            ApiModel<String> apiModel = testApi.connectSchool(params).execute().body();
            if (apiModel != null) {
                System.out.println(apiModel.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}