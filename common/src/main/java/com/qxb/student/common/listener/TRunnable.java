package com.qxb.student.common.listener;

/**
 * @author winky
 * @date 2018/5/6
 */
public abstract class TRunnable<T> implements Runnable {

    private T t;

    protected TRunnable(T t) {
        this.t = t;
    }

    @Override
    public void run() {
        this.run(t);
    }

    /**
     * 待处理
     * @param item 事件对象
     */
    public abstract void run(T item);
}
