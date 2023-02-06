package com.echarts.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: bai
 * @date: 2022/5/23 22:54
 * @description:
 */
@Api(tags = "Echarts路由")
@Controller
public class EchartsController extends BaseController{

    @ApiOperation(value = "echarts1")
    @GetMapping("echarts1")
    public String echarts1() {
        request.getSession().setAttribute("pageName", "Echarts首页");
        return "echarts1";
    }

    @ApiOperation(value = "echarts2")
    @GetMapping("echarts2")
    public String echarts2() {
        request.getSession().setAttribute("pageName", "Echarts树图");
        return "echarts2";
    }

    @ApiOperation(value = "echarts3")
    @GetMapping("echarts3")
    public String echarts3() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts3";
    }

    @ApiOperation(value = "echarts21")
    @GetMapping("echarts21")
    public String echarts21() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts21";
    }

    @ApiOperation(value = "echarts20")
    @GetMapping("echarts20")
    public String echarts20() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts20";
    }

    @ApiOperation(value = "echarts19")
    @GetMapping("echarts19")
    public String echarts19() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts19";
    }

    @ApiOperation(value = "echarts18")
    @GetMapping("echarts18")
    public String echarts18() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts18";
    }

    @ApiOperation(value = "echarts17")
    @GetMapping("echarts17")
    public String echarts17() {
        request.getSession().setAttribute("pageName", "人口普查");
        return "/echarts17";
    }
}
