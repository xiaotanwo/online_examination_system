package com.foxanfgrapes.controller;

import com.foxanfgrapes.entity.Questions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ExamServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        List<Questions> questionRandList = (List) session.getAttribute("questionRand");
        int score = 0;
        for (Questions question : questionRandList) {
            String answer = question.getAnswer();
            Integer questionId = question.getQuestionId();
            String selectAnswer = request.getParameter("selectAnswer" + questionId);
            // 将答案先存起来
            session.setAttribute("selectAnswer" + questionId, selectAnswer);
            if (answer.equals(selectAnswer)) {
                score += 20;
            }
        }
        session.setAttribute("score", score);
        request.setAttribute("info", "本次考试成绩：" + score + "分");
        request.getRequestDispatcher("/info.jsp").forward(request, response);
    }
}
