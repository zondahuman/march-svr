package com.abin.lee.march.svr.concurrent.complicating;

import com.abin.lee.march.svr.common.JsonUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by abin on 2017/8/4 13:01.
 * march-svr
 * com.abin.lee.march.svr.concurrent.complicating
 */
public class ForkJoinTaskAAA{

    public static void main(String[] args) {
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(null);
        list.add(3L);
        System.out.println("list--"+ JsonUtil.toJson(list) );
        for(Iterator<Long> iterator=list.iterator();iterator.hasNext();){
            Long temp = iterator.next();
            if(null == temp)
                list.remove(null);
        }
        System.out.println("list--="+ JsonUtil.toJson(list) );

    }
}