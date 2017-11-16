package com.example.listener;

/**
 * Created by Administrator on 2017/7/26.
 */
public class Client {
    public Data request(String param){
        FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(param);
                futureData.setRealData(realData);
            }
        }

        ).start();
        return  futureData;
    }
}
