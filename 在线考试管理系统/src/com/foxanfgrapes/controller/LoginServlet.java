package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        request.setCharacterEncoding("utf-8");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        response.setCharacterEncoding("utf-8");
        UserDao userDao = new UserDao();
        int result = userDao.login(userName, password, request);
        if (result == 1) {
            // 登录成功，给予令牌
            HttpSession session = request.getSession();
            response.sendRedirect("/myWeb/index.html");
        } else {
            response.sendRedirect("/myWeb/login_Error.html");
        }
    }
}
