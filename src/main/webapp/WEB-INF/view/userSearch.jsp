<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー検索</title>
</head>
<body>
	<c:forEach items = "${ messages }" var = "message">
		<li><span style="color: #ff0000"><c:out value = "${ message }" /><br></span>
	</c:forEach>
    <form:form modelAttribute="userForm" method = "get" action="userUpdate">
        ユーザーID：<input name = "userId" value = "${ userForm.userId }"/><br>
        <input type="submit" value = "検索">
    </form:form>
	<a href = "home">戻る</a>
</body>
</html>