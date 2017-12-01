package com.abin.lee.march.svr.basic.stack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by abin on 2017/7/25 15:20.
 * march-svr
 * com.abin.lee.march.svr.basic.stack
 */
public class StackEscapeAnalysis {
    private static int state = 0;
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state % 3 == 0) {
                        System.out.print("A");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state % 3 == 1) {
                        System.out.print("B");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });
        thread2.start();
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (state <= 30) {
                    lock.lock();
                    if (state % 3 == 2) {
                        System.out.print("C");
                        state++;
                    }
                    lock.unlock();
                }
            }
        });
        thread3.start();
    }


}
