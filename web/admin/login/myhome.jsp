<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/17
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/admin/css/home.css">
    <script src="/client/js/home.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.css">
</head>
<body>
<div id="content">
    <div class="head">
        <div class="con">
            <img src="/admin/images/picture.jpg" width="100%" height="100%">
        </div>
        <h1 style="margin-left: 90px">传智书城</h1>
    </div>
    <div class="menu">
        <div class="menu_head">
            <div class="menu_head_1">User:</div>
            <div class="menu_head_2">${sessionScope.user.getUsername()}</div>
        </div>
        <div id="menu_middle">
            <ul style="">
                <li class="item"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/listProduct" target="mainFrame">商品管理</a></li>
                <li class="item"><a href="${pageContext.request.contextPath}/admin/products/download.jsp" target="mainFrame">销售榜单</a> </li>
                <li class="item"><a href="${pageContext.request.contextPath}/findOrders" target="mainFrame" class="left_list">订单管理</a></li>
                <li class="item"><a href="${pageContext.request.contextPath}/manager/ListNoticeServlet" target="mainFrame">公告管理</a></li>
            </ul>
            <div id="menu-separator">
                <hr />
            </div>
        </div>
        <div id="menu-foot">
            <a href="javascript:void(0)"
               onclick="exitSys()">
                <button id="login_btn" value="退出登录" type="button">退出登录</button></a>
        </div>
    </div>
    <div id="main">
        <iframe id="main_1" src="${pageContext.request.contextPath}/admin/login/welcome.jsp" name="mainFrame"></iframe>
    </div>
</div>

</body>
</html>
