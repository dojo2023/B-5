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
            <label>投稿</label><br>
            <!-- 値の不足等でページを遷移させない時にエラーの内容を表示させる。 -->
            <label id="postlibraries_error"></label>
            <!-- 下記formのtextboxの内容をsubmitでservletに送る。 -->
            <form method="POST" autocomplete="off" action="/sante/PostLibrariesServlet.java">
                <div class="postlibraries_textbox">
                    銘柄:<input type="text" id="description" placeholder="春鹿"><br>
                    酒類:<input type="text" id="genre" placeholder="日本酒"><br>
                    種類:<input type="text" id="kind" placeholder="辛口"><br>
                    度数:<input type="text" id="alcon" placeholder="12"><br>
                    産地:<input type="text" id="from" placeholder="奈良県"><br>
                    備考:<input type="text" id="remarks" placeholder="軽い酸味に少し強めの苦味、低アルで柔らかさも感じ飲みやすく後口はすっきり。"><br>
                    <input type="submit" name="post" value="投稿">
                    <input type="submit" name="post" value="キャンセル">
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