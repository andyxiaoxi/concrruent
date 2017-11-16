package com.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/25.
 */
public class TestFuture {
    public static void main(String[] args){
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> future = pool.submit(new TestTask());

        while (!future.isDone()){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("主线程等待1s");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            int c =future.get();
            System.out.println("异步结果"+c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class TestTask implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            int a = 10;
            int b = 20;

            int result = a+b;

            TimeUnit.SECONDS.sleep(5);      //模拟耗时
            return result;
        }
    }
}
