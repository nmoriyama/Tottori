<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>ホーム</title>

<!-- jQuery読み込み -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- BootstrapのCSS読み込み -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div style="text-align:center"><br>
	<h1>管理者ホーム画面</h1>
		<font color="red"><form:errors path="*"  />${message}</font>

			
<div class="container-fluid">

  <div class="row">
  <div class="col-xs-8">
    <div class="col-sm-offset-3 col-sm-2"><a href="lendBook"><button type="button" class="btn btn-block">貸出</button></a></div>
	<div class="col-sm-2"><a href="returnBook"><button type="button" class="btn btn-block">返却</button></a></div>
	<div class="col-sm-2"><a href="reserveBook"><button type="button" class="btn btn-block">予約</button></a></div>
	<div class="col-sm-offset-3 col-sm-2"><a href="userRegister"><button type="button" class="btn btn-block">ユーザー登録</button></a></div>
	<div class="col-sm-2 col-md-pull-4"><IMG src="http://group.baristride.co.jp/wp-content/uploads/site-logo.png"width="100" height="22"></div>
	<div class="col-sm-2"><a href="userSearch"><button type="button" class="btn btn-block">ユーザー更新</button></a></div>
	<div class="col-sm-offset-3 col-sm-2"><a href="bookRegister"><button type="button" class="btn btn-block">図書登録</button></a></div>
	<div class="col-sm-2"><a href="blackList"><button type="button" class="btn btn-block">延滞者</button></a></div>
	<div class="col-sm-2"><a href="changeStatus"><button type="button" class="btn btn-block">本の状態変更</button></a></div>
	<div class="col-sm-offset-3 col-sm-2"><a href="userManagement"><button type="button" class="btn btn-block">ユーザー確認</button></a></div>
	<div class="col-sm-2"><a href="bookManagement"><button type="button" class="btn btn-block">本確認</button></a></div>
	<div class="col-sm-2">	<a href="manageLogin"><button type="button" class="btn btn-block">ログアウト</button></a></div>
  </div>
</div>
</div>
</div>
</body>
</html>