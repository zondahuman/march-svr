package com.abin.lee.march.svr.basic.store;

/**
 * Created by abin on 2017/12/21 19:13.
 * march-svr
 * com.abin.lee.march.svr.basic.store
 */
public class MemoryBarrier {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        flag = true;
        System.out.println("flag"+flag);
    }

}
