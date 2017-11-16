package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyClass {

    public static void main(String []args){
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(2);
        bq.offer(2);
        bq.offer(3);
        boolean flag =bq.offer(4);
        System.out.println(flag);

        try {
            bq.put(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
