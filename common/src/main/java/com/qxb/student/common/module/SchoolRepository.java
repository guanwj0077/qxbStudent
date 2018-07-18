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

import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 学校数据仓库
 *
 * @author winky
 * @date
 */
public class SchoolRepository extends BaseRepository {

    public LiveData<List<School>> getSchoolLiveData(String province) {
        final MutableLiveData<List<School>> finalLiveData = new MutableLiveData<>();
        Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

//        if (checkCacheTime(School.class)) {
//            Observable<ApiModel<List<School>>> observable = HttpUtils.create(SchoolApi.class).getRecommendedCollegeList(province);
//
//            Disposable disposable = observable.subscribeOn(Schedulers.io())
//
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Consumer<ApiModel<List<School>>>() {
//                        @Override
//                        public void accept(ApiModel<List<School>> listApiModel) {
//
//                        }
//                    }, new Consumer<Throwable>() {
//                        @Override
//                        public void accept(Throwable throwable) {
//
//                        }
//                    });
//            HttpUtils.getInstance().request(observable, new HttpResponse<ApiModel<List<School>>>() {
//                @Override
//                public void success(ApiModel<List<School>> result) {
//                    if (result.getCode() == 1) {
//                        finalLiveData.setValue(result.getData());
//                        addCache(School.class, result.getCode());
//                        executorUtils.addTask(new TRunnable<List<School>>(result.getData()) {
//                            @Override
//                            public void run(List<School> schools) {
//                                roomUtils.schoolDao().insertColleges(schools);
//                            }
//                        });
//                    }
//                }
//
//                @Override
//                public void failed(Throwable throwable) {
//
//                }
//            });
//        } else {
//            finalLiveData.setValue(roomUtils.schoolDao().getRecommendedColleges());
//        }
        return finalLiveData;
    }
}
