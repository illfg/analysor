<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/16/2020
  Time: 11:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>总舒适度评价</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="home.jsp">查询系统</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
            <li class="dropdown" style="margin-left: 15%;position: absolute">
                <a href="home.jsp" class="dropdown-toggle" data-toggle="dropdown">系统信息<strong class="caret"></strong></a>
                <ul class="dropdown-menu">

                    <li>
                        <a href="login.jsp">登录</a>
                    </li>
                    <%--  <li class="divider">
                      </li>--%>
                    <li>
                        <a href="signup.jsp">注册</a>
                    </li>
                </ul>
            </li>
            <li  style="margin-left: 25%;position: absolute">
                <a href="accbyday.jsp">振动舒适度评价</a>
            </li>
            <li  style="margin-left: 35%;position: absolute">
                <a href="tembyday.jsp">温度舒适度评价</a>
            </li>
            <li  style="margin-left: 45%;position: absolute">
                <a href="humbyday.jsp">湿度舒适度评价</a>
            </li>
            <li class="active" style="margin-left: 55%;position: absolute">
                <a href="totalbyday.jsp">舒适度总评价</a>
            </li>
            <li class="dropdown" style="margin-left: 65%;position: absolute">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">联系我们<strong class="caret"></strong></a>
                <ul class="dropdown-menu">

                    <li >
                        <a href="contact.jsp">联系方式</a>
                    </li>
                    <%--  <li class="divider">
                      </li>--%>
                    <li>
                        <a href="comment.jsp">在线留言</a>
                    </li>

                </ul>
            </li>
        </ul>
    </div>

</nav>
<div style="margin-left: 20%">

    <h1> <%=(String)request.getAttribute("title")%></h1>
    <br><br><br>
    <h4>平均加速度为<%=(Double)request.getAttribute("pave")%></h4>
    <h4>平均刹车加速度为<%=(Double)request.getAttribute("nave")%></h4>
    <h4>舒适度评价为<%=(Integer)request.getAttribute("suduscore")%></h4>
    <h4><%=(String)request.getAttribute("suducomment")%></h4>
    <%
        Integer suduscore = (Integer) request.getAttribute("suduscore");
        if (suduscore!=100){
    %>
    <h4>建议公交车司机在加减速时慢些和稳些</h4>
    <%
        }
    %>
    <br><br><br>

    <h4>平均温度为<%=(Double)request.getAttribute("tave")%></h4>
    <h4>温度舒适度评价为<%=(Integer)request.getAttribute("temscore")%></h4>
    <h4><%=(String)request.getAttribute("temcomment")%></h4>
    <%
        Double ave = (Double)request.getAttribute("tave");
        if (ave < 22.2){
    %>
    <h4>建议: 请司机打开空调加热</h4>
    <%
    }else if (ave > 25.6){
    %>
    <h4>建议: 请司机打开空调制冷</h4>
    <%
        }
    %>

    <br><br><br>
    <h4>平均温度为<%=(Double)request.getAttribute("have")%></h4>
    <h4>舒适度评价为<%=(Integer)request.getAttribute("humscore")%></h4>
    <h4><%=(String)request.getAttribute("humcomment")%></h4>
    <%
        Double have = (Double)request.getAttribute("have");
        Integer humscore = (Integer) request.getAttribute("humscore");
        if (have < 50&&humscore!=100){
    %>
    <h4>公交车内过于干燥，请司机打开空调加湿</h4>
    <%
    }else if (humscore!=100){
    %>
    <h4>公交车内湿度过大，建议司机打开空调抽湿，或在晴天打开门窗通风</h4>
    <%
        }
    %>
    <br><br>
    <h4>舒适度总评价为<%=(Integer)request.getAttribute("totalscore")%></h4>
    <%
        if ((Integer)request.getAttribute("totalscore") >= 60){
            %>
            <h4>该公交车在这段时间内较为舒适</h4>
            <%
        }else {
            %>
            <h4>该公交车在这段时间舒适度较低</h4>
            <%
        }
    %>


</div>
</body>
</html>
