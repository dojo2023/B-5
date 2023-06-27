<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="html">
<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>ログイン|santé !</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Login.css">


</head>
<body>
	<div class="wrapper">
		<!-- header -->
		<div class="header">
			<header>
			<img src = "/sante/img/background1.png" class = "headerbackground">
			</header>
		</div>
		<!-- body -->
		<div class="l_body">

			<img src="/sante/img/openedDoor.png" class="login_body">
			<form method="POST" action="/sante/LoginServlet">
				<table class="login_table">
					<tr>
						<td><label>ニックネーム:<br> <input type="text"
								name="users_name" id="nickname" oninput="handleIDInputChange()">
						</label></td>
					</tr>
					<tr>
						<td><label>パスワード:<br> <input type="password"
								name="users_password" id="password">
						</label></td>
					</tr>
					<tr>
						<td><input type="submit" name="login" value="ログイン"
							id="submit_buttom" onclick="saveCredentials()">
							 <input type="reset" name="reset" value="リセット" id="reset_buttom"><br>
						</td>
					</tr>
					<tr>
						<td><label> <a href="/sante/RegistServlet"
								id="regist_move">新規登録はこちら</a>
						</label></td>
					</tr>
				</table>
			</form>
		</div>
		<!-- footer -->
		<div class="login_footer">
			<footer>
			<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
			</footer>
		</div>
	</div>
</body>
</html>
