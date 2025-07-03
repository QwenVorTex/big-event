package org.ccnuiot.bigevent.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.ccnuiot.bigevent.pojo.Result;
import org.ccnuiot.bigevent.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            return true; // 验证通过，继续处理请求
        } catch (Exception e) {
            response.setStatus(401); // 设置响应状态码为401 Unauthorized
            return false; // 验证失败，阻止请求继续处理
        }
    }
}
