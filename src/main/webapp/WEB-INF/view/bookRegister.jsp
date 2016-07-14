<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>図書登録</title>
</head>
<body>
    <h1>${message}</h1>
    <form:form modelAttribute="bookForm">
   		書名(ふりがな)：<input name = "bookKanaByte"/><br>
        書籍：<input name = "bookName"/><br>
        著者名(ふりがな)：<input name = "authorKanaByte"/><br>
        著者名：<input name = "authorName"/><br>
        出版社名：<input name = "publisher"/><br>
        ISBN：<input name = "isbn"/><br>
        書類種類：<input name = "documentId"/><br>
        棚番号：<input name = "shelfId"/><br>
        図書館番号：<input name = "libraryId"/><br>
        <input type="submit" value = "登録">
    </form:form>
</body>
</html>