package com.qxb.student.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qxb.student.common.http.AuthInterceptor;
import com.qxb.student.common.http.JsonConverterFactory;
import com.qxb.student.common.module.TestApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.utils.Encrypt;

import org.junit.Test;

import java.lang.reflect.Type;

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

//        SchoolApi schoolApi = retrofit.create(SchoolApi.class);
//        Observable<ApiModel<List<RecomSchool>>> observable = schoolApi.getRecommendedColleges("26","42000");
//        observable
////                .subscribeOn(Schedulers.io())
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                    }
//                })
////                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<ApiModel<List<RecomSchool>>>() {
//                    @Override
//                    public void accept(ApiModel<List<RecomSchool>> t) throws Exception {
//                        System.out.println("success:" + t.toString());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        System.out.println(throwable.getMessage());
//                    }
//                });

        TestApi testApi = retrofit.create(TestApi.class);
        Observable<ApiModel<String>> observable = testApi.CreateCode("15326622373", "1");
        observable.subscribe(new Consumer<ApiModel<String>>() {
            @Override
            public void accept(ApiModel<String> apiModel) throws Exception {
                System.out.println(apiModel.toString());
            }
        });

    }

    @Test
    public void test() {
//        String temp = "fdas897329hflsh*&929jdjksjk))8238901)_02821###889sjfdskal;11n;;``11;:sokd889223_938$&@^@!(19LWKfdj1112990)*&&!JK02010838ufdskll38x988**&*()ook";
//        System.out.println(Encrypt.base64(temp));
        String json = "{\"cacheTime\":0,\"code\":0,\"data\":{\"has_regist\":\"0\"},\"msg\":\"发送短信频率过快，请稍后再试！\",\"socailMsg\":0,\"total\":0}";
//        Gson gson = new Gson();
//        Type type = new TypeToken<ApiModel<JSONObject>>() {
//        }.getType();
        ApiModel jsonObject = JSONObject.parseObject(json,ApiModel.class);
        System.out.println(jsonObject.getData());
    }
}