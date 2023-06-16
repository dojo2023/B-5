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
    <link rel="stylesheet" href=>
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
            <!-- 各ページへのリンク -->
            <nav>
                <ul>
                    <li><a href="/santé/CalendarServlet">カレンダー</a></li>
                    <li><a href="/santé/LibrariesServlet">図鑑</a></li>
                    <li><a href="/santé/CountsServlet">集計</a></li>
                    <li><a href="/santé/MypageServlet">マイページ</a></li>
                    <li><a href="/santé/UsersResultServlet">ログアウト</a></li>
                </ul>
            </nav>
        </header>
    </div>
    <!-- body -->
    <div class="body">
        <body>
            <form method="POST" action="/santé/CountsServlet">
                <p>人数を入力してください</p>
                <p><input type="text" name="counts"></p>
                <input type="submit" name="next" value="次へ">
            </form>
            <script src="Counts.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>