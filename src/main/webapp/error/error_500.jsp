<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러페이지</title>
</head>
<body>
	<h1>오류정보 알림</h1>
	<p><%= exception.getMessage() %></p>
	<p><%= exception.toString()%></p>
</body>
</html>