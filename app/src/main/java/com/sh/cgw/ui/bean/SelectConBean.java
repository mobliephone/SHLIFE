package com.sh.cgw.ui.bean;

/**
 * 作者：created by cgw on 2019/7/10 22:03
 * 类注释：
 */
public class SelectConBean {

    private int id;
    private String name;

    public SelectConBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
