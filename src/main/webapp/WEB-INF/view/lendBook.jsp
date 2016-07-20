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
		<li><c:out value = "${ message }" /><br>
	</c:forEach>
    <form:form modelAttribute="rentalForm">
   		ユーザーID：<input name = "userId"/><br>
        ISBN：<input name = "isbn"/><br>
        図書館番号：
        <select name = "libraryId">
			<c:forEach items = "${ Library }" var = "library">
				<option value = "${ library.libraryId }" >
				<c:out value = "${ library.libraryName }" /></option>
			</c:forEach>
		</select>
		<br>
		
        <input type="submit" value = "貸出"/>
    </form:form>
     <a href = "home">戻る</a>
</body>
</html>