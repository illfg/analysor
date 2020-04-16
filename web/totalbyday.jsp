<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 7:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>时段总舒适查询</title>
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
            <li style="margin-left: 25%;position: absolute">
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

<div class = "container-fluid; padding: 0px" >
    <br>
    <h1 style="text-align: center">总舒适度时段查询</h1>

    <div class="container-fluid">
        <div class="container-fluid">
            <div class="col-md-2"></div>
            <div class="col-md-5" id="notifyBody">
                <br><br><br><br>
                <form action="/totalbyday" method="post">
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
                    <p style="margin-top: 20px">请输入要查询的日期</p>
                    <input class="form-control" type="text" name="time" placeholder="yyyy-MM-dd">
                    <p style="margin-top: 20px">请输入要查询的车牌号</p>
                    <input class="form-control" type="text" name="number" placeholder="车牌号">
                    <p style="margin-top: 20px">请选择想要查询的开始时间段</p>
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start1" value="06:00" checked> 06:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start2" value="07:00" checked> 07:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start3" value="08:00" checked> 08:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start4" value="09:00" checked> 09:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start5" value="10:00" checked> 10:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start6" value="11:00" checked> 11:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start7" value="12:00" checked> 12:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start8" value="13:00" checked> 13:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start9" value="14:00" checked> 14:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start10" value="15:00" checked> 15:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start11" value="16:00" checked> 16:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start13" value="17:00" checked> 17:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start14" value="18:00" checked> 18:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start15" value="19:00" checked> 19:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start16" value="20:00" checked> 20:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start17" value="21:00" checked> 21:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="start" id="start18" value="22:00" checked> 22:00
                        </label>
                    </div>
                    <p style="margin-top: 20px">请选择想要查询的结束时间段</p>
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end1" value="06:00" checked> 06:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end2" value="07:00" checked> 07:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end3" value="08:00" checked> 08:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end4" value="09:00" checked> 09:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end5" value="10:00" checked> 10:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end6" value="11:00" checked> 11:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end7" value="12:00" checked> 12:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end8" value="13:00" checked> 13:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end9" value="14:00" checked> 14:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end10" value="15:00" checked> 15:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end11" value="16:00" checked> 16:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end12" value="17:00" checked> 17:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end13" value="18:00" checked> 18:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end14" value="19:00" checked> 19:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end15" value="20:00" checked> 20:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end16" value="21:00" checked> 21:00
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="end" id="end17" value="22:00" checked> 22:00
                        </label>
                    </div>
                    <input style="margin-top: 20px" type="submit" class="btn btn-primary" value="提交">
                </form>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-4">
                <br><br><br><br>
                <div>
                    <h3>总舒适度查询</h3>
                    <ul>
                        <br>
                        <li style="font-size: 80%">
                            <a href="totalbyweek.jsp" style="font-size: 150%;">按周查询总舒适度</a>
                        </li>
                        <br>
                        <li style="font-size: 80%">
                            <a href="totalbymonth.jsp" style="font-size: 150%;">按月查询总舒适度</a>
                        </li>
                        <br>
                        <li style="font-size: 80%">
                            <a href="totalbyyear.jsp" style="font-size: 150%;">查询一年内总舒适度</a>
                        </li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
</div>

</body>
</html>
