package com.abin.lee.march.svr.basic.stack.test;

/**
 * Created by abin on 2018/3/22 23:10.
 * march-svr
 * com.abin.lee.march.svr.basic.stack.test
 * java中移位运算符
 <<      :     左移运算符，num << 1,相当于num乘以2
 >>      :     右移运算符，num >> 1,相当于num除以2
 2的32次方，相当于32个2相乘
 1L<<32  ，不就是1乘以32个2 ，
 二者相等。
 <<的性能比直接乘以更优。
 */
public class BitAlgorithm {
    public static void main(String[] args) {
        System.out.println(1 << 29);
        System.out.println(1l << 31);
    }
}
