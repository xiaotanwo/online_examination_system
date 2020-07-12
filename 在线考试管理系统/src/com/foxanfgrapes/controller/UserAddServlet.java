package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.UserDao;
import com.foxanfgrapes.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        Users user = new Users(null, userName, password, sex, email);
        UserDao userDao = new UserDao();
        int result = userDao.add(user, request);
        if (result == 1) {
            request.setAttribute("info", "用户注册成功！");
        } else {
            request.setAttribute("info", "用户注册失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
