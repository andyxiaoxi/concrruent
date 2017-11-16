package com.example.listener;

/**
 * Created by Administrator on 2017/7/26.
 */
public class FutureData implements Data {

    private RealData realData;

    private boolean isready;

    private DataListener mDataListener;

    @Override
    public synchronized String getResult() {
        while(!isready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.real;
    }

    @Override
    public void addListener(DataListener dataListener) {
        mDataListener = dataListener;
    }


    public synchronized void setRealData(RealData realData){
        this.realData = realData;
        isready =true;
        mDataListener.complete(this);
        notify();
    }


}
