<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ステータス変更</title>
</head>
<body>
	<c:forEach items = "${ messages }" var = "message">
		<li><span style="color: #ff0000"><c:out value = "${ message }" /><br></span>
	</c:forEach>
	
	<form:form modelAttribute="userForm">
		ユーザーID：<input name = "userId"/><br>
		時間(yyyy/MM/dd HH:mm:ss)：<input name = "date"/><br>
		<input type="submit" value = "変更"/>
	</form:form>
	<a href = "home">戻る</a>

</body>
</html>