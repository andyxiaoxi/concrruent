package com.example;

public class MyClass {
    public static void main(String[] args){
       // System.out.println(new MyLock().lock());
        class Task implements Runnable{
            private MyLock myLock;
            public Task(MyLock myLock) {
                this.myLock = myLock;
            }

            @Override
            public void run() {
                System.out.println("Thread1 "+Thread.currentThread().getName()+"start "+" test =" +myLock.locked.get());
                if(!myLock.locked.get()){
                    myLock.locked.set(true);
                }
                System.out.println("Thread1 "+Thread.currentThread().getName()+"end" +" test =" +myLock.locked.get());
            }
        }

        MyLock myLock = new MyLock();
        new Thread(new Task(myLock),"Thread-A").start();
        new Thread(new Task(myLock),"Thread-B").start();


    }



}
