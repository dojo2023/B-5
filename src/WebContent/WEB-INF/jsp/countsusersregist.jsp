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
<link rel="stylesheet" type="text/css" href="css/Main.css">
<link rel="stylesheet" type="text/css" href="css/Counts.css">
</head>

<div class="wrapper">
	<!-- header -->
	<div class="header">
		<header>
			<img src = "/sante/img/background1.png" class = "headerbackground">
			<ul class="header_ul">
				<li class="header_li"><a href="/sante/CalendarServlet" ><img src = "/sante/img/calendar_leaf.png" alt="カレンダー" class="calendar_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/LibrariesServlet"><img src = "/sante/img/libraries_leaf.png" alt="図鑑" class="libraries_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/CountsServlet"><img src = "/sante/img/counts_leaf.png" alt="集計" class="counts_leaf" width="16%"></a></li>
                <li class="header_li"><a href="/sante/MypageServlet"><img src = "/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/LogoutServlet"><img src = "/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf" width="11%"></a></li>
			</ul>
		</header>
	</div>
	<!-- body -->
	<div class="body">
		<body>



			<form method="POST" action="/sante/CountsUsersRegistServlet">
				<p>アプリ利用者の名前と生年月日を入力してください</p>
				<table>
					<tr>
						<th>名前</th>
						<th><label>生年月日:<br>

						</label></th>
					</tr>



					<c:forEach var="i" begin="1" end="${post_counts.users_member}" step="1" varStatus="status">

                    <tr>
                        <td><input type="text" name="name${status.index}" class="inputtext"></td>

                        <td>
                            <select name="year${status.index}" onchange="handleIDInputChange()" class="inputtext">
                                <option value="年" selected>年</option>
                                <c:forEach var="year" begin="1941" end="2015">
                                    <option value="${year}">${year}</option>
                                </c:forEach>
                            </select>
                            <select name="month${status.index}" onchange="handleIDInputChange()" class="inputtext">
                                <option value="月" selected>月</option>
                                <c:forEach var="month" begin="1" end="12">
                                    <option value="${month}">${month}</option>
                                </c:forEach>
                            </select>
                            <select name="day${status.index}" class="inputtext">
                                <option value="日" selected>日</option>
                                <c:forEach var="day" begin="1" end="31">
                                    <option value="${day}">${day}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <td>
                            <span id="error_message" name="error_message${status.index}"></span>
                        </td>


                    </tr>

                    </c:forEach>



				</table>
				<div class="">
					<input type="submit" name="submit" value="次へ" class="button">
					<input type="submit" name="submit" value="キャンセル" class="button">
				</div>

			</form>
			<script src="js/counts/CountsUsersRegist.js"></script>
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

<!-- <script>
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
 -->