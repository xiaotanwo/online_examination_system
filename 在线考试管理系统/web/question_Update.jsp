<%@ page import="com.foxanfgrapes.entity.Questions" %><%--
  Created by IntelliJ IDEA.
  User: xiaotan
  Date: 2020/7/13
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <%
            Questions question = (Questions)request.getAttribute("curQuestion");
        %>
        <div align="center">
            <form action="/myWeb/question/update" method="get">
                <table border="2px">
                    <tr>
                        <td>试题Id</td>
                        <td><input type="text" name="questionId" readonly value="<%=question.getQuestionId()%>"></td>
                    </tr>
                    <tr>
                        <td>题目</td>
                        <td><input type="text" name="question" value="<%=question.getQuestion()%>"></td>
                    </tr>
                    <tr>
                        <td>A</td>
                        <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>
                    </tr>
                    <tr>
                        <td>B</td>
                        <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>
                    </tr>
                    <tr>
                        <td>C</td>
                        <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>
                    </tr>
                    <tr>
                        <td>D</td>
                        <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"></td>
                    </tr>
                    <tr>
                        <td>答案</td>
                        <td>
                            <input type="radio" name="answer" value="A" <%="A".equals(question.getAnswer()) ? "checked" : ""%>>A
                            <input type="radio" name="answer" value="B" <%="B".equals(question.getAnswer()) ? "checked" : ""%>>B
                            <input type="radio" name="answer" value="C" <%="C".equals(question.getAnswer()) ? "checked" : ""%>>C
                            <input type="radio" name="answer" value="D" <%="D".equals(question.getAnswer()) ? "checked" : ""%>>D
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2"><input type="submit" value="提交"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
