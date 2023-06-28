<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="html">

<head>
<meta charset="UTF-8">
<!-- 機能名|santé ! -->
<title>新規登録|santé !</title>
<!-- hrefの後ろにcssのリンクを書く -->
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Login.css">
<!-- <script src="Regist.js"></script> -->
<script>
	function handleIDInputChange() {
		var selectYear = document.getElementsByName("year")[0].value;
		var selectMonth = document.getElementsByName("month")[0];
		var selectDay = document.getElementsByName("day")[0];

		if (selectYear === '年' || selectYear === '') {
			selectMonth.disabled = true;
			selectDay.disabled = true;
			selectDay.selectedIndex = 0; // Reset
			return;
		} else {
			selectMonth.disabled = false;
			selectDay.disabled = true;
			selectDay.selectedIndex = 0; // Reset
		}

		if (selectMonth.value === '月' || selectMonth.value === '') {
			selectDay.disabled = true;
			selectDay.selectedIndex = 0; // Reset
			return;
		} else {
			selectDay.disabled = false;
		}

		var selectedDay = selectDay.value; // Store the selected day value

		selectDay.innerHTML = '';

		var maxDays = 31;

		if (selectMonth.value !== '月') {
			var month = parseInt(selectMonth.value, 10);
			var year = parseInt(selectYear, 10);

			if (month === 2) {
				if (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0) {
					maxDays = 29;
				} else {
					maxDays = 28;
				}
			} else if ([ 4, 6, 9, 11 ].includes(month)) {
				maxDays = 30;
			}
		}

		for (var i = 0; i <= maxDays; i++) {
			var option = document.createElement('option');
			if (i === 0) {
				option.value = '日';
				option.text = '日';
			} else {
				option.value = i;
				option.text = i;
			}
			selectDay.appendChild(option);
		}

		// Restore the selected day value if it's within the range
		if (selectedDay >= 1 && selectedDay <= maxDays) {
			selectDay.value = selectedDay;
		}
	}
</script>
<style>
.regist_year, .regist_month, .regist_day {
	cursor: pointer;
	display: flex;
	font-size: 20px;
	margin: 10px auto;
	border: 2px solid lightslategray;
	padding: 10px;
	width: 200px;
	outline: none;
	border-radius: 4px;
	background-color: #fff;
	box-shadow: none;
	text-align: center;
}

.regist_year :focus {
	width: 280px;
	background-color: honeydew;
}
.regist_table {
	height: 30%;
	position: absolute;
	left: 35%;
	font-size: 100%;
	padding: 0;
	top:85%;
	overflow:hidden;
}
</style>
</head>
<body >
<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<img src="/sante/img/background1.png" class="headerbackground">
			<ul class="header_ul2">
				<li class="header_li"><a href="/sante/LoginServlet"> <img
						src="/sante/img/login_leaf.png" alt="ログイン" class="login_leaf"
						width="11%"></a></li>
				<li class="header_li"><a href="/sante/RegistServlet"> <img
						src="/sante/img/regist_leaf.png" alt="新規登録" class="regist_leaf"
						width="11%"></a></li>
			</ul>
		</header>
	</div>
	<!-- body -->
	<div class="regist_body">


			<div align="center">
				<img src="/sante/img/openedDoor.png" style = "position:relative; width:80%;height:auto; overflow:hidden;">
				<form method="POST" action="/sante/RegistServlet">
					<table class="regist_table">
						<tr>
							<td><label>ニックネーム:<br> <input type="text"
									name="users_name" id="nickname" oninput="handleIDInputChange()">
							</label></td>
						</tr>
						<tr>
							<td><label>パスワード:<br> <input type="password"
									name="users_password" id="password">
							</label></td>
						</tr>
						<tr>
							<td><label class="regist_birth">生年月日:<br> <select
									name="year" onchange="handleIDInputChange()"
									class="regist_year">
										<option value="年" selected>年</option>
										<c:forEach var="year" begin="1941" end="2015">
											<option value="${year}">${year}</option>
										</c:forEach>
								</select> <select name="month" onchange="handleIDInputChange()"
									class="regist_month" disabled>
										<option value="月" selected>月</option>
										<c:forEach var="month" begin="1" end="12">
											<option value="${month}">${month}</option>
										</c:forEach>
								</select> <select name="day" class="regist_day" disabled>
										<option value="日" selected>日</option>
										<c:forEach var="day" begin="1" end="31">
											<option value="${day}">${day}</option>
										</c:forEach>
								</select>
							</label></td>
						</tr>
						<tr>
							<td><input type="submit" name="regist" id="regist"
								value="登録"> <input type="reset" name="reset" id="reset"
								value="キャンセル"></td>
						</tr>
					</table>
				</form>
			</div>
	</div>
	<!-- footer -->
	<div class="footer">
		<footer>
			<p style="position: absolute; bottom: -110%;">&copy;Copyright
				美酒乱-Michelin-. All rights reserved.</p>
		</footer>
	</div>
</div>
</body>
</html>
