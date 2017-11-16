package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/21.
 */
public class blockqueue {
    private List queue = new LinkedList<>();

    private int limit = 10;

    public blockqueue(int limit) {
        this.limit = limit;
    }

    public synchronized void equeue(Object item) throws InterruptedException {
        while (queue.size() == limit) {
            wait();
        }

        if (queue.size() == 0) {
            notifyAll();
        }
        queue.add(item);
    }


    public synchronized Object dequeue() throws InterruptedException {
        while (queue.size()==0){
            wait();
        }
        if(queue.size()==limit){
            notifyAll();
        }
        return queue.remove(0);
    }
}
