<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー登録</title>
</head>
<body>
    <h1>${message}</h1>
    <form:form modelAttribute="userForm">
        ユーザーID：<input name = "userId"/><br>
        <input type="submit" value = "検索">
    </form:form>
</body>
</html>