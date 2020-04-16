<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/15/2020
  Time: 9:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>温度舒适度查询结果</title>
</head>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
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
            <li class="active" style="margin-left: 35%;position: absolute">
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
<div style="margin-left: 20%">

    <h1> <%=(String)request.getAttribute("title")%></h1>
    <h4>折线图横坐标为时间</h4>
    <h4>折线图纵坐标为为温度值</h4>
    <div id="main" style="width:50%; height:400px;"></div>
    <h3>平均温度为<%=(Double)request.getAttribute("ave")%></h3>
    <h3>舒适度评价为<%=(Integer)request.getAttribute("score")%></h3>
    <h3><%=(String)request.getAttribute("comment")%></h3>
    <%
        Double ave = (Double)request.getAttribute("ave");
        if (ave < 22.2){
    %>
    <h3>建议: 请司机打开空调加热</h3>
    <%
    }else if (ave > 25.6){
    %>
    <h3>建议: 请司机打开空调制冷</h3>
    <%
        }
    %>
</div>
</body>
<script type="text/javascript">
    // based on prepared DOM, initialize echarts instance
    var myChart = echarts.init(document.getElementById('main'));

    // specify chart configuration item and data
    option = {
        xAxis: {
            type: 'category',
            data: [
                <%
                    List<Integer> keys = (List<Integer>) request.getAttribute("keys");
                    List<Double> values =(List<Double>) request.getAttribute("values");
                    request.removeAttribute("keys");

                    request.removeAttribute("values");
                    for(int i = 0; i < keys.size(); i++) {
                      if (i + 1 == keys.size()){

                          %>
                            "<%=keys.get(i)%>"
                          <%
                      }else {
                           %>
                            "<%=keys.get(i)%>",
                           <%
                      }
                    }
                %>
            ]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [<%
                    for(int i = 0; i < values.size(); i++) {
                      if (i + 1 == values.size()){
                                      %>
                            "<%=values.get(i)%>"
                            <%
                        }else {
                             %>
                            "<%=values.get(i)%>",
                            <%
                       }
                    }
                %>
            ],
            type: 'line'
        }]
    };

    // use configuration item and data specified to show chart
    myChart.setOption(option);
</script>
</html>
