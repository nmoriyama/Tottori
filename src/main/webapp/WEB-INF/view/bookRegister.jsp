<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="utf-8">
<title>図書登録</title>
</head>
<body>
    <c:forEach items = "${ messages }" var = "message">
		<li><c:out value = "${ message }" /><br>
	</c:forEach>
    <form:form modelAttribute="bookForm">
    <div><form:errors path="*"  /></div>
   		書名(ふりがな)：<input name = "bookKana"/><br>
        書籍：<input name = "bookName"/><br>
        著者名(ふりがな)：<input name = "authorKana"/><br>
        著者名：<input name = "authorName"/><br>
        出版社名：<input name = "publisher"/><br>
        ISBN：<input name = "isbn"/><br>
        書類種類：<input name = "documentId"/><br>
        棚番号：<input name = "shelfId"/><br>
        図書館番号：
        <select name = "libraryId">
			<c:forEach items = "${ Library }" var = "library">
				<option value = "${ library.libraryId }" ><c:out value = "${ library.libraryName }" /></option>
			</c:forEach>
		</select>
        <input type="submit" value = "登録">
    </form:form>
     <a href = "home">戻る</a>
</body>
</html>