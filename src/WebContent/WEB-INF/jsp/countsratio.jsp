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
<link rel="stylesheet" href="css/Counts.css">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<script
	src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
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
					<li><a href="/sante/LogoutServlet">ログアウト</a></li>
				</ul>
			</nav>
		</header>
	</div>
	<!-- body -->
	<div class="body">
		<body>
			<form method="POST" action="/sante/CountsRatioServlet">

				<div class="">
					<input type="submit" name="submit" value="登録"> <input
						type="submit" name="submit" value="戻る">
				</div>

			</form>
			<div class="chart-container">
				<canvas id="Chart"></canvas>
			</div>

			<c:forEach var="e" items="${post_counts.name_list}" varStatus="status">
			 	<input type="hidden" id="name${status.index}" value="${e}">
			 	<input type="hidden" class="name${status.last}" value="${status.index } ">
			</c:forEach>

			<c:forEach var="e" items="${post_counts.counts_list}" varStatus="status">
				<input type="hidden" id="counts${status.index}" value="${e}">
				<input type="hidden" class="counts${status.last}" value="${status.index } ">

			</c:forEach>



			<script>
				//	<c:forEach var="e" items="${post_counts.name_list}">
				//	console.log("${e}");
				//	</c:forEach>
				//<c:forEach var="e" items="${post_counts.counts_list}">
				//console.log("${e}");
				//</c:forEach>
				//    	name = [
				//		    	<c:forEach var="e" items="${post_counts.name_list}">
				//		    		'${e}',
				//		   	 	</c:forEach>
				//			];
				//			countscups = [
				//		  		 <c:forEach var="e" items="${post_counts.counts_list}">
				//		    		'${e}',
				//		    	</c:forEach>
				//			];
				//			console.log(name[1]);
				//			console.log(countscups[0]);
			</script>
			<script src="js/counts/CountsRatio.js"></script>
			<!--割合のグラフを挿入-->
		</body>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer> </footer>
	</div>
</div>

</html>