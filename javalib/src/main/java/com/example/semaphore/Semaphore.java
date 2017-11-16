package com.example.semaphore;

/**
 * Created by Administrator on 2017/7/20.
 */
public class Semaphore {
    private boolean single = false;

    public synchronized void take(){
        single = true;
        notify();
    }


    public synchronized void release() throws InterruptedException {
        while(!single){
            wait();
        }
        single = false;
    }
}
