package com.echarts.controller;

import com.echarts.dto.requestDto.RegistRequestDto;
import com.echarts.dto.responseDto.LoginResponseDto;
import com.echarts.entity.User;
import com.echarts.service.UserService;
import com.echarts.util.Md5Util;
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
@Api(tags = "注册")
@Controller
public class RegistController extends BaseController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "注册页面")
    @GetMapping("regist")
    public String login() {
        return "regist";
    }


    @ApiOperation(value = "注册验证")
    @PostMapping("/checkRegist")
    @ResponseBody
    public Map<String, Object> checkRegist(@RequestBody RegistRequestDto registRequestDto) {
        Map<String, Object> modelMap = new HashMap<>();
        //获取用户名
        String username = registRequestDto.getUsername();
        //获取密码
        String password = registRequestDto.getPassword();
        if ("".equals(username) || "".equals(password)) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名或密码不可为空");
        } else {
            //通过用户名密码查库
            LoginResponseDto userInfo = userService.getUserInfoByUsernameAndPassword(username, password);
            if (null != userInfo) {
                modelMap.put("success", false);
                modelMap.put("errMsg", "用户已存在");
            } else {
                modelMap.put("success", true);
                modelMap.put("username", username);
                User user = new User();
                user.setUsername(username);
                user.setPassword(Md5Util.getMd5(password));
                userService.insert(user);
            }
        }
        return modelMap;
    }
}
