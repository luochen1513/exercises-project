package com.echarts.service.impl;

import com.echarts.entity.People;
import com.echarts.dao.PeopleDao;
import com.echarts.service.PeopleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (People)表服务实现类
 *
 * @author makejava
 * @since 2022-06-15 16:23:43
 */
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {
    @Resource
    private PeopleDao peopleDao;

    @Override
    public List<People> queryAll(Integer year) {
        return peopleDao.queryAll(year);
    }

    @Override
    public List<People> queryAllBySort(Integer year) {
        return peopleDao.queryAllBySort(year);
    }

    @Override
    public Integer update(String province,Integer number,Integer year) {
        return peopleDao.update(province,number,year);
    }

    @Override
    public List<Integer> queryChinaNumber() {
        return peopleDao.queryChinaNumber();
    }

    @Override
    public Integer queryYearNumber(Integer year) {
        return peopleDao.queryYearNumber(year);
    }

}
