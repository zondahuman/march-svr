package com.abin.lee.march.svr.thrift.client;

import com.abin.lee.march.svr.common.JsonUtil;
import com.abin.lee.march.svr.thrift.model.TeamInfo;
import com.abin.lee.march.svr.thrift.service.TeamService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.util.List;

/**
 * Created by abin on 2017/9/7 14:20.
 * march-svr
 * com.abin.lee.march.svr.thrift.client
 */
public class ThriftClientServer {

    public static void main(String[] args) throws TException {
        TSocket transport = new TSocket("localhost", 30000);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        TMultiplexedProtocol teamProtocol = new TMultiplexedProtocol(protocol,"TeamService");

        TeamService.Client teamService = new TeamService.Client(teamProtocol);

//        TMultiplexedProtocol mp2 = new TMultiplexedProtocol(protocol,"UserService");
//        UserService.Client service2 = newUserService.Client(mp2);

        transport.open();
        List<TeamInfo> teamInfoList = teamService.findTeamListById(5L);
//        service2.store1(new User(888,"tom","haha"));

        System.out.println(JsonUtil.toJson(teamInfoList));
//        System.out.println(service2.retrieve1(999));

        transport.close();

    }

}
