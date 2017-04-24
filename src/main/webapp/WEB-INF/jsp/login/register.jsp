<%--
  Created by IntelliJ IDEA.
  User: latiflan
  Date: 2017/3/31
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action='/login/siteLogin'>
    <div>
        账号：<input type="text" name="userName"/><br>
        密码：<input type="password" name="password"/>
        <input type="submit" value="登录"/>
        <input id="register" type="button" value="注册"/>
    </div>
</form>
</body>
</html>
