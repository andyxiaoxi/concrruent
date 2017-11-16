package com.example.data;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Administrator on 2017/7/24.
 */
public class ThjLinkQueue<T> {
    private BlockingQueue<T> mQueue;

    public ThjLinkQueue() {
        mQueue = new LinkedBlockingQueue<>();
    }

    public BlockingQueue<T> getmQueue() {
        return mQueue;
    }

    /**
     * 非组赛式的方法，多个线程访问，肯定还会组赛
     * 非组赛体现在，如果容量满了，那么调用此方法会马上返回
     * @param e
     * @return
     */
    public boolean add(T e){
        if(e ==null){
            throw new RuntimeException("element obejct is null");
        }
        return mQueue.offer(e);
    }

    /**
     * 移除队列头元素
     * @return
     */
    public T remove(){
        return mQueue.poll();
    }

    /**
     * 移除单个元素
     * @param e
     * @return
     */
    public boolean remove(Object e){
        return mQueue.remove(e);
    }

    /**
     * 组赛算法
     * @param e
     */
    public void put(T e){
        if(e ==null){
            throw new RuntimeException("element obejct is null");
        }
        try {
            mQueue.put(e);
        } catch (InterruptedException e1) {
            //中断异常
            e1.printStackTrace();
        }
    }

    /**
     * 移除队列头元素
     * @return
     */
    public  T take(){
        T t = null;
        try {
             t = mQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * 获取队列的个数
     * @return
     */
    public int size(){
        return mQueue.size();
    }

    /**
     * 清空数据队列
     */
    public void clear(){
        mQueue.clear();
    }
}
