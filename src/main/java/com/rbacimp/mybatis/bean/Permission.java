package com.rbacimp.mybatis.bean;

import com.rbac.bean.PermissionInf;
import org.apache.ibatis.type.Alias;

@Alias("Permission")
public class Permission implements PermissionInf {
    private String id;//主键
    private String code;//编码
    private String name;//名字
    private String remark;//备注
    private String parentId;//父id
    private Integer sort;//排序

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }

    public String getParentId() {
        return parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
