package com.example.semaphore;

/**
 * Created by Administrator on 2017/7/20.
 */
public class TestSemaphore  {

    public static void main(String args[]){
        Semaphore semaphore = new Semaphore();

        new SendThread(semaphore).start();
        new ReciveThread(semaphore).start();
    }

    static  class SendThread extends Thread{
        private Semaphore semaphore;


        public SendThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while(true){

                //do something
                System.out.println("send single");
                //发出通知
                semaphore.take();
            }
        }
    }


    static class ReciveThread extends Thread{
        private Semaphore semaphore;


        public ReciveThread(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while(true){
                try {
                    semaphore.release();    //recv 通知
                    System.out.println("received  single");
                    //then do something
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
