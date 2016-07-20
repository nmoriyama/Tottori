<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>未返却の図書</title>
</head>
<body>
対象者の返却されていない本	<a href = "home">戻る</a>
<table>
	<tr>
    	<td>名前</td>
   		<td>書名</td>
   		<td>貸出日</td>
   		<td>経過日数</td>
   	</tr>
	<c:forEach items = "${ RentalBook }" var = "rentalBook">
		<tr>
			<td><c:out value = "${ rentalBook.authorName }" /></td>
			<td><c:out value = "${ rentalBook.bookName }" /></td>
			<td><fmt:formatDate value = "${ rentalBook.rentalTime }" pattern = "yyyy年MM月dd日"/></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>