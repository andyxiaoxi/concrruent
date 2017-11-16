package com.example.customer;

import com.example.data.ThjLinkQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by Administrator on 2017/7/24.
 */
public class ThjCustomer {
    private ThjLinkQueue mQueue;

    private ExecutorService pool;

    private List<Future> futures;


    public ThjCustomer(ThjLinkQueue mQueue) {
        this.mQueue = mQueue;
        pool = Executors.newFixedThreadPool(4);
        futures = new ArrayList<>();

    }

    public List<Future> getFutures() {
        return futures;
    }

    /**
     * 提交任务
     * @param runnable
     */
    public void submit(Callable runnable){
         Future future = pool.submit(runnable);

         synchronized (futures) {
            futures.add(future);
         }
    }

    /**
     * 获取线程的结果
     * @param r
     */
    public void executor(Runnable r){
        pool.execute(r);
    }



}
