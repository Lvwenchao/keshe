<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/4
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/client/css/login.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../Bootstrap/css/bootstrap.css">
    <script src="JS/login.js" type="text/javascript"></script>
    <
    <title>登录</title>
</head>
<body>
<div class="page">
    <div id="login">
        <h1>Login</h1>
        <form action="/login" method="post">
            <input id="username" type="text" placeholder="用户名" required="required" name="username">
            <input id="pwd" type="password" placeholder="密码" required="required" name="password"><br>
            <div style="margin-left: 110px;margin-top: 10px;color: white">
                <input type="checkbox" name="checkbox" value="checkbox01" />记住用户名
                &nbsp;&nbsp;
                <input type="checkbox" name="checkbox" value="checkbox02" )/> 自动登录<br/>
            </div>
            <input class="but1" type="submit" value="登录">
            <input class="but2" type="button"  onclick="window.open('/client/register.jsp')" value="注册">
        </form>
    </div>

</div>
</body>
</html>
