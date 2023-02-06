package com.echarts.controller;

import com.echarts.dto.requestDto.PasswordRequestDto;
import com.echarts.dto.responseDto.LoginResponseDto;
import com.echarts.entity.User;
import com.echarts.service.UserService;
import com.echarts.util.Md5Util;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-05-23 18:31:08
 */
@Controller
@RequestMapping("user")
public class UserController extends LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Integer id) {
        return this.userService.queryById(id);
    }

    @ApiOperation(value = "用户信息")
    @GetMapping("userInfo")
    public String userInfo() {
        request.getSession().setAttribute("pageName", "个人信息");
        return "userInfo";
    }


    @ApiOperation(value = "修改密码")
    @GetMapping("userPassword")
    public String userPassword() {
        request.getSession().setAttribute("pageName", "修改密码");
        return "userPassword";
    }

    @PostMapping("queryUser")
    @ApiOperation(value = "查看指定用户信息")
    @ResponseBody
    public Map<String, Object> queryUserByUsername() {
        Map<String, Object> map = new HashMap<>();
        User user = null;
        try {
            LoginResponseDto userInfo = (LoginResponseDto) request.getSession().getAttribute("userInfo");
            String username = userInfo.getUserName();
            user = userService.queryByUsername(username);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", user);
        return map;
    }

    @PostMapping("editPassword")
    @ApiOperation(value = "修改指定用户信息")
    @ResponseBody
    public Map<String, Object> editPassword(@RequestBody PasswordRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        String oldPassword = requestDto.getOldPassword();
        String newPassword = requestDto.getNewPassword();
        String rePassword = requestDto.getRePassword();
        LoginResponseDto userInfo = (LoginResponseDto) request.getSession().getAttribute("userInfo");
        String userName = userInfo.getUserName();
        User user = userService.queryByUsername(userName);
        String resultPassword = user.getPassword();
        if (resultPassword.equals(Md5Util.getMd5(oldPassword))) {
            if (!oldPassword.equals(newPassword)) {
                if (newPassword.equals(rePassword)) {
                    try {
                        userService.updatePassword(userName, newPassword);
                    } catch (Exception e) {
                        map.put("success", false);
                        map.put("errMsg", e.getMessage());
                        return map;
                    }
                } else {
                    map.put("success", false);
                    map.put("errMsg", "确认密码不一致");
                    return map;
                }
            } else {
                map.put("success", false);
                map.put("errMsg", "不能与初始密码相同");
                return map;
            }
        } else {
            map.put("success", false);
            map.put("errMsg", "旧密码错误");
            return map;
        }
        map.put("success", true);
        return map;
    }
}
