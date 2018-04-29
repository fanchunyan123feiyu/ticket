package com.sxzhwts.ticket.common.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 作者：fcy on 2018/4/14 13:06
 * 线程池代理类
 */

public class ThreadPoolProxy {
    ThreadPoolExecutor mThreadPoolExecutor;

    private int corePoolSize;
    private int maximumPoolSize;
    private long keepAliveTime;
    private TimeUnit unit;

    public ThreadPoolProxy(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        this.corePoolSize = corePoolSize;
        this.maximumPoolSize = maximumPoolSize;
        this.keepAliveTime = keepAliveTime;
        this.unit = unit;
    }

    private ThreadPoolExecutor initExecutor() {
        if (mThreadPoolExecutor == null) {
            synchronized ((ThreadPoolProxy.class)) {
                ThreadFactory threadFactory = Executors.defaultThreadFactory();
                RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
                LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
                mThreadPoolExecutor = new ThreadPoolExecutor(
                        corePoolSize,//核心线程数
                        maximumPoolSize,//最大线程数
                        keepAliveTime,//保持时间
                        unit,//保持时间对应的单位
                        workQueue,
                        threadFactory,//线程工厂
                        handler);//异常捕获器
            }
        }
        return  mThreadPoolExecutor;
    }
    public  void executeTask(Runnable r){
        initExecutor();
        mThreadPoolExecutor.execute(r);
    }

    /**提交任务*/
    public Future<?> commitTask(Runnable r) {
        initExecutor();
        return mThreadPoolExecutor.submit(r);
    }

    /**删除任务*/
    public void removeTask(Runnable r) {
        initExecutor();
        mThreadPoolExecutor.remove(r);
    }
}
