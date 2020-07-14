<%@ page import="com.foxanfgrapes.entity.Questions" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiaotan
  Date: 2020/7/14
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <p style="color: red">本次考试成绩：${sessionScope.score}</p>
            <table border="2px">
                <tr align="center">
                    <td>试题Id</td>
                    <td>题目</td>
                    <td>A</td>
                    <td>B</td>
                    <td>C</td>
                    <td>D</td>
                    <td>你的答案</td>
                    <td>正确答案</td>
                </tr>
                <%
                    List<Questions> questionRandList = (List) session.getAttribute("questionRand");
                    for (Questions question : questionRandList) {
                %>
                <tr>
                    <td><%=question.getQuestionId()%></td>
                    <td><%=question.getQuestion()%></td>
                    <td><%=question.getOptionA()%></td>
                    <td><%=question.getOptionB()%></td>
                    <td><%=question.getOptionC()%></td>
                    <td><%=question.getOptionD()%></td>
                    <td><%=session.getAttribute("selectAnswer" + question.getQuestionId())%></td>
                    <td><%=question.getAnswer()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
