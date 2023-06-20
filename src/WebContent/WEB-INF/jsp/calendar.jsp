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
    <link rel="stylesheet" href="calendar.css">
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
            <div class="calendar_management">
                <button id="prev-button" type="button" class="calender_prev">前の月</button>
                <label id="yearMonth" class="calender_yearmonth"></label>
                <label class="calender_countdown">次の予定まであと</label>
                <label class="calender_condition">コンディション</label>
                <button id="next-button" type="button" class="calender_next">次の月</button>
                <table>
                    <thead>
                        <tr>
                            <th class="sunday">日</th>
                            <th>月</th>
                            <th>火</th>
                            <th>水</th>
                            <th>木</th>
                            <th>金</th>
                            <th class="saturday">土</th>
                        </tr>
                    </thead>
                    <tbody id="calendar-body" onclick="clickDisplayAlert()">
                    </tbody>
                </table>
            </div>
            <script src="Schedules.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>