package com.echarts.controller;

import com.echarts.entity.People;
import com.echarts.service.PeopleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (People)表控制层
 *
 * @author makejava
 * @since 2022-06-15 16:23:35
 */
@Api(tags = "人口普查")
@Controller
@RequestMapping("people")
public class PeopleController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private PeopleService peopleService;

    @ApiOperation("人口普查")
    @PostMapping("/chinaPeople")
    @ResponseBody
    public Map<String, List<String>> chinaPeople(@RequestBody String year) {
        String[] years = year.split("=");
        year = years[1];
        Map<String, List<String>> chinaMap = new HashMap<>();
        List<People> peopleList = peopleService.queryAll(Integer.valueOf(year));
        List<String> province = new ArrayList<>();
        List<String> number = new ArrayList<>();
        System.out.println(number);
        List<String> id = new ArrayList<>();
        for (People people : peopleList) {
            province.add(people.getProvince());
            number.add(people.getNumber().toString());
            id.add(people.getId().toString());
        }
        chinaMap.put("province", province);
        chinaMap.put("number", number);
        chinaMap.put("id", id);
        return chinaMap;
    }

    @ApiOperation("下拉列表")
    @PostMapping("/peopleList")
    @ResponseBody
    public Map<String, List<People>> peopleList(@RequestBody String year) {
        String[] years = year.split("=");
        year = years[1];
        Map<String, List<People>> chinaMap = new HashMap<>();
        List<People> peopleList = peopleService.queryAll(Integer.valueOf(year));
        chinaMap.put("peopleList", peopleList);
        return chinaMap;
    }

    @ApiOperation("数据修改")
    @PostMapping("/updatePeople")
    @ResponseBody
    public void updatePeople(@RequestBody People people) {
        peopleService.update(people.getProvince(), people.getNumber(), people.getYear());
    }

    @ApiOperation("排序")
    @PostMapping("/sortPeople")
    @ResponseBody
    public Map<String, List<String>> sortPeople(@RequestBody String year) {
        String[] years = year.split("=");
        year = years[1];
        Map<String, List<String>> chinaMap = new HashMap<>();
        List<People> peopleList = peopleService.queryAllBySort(Integer.valueOf(year));
        List<String> province = new ArrayList<>();
        List<String> number = new ArrayList<>();
        List<String> id = new ArrayList<>();
        for (People people : peopleList) {
            province.add(people.getProvince());
            number.add(people.getNumber().toString());
            id.add(people.getId().toString());
        }
        chinaMap.put("province", province);
        chinaMap.put("number", number);
        chinaMap.put("id", id);
        return chinaMap;
    }

    @ApiOperation("总人数")
    @PostMapping("/queryChinaNumber")
    @ResponseBody
    public Map<String, List<Integer>> queryChinaNumber() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> year = new ArrayList<>();
        year.add(2017);
        year.add(2018);
        year.add(2019);
        year.add(2020);
        year.add(2021);
        List<Integer> number = peopleService.queryChinaNumber();
        System.out.println(number);
        map.put("number", number);
        map.put("year", year);
        return map;
    }

    @ApiOperation("各省人数")
    @PostMapping("/queryYearNumber")
    @ResponseBody
    public Map<String, Integer> queryYearNumber(@RequestBody String year) {
        String[] years = year.split("=");
        year = years[1];
        Map<String, Integer> map = new HashMap<>();
        Integer number = peopleService.queryYearNumber(Integer.valueOf(year));
        map.put("number", number);
        return map;
    }
}

