package com.echarts.dao;

import com.echarts.entity.People;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (People)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-15 16:23:35
 */
public interface PeopleDao {

    List<People> queryAll(@Param("year") Integer year);

    List<People> queryAllBySort(@Param("year") Integer year);

    int update(@Param("province") String province, @Param("number") Integer number,@Param("year") Integer year);

    List<Integer> queryChinaNumber();

    Integer queryYearNumber(@Param("year") Integer year);
}

