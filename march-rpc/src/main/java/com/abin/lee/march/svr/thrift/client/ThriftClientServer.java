package com.abin.lee.march.svr.thrift.client;

import com.abin.lee.march.svr.common.JsonUtil;
import com.abin.lee.march.svr.thrift.enums.BusinessRoleEnum;
import com.abin.lee.march.svr.thrift.model.Business;
import com.abin.lee.march.svr.thrift.model.TeamInfo;
import com.abin.lee.march.svr.thrift.service.TeamService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TMultiplexedProtocol;
import org.apache.thrift.transport.TSocket;

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

        //------------------------------------TeamService----------------------------------------------
        List<TeamInfo> teamInfoList = teamService.findTeamListById(5L);
        System.out.println("teamInfoList= : " + JsonUtil.toJson(teamInfoList));
        TeamInfo teamInfo = teamService.findTeamById(5L);
        System.out.println("teamInfo= : " + JsonUtil.toJson(teamInfo));
        long price1 = teamService.findByIdAndType(5L, "SYSTEM");
        System.out.println("price1= : " + price1);
        double price2 = teamService.findById(5L);
        System.out.println("price2= : " + price2);
        BusinessRoleEnum businessRoleEnum = teamService.findByBid(5L);
        System.out.println("businessRoleEnum= : " + businessRoleEnum);

        Business business = new Business();
        business.setAccountId(10000000000000000L);
        business.setBusinessId(20000000000000000L);
        business.setBusinessAddress("Los Angeles");
        business.setBusinessName("Holly Wood");
        business.setContractId(30000000000000000L);;
        teamService.insert(business);

        Business businessResult = teamService.findBusinessByBid(5L);
        System.out.println("businessResult= : " + businessResult);
        //------------------------------------TeamService----------------------------------------------





//        service2.store1(new User(888,"tom","haha"));
//        System.out.println(service2.retrieve1(999));

        transport.close();

    }

}
