package com.example.fairlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/19.
 */
public class TestFairLock {
    public static void main(String[] args){
        Share share = new Share();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                share.test();
            }
        };

        new Thread(runnable,"thj-1").start();
        new Thread(runnable,"thj-2").start();
        new Thread(runnable,"thj-3").start();
    }

    static class Share {
        private FairLock lock = new FairLock();

        private int num =1;

        public void test(){
            try {
                lock.lock();
                num++;
                //TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                System.out.println(Thread.currentThread().getName()+" num=="+num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


}
