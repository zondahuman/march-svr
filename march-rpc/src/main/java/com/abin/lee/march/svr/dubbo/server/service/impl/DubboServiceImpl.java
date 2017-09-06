package com.abin.lee.march.svr.dubbo.server.service.impl;

import com.abin.lee.march.svr.dubbo.enums.SecondaryCategory;
import com.abin.lee.march.svr.dubbo.server.service.DubboService;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
public class DubboServiceImpl implements DubboService{

    public String build(String name) throws Exception {
        System.out.println(" got a argument: " + name);
        return "message from provider: " + name;
    }

    @Override
    public List<Integer> findById(int id) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i <id ; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public SecondaryCategory findByParam(int id) {
        if(id == 10)
            return SecondaryCategory.SYSTEM;
        return SecondaryCategory.MANNUAL;
    }
}
