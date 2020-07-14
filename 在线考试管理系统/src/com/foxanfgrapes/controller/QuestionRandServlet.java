package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class QuestionRandServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDao questionDao = new QuestionDao();
        HttpSession session = request.getSession(false);
        List questionRandList = questionDao.findRand(request);
        session.setAttribute("questionRand", questionRandList);
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }
}
