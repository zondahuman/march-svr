package com.abin.lee.march.svr.dubbo.client.view;

import com.abin.lee.march.svr.common.JsonUtil;
import com.abin.lee.march.svr.dubbo.enums.UserRole;
import com.abin.lee.march.svr.dubbo.model.UserInfo;
import com.abin.lee.march.svr.dubbo.server.service.DubboService;
import com.google.common.collect.Lists;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by abin on 2017/9/7 2017/9/7.
 * march-svr
 * com.abin.lee.march.svr.dubbo.client.view
 */
public class DubboClientServer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/dubbo-consumer.xml"});
        context.start();
        DubboService dubboService = (DubboService) context.getBean("dubboService"); // 获取bean
        // service
        // invocation
        // proxy
        String message = "";
        List<Integer> list = null;
        UserRole userRole = UserRole.DEFAULT;
        List<Integer> resultList = null;
        List<UserInfo> userInfoList = null;
        try {
            message = dubboService.build("2016-10-20");
            System.out.println(" the message from server is:" + message);
            list = dubboService.findById(5);
            System.out.println("list is:" + JsonUtil.toJson(list));
            userRole = dubboService.findByParam(10);
            System.out.println("userRole is:" + userRole);
            resultList = dubboService.findById(Lists.newArrayList(1,2));
            System.out.println("resultList is:" + JsonUtil.toJson(resultList));
            userInfoList = dubboService.findUserInfoById(Lists.newArrayList(1,2));
            System.out.println("userInfoList is:" + JsonUtil.toJson(userInfoList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
