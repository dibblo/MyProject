package com.rbac.service;

import com.rbac.bean.RoleInf;

import java.util.List;

public interface RoleService {
    RoleInf get(String id);
    List<RoleInf> getAllRole();
    List<RoleInf> getRolesByUserId(String userId);
}
