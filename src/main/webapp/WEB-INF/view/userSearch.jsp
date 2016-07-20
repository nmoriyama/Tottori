<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー検索</title>
</head>
<body>
    <h1>${message}</h1>
    <form:form modelAttribute="userForm" method = "get" action="userUpdate">
        ユーザーID：<input name = "userId" value = "${ userForm.userId }"/><br>
        <input type="submit" value = "検索">
    </form:form>
	<a href = "home">戻る</a>
</body>
</html>