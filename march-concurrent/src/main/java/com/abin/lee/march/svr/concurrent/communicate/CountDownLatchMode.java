package com.abin.lee.march.svr.concurrent.communicate;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * Created by abin on 2017/7/25 19:52.
 * march-svr
 * com.abin.lee.march.svr.concurrent.communicate
 * http://blog.csdn.net/habren/article/details/51749535
 */
public class CountDownLatchMode {

    public static void main(String[] args) throws InterruptedException {
        int totalThread = 3;
        long start = System.currentTimeMillis();
        CountDownLatch countDown = new CountDownLatch(totalThread);
        for(int i = 0; i < totalThread; i++) {
            final String threadName = "Thread " + i;
            new Thread(() -> {
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "started"));
                try {
                    Thread.sleep(10000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                countDown.countDown();
                System.out.println(String.format("%s\t%s %s", new Date(), threadName, "ended"));
            }).start();;
        }
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println(String.format("Total time : %sms", (stop - start)));
    }

}
