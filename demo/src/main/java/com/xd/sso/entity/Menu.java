package com.xd.sso.entity;


import java.util.List;

public class Menu {


    private Integer id;

    private String title_us;

    private String title_cn;

    private String title_tw;

    private String icon;

    private String url;

    private Integer parentId;

    private List<Menu> children;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle_us() {
        return title_us;
    }

    public void setTitle_us(String title_us) {
        this.title_us = title_us;
    }

    public String getTitle_cn() {
        return title_cn;
    }

    public void setTitle_cn(String title_cn) {
        this.title_cn = title_cn;
    }

    public String getTitle_tw() {
        return title_tw;
    }

    public void setTitle_tw(String title_tw) {
        this.title_tw = title_tw;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}