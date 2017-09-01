package com.abin.lee.march.svr.limit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created by abin on 2017/8/31 11:52.
 * march-svr
 * com.abin.lee.march.svr.limit
 */
public class GuavaLimit {

    public static void getToken1() {
        RateLimiter rateLimiter = RateLimiter.create(5); //令牌桶容量为5，即每200毫秒产生1个令牌
        System.out.println(rateLimiter.acquire()); //阻塞获取一个令牌
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
    }

    public static void getToken2() {
        RateLimiter rateLimiter = RateLimiter.create(5); //令牌桶容量为5，即每200毫秒产生1个令牌
        System.out.println(rateLimiter.acquire(10)); //透支令牌
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
        System.out.println(rateLimiter.acquire());
    }

    public static void getToken3() {
        RateLimiter rateLimiter = RateLimiter.create(1000); //每秒投放1000个令牌
        for (int i = 0; i < 10; i++) {
            if (rateLimiter.tryAcquire()) { //tryAcquire检测有没有可用的令牌，结果马上返回
                System.out.println("处理请求");
            } else {
                System.out.println("拒绝请求");
            }
        }
    }

    public static void main(String[] args) {
//        getToken1();
//        getToken2();
        getToken3();
    }
}
