<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>使い方|santé!</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Mypage.css">
</head>
<body>
<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<img src="/sante/img/background1.png" class="headerbackground">
			<ul class="header_ul">
				<li class="header_li"><a href="/sante/CalendarServlet"><img
						src="/sante/img/calendar_leaf.png" alt="カレンダー"
						class="calendar_leaf" width="11%"></a></li>
				<li class="header_li"><a href="/sante/LibrariesServlet"><img
						src="/sante/img/libraries_leaf.png" alt="図鑑"
						class="libraries_leaf" width="11%"></a></li>
				<li class="header_li"><a href="/sante/CountsServlet"><img
						src="/sante/img/counts_leaf.png" alt="集計" class="counts_leaf"
						width="11%"></a></li>
				<li class="header_li"><a href="/sante/MypageServlet"><img
						src="/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf"
						width="16%"></a></li>
				<li class="header_li"><a href="/sante/LogoutServlet"><img
						src="/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf"
						width="11%"></a></li>
			</ul>
		</header>
	</div>
	<!-- body -->
	<div class="body">
			<div class="manualpics">
		        <img id="pics" src="/sante/img/calendar_leaf.png" alt="カレンダー使い方" onclick="">
		    </div>
		    <div class="manualbtns">
		    	<input type="submit" name="submit" value="カレンダー" id="calendarbtn">
		    	<input type="submit" name="submit" value="図鑑" id="librarybtn">
		    	<input type="submit" name="submit" value="集計" id="countbtn">
		    	<input type="submit" name="submit" value="マイページ"id="mypagebtn">
		    </div>
			<img src="/sante/img/cutlery.png"
				style="width: 350px; padding-left: 600px; top: 200px;">
			<img src="">
			<form method="GET" action="/sante/MypageServlet">
				<input type="submit" name="submit" value="戻る"
					style="font-size: 100%; display: block; margin: 10px auto; border: 2px solid lightslategray; padding: 10px; width: 150px; outline: none; border-radius: 28px; text-align: center;">
			</form>
			<script>
			document.getElementById("calendarbtn").onclick = function(){
				document.getElementById("pics").src="/sante/img/calendar_leaf.png";
			}
			document.getElementById("librarybtn").onclick = function(){
				document.getElementById("pics").src="/sante/img/libraries_leaf.png";
			}
			document.getElementById("countbtn").onclick = function(){
				document.getElementById("pics").src="/sante/img/counts_leaf.png";
			}
			document.getElementById("mypagebtn").onclick = function(){
				document.getElementById("pics").src="/sante/img/mypage_leaf.png";
			}
			</script>
	</div>

</div>
<!-- footer -->
<div class="footer">
	<footer>
		<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
	</footer>
</div>
</body>
</html>