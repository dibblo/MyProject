package com.rbacimp.mybatis.bean;

import com.rbac.bean.ResourceInf;
import org.apache.ibatis.type.Alias;

@Alias("Resource")
public class Resource implements ResourceInf{
    private String id;
    private String parentId;
    private String name;
    private int type;
    private String code;
    private String img16;
    private String img32;
    private String img64;
    private String url;

    public String getId() {
        return id;
    }

    public String getParentId() {
        return parentId;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public String getImg16() {
        return img16;
    }

    public String getImg32() {
        return img32;
    }

    public String getImg64() {
        return img64;
    }

    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setImg16(String img16) {
        this.img16 = img16;
    }

    public void setImg32(String img32) {
        this.img32 = img32;
    }

    public void setImg64(String img64) {
        this.img64 = img64;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
