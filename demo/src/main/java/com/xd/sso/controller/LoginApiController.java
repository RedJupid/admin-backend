package com.xd.sso.controller;

import com.xd.sso.annotation.ServiceLog;
import com.xd.sso.entity.Msg;
import com.xd.sso.entity.User;
import com.xd.sso.service.UserService;
import com.xd.sso.util.JwtUtil;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api")
@Api(description = "登录控制器")
//@Api(tags = {"用户登录控制器"})
public class LoginApiController {

    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
//    @ServiceLog
    @ApiOperation(value = "用户登录返回token", notes = "用户名admin或者zhangsan密码123456")
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType="query", name = "userName", value = "用户名", dataType = "String"),
//            @ApiImplicitParam(paramType="query", name = "password", value = "密码", required = true, dataType = "String"),
//    })
    public Msg login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
//        System.out.println(passwordEncoder.encode(password));
        User DbUser = new User();
        DbUser = userService.getByName(user.getUserName());
        if(DbUser == null){
            Msg.fail().add("detail","用户不存在");
        }
        if (user == null || !passwordEncoder.matches(user.getPassword(), DbUser.getPassword())){

            return Msg.fail().add("detail","用户名密码错误");
        }
        String token = JwtUtil.generateToken(signingKey, user.getUserName());
//        CookieUtil.create(response, jwtTokenCookieName, token, false, -1, "localhost");
        return Msg.success().add("token", token);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "登出请求,token失效")
    public Msg logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        JwtUtil.invalidateRelatedTokens(httpServletRequest);
//        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return Msg.success();
    }
}
