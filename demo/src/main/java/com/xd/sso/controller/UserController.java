package com.xd.sso.controller;

import com.xd.sso.entity.Msg;
import com.xd.sso.entity.User;
import com.xd.sso.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api(description = "用户控制器")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    @ApiOperation(value = "增加用户")
    public Msg add(@RequestBody User user){
        System.out.println(user.getUserName()+user.getPassword());
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        Integer flag = this.userService.add(user);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除用户")
    public Msg delete(@PathVariable Integer id){
        Integer flag = this.userService.delete(id);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "根据id更新用户")
    public Msg update(@RequestBody User user){
        Integer flag = this.userService.update(user);
        if (flag > 0){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询用户")
    public User getById(@PathVariable Integer id){
        User user = this.userService.getById(id);
        return user;
    }

    @GetMapping
    @ApiOperation(value = "查询所有用户")
    public List<User> getAll(){

        return this.userService.getAll();
    }

    @GetMapping("/getWithRoles/{username}")
    @ApiOperation(value = "根据用户名获取所拥有的角色")
    public User getWithRoles(@PathVariable String username){
        User user = this.userService.getWithRoles(username);
        return user;
    }

}
