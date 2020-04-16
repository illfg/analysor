<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
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
            <li style="margin-left: 35%;position: absolute">
                <a href="tembyday.jsp">温度舒适度评价</a>
            </li>
            <li style="margin-left: 45%;position: absolute">
                <a href="humbyday.jsp">湿度舒适度评价</a>
            </li>
            <li style="margin-left: 55%;position: absolute">
                <a href="totalbyday.jsp">舒适度总评价</a>
            </li>
            <li class="dropdown active" style="margin-left: 65%;position: absolute">
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
<div class="container-fluid">
    <div class="container-fluid">
        <div class="col-md-9" id="notifyBody">
            <br><br><br>
            <div style="margin-top: 25%;width: 40%;margin-left: 60%;transform: translate(-50%,-50%)">
                <p style="text-align: center;margin-top: 30px;font-size: 200%">乘客意见反馈</p>

                <div class="alert alert-success" style="margin-top: 30px">隐私保护声明：您提供的个人信息仅供反馈使用，我们绝不会泄露给第三方或其他通途，请放心填写</div>
                <%
                    //如果request域中有info属性说明刚刚的有提交，需要将结果信息显示出来
                    String info = (String) request.getAttribute("info");
                    if (info !=null && !"".equals(info)){
                %>
                <p style="text-align: center"><%=info%></p>
                <%
                        //信息打印后应该移除，避免重复打印
                        request.removeAttribute("info");
                    }
                %>
                <form action="/mesInsert" method="post">
                    <p style="margin-top: 20px">反馈类型</p>
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="type" id="type1" value="咨询" checked> 咨询
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="type" id="type2"  value="建议"> 建议
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="type" id="type3"  value="其他"> 其他
                        </label>
                    </div>
                    <p style="margin-top: 20px">性别</p>
                    <div>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="optionsRadios3" value="男" checked> 男
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="sex" id="optionsRadios4"  value="女"> 女
                        </label>
                    </div>
                    <input style="margin-top: 20px" class="form-control" type="text"  id="realName" name="realName" placeholder="请输入真实姓名">
                    <p style="margin-top: 20px">反馈内容</p>
                    <textarea style="width: 100%;height: 100px" name="description" placeholder="请填写需要反馈的内容"></textarea>
                    <p style="margin-top: 20px">回复方式</p>
                    <input style="margin-top: 20px" class="form-control" type="text"  id="mobile" name="mobile" placeholder="请输入手机号">
                    <input style="margin-top: 20px" class="form-control" type="text"  id="tel" name="tel" placeholder="请输入固定电话">
                    <input style="margin-top: 20px" class="form-control" type="text"  id="email" name="email" placeholder="请输入邮箱">
                    <p style="font-size: 90%;margin-top: 5px">请至少填写一种联系方式，以便我们更好的为您提供服务</p>
                    <input style="margin-top: 20px" type="submit" class="submitBottomlg" value="提交">
                </form>
            </div>
        </div>
        <div class="col-md-3">
            <br><br><br>
            <div>
                <h3>联系我们</h3>
                <ul>
                    <br>
                    <li style="font-size: 80%">
                        <a href="contact.jsp" style="font-size: 150%;">联系方式</a>
                    </li>
                    <br>
                    <li style="font-size: 80%">
                        <a href="comment.jsp" style="font-size: 150%;">在线联系</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

</body>
</html>
