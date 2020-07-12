package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List list = userDao.find(request);
        request.setAttribute("user_Find", list);
        request.getRequestDispatcher("/user_Find.jsp").forward(request, response);
    }
}
