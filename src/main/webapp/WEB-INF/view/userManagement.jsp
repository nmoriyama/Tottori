<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー管理</title>
</head>
<body>
<table border="" cellpadding="13" align="center">
	<tr>
		<td>ユーザーID</td>
		<td>名前</td>
		<td>アドレス</td>
		<td>メール</td>
		<td>電話番号</td>
		<td>受取図書館ID</td>
		<td>登録日時</td>
		<td>更新日時</td>
	</tr>
	<c:forEach items = "${ Users }" var = "user">
	<tr>	
		<td><c:out value = "${ user.userId }" /></td>
		<td><c:out value = "${ user.userName }" /></td>
		<td><c:out value = "${ user.address }" /></td>
		<td><c:out value = "${ user.mail }" /></td>
		<td><c:out value = "${ user.phoneNumber }" /></td>
		<td><c:out value = "${ user.libraryId }" /></td>
		<td><fmt:formatDate value = "${ user.insertTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
		<td><fmt:formatDate value = "${ user.updateTime }" pattern = "yyyy-MM-dd HH:mm:ss" /></td>
	</c:forEach>
</table>
<form:form modelAttribute="userForm">
	ユーザーID：<input name = "userId"/> 更新日時：<input name = "date"/> <input type="submit" value = "変更"/>
</form:form>
</body>
</html>