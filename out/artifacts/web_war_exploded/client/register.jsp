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
    <link href="/client/css/register.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="/Bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/client/js/form.js"></script>
    <script type="text/javascript">
        function changeImage() {
            // 改变验证码图片中的文字
            document.getElementById("img").src = "${pageContext.request.contextPath}/imageCode?time="
                + new Date().getTime();
        }
    </script>
    <title>注册</title>
</head>
<body>
<div class="page">
    <div id="login">
        <h1>regist</h1>
        <form action="/register" method="post">
            <input id="username" type="text" placeholder="用户名" required="required" name="username">
            <input id="pwd" type="password" placeholder="密码" required="required" name="password">
            <input id="mail" type="email" placeholder="邮箱" name="email"><br/>
            <input id="telephone" type="text" placeholder="手机" name="telephone"><br/>
            <div style="color: white;margin-left: 150px;margin-top: 10px">姓别:&nbsp;
                <input type="radio" name="gender" value="男">男
                <input type="radio" name="gender" value="女">女
            </div>
            <hr/>
            <div style="margin-left: 100px;margin-top: 10px">
                <p style="color: white">输入验证码：</p>
                <input style="width: 200px;height: 30px;border: 1px yellowgreen;border-radius: 4px;" type="text" class="textinput" />
                <img  src="${pageContext.request.contextPath}/imageCode" width="180px"
                     height="30" class="textinput" style="height: 30px;" id="img" onclick="changeImage()"/>
            </div>
                <input id="but" type="submit" value="注册">
        </form>
    </div>

</div>
</body>
</html>
