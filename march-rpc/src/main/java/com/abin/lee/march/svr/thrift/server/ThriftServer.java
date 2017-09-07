package com.abin.lee.march.svr.thrift.server;

import com.abin.lee.march.svr.thrift.service.TeamService;
import com.abin.lee.march.svr.thrift.service.TeamServiceImpl;
import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by abin on 2017/9/7 14:19.
 * march-svr
 * com.abin.lee.march.svr.thrift.server
 */
public class ThriftServer {

    public static void main(String[] args) throws TTransportException {
        TMultiplexedProcessor processor = new TMultiplexedProcessor();

        TServerTransport transport = new TServerSocket(30000);
        TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(transport).processor(processor));

        processor.registerProcessor("TeamService", new TeamService.Processor<TeamService.Iface>(new TeamServiceImpl()));
//        processor.registerProcessor("UserService", new UserService.Processor<UserService.Iface>(new UserImpl()));

//         TSimpleServer server = new TSimpleServer(new Args(t).processor(processor));
        System.out.println(".........................................................................................................");
        System.out.println("...........................the server is started and is listening at 30000...............................");
        System.out.println(".........................................................................................................");

        server.serve();
    }


}
