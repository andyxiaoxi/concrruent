package com.example.producer;

import com.example.inter.IFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/25.
 */
public class TestFutureGet  {
    public static void main(String[] args){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future future =  pool.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                TimeUnit.SECONDS.sleep(2000);
                return null;
            }
        });


        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
