package com.bjpowernode.dao;

import com.bjpowernode.entity.City;
import com.bjpowernode.entity.Province;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProvinceDao {

    public List<Province> selectName();

    public List<City> selectCity(Integer provinceid);

    public int insertProvince(@Param("id")Integer id,
                              @Param("name")String name,
                              @Param("jiancheng")String jiancheng,
                              @Param("shenghui")String shenghui);
}
