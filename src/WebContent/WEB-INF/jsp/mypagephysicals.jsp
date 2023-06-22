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
    <link rel="stylesheet" href=>
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
            <h1>
                <a href=""><img src="" alt="画像"></a>
            </h1>
            <nav>
                <ul>
                    <li><a href="/sante/CalendarServlet">カレンダー</a></li>
                    <li><a href="/sante/LibrariesServlet">図鑑</a></li>
                    <li><a href="/sante/CountsServlet">集計</a></li>
                    <li><a href="/sante/MypageServlet">マイページ</a></li>
                    <li><a href="/sante/LoginServlet">ログアウト</a></li>
                </ul>
            </nav>
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

        </footer>
    </div>
</div>

</html>