package com.echarts.entity;

import java.io.Serializable;

/**
 * (People)实体类
 *
 * @author makejava
 * @since 2022-06-15 16:21:56
 */
public class People implements Serializable {
    private static final long serialVersionUID = -60863944794822282L;
    
    private Integer id;
    
    private String province;
    
    private Integer number;

    private Integer year;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}

