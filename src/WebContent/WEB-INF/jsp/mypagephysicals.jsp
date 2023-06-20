<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>アルコール耐性とコンディション|sante</title>
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
          <label for = "resistance-select">アルコール耐性</label><br>
          <select name = "resistance" >
            <option value="">選択してください</option>
            <option value="高い">高い</option>
            <option value="やや高い">やや高い</option>
            <option value="普通">普通</option>
            <option value="やや低い">やや低い</option>
            <option value="低い">低い</option>
          </select><br>
            <label for = "condition-select">コンディション</label><br>
            <select name = "condition" required>
            <option value="">選択してください</option>
            <option value="10%">10%</option>
            <option value="20%">20%</option>
            <option value="30%">30%</option>
            <option value="40%">40%</option>
            <option value="50%">50%</option>
            <option value="60%">60%</option>
            <option value="70%">70%</option>
            <option value="80%">80%</option>
            <option value="90%">90%</option>
            <option value="100%">100%</option>
            </select><br>
			<form method="POST"action="MypagePhysicalsServlet">
				<input type="submit" name = "submit" value="更新">
			</form>
			<form method="GET"action="MypageServlet">
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