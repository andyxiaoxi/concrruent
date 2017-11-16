package com.example.fairlock;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/7/19.
 * 公平锁，锁对象，要被多个线程调用
 */
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private ArrayList<QueueObject> waittingThread = new ArrayList<>();


    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        boolean isLockedForThisThread = true;
        synchronized (this){
            waittingThread.add(queueObject);
        }

        while(isLockedForThisThread){       //为什么要加入while循环
           synchronized (this){
               isLockedForThisThread = isLocked||waittingThread.get(0)!=queueObject;
               if(!isLockedForThisThread){
                   isLocked=true;
                   lockingThread = Thread.currentThread();
                   waittingThread.remove(queueObject);
                   System.out.println(Thread.currentThread().getName()+" invoke lock");
                   return;
               }
           }
            try {
                System.out.println(Thread.currentThread().getName()+" block "+queueObject.toString());
                queueObject.dowait();

            } catch (InterruptedException e) {
                synchronized (this){
                    waittingThread.remove(queueObject);
                }
                throw e;
            }
        }


    }


    public synchronized void unlock(){
        if(this.lockingThread!=Thread.currentThread()){
            throw new IllegalMonitorStateException("Calling thread is not hava lock");
        }
        isLocked =false;
        lockingThread = null;
        if(waittingThread.size()>0){
            System.out.println(Thread.currentThread().getName()+" unlock "+" single=" +waittingThread.get(0).toString());
            waittingThread.get(0).donotify();
        }
    }
}


class QueueObject{
    private boolean isNotified = false;            //这个干什么的

    public synchronized void dowait() throws InterruptedException {
        while(!isNotified){
            this.wait();
        }

        //清除信号
        isNotified =false;
    }

    public synchronized void donotify(){           //为什么要加入synchronized
        isNotified =true;
        this.notify();
    }

    @Override
    public boolean equals(Object obj) {
        return this==obj;
    }
}