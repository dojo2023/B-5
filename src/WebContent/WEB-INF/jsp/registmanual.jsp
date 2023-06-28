<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>登録|santé!</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Mypage.css">
</head>
	<body>
<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<!-- 各ページへのリンク -->

		</header>

	</div>
	<!-- body -->
	<div align="center">
	<div class="regist_body">

			<img src="">
			<form method="GET" action="/sante/RegistPhysicalsServlet">
				<input type="submit" name="submit" value="次へ" style="
					font-size: 100%; display: block; margin: 10px auto; border: 2px
					solid lightslategray; padding: 10px; width: 150px; outline:
					none; border-radius: 28px; text-align:center;">
			</form>
			<script>

			</script>

	</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer>
			<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
		</footer>
	</div>
</div>
</body>
</html>