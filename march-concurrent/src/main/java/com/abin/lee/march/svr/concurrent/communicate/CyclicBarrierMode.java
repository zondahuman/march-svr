package com.abin.lee.march.svr.concurrent.communicate;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by abin on 2017/7/26 11:42.
 * march-svr
 * com.abin.lee.march.svr.concurrent.communicate
 */
public class CyclicBarrierMode {


    public static void main(String[] args) {
        int totalThread = 5;
        CyclicBarrier barrier = new CyclicBarrier(totalThread);

        for (int i = 0; i < totalThread; i++) {
            String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, " is waiting"));
                try {
                    barrier.await();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();
        }
    }

}
