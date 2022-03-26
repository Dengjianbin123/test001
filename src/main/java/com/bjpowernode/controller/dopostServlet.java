package com.bjpowernode.controller;

import com.bjpowernode.Utils.MybaitsUtils;
import com.bjpowernode.dao.ProvinceDao;
import com.bjpowernode.entity.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class dopostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String provinId = request.getParameter("provinId");
        Integer integer = Integer.valueOf(provinId);

        SqlSession sqlSession = MybaitsUtils.getSqlSession();
        ProvinceDao mapper = sqlSession.getMapper(ProvinceDao.class);
        List<City> cityList = mapper.selectCity(integer);

        ObjectMapper objectMapper = new ObjectMapper();
        String json= objectMapper.writeValueAsString(cityList);

        response.setContentType("application/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(json);
        writer.flush();
        writer.close();
    }

}
