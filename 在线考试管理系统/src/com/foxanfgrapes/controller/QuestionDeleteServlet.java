package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.valueOf(request.getParameter("questionId"));
        QuestionDao questionDao = new QuestionDao();
        int result = 0;
        result = questionDao.delete(questionId, request);
        if (result == 1) {
            request.setAttribute("info", "试题删除成功！");
        } else {
            request.setAttribute("info", "试题删除失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
