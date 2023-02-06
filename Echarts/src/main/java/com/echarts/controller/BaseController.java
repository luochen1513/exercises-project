package com.echarts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: bai
 * @date: 2022/5/23 17:17
 * @description:
 */
@Controller
public class BaseController {

    @Autowired
    HttpServletRequest request;
}
