<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "entity.Mes" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>管理员后台</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>

<div style="width: 70%;margin-left: 15%">
    <h1 style="margin-top: 10%;text-align: center">管理员后台</h1>
    <ul style="margin-top: 25px" class="nav nav-tabs">
        <li class="active">
            <a href="/mes">评论</a>
        </li>
        <li>
            <a href="temInsert.jsp">温度数据输入</a>
        </li>
        <li>
            <a href="humInsert.jsp">湿度数据输入</a>
        </li>
        <li >
            <a href="accInput.jsp">加速度数据输入</a>
        </li>
        <li>
            <a href="/commonInsert.jsp">日数据输入</a>
        </li>

        <li class="dropdown pull-right">
            <a href="#" data-toggle="dropdown" class="dropdown-toggle">退出<strong class="caret"></strong></a>
            <ul class="dropdown-menu">
                <li>
                    <a href="home.jsp">退出到主页</a>
                </li>
            </ul>
        </li>
    </ul>

    <table class="table" style="margin-top: 20px">
        <thead>
        <tr>
            <th>
                类型
            </th>
            <th>
                性别
            </th>
            <th>
                真实姓名
            </th>
            <th>
                描述
            </th>
            <th>
                手机号
            </th>
            <th>
                固定电话
            </th>
            <th>
                邮箱
            </th>
        </tr>
        </thead>
        <tbody>

            <%
                //获取request域中的留言内容，填充到表中
                List<Mes> mesList = (List<Mes>) request.getAttribute("mes");
                for (Mes mes:mesList) {
                    %>
            <tr>
                <td>
                    <%=mes.getType()%>
                </td>
                <td>
                    <%=mes.getSex()%>
                </td>
                <td>
                    <%=mes.getRealname()%>
                </td>
                <td>
                    <%=mes.getDescription()%>
                </td>
                <td>
                    <%=mes.getMobile()%>
                </td>
                <td>
                    <%=mes.getTel()%>
                </td>
                <td>
                    <%=mes.getEmail()%>
                </td>
            </tr>
                    <%
                }
            %>


        </tbody>
    </table>


</div>



</body>
</html>
