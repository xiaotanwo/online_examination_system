<%@ page import="com.foxanfgrapes.entity.Users" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiaotan
  Date: 2020/7/12
  Time: 22:14
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
                    <td>用户ID</td>
                    <td>用户姓名</td>
                    <td>用户密码</td>
                    <td>用户性别</td>
                    <td>用户邮箱</td>
                    <td>操作</td>
                </tr>
                <%
                    List<Users> userList = (List)request.getAttribute("user_Find");
                    for (Users user : userList) {
                %>
                        <tr>
                            <td><%=user.getUserId()%></td>
                            <td><%=user.getUserName()%></td>
                            <td>******</td>
                            <td><%=user.getSex()%></td>
                            <td><%=user.getEmail()%></td>
                            <td><a href="/myWeb/user/delete?userId=<%=user.getUserId()%>">删除</a></td>
                        </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
