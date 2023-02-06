package com.book.interceptor;

import com.book.dto.responseDto.LoginResponseDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: bai
 * @date: 2022/5/23 18:26
 * @description:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userObject = request.getSession().getAttribute("userInfo");
        if (userObject != null) {
            LoginResponseDto userInfo = (LoginResponseDto) userObject;
            if (userInfo.getUserId() != null) {
                //如果用户已经登录,url为/login或者/,就自动跳转/main
//                if (request.getRequestURI().toLowerCase().contains("/login") || "/".equals(request.getRequestURI())) {
//                    response.sendRedirect("/main");
//                    return false;
//                }
                if ("/".equals(request.getRequestURI())) {
                    response.sendRedirect("/main");
                    return false;
                }
                return true;
            }
        }
        if (request.getRequestURI().toLowerCase().contains("/login") || "/".equals(request.getRequestURI())) {
            return true;
        }
        response.sendRedirect("login");
        return false;
    }
}
