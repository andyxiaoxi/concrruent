package com.example;

import com.example.listener.Client;
import com.example.listener.Data;


public class MyClass {

    public static void main(String[] args){
        Client client = new Client();
        //异步方法
         client.request("who").addListener(new Data.DataListener() {
            @Override
            public void complete(Data data) {
                //从这里直接拿取耗时线程的结果
                System.out.println(data.getResult());
            }
        });

       /* try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


    }
}
