<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<form action="RegistUser" method="post">
		ユーザー名:<input type="text" name="name"
			value="<c:out value='${user.name}' />"><br>
		<div style="color: red;">
			<c:out value="${errorMsg.name}" />
		</div>
		<br> パスワード:<input type="password" name="pass"
			value="<c:out value='${user.pass}' />"><br>
		<div style="color: red;">
			<c:out value="${errorMsg.pass}" />
		</div>
		<br> <input type="submit" value="登録">
	</form>
</body>
</html>