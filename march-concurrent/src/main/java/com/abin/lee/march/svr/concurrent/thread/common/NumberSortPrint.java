package com.abin.lee.march.svr.concurrent.thread.common;

/**
 * Created by abin on 2017/7/21 15:55.
 * march-svr
 * com.abin.lee.march.svr.concurrent.thread
 */
public class NumberSortPrint {
    private Object lock = new Object();
    private volatile int num = 0;
    public void odd() {
        while(num<100){
            synchronized (lock){
                if(num % 2 != 0){
                    System.out.println("Thread-Name: "+ Thread.currentThread().getName() +", event="+ (++num));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
    public void event() {
        while(num<100){
            synchronized (lock){
                if(num % 2 == 0) {
                    System.out.println("Thread-Name: " + Thread.currentThread().getName() + ", odd=" + (++num));
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        final NumberSortPrint print = new NumberSortPrint();
        new Thread(new Runnable() {
            public void run() {
                print.odd();
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                print.event();
            }
        }).start();
    }
}
