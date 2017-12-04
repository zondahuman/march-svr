package com.abin.lee.march.svr.limit;

import com.google.common.io.CharStreams;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by abin on 2017/12/5 2017/12/5.
 * march-svr
 * com.abin.lee.march.svr.limit
 * https://www.cnblogs.com/itrena/p/5926878.html
 * 案例-实现访问频率限制: 实现访问者 $ip 在一定的时间 $time 内只能访问 $limit 次.
 */
public class AccessLimit {

    private boolean accessLimit(String ip, int limit, int timeout, Jedis connection) throws IOException {
        List<String> keys = Collections.singletonList(ip);
        List<String> argv = Arrays.asList(String.valueOf(limit), String.valueOf(timeout));

        return 1 == (long) connection.eval(loadScriptString("access_limit.lua"), keys, argv);
    }

    // 加载Lua代码
    private String loadScriptString(String fileName) throws IOException {
        Reader reader = new InputStreamReader(Client.class.getClassLoader().getResourceAsStream(fileName));
        return CharStreams.toString(reader);
    }


}
