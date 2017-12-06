package com.abin.lee.march.svr.spike.kill;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;

/**
 * Created by abin on 2017/12/5 11:58.
 * march-svr
 * com.abin.lee.march.svr.spike.kill
 */
public class SecondKill {

    public static String host = "172.16.2.146";
    public static String script = "script.lua";


    public static void testTryGetHongBao() throws InterruptedException {

        Jedis jedis = new Jedis(host);
        String sha = jedis.scriptLoad(script);
        Object object = jedis.evalsha(sha, Lists.newArrayList(), Lists.newArrayList());

        System.err.println("end:" + System.currentTimeMillis() / 1000);
    }


}
