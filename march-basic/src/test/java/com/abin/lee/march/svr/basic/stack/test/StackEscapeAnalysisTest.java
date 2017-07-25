package com.abin.lee.march.svr.basic.stack.test;

/**
 * Created by abin on 2017/7/25 15:20.
 * march-svr
 * com.abin.lee.march.svr.basic.stack.test
 */
public class StackEscapeAnalysisTest {
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println(e - b);
    }
}
