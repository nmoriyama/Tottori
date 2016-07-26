<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>貸出管理</title>
</head>
<body>
<table border="" cellpadding="13" align="center">
	<tr>
		<td>図書名</td>
		<td>著者名</td>
		<td>出版社</td>
		<td>ISBN</td>
		<td>棚番号</td>
		<td>書類種類</td>
		<td>保管図書館</td>
		<td>状態</td>
	<c:forEach items = "${ Books }" var = "book">
	<tr>	
		<td><c:out value = "${ book.bookName }" /></td>
		<td><c:out value = "${ book.authorName }" /></td>
		<td><c:out value = "${ book.publisher }" /></td>
		<td><c:out value = "${ book.isbn }" /></td>
		<td><c:out value = "${ book.shelfId }" /></td>
		<td><c:out value = "${ book.documentId }" /></td>
		<td><c:out value = "${ book.libraryId }" /></td>
		<td><c:out value = "${ book.statusId }" /></td>
	</tr>
	</c:forEach>
</table>
<br>
<table border="" cellpadding="13" align="center">
	<tr>
		<td>ユーザー名</td>
		<td>図書名</td>
		<td>ISBN</td>
		<td>貸出日</td>
	<c:forEach items = "${ Rental }" var = "rental">
	<tr>	
		<td><c:out value = "${ rental.userName }" /></td>
		<td><c:out value = "${ rental.bookName }" /></td>
		<td><c:out value = "${ rental.isbn }" /></td>
		<td><fmt:formatDate value = "${ rental.rentalTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	</c:forEach>
</table>
<form:form modelAttribute="rentalForm">
	ユーザーID：<input name = "userId" /> ISBN：<input name = "useIsbn" /> 
	保管図書館：<input name = "libraryId" /> 更新日時：<input name = "date"/> 
	<input type="submit" value = "変更"/>
</form:form>
</body>
</html>