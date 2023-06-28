<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>図鑑|santé !</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Libraries.css">
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
							class="libraries_leaf" width="16%"></a></li>
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
			</header>
		</div>
		<!-- body -->
		<div class="libraries_body">


			<!-- 図鑑上部の各機能 -->
			<div class="libararies_feature">
				<form method="POST" autocomplete="off"
					action="/sante/LibrariesServlet">
					<input type="text" name="search_box" placeholder="キーワード"> <input
						type="submit" name="submit" value="検索"> <input
						type="submit" name="submit" value="絞り込み"> <input
						type="submit" name="submit" value="投稿">
				</form>
			</div>
			<br>
			<!-- 図鑑の内容 -->
			<div class="content">
				<!-- 一致する結果の有無 -->
				<c:choose>
					<c:when
						test="${not empty searchList or not empty narrowList or not empty librariesList}">
						<div align = "center">

								<c:forEach var="libraries"
									items="${not empty narrowList ? narrowList : not empty searchList ? searchList : librariesList}">
									<table id="libraries_table"><tr>
										<th>番号</th>
										<td>${libraries.libraries_id}</td>
									</tr>
									<tr>
										<th>銘柄</th>
										<td>${libraries.libraries_description}</td>
									</tr>
									<tr>
										<th>酒類</th>
										<td>${libraries.libraries_genre}</td>
									</tr>
									<tr>
										<th>種類</th>
										<td>${libraries.libraries_kind}</td>
									</tr>
									<tr>
										<th>度数</th>
										<td>${libraries.libraries_alcon}</td>
									</tr>
									<tr>
										<th>産地</th>
										<td>${libraries.libraries_from}</td>
									</tr>
									<tr>
										<th>備考</th>
										<td>${libraries.libraries_remarks}</td>
									</tr></table>
								</c:forEach>
						</div>
					</c:when>
					<c:otherwise>
						<div class="result_not_found">
							<p>一致する結果はありません。</p>
						</div>
					</c:otherwise>
				</c:choose>

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
