package com.rbac.dao;

import com.rbac.bean.UserInf;

import java.util.List;

public interface UserDao {
    UserInf get(String id);
    List<UserInf> getUsersByRoleId(String roleId);
}
