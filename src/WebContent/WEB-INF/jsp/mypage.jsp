<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <title>マイページ|santé!</title>
    <link rel="stylesheet" href=>
</head>

<div class="wrapper">
    <div class="header">
        <header>
            <h1>
                <a href=""><img src="" alt="画像"></a>
            </h1>

            <ul>
                <li><a href="">カレンダー</a></li>
                <li><a href="">図鑑</a></li>
                <li><a href="">集計</a></li>
                <li><a href="">マイページ</a></li>
                <li><a href="">ログアウト</a></li>
            </ul>
            <hr>
        </header>
    </div>
    <div class="body">
        <body>
			<form method = "GET" action = "/sante/MypagePhysicalsServlet">
				<input type="submit" name = "submit" value="コンディションとアルコール耐性 "><br>
			</form>
			<form method = "GET" action = "/sante/MypageManualServlet">
				<input type="submit" name = "submit" value="使い方 " >
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