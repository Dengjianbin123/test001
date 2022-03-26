package com.bjpowernode;

import com.bjpowernode.Utils.MybaitsUtils;
import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class myapp {
    @Test
    public void testSelect(){
        SqlSession sqlSession = MybaitsUtils.getSqlSession();
        ProvinceDao mapper = sqlSession.getMapper(ProvinceDao.class);
        List<Province> provinceList = mapper.selectName();
        for (Province province:provinceList){
            System.out.println(province);
        }
    }
}
