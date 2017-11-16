package com.example;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Administrator on 2017/7/18.
 */
public class MyLock {
    public AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock(){
        return locked.compareAndSet(false,true);
    }

    public  boolean test;


    public void setTest(boolean test) {
        this.test = test;
    }
}
