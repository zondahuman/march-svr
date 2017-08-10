package com.abin.lee.march.svr.rpc.server;

import com.abin.lee.march.svr.rpc.service.impl.RpcServiceImpl;
import com.abin.lee.march.svr.rpc.skeleton.RpcSkeleton;

/**
 * Created by abin on 2017/7/31 2017/7/31.
 * march-svr
 * com.abin.lee.march.svr.rpc.server
 */
public class RpcSkeletonServer {
    public static void main(String args[]) {
        // new object server
        RpcServiceImpl rpcService = new RpcServiceImpl("Richard", 34);
        RpcSkeleton rpcSkeleton = new RpcSkeleton(rpcService);
        rpcSkeleton.start();
    }
}
