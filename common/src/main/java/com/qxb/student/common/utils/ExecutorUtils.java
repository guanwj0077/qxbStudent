package com.qxb.student.common.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * @author winky
 */
public class ExecutorUtils {

    private static final Singleton<ExecutorUtils> SINGLETON = new Singleton<ExecutorUtils>() {
        @Override
        protected ExecutorUtils create() {
            return new ExecutorUtils();
        }
    };

    private final ThreadPoolExecutor threadPoolExecutor;
    private final LinkedBlockingQueue<Runnable> taskQueue;

    private boolean flag = true;

    public static ExecutorUtils getInstance() {
        return SINGLETON.get();
    }
    
    private ExecutorUtils() {
        RejectedExecutionHandler rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
                try {
                    taskQueue.put(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        this.threadPoolExecutor = new ThreadPoolExecutor(6, 30, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), rejectedHandler);
        this.taskQueue = new LinkedBlockingQueue<>();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (flag) {
                    Runnable task = null;
                    try {
                        task = taskQueue.take();
                        if (task != null) {
                            threadPoolExecutor.execute(task);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        this.threadPoolExecutor.execute(runnable);
    }


    public void addTask(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove(Runnable runnable) {
        taskQueue.remove(runnable);
    }

    public void clear() {
        taskQueue.clear();
        //设置标记 退出循环
        flag = false;
    }

}
