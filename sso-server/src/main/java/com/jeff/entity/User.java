package com.jeff.entity;

import java.util.Date;

public class User {
    /**
     * 
     */
    private Integer uid;

    /**
     * 
     */
    private String uname;

    /**
     * 
     */
    private Date birth;

    /**
     * 
     * @return uid 
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 
     * @param uid 
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 
     * @return uname 
     */
    public String getUname() {
        return uname;
    }

    /**
     * 
     * @param uname 
     */
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    /**
     * 
     * @return birth 
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 
     * @param birth 
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }
}