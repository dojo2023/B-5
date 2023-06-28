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
            <img src = "/sante/img/background1.png" class = "headerbackground">
            <nav>
                <ul class="header_ul">
                    <li class="header_li"><a href="/sante/CalendarServlet"><img src = "/sante/img/calendar_leaf.png" alt="カレンダー" class="calendar_leaf" width="16%"></a></li>
                    <li class="header_li"><a href="/sante/LibrariesServlet"><img src = "/sante/img/libraries_leaf.png" alt="図鑑" class="libraries_leaf" width="11%"></a></li>
                    <li class="header_li"><a href="/sante/CountsServlet"><img src = "/sante/img/counts_leaf.png" alt="集計" class="counts_leaf" width="11%"></a></li>
                    <li class="header_li"><a href="/sante/MypageServlet"><img src = "/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf" width="11%"></a></li>
                    <li class="header_li"><a href="/sante/LogoutServlet"><img src = "/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf" width="11%"></a></li>
            	</ul>
            </nav>
        </header>
    </div>
    <!-- body -->
    <div class="body">
        <body>
            <button id="prev" type="button">前の月</button>
            <button id="next" type="button">次の月</button>
            <div id="calendar"></div>
            <div class="dummy_buttons">
            	<form method="POST" id="date_check" autocomplete="off" action="/sante/CalendarServlet">
					<input type="hidden" name="select_day" value="">
					<input type="submit" name="submit" value="編集">
            	</form>
            </div>
            <!-- 表示されないスケジュールリスト -->
            <div id="schedules_list">
            	<c:forEach var="e" items="${schedulesList}" varStatus="status">
            		<form>
            			<input type="hidden" name="id" value="${e.schedules_id}" id="id${status.index}">
            			<input type="hidden" name="name" value="${e.schedules_name}" id="name${status.index}">
            			<input type="hidden" name="dt" value="${e.schedules_dt}" id="dt${status.index}">
            			<input type="hidden" name="date" value="${e.schedules_date}" id="date${status.index}">
            			<input type="hidden" name="time" value="${e.schedules_time}" id="time${status.index}">
            			<input type="hidden" name="count" class="${status.last}" id="${status.index}">
            		</form>
            	</c:forEach>
            </div>
           <script src="js/schedules/Schedules.js"></script>
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