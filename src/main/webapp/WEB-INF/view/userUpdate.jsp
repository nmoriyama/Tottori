<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー更新</title>
</head>
<body>
	<c:forEach items = "${ messages }" var = "message">
		<li><span style="color: #ff0000"><c:out value = "${ message }" /><br></span>
	</c:forEach>
    <form:form modelAttribute="userForm">
        ログインID：<input name = "userId" value = "${ updateUser.userId }"/><br>
        名前：<input name = "userName" value = "${ updateUser.userName }"/><br>
        住所：<input name = "address" value = "${ updateUser.address }"/><br>
        電話番号：<input name = "phoneNumber" type="tel" value = "${ updateUser.phoneNumber }"/><br>
        メールアドレス：<input name = "mail" type="email" value = "${ updateUser.mail }"/><br>
        受取図書館：
        <select name = "libraryId">
			<c:forEach items = "${ Library }" var = "library">
				<option value = "${ library.libraryId }" <c:if test = "${ updateUser.libraryId == library.libraryId }">selected</c:if>>
				<c:out value = "${ library.libraryName }" /></option>
			</c:forEach>
		</select><br>
        <input type="submit" value = "登録">
    </form:form>
	<a href = "home">戻る</a>
</body>
</html>