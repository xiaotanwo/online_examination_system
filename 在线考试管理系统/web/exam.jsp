<%@ page import="java.util.List" %>
<%@ page import="com.foxanfgrapes.entity.Questions" %><%--
  Created by IntelliJ IDEA.
  User: xiaotan
  Date: 2020/7/14
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <div align="center">
            <form action="/myWeb/exam">
                <table border="2px">
                    <tr align="center">
                        <td>试题Id</td>
                        <td>题目</td>
                        <td>A</td>
                        <td>B</td>
                        <td>C</td>
                        <td>D</td>
                        <td>答案</td>
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
                            <td>
                                <input type="radio" name="selectAnswer<%=question.getQuestionId()%>" value="A">A
                                <input type="radio" name="selectAnswer<%=question.getQuestionId()%>" value="B">B
                                <input type="radio" name="selectAnswer<%=question.getQuestionId()%>" value="C">C
                                <input type="radio" name="selectAnswer<%=question.getQuestionId()%>" value="D">D
                            </td>
                        </tr>
                    <%
                        }
                    %>
                    <tr align="center">
                        <td colspan="6"><input type="reset" value="重做"></td>
                        <td><input type="submit" value="交卷"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
