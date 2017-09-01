package com.abin.lee.march.svr.limit;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by abin on 2017/9/1 11:14.
 * march-svr
 * com.abin.lee.march.svr.limit
 */
public class DistrubuteLuaLimit {

    public void aquire1() throws IOException {
//        String luaScript = Files.toString(new File("D:\\SystemFile\\LuaWorkspace\\lua-start1\\distribute_limit.lua"), Charset.defaultCharset());
//        String luaScript = Files.asCharSource(new File("D:\\SystemFile\\GithubWorkspace\\march-svr\\march-concurrent\\src\\main\\resources\\lua\\limit.lua"), Charset.defaultCharset()).toString();
        Jedis jedis = new Jedis("172.16.2.146", 6379);
        String ping = jedis.ping();
        System.out.println("ping-----:" + ping);
//        String key = "ip:" + System.currentTimeMillis() / 1000; //此处将当前时间戳取秒数
        String key = "ip:" + 1; //此处硬编码时间，保证请求都是在同一秒内发起
        String limit = "6"; //限流大小
//        Object response = jedis.eval(luaScript, Lists.newArrayList(key), Lists.newArrayList("2", limit));
//        System.out.println("response-----:" + response);
//        boolean flag = accessLimit(key, 6, 100000, jedis);
//        System.out.println("flag-----:" + flag);
    }

    public Long aquire() throws IOException {
        Jedis jedis = new Jedis("172.16.2.146", 6379);
        String ping = jedis.ping();
        System.out.println("ping-----:" + ping);
//        String key = "ip:" + System.currentTimeMillis() / 1000; //此处将当前时间戳取秒数
        String key = "ip:" + 1; //此处硬编码时间，保证请求都是在同一秒内发起
        String limit = "6"; //限流大小
//        Object response = jedis.eval(luaScript, Lists.newArrayList(key), Lists.newArrayList("2", limit));
//        System.out.println("response-----:" + response);
        List<String> keys = Collections.singletonList(key);
        List<String> argv = Arrays.asList(String.valueOf(limit), String.valueOf(100000));
//
        Long result = (long) jedis.eval(loadScriptString("D:\\SystemFile\\GithubWorkspace\\march-svr\\march-concurrent\\src\\main\\resources\\lua\\limit.lua"), keys, argv);
        System.out.println("result-----:" + result);
        return result;
    }

    private boolean accessLimit(String ip, int limit, int timeout, Jedis connection) throws IOException {
        List<String> keys = Collections.singletonList(ip);
        List<String> argv = Arrays.asList(String.valueOf(limit), String.valueOf(timeout));

        return 1 == (long) connection.eval(loadScriptString("D:\\SystemFile\\GithubWorkspace\\march-svr\\march-concurrent\\src\\main\\resources\\lua\\limit.lua"), keys, argv);
    }

    // 加载Lua代码
    private String loadScriptString(String fileName) throws IOException {
        Reader reader = new InputStreamReader(Client.class.getClassLoader().getResourceAsStream(fileName));
        return CharStreams.toString(reader);
    }


    public static void main(String[] args) throws IOException {
        final DistrubuteLuaLimit distrubuteLimit = new DistrubuteLuaLimit();
        final CountDownLatch latch = new CountDownLatch(1);//两个工人的协作
        final Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        latch.await();
                        int sleepTime = random.nextInt(1000);
                        Thread.sleep(sleepTime);
                        Long rev = distrubuteLimit.aquire();
                        if (rev == 1) {
                            System.out.println("t:" + finalI + ":" + "请求成功");
                        } else {
                            System.out.println("t:" + finalI + ":" + "被限流了");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        latch.countDown();
        System.in.read();
    }


}
