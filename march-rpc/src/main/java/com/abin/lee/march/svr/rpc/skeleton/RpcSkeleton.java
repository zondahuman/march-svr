package com.abin.lee.march.svr.rpc.skeleton;

/**
 * Created by abin on 2017/7/31 2017/7/31.
 * march-svr
 * com.abin.lee.march.svr.rpc.skeleton
 */

import com.abin.lee.march.svr.rpc.service.impl.RpcServiceImpl;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcSkeleton extends Thread {
    private RpcServiceImpl rpcService;

    public RpcSkeleton(RpcServiceImpl rpcService) {
        // get reference of object server
        this.rpcService = rpcService;
    }

    public void run() {
        try {
            // new socket at port 9000
            ServerSocket serverSocket = new ServerSocket(9000);
            // accept stub's request
            Socket socket = serverSocket.accept();
            while (socket != null) {
                // get stub's request
                ObjectInputStream inStream =
                        new ObjectInputStream(socket.getInputStream());
                String method = (String) inStream.readObject();
                // check method name
                if (method.equals("age")) {
                    // execute object server's business method
                    int age = rpcService.getAge();
                    ObjectOutputStream outStream =
                            new ObjectOutputStream(socket.getOutputStream());
                    // return result to stub
                    outStream.writeInt(age);
                    outStream.flush();
                }
                if (method.equals("name")) {
                    // execute object server's business method
                    String name = rpcService.getName();
                    ObjectOutputStream outStream =
                            new ObjectOutputStream(socket.getOutputStream());
                    // return result to stub
                    outStream.writeObject(name);
                    outStream.flush();
                }
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(0);
        }
    }


}