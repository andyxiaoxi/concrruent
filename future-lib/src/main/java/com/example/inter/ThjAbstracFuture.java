package com.example.inter;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2017/7/25.
 */
public class ThjAbstracFuture implements ThjFuture,Runnable {
    private Object result;

    private Callable callable;

    private ThjFutureListener mThjFutureListener;

    private Thread thread;

    public ThjAbstracFuture(Callable callable) {
        this.callable = callable;
        thread = Thread.currentThread();
    }

    /**
     * 线程成功运行的结果
     */
    private volatile boolean  SUCCESS;

    @Override
    public Object get() {
        if(!SUCCESS){
            //没有成功堵塞
            LockSupport.park();
        }
        return result;
    }

    @Override
    public void addListener(ThjFutureListener listener) {
        mThjFutureListener = listener;
    }

    /**
     * 设置结果
     */
    private void set(){
        if(SUCCESS){
            LockSupport.unpark(thread);
        }
    }

    @Override
    public void run() {
        try {
            Object result = callable.call();
            SUCCESS=true;
            this.result = result;
            set();
            if(mThjFutureListener!=null) {
                mThjFutureListener.operationComplete(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否线程执行完了
     * @return
     */
    public boolean isDone(){
        return SUCCESS;
    }
}
