package com.example.listener;

/**
 * Created by Administrator on 2017/7/26.
 */
public interface Data {
    String getResult();
    void addListener(DataListener dataListener);

    interface DataListener{
       void complete(Data data);
    }
}
