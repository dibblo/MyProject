package com.rbac.service;

import com.rbac.bean.PermissionInf;

import java.util.List;

public interface PermissionService {
    PermissionInf get(String id);
    List<PermissionInf> getAll();
    List<PermissionInf> getPermissionByRole(String roleId);
    List<PermissionInf> getPermissionByUser(String userId);
}
