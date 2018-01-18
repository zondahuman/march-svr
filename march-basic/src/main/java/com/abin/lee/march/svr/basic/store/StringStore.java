package com.abin.lee.march.svr.basic.store;

/**
 * Created by abin on 2017/12/19 19:08.
 * march-svr
 * com.abin.lee.march.svr.basic.store
 */
public class StringStore {
    public static void main(String[] args) {
        String a = "123";
        String b = "123";
        System.out.println("a==b : "+(a == b));
        System.out.println("a==b : "+(a.equals(b)));
    }
}
