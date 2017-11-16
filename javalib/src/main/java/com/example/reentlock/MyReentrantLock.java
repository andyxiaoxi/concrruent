package com.example.reentlock;

/**
 * Created by Administrator on 2017/7/20.
 */
public class MyReentrantLock {
    private boolean isLocked = false;       //信号状态

    private Thread lockedBy = null;         //被锁住的线程

    private int lockedCount =  0;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while(isLocked&&lockedBy!=callingThread){
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = Thread.currentThread();
    }



    public synchronized void unlock(){
        if(Thread.currentThread()==lockedBy){
            lockedCount--;
            if(lockedCount==0) {
                isLocked = false;
                notify();
            }
        }

    }
}
