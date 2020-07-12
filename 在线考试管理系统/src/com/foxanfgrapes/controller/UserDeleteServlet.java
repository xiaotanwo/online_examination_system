package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer userId = Integer.valueOf(request.getParameter("userId"));
        UserDao userDao = new UserDao();
        int result = userDao.delete(userId, request);
        if (result == 1) {
            request.setAttribute("info", "删除用户成功！");
        } else {
            request.setAttribute("info", "删除用户失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
