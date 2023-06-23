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
			<label>予定追加</label>
			<br>
			<div class="add_schedules">
				<form method="POST" autocomplete="off"
					action="/sante/AddSchedulesServlet">
					<label>日付:</label><label>"${add_schedules.getEditing_schedules_dt()}"</label><br>
					予定:<input type="text" id="add_schedules_name"
						name="add_schedules_name"
						<c:if test="${not empty add_schedules.getEditing_schedules_name()}">
					value="${add_schedules.getEditing_schedules_name()}"
					</c:if>
						placeholder="飲み会"><br> <input type="submit"
						name="submit" value="追加"> <input type="submit"
						name="submit" value="キャンセル">
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