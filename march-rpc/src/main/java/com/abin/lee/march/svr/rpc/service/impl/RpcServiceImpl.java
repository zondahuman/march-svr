package com.abin.lee.march.svr.rpc.service.impl;

import com.abin.lee.march.svr.rpc.service.RpcService;

/**
 * Created by abin on 2017/7/31 2017/7/31.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
public class RpcServiceImpl implements RpcService {
    private int age;
    private String name;

    public RpcServiceImpl(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}