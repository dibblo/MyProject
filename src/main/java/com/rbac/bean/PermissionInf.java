package com.rbac.bean;

public interface PermissionInf {
    String getId();

    String getCode();

    String getName();

    String getRemark();

    String getParentId();

    Integer getSort();

    void setId(String id);

    void setCode(String code);

    void setName(String name);

    void setRemark(String remark);

    void setParentId(String parentId);

    void setSort(Integer sort);
}
