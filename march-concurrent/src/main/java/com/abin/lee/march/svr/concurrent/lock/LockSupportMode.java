package com.abin.lee.march.svr.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by abin on 2017/7/25 18:50.
 * march-svr
 * com.abin.lee.march.svr.concurrent.lock
 * http://www.tuicool.com/articles/MveUNzF
 */
public class LockSupportMode {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();

        LockSupport.unpark(thread);

        System.out.println("a");
        LockSupport.park();
        System.out.println("b");
        LockSupport.unpark(thread);
        LockSupport.park();
        System.out.println("c");
    }

}




