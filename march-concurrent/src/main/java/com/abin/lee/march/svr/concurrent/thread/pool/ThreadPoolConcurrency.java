package com.abin.lee.march.svr.concurrent.thread.pool;

import org.junit.Test;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.sql.Time;
import java.util.concurrent.*;

/**
 * Created by abin on 2017/12/4 19:39.
 * march-svr
 * com.abin.lee.march.svr.concurrent.thread.pool
 * http://cuisuqiang.iteye.com/blog/2019372
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
        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        fixedThreadPool1.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executors.newFixedThreadPool---submit----Runnable");
            }
        });

        ExecutorService fixedThreadPool2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Future<Object> future2 = fixedThreadPool2.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "" + Math.random() ;
            }
        });
        Object result2 = future2.get();
        System.out.println("Executors.newFixedThreadPool----submit---Callable--result2="+result2);
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行。
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testScheduledThreadPool() throws InterruptedException {
        //创建一个定长线程池，支持定时及周期性任务执行。延迟执行示例代码如下：表示延迟3秒执行。
        ScheduledExecutorService scheduledExecutorService1 = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
        scheduledExecutorService1.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        //定期执行示例代码如下：
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(5);
        scheduledExecutorService2.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
        Thread.sleep(100000);
    }

    @Test
    public void testSingleThreadExecutor()  {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
