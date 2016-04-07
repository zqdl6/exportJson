package com.nm.model;

import java.util.List;

/**
 * Created by lenovo on 2016/4/5.
 */
public class AreaCode {
    private String code;
    private String name;
    private String pCode;
    private List<ChildrenBean> children;

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

    public String getPCode() {
        return pCode;
    }

    public void setPCode(String pCode) {
        this.pCode = pCode;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }
}
