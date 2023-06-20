<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">

    <title>登録|sante</title>

    <link rel="stylesheet" href=>
</head>

<div class="wrapper">

    <div class="header">
        <header>


        </header>
    </div>

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
            <form method="POST"action="RegistPhysicalsServlet">
            <input type = "submit" name = "submit"value = "登録">
			</form>
            <script>
            </script>
        </body>
    </div>

    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>