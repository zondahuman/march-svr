package com.abin.lee.march.svr.practice.producer;

import org.omg.SendingContext.RunTime;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by abin on 2017/12/9 2017/12/9.
 * march-svr
 * com.abin.lee.march.svr.practice.producer
 * https://www.cnblogs.com/dmir/p/4907515.html
 */
public class ProducerConsumer {

    public static void main(String[] args) {
        Basket basket = new Basket();
        Producer producer1 = new Producer(basket);
//        Producer producer2 = new Producer(basket);
//        Producer producer3 = new Producer(basket);

        Consumer consumer = new Consumer(basket);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(producer1);
//        executorService.submit(producer2);
//        executorService.submit(producer3);

        executorService.submit(consumer);

        executorService.shutdown();
    }


    public static class Basket{
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();

        public void produce(Integer param) throws InterruptedException {
            blockingQueue.put(param);
        }
        public Integer consume() throws InterruptedException {
            return blockingQueue.take();
        }
    }

    public static class Producer implements Runnable{
        private Basket basket;

        public Producer(Basket basket) {
            this.basket = basket;
        }

        @Override
        public void run() {
            while (true){
                for (int i = 0; i < 10; i++) {
                    try {
                        basket.produce(i);
                        System.out.println("Producer---produce---i:"+i);
                        Thread.sleep(2_000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class Consumer implements Runnable {
        private Basket basket;

        public Consumer(Basket basket) {
            this.basket = basket;
        }

        @Override
        public void run() {
            while (true) {
                int result = 0;
                try {
                    result = basket.consume();
                    System.out.println("Consumer---consume---result:" + result);
                    Thread.sleep(2_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
