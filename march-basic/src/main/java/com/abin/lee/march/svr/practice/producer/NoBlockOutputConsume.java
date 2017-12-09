package com.abin.lee.march.svr.practice.producer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by abin on 2017/12/9 2017/12/9.
 * march-svr
 * com.abin.lee.march.svr.practice.producer
 * https://www.cnblogs.com/dmir/p/4907515.html
 */
public class NoBlockOutputConsume {
    private static Log log = LogFactory.getLog(NoBlockOutputConsume.class);
    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

    private static int count = 2;
    private static CountDownLatch latch = new CountDownLatch(count);

    private static class Poll implements Runnable {
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                System.out.println(Thread.currentThread().getName() + "消费一个商品: " + queue.poll());
            }
            latch.countDown();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        ExecutorService eService = Executors.newFixedThreadPool(4);

        // 生产商品
        for (int i = 0; i < 500; ++i) {
            queue.offer(i);
            System.out.println(Thread.currentThread().getName() + "生产一个商品------- i : " + i);
        }

        // 消费者
        for (int i = 0; i < count; ++i) {
            eService.submit(new Poll());
        }

        latch.await();// 使得主线程阻塞，直到latch.getCount()为0
        System.out.println("Cost time: " + (System.currentTimeMillis() - timeStart));
        eService.shutdown();
    }


}
