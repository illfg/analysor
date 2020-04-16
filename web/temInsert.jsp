<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 4:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>温度数据输入</title>
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
        <li class="active">
            <a href="temInsert.jsp">温度数据输入</a>
        </li>
        <li >
            <a href="humInsert.jsp">湿度数据输入</a>
        </li>
        <li >
            <a href="/accInput.jsp">加速度数据输入</a>
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

    <div class="alert alert-success" style="margin-top: 30px">注意 时间请按格式填写</div>

    <p style="margin-top: 100px">温度数据输入</p>
    <%
        //如果request域中有tem属性说明刚刚的有提交，需要将结果信息显示出来
        String info1 = (String) request.getAttribute("tem");
        if (info1 !=null && !"".equals(info1)){
    %>
    <p style="text-align: center"><%=info1%></p>
    <%
            //信息打印后应该移除，避免重复打印
            request.removeAttribute("tem");
        }
    %>
    <form action="/temInsert" method="post" style="width: 60%">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="车牌号" name="number">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="司机姓名" name="name">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="温度" name="tem">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="日期：yyyy/MM/dd " name="time">
        <input style="margin-top: 20px" class="form-control" type="text" placeholder="具体时刻：HH:mm:ss" name="now">
        <input class="btn btn-primary btn-lg" style="margin-top: 20px" type="submit" value="提交">
    </form>
</div>
</body>
</html>
