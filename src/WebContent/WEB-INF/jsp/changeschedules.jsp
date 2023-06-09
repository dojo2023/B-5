<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>カレンダー|santé!</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Schedules.css">
</head>

<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<img src="/sante/img/background1.png" class="headerbackground">
			<nav>
				<ul class="header_ul">
					<li class="header_li"><a href="/sante/CalendarServlet"><img
							src="/sante/img/calendar_leaf.png" alt="カレンダー"
							class="calendar_leaf" width="16%"></a></li>
					<li class="header_li"><a href="/sante/LibrariesServlet"><img
							src="/sante/img/libraries_leaf.png" alt="図鑑"
							class="libraries_leaf" width="11%"></a></li>
					<li class="header_li"><a href="/sante/CountsServlet"><img
							src="/sante/img/counts_leaf.png" alt="集計" class="counts_leaf"
							width="11%"></a></li>
					<li class="header_li"><a href="/sante/MypageServlet"><img
							src="/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf"
							width="11%"></a></li>
					<li class="header_li"><a href="/sante/LogoutServlet"><img
							src="/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf"
							width="11%"></a></li>
				</ul>
			</nav>
		</header>
	</div>
	<!-- body -->
	<div class="body">
		<body>
			<form method="POST" autocomplete="off"
				action="/sante/ChangeSchedulesServlet">
				日付:<input type="text" name="change_schedules_date" value="${sessionScope.schedules_date}"><br>
				内容:<input type="text" name="change_schedules_name" value="${sessionScope.schedules_name}"><br>
				<input type="submit" name="submit" value="更新">
				<input type="submit" name="submit" value="削除">
				<input type="submit" name="submit" value="キャンセル">
			</form>
		</body>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer> </footer>
	</div>
</div>

</html>