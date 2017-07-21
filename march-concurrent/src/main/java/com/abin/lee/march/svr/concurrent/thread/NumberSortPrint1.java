package com.abin.lee.march.svr.concurrent.thread;

/**
 * Created by abin on 2017/7/20 2017/7/20.
 * arithmetic-svr
 * com.abin.lee.arithmetic.tree.traversal
 */
public class NumberSortPrint1 {
    static final NumberSortPrint1 lock = new NumberSortPrint1();
    public static void main(String[] args) {
        new Thread(new Number1()).start();
        new Thread(new Number2()).start();
    }
}

class Number1 implements Runnable{
    int i = -1;
    public void run() {
        while(i<99){
            synchronized (NumberSortPrint1.lock){
                System.out.println("Thread-Name: "+ Thread.currentThread().getName() +", "+ (i+=2));
                NumberSortPrint1.lock.notify();
                try {
                    NumberSortPrint1.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Number2 implements Runnable{
    int i = 0;
    public void run() {
        while(i<99){
            synchronized (NumberSortPrint1.lock){
                System.out.println("Thread-Name: "+ Thread.currentThread().getName() +", "+ (i+=2));
                NumberSortPrint1.lock.notify();
                try {
                    NumberSortPrint1.lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
