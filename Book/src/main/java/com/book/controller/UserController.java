package com.book.controller;

import com.book.dto.requestDto.PasswordRequestDto;
import com.book.dto.responseDto.LoginResponseDto;
import com.book.entity.Book;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.util.Md5Util;
import io.swagger.annotations.Api;
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
@Api(tags = "用户管理")
@Controller
@RequestMapping("user")
public class UserController extends LoginController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @ApiOperation(value = "跳转用户列表")
    @GetMapping("userList")
    public String userList() {
        request.getSession().setAttribute("pageName", "用户管理");
        return "user-list";
    }

    @ApiOperation(value = "root用户信息")
    @GetMapping("userInfoRoot")
    public String userInfoRoot() {
        request.getSession().setAttribute("pageName", "个人信息");
        return "userInfoRoot";
    }

    @ApiOperation(value = "root用户信息")
    @GetMapping("userInfoRoot1")
    public String userInfoRoot1() {
        request.getSession().setAttribute("pageName", "修改个人信息");
        return "userInfoRoot1";
    }

    @ApiOperation(value = "用户信息")
    @GetMapping("selectUser")
    public String userSelect() {
        request.getSession().setAttribute("pageName", "用户详情");
        return "selectUser";
    }

    @ApiOperation(value = "修改用户信息")
    @GetMapping("userUpdate")
    public String userUpdate() {
        request.getSession().setAttribute("pageName", "修改用户");
        return "updateUser";
    }

    @ApiOperation(value = "添加用户信息")
    @GetMapping("insertUser")
    public String insertUser() {
        request.getSession().setAttribute("pageName", "添加用户");
        return "insertUser";
    }

    @ApiOperation(value = "用户信息")
    @GetMapping("userInfo")
    public String userInfo() {
        request.getSession().setAttribute("pageName", "个人信息");
        return "userInfo";
    }

    @ApiOperation(value = "用户信息")
    @GetMapping("userInfo1")
    public String userInfo1() {
        request.getSession().setAttribute("pageName", "修改个人信息");
        return "userInfo1";
    }

    @ApiOperation(value = "修改密码")
    @GetMapping("userPassword")
    public String userPassword() {
        request.getSession().setAttribute("pageName", "修改密码");
        return "userPassword";
    }

    @ApiOperation(value = "修改root密码")
    @GetMapping("userPasswordRoot")
    public String userPasswordRoot() {
        request.getSession().setAttribute("pageName", "修改密码");
        return "userPasswordRoot";
    }

    @PostMapping("queryUser")
    @ApiOperation(value = "查看指定用户信息")
    @ResponseBody
    public Map<String, Object> queryUserByUsername() {
        Map<String, Object> map = new HashMap<>();
        User user = null;
        try {
            LoginResponseDto userInfo = (LoginResponseDto) request.getSession().getAttribute("userInfo");
            String username = userInfo.getUsername();
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
    @ApiOperation(value = "修改指定用户密码")
    @ResponseBody
    public Map<String, Object> editPassword(@RequestBody PasswordRequestDto requestDto) {
        Map<String, Object> map = new HashMap<>();
        String oldPassword = requestDto.getOldPassword();
        String newPassword = requestDto.getNewPassword();
        String rePassword = requestDto.getRePassword();
        LoginResponseDto userInfo = (LoginResponseDto) request.getSession().getAttribute("userInfo");
        String username = userInfo.getUsername();
        User user = userService.queryByUsername(username);
        String resultPassword = user.getPassword();
        if (resultPassword.equals(Md5Util.getMd5(oldPassword))) {
            if (!oldPassword.equals(newPassword)) {
                if (newPassword.equals(rePassword)) {
                    try {
                        userService.updatePassword(username, newPassword);
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

    @PostMapping("updateUser")
    @ApiOperation(value = "修改指定用户信息")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        if ("".equals(user.getUsername()) || "".equals(user.getSex()) || "".equals(user.getEmail()) || "".equals(user.getPhone())) {
            map.put("success", false);
            map.put("errMsg", "不能有空白项");
            return map;
        } else {
            if (user.getPhone().length() != 11) {
                map.put("success", false);
                map.put("errMsg", "手机号格式错误");
                return map;
            } else {
                try {
                    userService.update(user);
                    map.put("success", true);
                    return map;
                } catch (Exception e) {
                    map.put("success", false);
                    map.put("errMsg", "用户名/邮箱/手机号重复");
                    return map;
                }
            }
        }
    }

    @ApiOperation(value = "查询列表数据(包括分页,模糊,条件查询)")
    @PostMapping("getList")
    @ResponseBody
    public Map<String, Object> getList(@RequestBody User user) {
        Map<String, Object> map = null;
        try {
            map = userService.queryPageList(user);
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }

    @PostMapping("userSelect")
    @ApiOperation(value = "查看指定用户信息")
    @ResponseBody
    public Map<String, Object> userSelect(Integer userId) {
        Map<String, Object> map = new HashMap<>();
        User user = null;
        try {
            user = userService.queryById(userId);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        map.put("data", user);
        return map;
    }

    @PostMapping("resetPassword")
    @ApiOperation(value = "修改指定用户信息")
    @ResponseBody
    public Map<String, Object> resetPassword(@RequestBody User user) {
        HashMap<String, Object> map = new HashMap<>();
        user.setPassword(Md5Util.getMd5("1513"));
        boolean reset = false;
        String username = (String) request.getSession().getAttribute("username");
        if (userService.queryById(user.getUserId()).getUsername()
                .equals(username)) {
            reset = true;
        }
        try {
            userService.update(user);
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        map.put("success", true);
        if (reset) {
            map.put("reset", true);
        } else {
            map.put("reset", false);
        }
        return map;
    }

    @PostMapping("userInsert")
    @ResponseBody
    @ApiOperation(value = "添加用户")
    public Map<String, Object> userInsert(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        User queryByUsername = userService.queryByUsername(user.getUsername());
        User queryByEmail = userService.queryByEmail(user.getEmail());
        User queryByPhone = userService.queryByPhone(user.getPhone());
        if ("".equals(user.getUsername()) || "".equals(user.getSex()) || "".equals(user.getEmail()) || "".equals(user.getPhone())) {
            map.put("success", false);
            map.put("errMsg", "不能有空白项");
            return map;
        } else {
            if (queryByUsername != null) {
                map.put("success", false);
                map.put("errMsg", "用户名已存在");
                return map;
            } else {
                if (!user.getSex().equals("男") && !user.getSex().equals("女")) {
                    map.put("success", false);
                    map.put("errMsg", "非法性别");
                    return map;
                } else {
                    if (queryByEmail != null) {
                        map.put("success", false);
                        map.put("errMsg", "该邮箱已绑定");
                        return map;
                    } else {
                        if (user.getPhone().length() != 11) {
                            map.put("success", false);
                            map.put("errMsg", "手机号格式错误");
                            return map;
                        } else {
                            if (queryByPhone != null) {
                                map.put("success", false);
                                map.put("errMsg", "该手机号已绑定");
                                return map;
                            } else {
                                try {
                                    userService.insertAll(user);
                                    map.put("success", true);
                                    return map;
                                } catch (Exception e) {
                                    map.put("success", false);
                                    map.put("errMsg", e.getMessage());
                                    return map;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @PostMapping("userDelete")
    @ResponseBody
    @ApiOperation(value = "删除图书")
    public Map<String, Object> userDelete(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            userService.deleteById(user.getUserId());
        } catch (Exception e) {
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }
}
