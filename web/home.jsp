<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 4/14/2020
  Time: 9:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公交车舒适度评价系统</title>
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
            <li class="dropdown active" style="margin-left: 15%;position: absolute">
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
<div class="container-fluid">
    <div class="container-fluid">
        <div class="col-md-2"></div>
        <div class="col-md-5" id="notifyBody">
            <br><br><br><br>
            <h1>关于系统</h1>
            <br>
            <h3>一，系统简介</h3>
            <br>
            <ol>
                <li>
                    经济的发展带来人们生活的改变,民众日益增长的服务质量要求对公交的运营和发展提出了新的挑战。方便、快捷、舒适的出行方式成了人们的首选,提高公交车服务质量将是提高公交客流量的有效途径。
                    研究公交车舒适度可以促进公交环境的改善,可以为公交服务质量的提高提供科学指导。因此,研究公交车舒适度具有积极的意义。
                    在研究车辆舒适度评价时，多源传感器数据引入车辆舒适度评价系统中，先对公交车辆的关键传感器数据进行采集，然后分析数据，根据数据给出车辆舒适度数据，更加精准，避免人为客观因素的影响。
                </li>
                <li>
                    在本系统中，主要是能查看到关于振动，温度，湿度的舒适度查询，以及总的舒适度查询，在留言板块，乘客能留下自己的想法，让管理者看到。
                </li>
            </ol>
            <br>
            <h3>二，系统优点</h3>
            <br>
            <h4>本系统采用网站形式的页面，导航方便，使用简便，清楚易懂。
                适用于任何系统的浏览器，不用下载任何插件或者APP。在能够查看关于振动，温度，湿度，以及总的舒适度信息外，还能增加了许多其他的板块，实用性更强</h4>
            <br>
            <h3>三，发展历程</h3>
            <br>
            <ol>
                <li>
                    该系统在国内的发展：目前，基于多源传感器数据的公交车舒适度评价系统，对于研究者而言，只是停留在报告上，真正投入使用的舒适度评价系统还没有。
                </li>
                <li>
                    该系统对于乘客而言，还是比较新颖的，因为目前大多数乘客使用的，还仅仅在于路线以及时间的查询上，对于公交车舒适度，虽然乘客感觉到不舒服，但是因为一些原因还会继续乘坐。公交车服务跟不上人们的需求。
                </li>
            </ol>

            <br>
            <h3>四，发展前景</h3>
            <br>
            <h4>使用基于多源传感器数据的公交车舒适度评价系统建站平台，关注公交车的舒适度，持续改善乘客的乘坐环境，建设良好的公共交通服务平台。</h4>
            <ol>
                <li>
                    在国家经济发展如此迅速下，人们将会越来越注重生活品质，公交车是人们在生活中出行的重要方式，公交车舒适度将会越来越被引起重视，政府也会投入许多资金，帮助建立公交车服务平台，改善乘车环境。
                </li>
                <li>
                    这个系统采用网页编辑模板，便捷调整整个网站的外观、结构、内容、功能模块和排版布局。
                </li>
                <li>
                    简化企业网站的建设、管理和维护过程，即开即用并且无需额处购买网站空间，这样的模式很简单实用。
                </li>
                <li>
                    逐步整合第三方交流平台，提供一个良好的服务交流平台，充分利用这个系统达到改善乘车环境的目的。
                </li>
            </ol>
            <br>
            <h3>五，网站使用方法介绍</h3>
            <br>
            <ol>
                <li>
                    该系统页面头部，导航栏目下和页面里有多个功能链接，挑选自己想要的信息，点击即可。如果是乘客，不需要登录就可以看到关于振动，温度，湿度的舒适度信息以及总的舒适度信息，并且可以在联系我们板块中留言，根据自己的乘坐体验，给予一些建议，或者是投诉 。在留言功能方面，只可以看到自己所提交的内容,安全又保密。
                </li>
                <li>
                    管理者可以根据这个系统看到乘客的想法和需求，以此作为完善公交车服务以及改进公交车设施的参考意见。
                </li>
                <li>
                    管理者需要登录/注册，才能有权限查看所有留言信息.
                </li>
            </ol>

        </div>
        <div class="col-md-1"></div>
        <div class="col-md-4">
            <br><br><br><br><br><br>
            <div>
                <h3>舒适度查询</h3>
                <ul>
                    <br>
                    <li style="font-size: 80%">
                        <a href="accbyday.jsp" style="font-size: 150%;">振动舒适度评价</a>
                    </li>
                    <br>
                    <li style="font-size: 80%">
                        <a href="tembyday.jsp" style="font-size: 150%;">温度舒适度评价</a>
                    </li>
                    <br>

                    <li style="font-size: 80%">
                        <a href="humbyday.jsp" style="font-size: 150%;">湿度舒适度评价</a>
                    </li>
                    <br>
                    <li style="font-size: 80%">
                        <a href="totalbyday.jsp" style="font-size: 150%;">舒适度总评价</a>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

</body>
</html>
