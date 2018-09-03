package com.jeff.model;

import java.io.Serializable;

/**
 * Created by zhangying on 2018/8/31.
 */
public class SessionUser implements Serializable{
    // 登录用户访问Token
    private String token;
    // 登录名
    private String account;

    public SessionUser(String token, String account){
        this.token = token;
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
