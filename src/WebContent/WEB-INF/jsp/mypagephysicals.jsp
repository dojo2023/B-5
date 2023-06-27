<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>アルコール耐性とコンディション|santé!</title>
    <!-- hrefの後ろにcssのリンクを書く -->
    <link rel="stylesheet" type="text/css" href="css/Main.css">
	<link rel="stylesheet" type="text/css" href="css/Mypage.css">
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
			<img src = "/sante/img/background1.png" class = "headerbackground">
			<ul class="header_ul">
				<li class="header_li"><a href="/sante/CalendarServlet" ><img src = "/sante/img/calendar_leaf.png" alt="カレンダー" class="calendar_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/LibrariesServlet"><img src = "/sante/img/libraries_leaf.png" alt="図鑑" class="libraries_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/CountsServlet"><img src = "/sante/img/counts_leaf.png" alt="集計" class="counts_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/MypageServlet"><img src = "/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf" width="16%"></a></li>
                <li class="header_li"><a href="/sante/LogoutServlet"><img src = "/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf" width="11%"></a></li>
			</ul>
		</header>
    </div>
    <!-- body -->
    <div class="body">
        <body>
          <form method="POST"action="/sante/MypagePhysicalsServlet">
          <label class = "resistance-select">アルコール耐性</label><br>
          <select name = "physicals_resistance" >
            <option value="">選択してください</option>
            <option value="1">高い</option>
            <option value="2">やや高い</option>
            <option value="3">普通</option>
            <option value="4">やや低い</option>
            <option value="5">低い</option>
          </select><br>
            <label class = "condition-select">コンディション</label><br>
            <select name = "physicals_condition" required>
            <option value="">選択してください</option>
            <option value="1">10%</option>
            <option value="2">20%</option>
            <option value="3">30%</option>
            <option value="4">40%</option>
            <option value="5">50%</option>
            <option value="6">60%</option>
            <option value="7">70%</option>
            <option value="8">80%</option>
            <option value="9">90%</option>
            <option value="10">100%</option>
            </select><br>

				<input type="submit" name = "submit" value="更新">
			</form>
			<form method="GET"action="/sante/MypageServlet">
				<input type="submit" name = "submit" value="戻る">
			</form>
			<script>


			</script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>
		<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
		</footer>
    </div>
</div>

</html>