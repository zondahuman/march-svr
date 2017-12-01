package com.abin.lee.march.svr.basic.stack.test;

import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;

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

    @Test
    public void test1(){
        int state = 0;
        while(state < 30){
            System.out.println("state=" + state + ", state % 3 =" + state % 3);
            state++;
        }
    }



}
