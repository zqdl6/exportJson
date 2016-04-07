package com.nm.model;

import java.util.List;

/**
 * Created by lenovo on 2016/4/5.
 */
public class ChildrenBean {
    private String code;
    private String name;
    private String pCode;
    private List<Children> children;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }
}
