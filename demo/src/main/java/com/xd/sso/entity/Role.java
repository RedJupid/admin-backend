package com.xd.sso.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class Role {
    private Integer id;

    @ApiModelProperty(value = "角色名称", name = "name")
    private String name;

    @ApiModelProperty(value = "角色所拥有的菜单", name = "menus", required = false)
    private List<Menu> menus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}