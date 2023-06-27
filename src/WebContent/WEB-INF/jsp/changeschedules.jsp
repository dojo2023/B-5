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
					<li class="header_li"><a href="/sante/CalendarServlet" ><img src = "/sante/img/calendar_leaf.png" alt="カレンダー" class="calendar_leaf" width="16%"></a></li>
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
            <h1>予定変更</h1>
            <table>
                <tr>
                    <td>
                        <label>前の画面で取得した日付
                            <input type="time" name="schedules_dt" id="schedule_dt">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>予定の名前
                            <input type="text" name="schedules_name" id="schedules_name">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="add" value="変更">
                        <input type="submit" name="add" value="削除">
                        <input type="submit" name="cansel" value="キャンセル">
                    </td>
                </tr>

            </table>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>