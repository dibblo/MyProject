package com.rbac.service;

import com.rbac.bean.UserInf;

import java.util.List;

public interface UserService {
    UserInf get(String id);
    List<UserInf> getUsersByRoleId(String roleId);
}
