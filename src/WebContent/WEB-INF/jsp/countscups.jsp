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
    <div class="">
        <body>
            
                <p>杯数を選択してください</p>
            
                <div class="cupscounts">
                    <div>
                        名前 <br><!--入力した各ユーザー名を表示する-->
                        ${post_counts.users_name1}
                    </div><br>
                    <div class="field">
                       <button class="button" id="down">－</button>
    					<input type="text" value='0' class="inputtext" id="textbox"> <!--杯数カウントボタンの値を出力する-->
    					<button class="button" id="up">＋</button>
                    </div>
                    	<button class="button resetbtn" id="reset">RESET</button>
                </div>
                
            <form method="POST" action="/sante/CountsCupsServlet">
                <div class="">
                    <input type="submit" name="submit" value="登録">
                    <input type="submit" name="submit" value="割合表示">
                </div>
            </form>
            <script src="js/counts/CountsCups.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>