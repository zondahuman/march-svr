package com.abin.lee.march.svr.dubbo.server.service;

import com.abin.lee.march.svr.dubbo.enums.UserRole;
import com.abin.lee.march.svr.dubbo.model.UserInfo;

import java.util.List;

/**
 * Created by abin on 2017/9/6 2017/9/6.
 * march-svr
 * com.abin.lee.march.svr.rpc.service
 */
public interface DubboService {

    String build(String name) throws Exception;

    List<Integer> findById(int id);

    UserRole findByParam(int id);

    List<Integer> findById(List<Integer> list);

    List<UserInfo> findUserInfoById(List<Integer> list);

}
