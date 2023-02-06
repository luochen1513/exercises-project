package com.book.entity;

import com.book.dto.requestDto.PageDto;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-05-23 18:31:05
 */
public class User extends PageDto implements Serializable {
    private static final long serialVersionUID = 627029103871267959L;
    
    private Integer userId;
    
    private String username;
    
    private String password;

    private String sex;

    private String email;

    private String phone;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
