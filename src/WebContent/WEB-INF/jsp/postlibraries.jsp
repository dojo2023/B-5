
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
<link rel="stylesheet" href=>
</head>

<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<!-- 各ページへのリンク -->
			<nav>
				<ul>
					<li><a href="/sante/CalendarServlet">カレンダー</a></li>
					<li><a href="/sante/LibrariesServlet">図鑑</a></li>
					<li><a href="/sante/CountsServlet">集計</a></li>
					<li><a href="/sante/MypageServlet">マイページ</a></li>
					<li><a href="/sante/UsersResultServlet">ログアウト</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<!-- body -->
	<div class="body">

		<body>
			<label>投稿</label>
			<br>

			<!-- 下記formのtextboxの内容をsubmitでservletに送る。 -->

			<div class="postlibraries_textbox">
					<form method="POST" autocomplete="off"
						action="/sante/PostLibrariesServlet">
						銘柄:<input type="text" id="description" name="description"
							<c:if test="${not empty  post_lib.getPost_description()}">
							value="${post_lib.getPost_description()}"
							</c:if>
							placeholder="春鹿"><br>
						酒類:<input type="text" id="genre" name="genre"
							<c:if test="${not empty  post_lib.getPost_genre()}">
							value="${post_lib.getPost_genre()}"
							</c:if>
							placeholder="日本酒"><br>
						種類:<input type="text" id="kind" name="kind"
							<c:if test="${not empty  post_lib.getPost_kind()}">
							value="${post_lib.getPost_kind()}"
							</c:if>
							placeholder="辛口"><br>
						度数:<input type="text" id="alcon" name="alcon"
							<c:if test="${not empty  post_lib.getPost_alcon()}">
							value="${post_lib.getPost_alcon()}"
							</c:if>
							placeholder="12"><br>
						産地:<input type="text" id="from" name="from"
							<c:if test="${not empty  post_lib.getPost_from()}">
							value="${post_lib.getPost_from()}"
							</c:if>
							 placeholder="奈良県"><br>
						備考:<input type="text" id="remarks" name="remarks"
							<c:if test="${not empty  post_lib.getPost_remarks()}">
							value="${post_lib.getPost_remarks()}"
							</c:if>
							placeholder="軽い酸味に少し強めの苦味。"><br>
							<input type="submit" name="submit" value="投稿">
							<input type="submit" name="submit" value="キャンセル">
						<!-- 値の不足等でページを遷移させない時にエラーの内容を表示させる。 -->
						<%
							if (request.getAttribute("message") != null) {
						%>
						<p><%=request.getAttribute("message")%></p>
						<%
							}
						%>
					</form>
			</div>
		</body>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer> </footer>
	</div>
</div>

</html>