package com.example.listener;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/26.
 */
public class RealData implements Data {
    public String real;
    public RealData(String param){
        real = param+"_real";
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getResult() {
        return real;
    }

    @Override
    public void addListener(DataListener dataListener) {

    }
}
