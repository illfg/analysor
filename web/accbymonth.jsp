<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/15/2020
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按月查询振动舒适度</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/webStyle.css" media="screen" type="text/css" />
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
            <li class="active" style="margin-left: 25%;position: absolute">
                <a href="accbyday.jsp">振动舒适度评价</a>
            </li>
            <li style="margin-left: 35%;position: absolute">
                <a href="tembyday.jsp">温度舒适度评价</a>
            </li>
            <li style="margin-left: 45%;position: absolute">
                <a href="humbyday.jsp">湿度舒适度评价</a>
            </li>
            <li style="margin-left: 55%;position: absolute">
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

<div class = "container-fluid; padding: 0px" >
    <br>
    <h1 style="text-align: center">振动舒适度按月查询</h1>

    <div class="container-fluid">
        <div class="container-fluid">
            <div class="col-md-2"></div>
            <div class="col-md-5" id="notifyBody">
                <br><br><br><br>
                <form action="/sudubymonth" method="post">
                    <%
                        //如果request域中有hum属性说明刚刚的有提交，需要将结果信息显示出来
                        String info = (String) request.getAttribute("info");
                        if (info !=null && !"".equals(info)){
                    %>
                    <p style="text-align: center"><%=info%></p>
                    <%
                            //信息打印后应该移除，避免重复打印
                            request.removeAttribute("info");
                        }
                    %>
                    <p style="margin-top: 20px">请输入要查询的年份</p>
                    <input class="form-control" type="text" name="year" placeholder="yyyy">
                    <p style="margin-top: 20px">请输入要查询的车牌号</p>
                    <input class="form-control" type="text" name="number" placeholder="车牌号">
                    <p style="margin-top: 20px">请选择想要查询的月份</p>
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end1" value="1" checked> 一月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end2" value="2" checked> 二月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end3" value="3" checked> 三月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end4" value="4" checked> 四月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end5" value="5" checked> 五月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end6" value="6" checked> 六月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end7" value="7" checked> 七月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end8" value="8" checked> 八月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end9" value="9" checked> 九月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end10" value="10" checked> 十月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end11" value="11" checked> 十一月份
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="month" id="end12" value="12" checked> 十二月份
                        </label>
                    </div>
                    <input style="margin-top: 20px" type="submit" class="btn btn-primary" value="提交">
                </form>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-4">
                <br><br><br><br>
                <div>
                    <h3>振动舒适度查询</h3>
                    <ul>
                        <br>
                        <li style="font-size: 80%">
                            <a href="accbyweek.jsp" style="font-size: 150%;">按周查询振动舒适度</a>
                        </li>
                        <br>
                        <li style="font-size: 80%">
                            <a href="accbymonth.jsp" style="font-size: 150%;">按月查询振动舒适度</a>
                        </li>
                        <br>
                        <li style="font-size: 80%">
                            <a href="accbyyear.jsp" style="font-size: 150%;">查询一年内振动舒适度</a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
</html>
