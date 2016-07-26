<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>貸出</title>
</head>
<body>
	<c:forEach items = "${ messages }" var = "message">
		<li><span style="color: #ff0000"><c:out value = "${ message }" /><br></span>
	</c:forEach>
    <form:form modelAttribute="rentalForm">
		ユーザーID：<c:out value = "${ lend.userId }" /><br>
		図書名：<c:out value = "${ lend.bookName }" />
		図書館：<c:out value = "${ lend.libraryName }" />
	
			<br>
        <input type="submit" value = "貸出"/>
    </form:form>
     <a href = "home">戻る</a>
</body>
</html>