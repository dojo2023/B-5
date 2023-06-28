<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>集計|santé !</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Counts.css">
</head>

<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<img src="/sante/img/background1.png" class="headerbackground">
			<ul class="header_ul">
				<li class="header_li"><a href="/sante/CalendarServlet"><img
						src="/sante/img/calendar_leaf.png" alt="カレンダー"
						class="calendar_leaf" width="7%"></a></li>
				<li class="header_li"><a href="/sante/LibrariesServlet"><img
						src="/sante/img/libraries_leaf.png" alt="図鑑"
						class="libraries_leaf" width="7%"></a></li>
				<li class="header_li"><a href="/sante/CountsServlet"><img
						src="/sante/img/counts_leaf.png" alt="集計" class="counts_leaf"
						width="7%"></a></li>
				<li class="header_li"><a href="/sante/MypageServlet"><img
						src="/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf"
						width="7%"></a></li>
				<li class="header_li"><a href="/sante/LogoutServlet"><img
						src="/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf"
						width="7%"></a></li>
			</ul>
		</header>
	</div>
	<!-- body -->
	<div class="cups">
		<body>

			<form method="POST" action="/sante/CountsCupsServlet">
				<p>杯数を選択してください</p>

				<c:forEach var="i" begin="0" end="${post_counts.all_member-1}"
					step="1" varStatus="status">
					<div class="cupscounts" ${status.index}>
						<div>
							<c:if test="${post_counts.name_list[i] != null}">
									${post_counts.name_list[status.index]}
							</c:if>
							<c:if test="${post_counts.name_list[i] == null}">
                					guest ${i-1} 
							</c:if>
							<br> <input type="hidden" name="ids[status.index]"
								value="${ids[status.index]}">
						</div>
						<br>
						<div class="field">

							<button class="button" id="down${status.index}">－</button>
							<input type="text" name="counts_cups${status.index}" value='0'
								class="inputtext" id="textbox${status.index}">
							<!--杯数カウントボタンの値を出力する-->
							<button class="button" id="up${status.index}">＋</button>
						</div>
						<button class="button resetbtn" id="reset${status.index}">RESET</button>
					</div>

				</c:forEach>

				<div class="">
					<input type="submit" name="submit" value="登録"> 
					<input type="submit" name="submit" value="割合表示">
				</div>
			</form>
			<script>
				let c = ${post_counts.all_member};
			</script>
			<script src="js/counts/CountsCups.js"></script>
		</body>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer>
			<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
		</footer>
	</div>
</div>

</html>