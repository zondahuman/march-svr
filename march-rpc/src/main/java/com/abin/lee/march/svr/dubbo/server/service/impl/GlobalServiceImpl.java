package com.abin.lee.march.svr.dubbo.server.service.impl;

import com.abin.lee.march.svr.dubbo.enums.UserRole;
import com.abin.lee.march.svr.dubbo.model.UserInfo;
import com.abin.lee.march.svr.dubbo.server.service.GlobalService;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service.impl
 */
public class GlobalServiceImpl implements GlobalService {

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
    public UserRole findByParam(int id) {
        if(id == 10)
            return UserRole.SYSTEM;
        return UserRole.MANNUAL;
    }


    @Override
    public List<Integer> findById(List<Integer> list) {
        int id = list.get(0);
        List<Integer> result = Lists.newArrayList();
        for (int i = 0; i <id ; i++) {
            result.add(i);
        }
        return result;
    }

    @Override
    public List<UserInfo> findUserInfoById(List<Integer> list) {
        int id = list.get(1);
        List<UserInfo> result = Lists.newArrayList();
        for (int i = 0; i <id ; i++) {
            result.add(new UserInfo(i, "abin"+i));
        }
        return result;
    }
}
