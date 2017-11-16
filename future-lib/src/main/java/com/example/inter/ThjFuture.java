package com.example.inter;

/**
 * Created by Administrator on 2017/7/25.
 */
public interface ThjFuture<T> {
    T get();

    void addListener(ThjFutureListener listener);


    interface ThjFutureListener{
        void operationComplete(ThjAbstracFuture thjFuture);
    }
}


