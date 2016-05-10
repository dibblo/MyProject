<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action='${pageContext.request.contextPath}/siteLogin'>
		<div>
			账号：<input type="text" name="userName" /><br>
			密码：<input type="password" name="password" />
			<input type="submit" value="登录" />
		</div>
	</form>
</body>                                                            
</html>