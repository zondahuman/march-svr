package com.abin.lee.march.svr.concurrent.thread.pool;

import org.junit.Test;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.util.concurrent.*;

/**
 * Created by abin on 2017/12/4 19:39.
 * march-svr
 * com.abin.lee.march.svr.concurrent.thread.pool
 */
public class ThreadPoolConcurrency {


    @Test
    public void testCachedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool();
        cachedThreadPool1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executors.newCachedThreadPool---submit----Runnable");
            }
        });
        ExecutorService cachedThreadPool2 = Executors.newCachedThreadPool();
        cachedThreadPool2.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executors.newCachedThreadPool----execute---Runnable");
            }
        });
        ExecutorService cachedThreadPool3 = Executors.newCachedThreadPool();
        Future<Object> future3 = cachedThreadPool3.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "" + Math.random() ;
            }
        });
        Object result3 = future3.get();
        System.out.println("Executors.newCachedThreadPool----submit---Callable--result3="+result3);
    }

    @Test
    public void testFixedThreadPool() throws ExecutionException, InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        fixedThreadPool.submit()


        
    }







}
