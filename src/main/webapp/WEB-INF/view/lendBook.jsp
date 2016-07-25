<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<script  src="<c:url value="/resources/js/input.js" />"></script>
<meta charset="utf-8">
<title>貸出</title>
</head>
<body>
	<c:forEach items = "${ messages }" var = "message">
		<li><span style="color: #ff0000"><c:out value = "${ message }" /><br></span>
	</c:forEach>
	
    <form:form modelAttribute="rentalForm">
        <div><form:errors path="*"  /></div>
	   		ユーザーID：<input name = "userId"/><br>
	        ISBN：<input name = "isbn"/><br>
	        図書館番号：
	        <select name = "libraryId">
				<c:forEach items = "${ Library }" var = "library">
					<option value = "${ library.libraryId }" >
					<c:out value = "${ library.libraryName }" /></option>
				</c:forEach>
			</select>
			<div id="input"></div>
			<input type="button" value="追加" onClick="add()">
			<input type="button" value="削除" onClick="cut()">
			<br>
        <input type="submit" value = "貸出"/>
    </form:form>
     <a href = "home">戻る</a>
</body>
</html>