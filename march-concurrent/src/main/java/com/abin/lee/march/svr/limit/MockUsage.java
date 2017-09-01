package com.abin.lee.march.svr.limit;

import com.google.common.util.concurrent.RateLimiter;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by abin on 2017/8/31 16:53.
 * march-svr
 * com.abin.lee.march.svr.limit
 */
public class MockUsage {
    RateLimiter rateLimiter = RateLimiter.create(10); //TPS为10

    public void doRequest(String threadName) {
        boolean isAcquired = rateLimiter.tryAcquire();
        if (isAcquired) {
            System.out.println(threadName + ":下单成功");
        } else {
            System.out.println(threadName + ":当前下单人数过多，请稍后再试");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        final MockUsage mockUsage = new MockUsage();
        final CountDownLatch latch = new CountDownLatch(1);//两个工人的协作
        final Random random = new Random(10);
        for (int i = 0; i < 20; i++) { //模拟一秒内20个并发
            final int finalI = i;
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                        int sleepTime = random.nextInt(1000); //随机sleep [0,1000)毫秒
                        Thread.sleep(sleepTime);
                        mockUsage.doRequest("t-" + finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        latch.countDown();
        System.in.read();
    }

}
