package com.abin.lee.march.svr.concurrent.thread.interrupt;

/**
 * Created by abin on 2018/3/20 16:46.
 * march-svr
 * com.abin.lee.march.svr.concurrent.thread.interrupt
 */
public class ThreadInterruptOperate extends Thread {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Someone interrupt me");
                break;
            } else {
                System.out.println("THread is Going ....");
            }
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("Jump current Thread..........");
        System.out.println("-------------------------------------------------------");

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadInterruptOperate threadInterruptOperate = new ThreadInterruptOperate();
        threadInterruptOperate.start();
        Thread.sleep(3000);
        threadInterruptOperate.interrupt();
    }


}