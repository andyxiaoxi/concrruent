package com.example.customer;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2017/7/25.
 * <p/>
 * 获取工作线程的结果
 */
public class ThjResultTask implements Runnable {

    private List<Future> futures;

    public ThjResultTask(List<Future> futures) {
        this.futures = futures;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (futures) {

                for(int i = 0; i<futures.size();i++){
                    Future temp = futures.get(i);
                    if(temp.isDone()){
                        try {
                            int obj = (int) temp.get();
                            System.out.println("结果线程获取到的结果：" + obj);
                            futures.remove(temp);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        }
    }
}
