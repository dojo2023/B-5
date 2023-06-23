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
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@3.9.1/dist/chart.min.js"></script>
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
            <form method="POST" action="/sante/CountsRatioServlet">
                <p>杯数</p>
                <div class="chart-container" >
					<canvas id="Chart" ></canvas>
				</div>
				<script>let data = ${post_counts.name_list.get(namei)};</script>
                <script src="js/counts/CountsRatio.js"></script> <!--割合のグラフを挿入-->
                
                <div class="">
                    <input type="submit" name="submit" value="登録">
                    <input type="submit" name="submit" value="戻る">
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