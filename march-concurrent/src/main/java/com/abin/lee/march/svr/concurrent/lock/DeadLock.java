package com.abin.lee.march.svr.concurrent.lock;

/**
 * Created by abin on 2017/12/4 15:30.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lock
 * 死锁简单实现
 */
public class DeadLock {

    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("lock1-----Locking----");
                    synchronized (lock1){
                        System.out.println("lock1------Locked----Lock2");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock2){
                            System.out.println("lock1------enter----Lock2");
                        }
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println("lock2-----Locking----");
                    synchronized (lock2){
                        System.out.println("lock2------Locked----lock1");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (lock1){
                            System.out.println("lock2------enter----lock1");
                        }
                    }
                }
            }
        }).start();


    }


}
