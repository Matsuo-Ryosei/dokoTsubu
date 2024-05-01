<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
	<h1>どこつぶへようこそ</h1>
	<form action="Login" method="post">
	ユーザー名:<input type="text" name="name"
	value="<c:out value='${user.name}' />"><br>
	<div style="color: red;">
		<c:out value="${errorMsg.name}" />
	</div><br>
	パスワード:<input type="password" name="pass"
	value="<c:out value='${user.pass}' />"><br>
	<div style="color: red;">
		<c:out value="${errorMsg.pass}" />
	</div><br>
	<input type="submit" value="ログイン">
	</form>
</body>
</html>