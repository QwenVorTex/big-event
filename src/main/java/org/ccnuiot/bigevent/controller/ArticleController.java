package org.ccnuiot.bigevent.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.ccnuiot.bigevent.pojo.Result;
import org.ccnuiot.bigevent.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @GetMapping("/list")
    public Result<String> list(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
        /* 验证token
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return Result.success("所有的文章数据...");
        } catch (Exception e) {
            response.setStatus(401); // 设置响应状态码为401 Unauthorized
            return Result.error("用户信息验证失败,请重新登录");
        }*/
        return Result.success("所有的文章数据...");
    }
}
