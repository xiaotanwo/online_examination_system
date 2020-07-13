package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.QuestionDao;
import com.foxanfgrapes.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer questionId = Integer.valueOf(request.getParameter("questionId"));
        QuestionDao questionDao = new QuestionDao();
        Questions questions = questionDao.findById(questionId, request);
        if (questions != null) {
            request.setAttribute("curQuestion", questions);
            request.getRequestDispatcher("/question_Update.jsp").forward(request, response);
        } else {
            request.setAttribute("info", "要修改的试题不存在！");
            request.getRequestDispatcher("/info.jsp").forward(request, response);
        }
    }
}
