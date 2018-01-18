package com.abin.lee.march.svr.concurrent.queue;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by abin on 2017/12/5 2017/12/5.
 * march-svr
 * com.abin.lee.march.svr.concurrent.queue
 * http://blog.csdn.net/suifeng3051/article/details/48807423
 */
public class BlockQueueConcurrency {

    @Test
    public void testArrayBlockingQueue() throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> blockingQueue1 = new ArrayBlockingQueue<Integer>(5);
        for (int i = 0; i < 5; i++) {
            blockingQueue1.add(i);
        }
        for (int i = 0; i < 5; i++) {
            Integer result1 = blockingQueue1.remove();
            System.out.println("result1=" + result1);
        }

        BlockingQueue<Integer> blockingQueue2 = new ArrayBlockingQueue<Integer>(5);
        for (int i = 0; i < 5; i++) {
            blockingQueue2.offer(i);
        }
        for (int i = 0; i < 5; i++) {
            Integer result2 = blockingQueue2.poll();
            System.out.println("result2=" + result2);
        }

        BlockingQueue<Integer> blockingQueue3 = new ArrayBlockingQueue<Integer>(5);
        for (int i = 0; i < 5; i++) {
            blockingQueue3.put(i);
        }
        for (int i = 0; i < 5; i++) {
            Integer result3 = blockingQueue3.take();
            System.out.println("result3=" + result3);
        }
    }

    @Test
    public void testLinkedBlockingDeque() throws ExecutionException, InterruptedException {
        BlockingQueue<Integer> blockingQueue1 = new LinkedBlockingDeque<>(4);
        for (int i = 0; i < 5; i++) {
            blockingQueue1.add(i);
        }
        for (int i = 0; i < 5; i++) {
            Integer result1 = blockingQueue1.remove();
            System.out.println("result1=" + result1);
        }
    }


    @Test
    public void testDelayQueue() throws ExecutionException, InterruptedException {
        DelayQueue<DelayedElement> queue= new DelayQueue<>();
        DelayedElement ele= new DelayedElement( "cache 3 seconds",3000);
        queue.put( ele);
        System. out.println( queue.take());
    }


    @Test
    public void testPriorityBlockingQueue() throws ExecutionException, InterruptedException {
        PriorityBlockingQueue<PriorityElement> blockingQueue1 = new PriorityBlockingQueue<>(4);
        for (int i = 0; i < 5; i++) {
            Random random=new Random();
            PriorityElement element = new PriorityElement(random.nextInt(10));
            blockingQueue1.add(element);
        }
        while(!blockingQueue1.isEmpty()){
            System.out.println("PriorityBlockingQueue---blockingQueue1= " + blockingQueue1.take());
        }
        PriorityBlockingQueue<Integer> blockingQueue2 = new PriorityBlockingQueue<Integer>(4);
        for (int i = 0; i < 5; i++) {
            blockingQueue2.add(i);
        }
        while(!blockingQueue2.isEmpty()){
            System.out.println("PriorityBlockingQueue---blockingQueue2= " + blockingQueue2.take());
        }
    }

    /**
     * http://shift-alt-ctrl.iteye.com/blog/1840385
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void testSynchronousQueue() throws ExecutionException, InterruptedException {
        SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
        for(int i=0;i<5;i++){
            Thread t = new SQThread(queue, 1);
            t.start();
        }
        //Thread.sleep(1000);
        for(int i=0;i<10;i++){
            if(!queue.offer(new Object())){
                System.out.println("Failure");
            }
        }
    }

}

class SQThread extends Thread{
    private SynchronousQueue<Object> queue;
    int mode;
    SQThread(SynchronousQueue<Object> queue,int mode){
        this.queue = queue;
        this.mode = mode;
    }
    @Override
    public void run(){
        Object item = null;
        try{
            System.out.println(Thread.currentThread().getId());
            if(mode == 1){
                while((item = queue.take()) != null){
                    System.out.println(item.toString());
                }
            }else{
                //
            }
        }catch(Exception e){
            //
        }
        System.out.println("end");
    }
}

class PriorityElement implements Comparable<PriorityElement> {
    private int priority;//定义优先级
    PriorityElement(int priority) {
        //初始化优先级
        this.priority = priority;
    }
    @Override
    public int compareTo(PriorityElement o) {
        //按照优先级大小进行排序
        return priority >= o.getPriority() ? 1 : -1;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    @Override
    public String toString() {
        return "PriorityElement [priority=" + priority + "]";
    }
}

class DelayedElement implements Delayed {
    private long expired;
    private long delay;
    private String name;

    DelayedElement(String elementName, long delay) {
        this. name = elementName;
        this. delay= delay;
        expired = ( delay + System. currentTimeMillis());
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedElement cached=(DelayedElement) o;
        return cached.getExpired()> expired?1:-1;
    }

    @Override
    public long getDelay(TimeUnit unit) {

        return ( expired - System. currentTimeMillis());
    }

    @Override
    public String toString() {
        return "DelayedElement [delay=" + delay + ", name=" + name + "]";
    }

    public long getExpired() {
        return expired;
    }

}