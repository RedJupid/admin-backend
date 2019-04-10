package com.xd.sso.controller;

import com.xd.sso.entity.Msg;
import com.xd.sso.entity.RoleMenu;
import com.xd.sso.service.RoleMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/RoleMenu")
@Api(description = "给角色分配访问的菜单")
public class RoleMenuController {

    @Autowired
    RoleMenuService roleMenuService;

    @PostMapping
    @ApiOperation(value = "根据角色id和菜单id添加角色所能访问的菜单")
    public Msg add(@RequestBody RoleMenu RoleMenu){
        Integer flag = this.roleMenuService.add(RoleMenu);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除角色所拥有的菜单")
    public Msg delete(@PathVariable Integer id){
        Integer flag = this.roleMenuService.delete(id);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据id更新角色所拥有的菜单")
    public Msg update(@RequestBody RoleMenu RoleMenu){
        Integer flag = this.roleMenuService.update(RoleMenu);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询角色所拥有的菜单")
    public RoleMenu getById(@PathVariable Integer id){
        RoleMenu RoleMenu = this.roleMenuService.getById(id);
        return RoleMenu;
    }

    @GetMapping
    @ApiOperation(value = "查询所有角色菜单信息")
    public List<RoleMenu> getAll(){
        return this.roleMenuService.getAll();
    }

}
