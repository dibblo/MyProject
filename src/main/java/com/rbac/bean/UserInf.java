package com.rbac.bean;

import java.util.Date;

public interface UserInf {
    String getId();

    String getUserName();

    String getAccount();

    String getPassword();

    String getStatus();

    Date getLastVisit();

    String getLastIp();

    String getExtConfig();

    void setId(String id);

    void setUserName(String userName);

    void setAccount(String account);

    void setPassword(String password);

    void setStatus(String status);

    void setLastVisit(Date lastVisit);

    void setLastIp(String lastIp);

    void setExtConfig(String extConfig);

}
