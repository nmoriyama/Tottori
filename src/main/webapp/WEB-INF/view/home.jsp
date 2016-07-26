<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ホーム</title>
</head>
<body>
	<h2>${LibraryName.libraryName}</h2>
	<a href="logout"><button >ログアウト</button></a>
	<br /><br />
	<a href="lendBook"><button >貸出</button></a>
	<a href="returnBook"><button >返却</button></a>
	<a href="reserveBook"><button >予約</button></a>
	<br /><br />
	<a href="userRegister"><button >ユーザー登録</button></a>
	<a href="userSearch"><button >ユーザー更新</button></a>
	<a href="bookRegister"><button >図書登録</button></a>
	<br /><br />
	<a href="blackList"><button >延滞者</button></a>
	
	<a href="changeStatus"><button >本の状態変更</button></a>
</body>
</html>