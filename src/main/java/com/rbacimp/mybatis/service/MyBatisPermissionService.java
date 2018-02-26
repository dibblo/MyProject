package com.rbacimp.mybatis.service;

import com.rbac.bean.PermissionInf;
import com.rbac.service.PermissionService;

import java.util.List;

public interface MyBatisPermissionService extends PermissionService {

    PermissionInf get(String id);
    List<PermissionInf> getAll();
    List<PermissionInf> getPermissionByUser();
    List<PermissionInf> getPermissionByRole();
    List<PermissionInf> getPermissionByResource();
}
