<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">

    <title>登録|santé!</title>

    <link rel="stylesheet" type="text/css" href="css/Main.css">
    <link rel="stylesheet" type="text/css" href="css/Mypage.css">
    <link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<body>
<div class="wrapper">

    <div class="header">
        <header>


        </header>
    </div>

    <div class="regist_body">

<div align="center">
		<form method="POST"action="RegistPhysicalsServlet">
           <table class = "physicals_table">
				<tr>
					<td><label class="resistance-select">アルコール耐性<br>
							<select name="physicals_resistance"
							style="cursor: pointer; display: flex; font-size: 20px; margin: 10px auto; border: 2px solid lightslategray; padding: 10px; width: 200px; outline: none; border-radius: 4px; background-color: #fff; box-shadow: none; text-align: center;"
							required>
								<option value="">選択してください</option>
								<option value="1">高い</option>
								<option value="2">やや高い</option>
								<option value="3">普通</option>
								<option value="4">やや低い</option>
								<option value="5">低い</option>
						</select></label></td>
				</tr>
				<tr>
					<td><label class="condition-select">コンディション<br> <select
							name="physicals_condition"
							style="cursor: pointer; display: flex; font-size: 20px; margin: 10px auto; border: 2px solid lightslategray; padding: 10px; width: 200px; outline: none; border-radius: 4px; background-color: #fff; box-shadow: none; text-align: center;"
							required>
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
						</select></label></td>
				</tr>
				<tr>
				<td>

            <input type = "submit" name = "submit" value = "登録">
            </td>
            </tr>

			</table>
		</form>
            <script>
            </script>

    </div>
</div>
    <div class="footer">
        <footer>
		<p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
		</footer>
    </div>
</div>
</body>
</html>