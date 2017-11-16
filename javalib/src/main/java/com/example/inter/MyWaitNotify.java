package com.example.inter;

/**
 * Created by Administrator on 2017/7/18.
 */
public class MyWaitNotify {
    private MyMonitor myMonitor = new MyMonitor();

    public void dowait(){
        synchronized (myMonitor){
            try {
                myMonitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void donotify(){
        synchronized (myMonitor){

            myMonitor.notify();
        }
    }
}

/**
 * 监视器对象
 */
class MyMonitor{

}