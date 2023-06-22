<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<title>マイページ|santé!</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Mypage.css">
</head>

<div class="wrapper">
	<div class="header">
		<header>
			<h1>
				<div class="wood">
					<img id="logo" src="/sante/img/wood.jpg" alt="画像">
				</div>
			</h1>

			<ul>
				<li><a href="/sante/CalendarServlet">カレンダー</a></li>
                <li><a href="/sante/LibrariesServlet">図鑑</a></li>
                <li><a href="/sante/CountsServlet">集計</a></li>
                <li><a href="/sante/MypageServlet">マイページ</a></li>
                <li><a href="/sante/LoginServlet">ログアウト</a></li>
			</ul>
			<hr>
		</header>
	</div>
	<div class="body">
		<body>
			<form id = "Physicals" method="GET" action="/sante/MypagePhysicalsServlet">
				<input type="submit" name="submit" value="コンディションとアルコール耐性 "><br>
			</form>
			<form  id = "Manual" method="GET" action="/sante/MypageManualServlet">
				<input type="submit" name="submit" value="使い方 ">
			</form>
			<script>

			</script>
		</body>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer> </footer>
	</div>
</div>

</html>