package com.abin.lee.march.svr.rpc.stub;

/**
 * Created by abin on 2017/7/31 2017/7/31.
 * march-svr
 * com.abin.lee.march.svr.rpc.stub
 */

import com.abin.lee.march.svr.rpc.service.RpcService;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcStub implements RpcService {
    private Socket socket;

    public RpcStub() throws Throwable {
        // connect to skeleton
        socket = new Socket("localhost", 9000);
    }

    public int getAge() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return inStream.readInt();
    }

    public String getName() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return (String) inStream.readObject();
    }
}