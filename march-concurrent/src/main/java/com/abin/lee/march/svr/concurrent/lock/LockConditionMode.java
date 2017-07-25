package com.abin.lee.march.svr.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by abin on 2017/7/25 17:30.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lock
 */
public class LockConditionMode {
    private Lock lock = new ReentrantLock();
    private Condition oddCondition = lock.newCondition();
    private Condition eventCondition = lock.newCondition();

    public static void main(String[] args) {
        final LockConditionMode instance = new LockConditionMode();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                instance.printOdd();
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                instance.printEvent();
            }
        });
        thread2.start();
    }


    public void printOdd() {
        lock.lock();
        System.out.println("ThreadName: " + Thread.currentThread().getName());
        eventCondition.signal();
        try {
            oddCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }


    public void printEvent() {
        lock.lock();
        System.out.println("ThreadName: " + Thread.currentThread().getName());
        oddCondition.signal();
        try {
            eventCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }


}
