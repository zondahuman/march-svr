package com.abin.lee.march.svr.rpc.client;

import com.abin.lee.march.svr.rpc.service.RpcService;
import com.abin.lee.march.svr.rpc.stub.RpcStub;

/**
 * Created by abin on 2017/7/31 2017/7/31.
 * march-svr
 * com.abin.lee.march.svr.rpc.client
 */
public   class RpcStubClient {
    public   static   void  main(String [] args) {
        try  {
            RpcService rpcService =  new RpcStub();
            int  age = rpcService.getAge();
            String name = rpcService.getName();
            System.out.println(name +  " is "  + age +  " years old" );
        }  catch (Throwable t) {
            t.printStackTrace();
        }
    }
}