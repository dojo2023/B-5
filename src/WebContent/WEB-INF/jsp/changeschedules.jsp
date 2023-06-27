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
                    <li><a href="/sante/LogoutServlet">ログアウト</a></li>
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