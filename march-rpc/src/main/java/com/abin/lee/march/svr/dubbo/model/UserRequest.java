package com.abin.lee.march.svr.dubbo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by abin on 2017/12/19 11:31.
 * march-svr
 * com.abin.lee.march.svr.dubbo.model
 */
//@Getter
//@Setter
//@ToString
public class UserRequest implements Serializable{
    private Integer id;
    private String userName;

    public UserRequest() {
    }

    public UserRequest(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userName", userName)
                .toString();
    }
}
