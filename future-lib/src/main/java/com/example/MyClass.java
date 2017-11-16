package com.example;

import com.example.inter.ThjAbstracFuture;
import com.example.inter.ThjFuture;


import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyClass {

    public static void main(String[] args){
        ThjAbstracFuture future = new ThjAbstracFuture(new ThjCallable());

        future.addListener(new ThjFuture.ThjFutureListener() {
            @Override
            public void operationComplete(ThjAbstracFuture thjFuture) {
                if(thjFuture.isDone()){
                    System.out.println("获取线程的结果："+thjFuture.get());
                }
            }
        });

        new Thread(future).start();

        String rlt= (String) future.get();

        System.out.println(rlt);
    }

    static class ThjCallable implements Callable<String>{


        @Override
        public String call() throws Exception {
            TimeUnit.SECONDS.sleep(30);
            return "future test";
        }
    }
}
