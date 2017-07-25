package com.abin.lee.march.svr.concurrent.lock;

/**
 * Created by abin on 2017/7/25 17:26.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lock
 */
public class SynchronizedMode {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                print();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                print();
            }
        });
        thread2.start();
    }

    public static void print() {
        synchronized (lock) {
            System.out.println("ThreadName: " + Thread.currentThread().getName());
        }
    }


}
