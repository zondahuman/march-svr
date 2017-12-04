package com.abin.lee.march.svr.practice.producer;

import java.util.LinkedList;

/**
 * Created by abin on 2017/12/4 18:21.
 * march-svr
 * com.abin.lee.march.svr.practice.producer
 */
public class Person {

    private LinkedList<Integer> list = new LinkedList<>();
    private int Max = 10;

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        if (list.size() == Max) {
                            System.out.println("storeHouse is full , please wait consumer");
                            list.wait();
                        }
                        int object = 0;
                        list.add(++object);
                        System.out.println("Comsumer set  a Object :" + object);
                        Thread.sleep((long) (Math.random() * 3000));
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    try {
                        if (list.size() == 0) {
                            System.out.println("storeHouse is empty , please wait producer");
                            list.wait();
                        }
                        Integer object = list.removeLast();
                        System.out.println("Comsumer get  a Object :" + object);
                        Thread.sleep((long) (Math.random() * 3000));
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Person pc = new Person();
        Producer producer = pc.new Producer();
        Thread thread1 = new Thread(producer);
        Consumer consumer = pc.new Consumer();
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();
    }


}
