package com.qxb.student.common.module;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.qxb.student.common.http.HttpResponse;
import com.qxb.student.common.http.HttpUtils;
import com.qxb.student.common.listener.TRunnable;
import com.qxb.student.common.module.api.SchoolApi;
import com.qxb.student.common.module.bean.ApiModel;
import com.qxb.student.common.module.bean.School;
import com.qxb.student.common.module.dao.HttpCacheDao;
import com.qxb.student.common.module.dao.RoomUtils;
import com.qxb.student.common.utils.ExecutorUtils;
import com.qxb.student.common.utils.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository extends BaseRepository {

    public Observable<ApiModel<List<School>>> getSchoolLiveData(String province) {
        Logger.getInstance().e("getSchoolLiveData");
        return HttpUtils.create(SchoolApi.class).getRecommendedCollegeList(province)
                .subscribeOn(Schedulers.io())
                .doOnNext(new Consumer<ApiModel<List<School>>>() {
                    @Override
                    public void accept(ApiModel<List<School>> listApiModel) throws Exception {
                        Logger.getInstance().e("SchoolRepository  doOnNext");
                        addCache(School.class, listApiModel.getCacheTime());
                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
                    }
                });
//                .subscribe();
//        Disposable disposable = Observable.create(new ObservableOnSubscribe<List<School>>() {
//            @Override
//            public void subscribe(ObservableEmitter<List<School>> emitter) {
//                System.out.print("subscribe threadName:" + Thread.currentThread().getName());
//                if (!checkCacheTime(School.class)) {
//                    List<School> schoolList = roomUtils.schoolDao().getRecommendedColleges();
//                    if (schoolList == null || schoolList.size() == 0) {
//                        emitter.onComplete();
//                    } else {
//                        emitter.onNext(schoolList);
//                    }
//                } else {
//                    emitter.onComplete();
//                }
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(new Consumer<List<School>>() {
//                    @Override
//                    public void accept(List<School> schools) throws Exception {
//                        System.out.print("doOnNext threadName:" + Thread.currentThread().getName());
//                        finalLiveData.setValue(schools);
//                    }
//                }).doOnComplete(new Action() {
//                    @Override
//                    public void run() throws Exception {
//        HttpUtils.getInstance().request(observable, new HttpResponse<ApiModel<List<School>>>() {
//            @Override
//            public void success(ApiModel<List<School>> result) {
//                System.out.print("success threadName:" + Thread.currentThread().getName());
//                executorUtils.addTask(new TRunnable<ApiModel<List<School>>>(result) {
//                    @Override
//                    public void run(ApiModel<List<School>> listApiModel) {
//                        addCache(School.class, listApiModel.getCacheTime());
//                        roomUtils.schoolDao().insertColleges(listApiModel.getData());
//                    }
//                });
//            }
//
//            @Override
//            public void failed(Throwable throwable) {
//                System.out.print("Throwable threadName:" + Thread.currentThread().getName());
//            }
//        });
//                    }
//                }).subscribe();
//        return observable;
    }
}
