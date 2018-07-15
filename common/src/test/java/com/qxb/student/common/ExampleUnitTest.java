package com.qxb.student.common;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qxb.student.common.module.api.AdvertApi;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;

import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SchoolApi schoolApi = retrofit.create(SchoolApi.class);
        Observable<ApiModel<List<School>>> observable = schoolApi.getRecommendedColleges("26","42000");
        observable
//                .subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                    }
                })
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ApiModel<List<School>>>() {
                    @Override
                    public void accept(ApiModel<List<School>> t) throws Exception {
                        System.out.println("success:" + t.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        System.out.println(throwable.getMessage());
                    }
                });

    }
}