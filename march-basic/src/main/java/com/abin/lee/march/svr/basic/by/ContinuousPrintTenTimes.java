package com.abin.lee.march.svr.basic.by;

/**
 * Created by abin on 2017/12/1 18:10.
 * march-svr
 * com.abin.lee.march.svr.basic.by
 *  Java多线程：用三个线程控制循环输出10次ABC
 * https://yq.aliyun.com/articles/34834
 */
public class ContinuousPrintTenTimes implements Runnable{
    //打印机只有一台
    private PrintTimes print;
    private char val;
    private static volatile char next= 'A';
//    private Object lock = new Object();

    public ContinuousPrintTenTimes(PrintTimes print, char val) {
        this.print = print;
        this.val = val;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i<10;){
                synchronized (print){
                    if(val == 'A' && next == val){
                        print.print(val);
                        next = 'B';
                        i++;
                    }
                    if(val == 'B' && next == val){
                        print.print(val);
                        next = 'C';
                        i++;
                    }
                    if(val == 'C' && next == val){
                        print.print(val);
                        next = 'A';
                        i++;
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        PrintTimes print = new PrintTimes();
        Thread thread1 = new Thread(new ContinuousPrintTenTimes(print, 'A'));
        Thread thread2 = new Thread(new ContinuousPrintTenTimes(print, 'B'));
        Thread thread3 = new Thread(new ContinuousPrintTenTimes(print, 'C'));
        thread1.start();
        thread2.start();
        thread3.start();
    }


}
class PrintTimes {

    //private char next;
    public void print(char val) throws Exception {
        System.out.print(val);
    }
}