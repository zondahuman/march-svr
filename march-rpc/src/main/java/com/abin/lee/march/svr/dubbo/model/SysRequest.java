package com.abin.lee.march.svr.dubbo.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by abin on 2017/12/19 11:54.
 * march-svr
 * com.abin.lee.march.svr.dubbo.model
 */
public class SysRequest extends UserRequest {
    private Integer id;
    private String otherName;


//    public UserRequest() {
//    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("otherName", otherName)
                .toString();
    }

}
