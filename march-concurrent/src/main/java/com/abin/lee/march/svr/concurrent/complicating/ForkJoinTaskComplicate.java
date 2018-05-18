package com.abin.lee.march.svr.concurrent.complicating;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by abin on 2017/8/4 13:01.
 * march-svr
 * com.abin.lee.march.svr.concurrent.complicating
 *  FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，再去获取结果。
 *  然后通过Future来取得计算结果。但是，若开启了多个任务，我们无从知晓哪个任务最先结束。因此，若要实现“当某任务结束时，立刻做一些事情，例如记录日志”这一功能，就需要写一些额外的代码
 * https://blog.csdn.net/zmx729618/article/details/51596414
 */
public class ForkJoinTaskComplicate extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -3611254198265061729L;

    public static final int threshold = 2;
    private int start;
    private int end;

    public ForkJoinTaskComplicate(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;

        //如果任务足够小就计算任务
        boolean canCompute = (end - start) <= threshold;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            ForkJoinTaskComplicate leftTask = new ForkJoinTaskComplicate(start, middle);
            ForkJoinTaskComplicate rightTask = new ForkJoinTaskComplicate(middle + 1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            //等待任务执行结束合并其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            //合并子任务
            sum = leftResult + rightResult;

        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkjoinPool = new ForkJoinPool();

        //生成一个计算任务，计算1+2+3+4
        ForkJoinTaskComplicate task = new ForkJoinTaskComplicate(1, 100);

        //执行一个任务
        Future<Integer> result = forkjoinPool.submit(task);

        try {
            System.out.println(result.get());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}