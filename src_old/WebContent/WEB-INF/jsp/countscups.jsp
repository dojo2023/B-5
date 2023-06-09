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
            <form method="POST" action="/santé !/CountsCupsServlet">
                <p>杯数を選択してください</p>
            
                <div class="">
                    <div>
                        名前 <!--入力した各ユーザー名を表示する-->
                    </div><br>
                    <div>
                        <input type="submit" name="cupscountsbutton" value="杯数カウントボタン"> <!--ボタンをお酒のイラストに変更-->
                    </div><br>
                    <div>
                        <input type="text" name="cupscounts"> <!--杯数カウントボタンの値を出力する-->
                    </div><br>
                </div>

                <div class="">
                    <input type="submit" name="regist" value="登録">
                    <input type="submit" name="rate" value="割合表示">
                </div>

            </form>
            <script src="CountsCups.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>