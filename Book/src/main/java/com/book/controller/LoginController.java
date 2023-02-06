package com.book.controller;

import com.book.dto.requestDto.LoginRequestDto;
import com.book.dto.responseDto.LoginResponseDto;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: bai
 * @date: 2022/5/23 17:11
 * @description:
 */
@Api(tags = "登陆登出")
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "登录页面")
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "跳转主页面")
    @GetMapping("main")
    public String toMain() {
        request.getSession().setAttribute("pageName", "首页");
        return "main";
    }

    @ApiOperation(value = "跳转管理员主页面")
    @GetMapping("mainRoot")
    public String toMainRoot() {
        request.getSession().setAttribute("pageName", "首页");
        return "mainRoot";
    }

    @ApiOperation(value = "登录验证")
    @PostMapping("/checkLogin")
    @ResponseBody
    public Map<String, Object> checkLogin(@RequestBody LoginRequestDto loginRequestDto) {
        Map<String, Object> modelMap = new HashMap<>();
        //是否需要校验验证码
        Boolean needVerify = loginRequestDto.getNeedVerify();
        //获取验证码
        String verifyCodeActual = loginRequestDto.getVerifyCodeActual();
        //获取用户名
        String username = loginRequestDto.getUsername();
        //获取密码
        String password = loginRequestDto.getPassword();
        if (needVerify && !CodeUtil.checkVerifyCode(request, verifyCodeActual)) {
            //验证码错误
            modelMap.put("success", false);
            modelMap.put("errMsg", "验证码错误");
            return modelMap;
        }
        if ("".equals(username) || "".equals(password)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名或密码不可为空");
        } else {
            //通过用户名密码查库
            LoginResponseDto userInfo = userService.getUserInfoByUsernameAndPassword(username, password);
            if (null != userInfo) {
                //userInfo不为空,登陆成功
                modelMap.put("success", true);
                modelMap.put("username", userInfo.getUsername());
                //将信息存入到session
                request.getSession().setAttribute("userInfo", userInfo);
                request.getSession().setAttribute("username", userInfo.getUsername());
            } else {
                User user = userService.queryByUsername(username);
                modelMap.put("success", false);
                if (null != user){
                    modelMap.put("errMsg", "用户名或者密码错误");
                }else {
                    modelMap.put("errMsg", "用户不存在");
                }
            }
        }
        return modelMap;
    }

    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout() {
        Map<String, Object> modelMap = new HashMap<>();
        request.getSession().setAttribute("userInfo", null);
        modelMap.put("success", true);
        return modelMap;
    }

    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    public String logoutGet() {
        request.getSession().setAttribute("userInfo", null);
        return "login";
    }
}
