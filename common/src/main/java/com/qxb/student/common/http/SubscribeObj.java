package com.qxb.student.common.http;

import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public abstract class SubscribeObj<T> implements ObservableOnSubscribe<T> {

    @Override
    public void subscribe(ObservableEmitter<T> emitter) throws Exception {
        T t = queryLocal();
        if (t instanceof List) {
            List<?> list = (List<?>) t;
            if (list.size() == 0) {
                emitter.onComplete();
            } else {
                toNext(emitter, t, list.get(0).getClass());
            }
        } else {
            if (t == null) {
                emitter.onComplete();
            } else {
                toNext(emitter, t, t.getClass());
            }
        }
    }

    private void toNext(ObservableEmitter<T> emitter, T t, Class<?> clazz) {
        emitter.onNext(t);
        if (HttpUtils.getInstance().checkCacheTime(clazz)) {
            emitter.onComplete();
        }
    }

    protected abstract T queryLocal();
}
