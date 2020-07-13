package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        List questionlist = (List)questionDao.find(request);
        request.setAttribute("question_Find", questionlist);
        request.getRequestDispatcher("/question_Find.jsp").forward(request, response);
    }
}
