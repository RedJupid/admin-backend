package com.xd.sso.controller;

import com.xd.sso.entity.Msg;
import com.xd.sso.entity.Role;
import com.xd.sso.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Api(description = "角色控制器")
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping
    @ApiOperation(value = "添加角色")
    public Msg add(@RequestBody Role role){
        Integer flag = this.roleService.add(role);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除角色")
    public Msg delete(@PathVariable Integer id){
        Integer flag = this.roleService.delete(id);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据id更新角色")
    public Msg update(@RequestBody Role role){
        Integer flag = this.roleService.update(role);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据角色id获取角色")
    public Role getById(@PathVariable Integer id){
        Role role = this.roleService.getById(id);
        return role;
    }

    @GetMapping
    @ApiOperation(value = "得到所有角色信息")
    public List<Role> getAll(){
        return this.roleService.getAll();
    }

    @PostMapping("/getWithMenus")
    @ApiOperation(value = "得到该角色能够访问的菜单")
    public Role getWithRoles(@RequestParam String name){
//        String name = role.getName();
        Role result = this.roleService.getWithMenus(name);
        return result;
    }

}
