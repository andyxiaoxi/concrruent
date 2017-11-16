package com.example.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/19.
 */
public class TestThreadLocal  {
    public static void main(String[] args){
        ThreadLocal<String> local = new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return "initial value";
            }
        };
        new Thread(){
            @Override
            public void run() {
                System.out.println("threadlocal1 initial"+local.get());
                local.set("修改值");
            }
        }.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(){
            @Override
            public void run() {
                System.out.println("threadlocal2 initial"+local.get());
                local.set("修改值");
            }
        }.start();

    }


}
