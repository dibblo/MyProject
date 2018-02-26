package com.rbac.bean;

import java.util.Date;

public interface RoleInf {
    String getId();

    String getName();

    String getRemark();

    Integer getSort();

    void setId(String id);

    void setName(String name);

    void setRemark(String remark);

    void setSort(Integer sort);

    String getUnitId();

    void setUnitId(String unitId);

    String getUnitName();

    void setUnitName(String unitName);

    String getOrgId();

    void setOrgId(String orgId);

    String getOrgName();

    void setOrgName(String orgName);

    Date getCreateTime();

    void setCreateTime(Date createTime);

}
