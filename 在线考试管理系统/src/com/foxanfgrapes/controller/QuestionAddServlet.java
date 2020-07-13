package com.foxanfgrapes.controller;

import com.foxanfgrapes.dao.QuestionDao;
import com.foxanfgrapes.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String question, optionA, optionB, optionC, optionD, answer;
        question = request.getParameter("question");
        optionA = request.getParameter("optionA");
        optionB = request.getParameter("optionB");
        optionC = request.getParameter("optionC");
        optionD = request.getParameter("optionD");
        answer = request.getParameter("answer");
        Questions questions = new Questions(null, question, optionA, optionB, optionC, optionD, answer);
        QuestionDao questionDao = new QuestionDao();
        int restult = questionDao.add(questions, request);
        if (restult == 1) {
            request.setAttribute("info", "试题添加成功！");
        } else {
            request.setAttribute("info", "试题添加失败！");
        }
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
