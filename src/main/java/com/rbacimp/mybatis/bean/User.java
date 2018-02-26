package com.rbacimp.mybatis.bean;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("User")
public class User implements com.rbac.bean.UserInf {
    private String id;
    private String userName; //昵称
    private String account; //账号
    private String password; //密码
    private String status; //状态
    private Date lastVisit;//
    private String lastIp;
    private String extConfig;//

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public String getExtConfig() {
        return extConfig;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setExtConfig(String extConfig) {
        this.extConfig = extConfig;
    }
}
