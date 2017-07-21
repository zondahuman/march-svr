package com.abin.lee.march.svr.concurrent.thread.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private Lock lock = new ReentrantLock();
    private Condition oddCondition = lock.newCondition();
    private Condition evenCondition = lock.newCondition();// 偶数
    private volatile int count = 0;

    public void inCreaseOdd(String threadName) {
        lock.lock();
        if (count % 2 == 0) {//
            printOdd(threadName);
            evenCondition.signalAll();
        } else {
            try {
                oddCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    public void inCreaseEven(String threadName) {
        lock.lock();
        if (count % 2 != 0) {
            printEven(threadName);
            oddCondition.signalAll();
        } else {
            try {
                evenCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock.unlock();
    }

    private void printOdd(String threadName) {
        System.out.println("threadName:" + threadName + " count:" + (++count));
    }

    private void printEven(String threadName) {
        System.out.println("threadName:" + threadName + " count:" + (++count));
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.inCreaseOdd("t1");
                }
            }
        });
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.inCreaseEven("t2");
                }
            }
        });
        t2.setName("t2");
        t2.start();
    }
}