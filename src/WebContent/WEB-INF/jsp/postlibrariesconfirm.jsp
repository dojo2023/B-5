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
            <form method="POST" autocomplete="off"
            action="/sante/PostLibrariesConfirmServlet">

                <p>銘柄:${post_lib.getPost_description()}</p>
                <p>酒類:${post_lib.getPost_genre()}</p>
                <p>種類:${post_lib.getPost_kind()}</p>
                <p>度数:${post_lib.getPost_alcon()}</p>
                <p>産地:${post_lib.getPost_from()}</p>
                <p>備考:${post_lib.getPost_remarks()}</p>

                <p>以上の内容で投稿してもよろしいですか？</p>
                <!-- 送信用submit -->
                <div class="post_libraries_confirm_input">
                    <input type="submit" name="submit" value="はい">
                    <input type="submit" name="submit" value="いいえ">
                </div>
            </form>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>