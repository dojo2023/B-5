<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">

    <title>登録|santé!</title>

    <link rel="stylesheet" type="text/css" href="css/Main.css">
</head>

<div class="wrapper">

    <div class="header">
        <header>


        </header>
    </div>

    <div class="body">
    <body>
    	<form method="POST"action="RegistPhysicalsServlet">
            <label class = "resistance-select">アルコール耐性</label><br>
          <select name = "physicals_resistance" required>
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

            <input type = "submit" name = "submit" value = "登録">
			</form>
            <script>
            </script>
        </body>
    </div>

    <div class="footer">
        <footer>
		<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
		</footer>
    </div>
</div>

</html>