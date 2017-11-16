package com.example.inter;

import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/7/25.
 */
public interface IFuture<T> extends Future<T>{
    boolean isSuccess();

    void addListener();

    void removeListener();
}
