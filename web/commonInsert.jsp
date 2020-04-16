<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/15/2020
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>日数据输入</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<div style="width: 70%;margin-left: 15%">
    <h1 style="margin-top: 10%;text-align: center">管理员后台</h1>
    <ul style="margin-top: 25px" class="nav nav-tabs">
        <li >
            <a href="/mes">评论</a>
        </li>
        <li>
            <a href="temInsert.jsp">温度数据输入</a>
        </li>
        <li>
            <a href="humInsert.jsp">湿度数据输入</a>
        </li>
        <li >
            <a href="/accInput.jsp">加速度数据输入</a>
        </li>
        <li class="active">
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

    <div class="alert alert-success" style="margin-top: 30px">注意 请按格式填写</div>


    <p style="margin-top: 30px">日数据输入</p>
    <%
        //如果request域中有hum属性说明刚刚的有提交，需要将结果信息显示出来
        String info2 = (String) request.getAttribute("info");
        if (info2 !=null && !"".equals(info2)){
    %>
    <p style="text-align: center"><%=info2%></p>
    <%
            //信息打印后应该移除，避免重复打印
            request.removeAttribute("info");
        }
    %>
    <form action="/commonInsert" method="post" style="width: 60%">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="车牌号" name="number">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="湿度 浮点数" name="hum">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="温度 浮点数" name="tem">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="加速度 浮点数" name="acc">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="年份：yyyy " name="year">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="月份：MM" name="month">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="周数：W" name="week">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="天数：dd(30天制)" name="day">
        <input class="btn btn-primary btn-lg" style="margin-top: 20px" type="submit" value="提交">
    </form>

</div>

</body>
</html>
