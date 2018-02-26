package com.rbac.bean;

public interface ResourceInf {
    String getId();

    String getParentId();

    String getName();

    int getType();

    String getCode();

    String getImg16();

    String getImg32();

    String getImg64();

    String getUrl();

    void setId(String id);

    void setParentId(String parentId);

    void setName(String name);

    void setType(int type);

    void setCode(String code);

    void setImg16(String img16);

    void setImg32(String img32);

    void setImg64(String img64);

    void setUrl(String url);
}
