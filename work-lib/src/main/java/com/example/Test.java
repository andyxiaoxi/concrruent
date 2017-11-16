package com.example;

import com.example.customer.ThjCustomer;
import com.example.customer.ThjResultTask;
import com.example.customer.ThjTask;
import com.example.data.ThjLinkQueue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/25.
 */
public class Test {
    public static void main(String []args){
        ThjLinkQueue pdate = new ThjLinkQueue();

        //3个工作任务
        ThjTask w1 = new ThjTask<Integer>(){
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(1);

                int a = new Random().nextInt(100);
                System.out.println("线程睡1秒"+"线程的运行结果:  "+a);
                return a;
            }
        };
        ThjTask w2 = new ThjTask<Integer>(){
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(2);
                int a = new Random().nextInt(100);
                System.out.println("线程睡2秒"+"线程的运行结果:  "+a);
                return a;
            }
        };
        ThjTask w3 = new ThjTask<Integer>(){
            @Override
            public Integer call() throws Exception {
                TimeUnit.SECONDS.sleep(3);
                int a = new Random().nextInt(100);
                System.out.println("线程睡3秒"+"线程的运行结果:  "+a);
                return a;
            }
        };

        ThjCustomer customer = new ThjCustomer(pdate);

        customer.submit(w1);
        customer.submit(w2);
        customer.submit(w3);

        //结果任务
        ThjResultTask resultTask = new ThjResultTask(customer.getFutures());

        customer.executor(resultTask);
    }
}
