package org.ccnuiot.bigevent.controller;

import jakarta.validation.constraints.Pattern;
import org.ccnuiot.bigevent.pojo.Result;
import org.ccnuiot.bigevent.pojo.User;
import org.ccnuiot.bigevent.service.UserService;
import org.ccnuiot.bigevent.utils.JwtUtil;
import org.ccnuiot.bigevent.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        /*if (username != null && username.length() >= 5 && username.length() <= 16 &&
                password != null && password.length() >= 5 && password.length() <= 16
        ) {*/
        //查询用户
        User u = userService.findByUsername(username);
        if (u == null) {
            //没有占用
            //注册
            userService.register(username, password);
            return Result.success();
        } else {
            //占用
            return Result.error("用户名已被占用");
        }
    } /*else {
            //参数不合法
            return Result.error("用户名或密码长度不合法");
        }*/

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {

        //根据用户名查询用户
        User u = userService.findByUsername(username);

        //判断该用户是否存在
        if (u == null) {
            return Result.error("用户名不存在");
        }

        //判断密码是否正确
        if (Md5Util.getMD5String(password).equals(u.getPassword())) {
            //密码正确
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", u.getId());
            claims.put("username", u.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        } else {
            //密码错误
            return Result.error("密码错误");
        }
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
        //根据用户名查找用户
        Map<String, Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");

        User user = userService.findByUsername(username);
        return Result.success(user);
    }
}

