<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>ユーザー登録</title>
</head>
<body>
    <h1>${message}</h1>
    <form:form modelAttribute="userForm">
    <div><form:errors path="*"  /></div>
        ログインID：<input name = "userId"/><br>
        名前：<input name = "userName"/><br>
        住所：鳥取県鳥取市<input name = "address"/><br>
        電話番号：<input name = "phoneNumber"/><br>
        メールアドレス：<input name = "mail"/><br>
        受取図書館：
        <select name = "libraryId">
			<c:forEach items = "${ Library }" var = "library">
				<option value = "${ library.libraryId }" >
				<c:out value = "${ library.libraryName }" /></option>
		</c:forEach>
		</select>
        <input type="submit" value = "登録">
    </form:form>
     <a href = "manageHome">戻る</a>
</body>
</html>