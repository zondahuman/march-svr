package com.abin.lee.march.svr.basic.by;

/**
 * Created by abin on 2017/12/1 18:26.
 * march-svr
 * com.abin.lee.march.svr.basic.by
 */
public class PrintThread implements Runnable {
    //打印机只有一台
    private Print print;
    //设置默认值[即第一个打印值]和下一个的打印值
    private static volatile char next='A';
    private char val;

    public PrintThread(Print print, char val) {
        this.print = print;
        this.val = val;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; ) {
                synchronized (print) {
                    //协调线程顺序打印ABCABC
                    if(val=='A'&&next==val) {
                        print.print(val);
                        next='B';
                        i++;
                    }
                    if(val=='B'&&next==val) {
                        print.print(val);
                        next='C';
                        i++;
                    }
                    if(val=='C'&&next==val) {
                        print.print(val);
                        next='A';
                        i++;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Print print = new Print();
        Thread thread_a = new Thread(new PrintThread(print, 'A'));
        Thread thread_b = new Thread(new PrintThread(print, 'B'));
        Thread thread_c = new Thread(new PrintThread(print, 'C'));
        thread_a.start();
        thread_b.start();
        thread_c.start();
    }


}
class Print {

    //private char next;
    public void print(char val) throws Exception {
        System.out.print(val);
    }
}