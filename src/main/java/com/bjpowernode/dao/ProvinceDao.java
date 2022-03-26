package com.bjpowernode.dao;

import com.bjpowernode.entity.City;
import com.bjpowernode.entity.Province;

import java.util.List;

public interface ProvinceDao {

    public List<Province> selectName();

    public List<City> selectCity(Integer provinceid);
}
