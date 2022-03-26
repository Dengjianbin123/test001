package com.bjpowernode.controller;


import com.bjpowernode.Utils.MybaitsUtils;
import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.Province;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class twoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String json = "{}";
        SqlSession sqlSession = MybaitsUtils.getSqlSession();
        ProvinceDao mapper = sqlSession.getMapper(ProvinceDao.class);
        List<Province> provinceList = mapper.selectName();
        ObjectMapper objectMapper = new ObjectMapper();
        json = objectMapper.writeValueAsString(provinceList);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.flush();
        writer.close();
    }
}

