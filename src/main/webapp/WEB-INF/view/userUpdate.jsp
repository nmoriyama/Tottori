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
        ログインID：<input name = "userId"/><br>
        名前：<input name = "userName"/><br>
        住所：<input name = "address"/><br>
        電話番号：<input name = "phoneNumber"/><br>
        メールアドレス：<input name = "mail"/><br>
        受取図書館(セレクトボックスに)：<input name = "libraryId"/><br>
        <input type="submit" value = "登録">
    </form:form>
</body>
</html>