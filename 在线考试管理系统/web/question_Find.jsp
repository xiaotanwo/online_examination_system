<%@ page import="com.foxanfgrapes.entity.Questions" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiaotan
  Date: 2020/7/13
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <table border="2px">
                <tr align="center">
                    <td>试题Id</td>
                    <td>题目</td>
                    <td>A</td>
                    <td>B</td>
                    <td>C</td>
                    <td>D</td>
                    <td>答案</td>
                    <td colspan="2">操作</td>
                </tr>
                <%
                    List<Questions> questionList = (List)request.getAttribute("question_Find");
                    for (Questions question : questionList) {
                %>
                <tr>
                    <td><%=question.getQuestionId()%></td>
                    <td><%=question.getQuestion()%></td>
                    <td><%=question.getOptionA()%></td>
                    <td><%=question.getOptionB()%></td>
                    <td><%=question.getOptionC()%></td>
                    <td><%=question.getOptionD()%></td>
                    <td><%=question.getAnswer()%></td>
                    <td><a href="/myWeb/question/findById?questionId=<%=question.getQuestionId()%>"/>修改</td>
                    <td><a href="/myWeb/question/delete?questionId=<%=question.getQuestionId()%>"/>删除</td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
