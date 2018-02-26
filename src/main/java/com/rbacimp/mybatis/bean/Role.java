package com.rbacimp.mybatis.bean;

import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("Role")
public class Role implements com.rbac.bean.RoleInf {
    private String id;
    private String name;
    private String remark;
    private Integer sort;
    private String unitId;
    private String unitName;
    private String orgId;
    private String orgName;
    private Date createTime;

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    public Integer getSort() {
        return sort;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
