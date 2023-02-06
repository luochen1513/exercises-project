package com.echarts.service;

import com.echarts.entity.People;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (People)表服务接口
 *
 * @author makejava
 * @since 2022-06-15 16:23:43
 */
public interface PeopleService {

    List<People> queryAll(Integer year);

    List<People> queryAllBySort(Integer year);

    Integer update(String province,Integer number,Integer year);

    List<Integer> queryChinaNumber();

    Integer queryYearNumber(Integer year);
}
