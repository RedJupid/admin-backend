package com.xd.sso.controller;

import com.xd.sso.entity.Msg;
import com.xd.sso.entity.UserRole;
import com.xd.sso.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRole")
@Api(description = "给用户分配角色")
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @PostMapping
    @ApiOperation(value = "增加用户角色")
    public Msg add(@RequestBody UserRole userRole){
        Integer flag = this.userRoleService.add(userRole);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户角色")
    public Msg delete(@PathVariable Integer id){
        Integer flag = this.userRoleService.delete(id);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据id更新用户角色")
    public Msg update(@RequestBody UserRole userRole){
        Integer flag = this.userRoleService.update(userRole);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获得用户角色")
    public UserRole getById(@PathVariable Integer id){
        UserRole userRole = this.userRoleService.getById(id);
        return userRole;
    }

    @GetMapping
    @ApiOperation(value = "获取所有用户角色信息")
    public List<UserRole> getAll(){
        return this.userRoleService.getAll();
    }

}
