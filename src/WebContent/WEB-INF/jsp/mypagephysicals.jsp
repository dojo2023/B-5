<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>アルコール耐性とコンディション|santé!</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Mypage.css">
<link rel="stylesheet" type="text/css" href="css/Login.css">

<style>
.physicals_table {
height: 30%;
	position: absolute;
	left: 35%;
	font-size: 100%;
	padding: 0;
	top:25%;
	overflow:hidden;
}
</style>
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

			<img src="/sante/img/cutlery.png"
				style="width: 350px; padding-left: 600px; top: 200px;">

			<table class = "physicals_table">
				<tr>
					<td><label class="resistance-select">アルコール耐性<br>
							<select name="physicals_resistance"
							style="cursor: pointer; display: flex; font-size: 20px; margin: 10px auto; border: 2px solid lightslategray; padding: 10px; width: 200px; outline: none; border-radius: 4px; background-color: #fff; box-shadow: none; text-align: center;">
								<option value="">選択してください</option>
								<option value="1">高い</option>
								<option value="2">やや高い</option>
								<option value="3">普通</option>
								<option value="4">やや低い</option>
								<option value="5">低い</option>
						</select></label></td>
				</tr>
				<tr>
					<td><label class="condition-select">コンディション<br> <select
							name="physicals_condition"
							style="cursor: pointer; display: flex; font-size: 20px; margin: 10px auto; border: 2px solid lightslategray; padding: 10px; width: 200px; outline: none; border-radius: 4px; background-color: #fff; box-shadow: none; text-align: center;"
							required>
								<option value="">選択してください</option>
								<option value="1">10%</option>
								<option value="2">20%</option>
								<option value="3">30%</option>
								<option value="4">40%</option>
								<option value="5">50%</option>
								<option value="6">60%</option>
								<option value="7">70%</option>
								<option value="8">80%</option>
								<option value="9">90%</option>
								<option value="10">100%</option>
						</select></label></td>
				</tr>
				<tr>
					<td>
						<form method="POST" action="/sante/MypagePhysicalsServlet">
							<input type="submit" name="submit"   value="更新" style = "margin:0">
						</form>
						<form method="GET" action="/sante/MypageServlet">
							<input type="submit" name="submit" value="戻る"  style = "margin:0%">
						</form>
					</td>
				</tr>

			</table>
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