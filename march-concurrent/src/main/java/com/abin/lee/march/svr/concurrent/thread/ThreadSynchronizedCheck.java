package com.abin.lee.march.svr.concurrent.thread;

/**
 * Created by abin on 2017/7/25 17:14.
 * march-svr
 * com.abin.lee.march.svr.concurrent.thread
 */
public class ThreadSynchronizedCheck {
    public static void main(String[] args) {
        synchronized (ThreadSynchronizedCheck.class) {
            boolean flag = Thread.holdsLock(ThreadSynchronizedCheck.class);
            System.out.println(flag);
        }
    }
}
