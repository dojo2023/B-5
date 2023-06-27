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
    <link rel="stylesheet" href="css/Schedules.css">
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
            <button id="prev" type="button">前の月</button>
            <button id="next" type="button">次の月</button>
            <div id="calendar"></div>
            <div class="dummy_buttons">
            	<form method="POST" autocomplete="off"
					action="/sante/CalendarServlet">
					<input type="submit"
						name="submit" value="過去予定無"> <input type="submit"
						name="submit" value="過去予定有">
						<input type="submit"
						name="submit" value="未来予定無"> <input type="submit"
						name="submit" value="未来予定有">
            	</form>
            </div>
            <!-- 表示されないスケジュールリスト -->
            <div id="schedules_list">
            	<c:forEach var="e" items="${schedulesList}" varStatus="status">
            		<form>
            			<input type="text" name="id" value="${e.schedules_id}" id="id${status.index}">
            			<input type="text" name="name" value="${e.schedules_name}" id="name${status.index}">
            			<input type="text" name="dt" value="${e.schedules_dt}" id="dt${status.index}">
            			<input type="text" name="date" value="${e.schedules_date}" id="date${status.index}">
            			<input type="text" name="time" value="${e.schedules_time}" id="time${status.index}">
            			<input type="text" name="count" class="${status.last}" id="${status.index}">
            		</form>
            	</c:forEach>
            </div>
           <script src="js/schedules/Schedules.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>