package com.cheyitou.common.model.po;

import java.util.Date;

public class User {
    private Integer id;

    private String phone;//电话

    private String passwd;//密码

    private Date getCreate;//创建时间

    private Date getModified;//修改时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getGetCreate() {
        return getCreate;
    }

    public void setGetCreate(Date getCreate) {
        this.getCreate = getCreate;
    }

    public Date getGetModified() {
        return getModified;
    }

    public void setGetModifr(Date getModified) {
        this.getModified = getModified;
    }
}