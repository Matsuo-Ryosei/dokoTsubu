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
	<h1>どこつぶログイン</h1>
		<script>
	 	alert('ログインに成功しました');
	 	</script>
		<p>ようこそ<c:out value="${loginUser.name}" />さん</p>
		<a href="Main">つぶやき投稿・閲覧へ</a>
</body>
</html>