<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="/js/jquery-1.12.3.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录</title>
    <script type="">
        $(function () {
            $("#register").click(function(){
                window.location.href="login/register";
            });
        })
    </script>
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