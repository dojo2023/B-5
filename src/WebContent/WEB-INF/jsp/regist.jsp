<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            	if (year % 4 === 0 && year % 100 !== 0 || year % 400 === 0){
            		maxDays = 29;
            	} else {
            		maxDays = 28;
            	}
            } else if ([4, 6, 9, 11].includes(month)) {
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
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
	<img src = "/sante/img/background1.png" class = "headerbackground">
        </header>
    </div>
    <!-- body -->
    <div class="regist_body">
        <body>
            <h1>

            </h1>
            <div align = "center">
            <h2>新規登録</h2>
            <form method="POST" action="/sante/RegistServlet">
                <table>
                    <tr>
                        <td>

                            <label>ニックネーム:<br>
                                <input type="text" name="users_name" id="nickname" oninput="handleIDInputChange()">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>パスワード:<br>
                                <input type="password" name="users_password" id="password">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class =  "regist_birth">生年月日:<br>
                                <select name="year" onchange="handleIDInputChange()" >
                                    <option value="年" selected>年</option>
                                    <c:forEach var="year" begin="1941" end="2015">
                                        <option value="${year}">${year}</option>
                                    </c:forEach>
                                </select>
                                <select name="month" onchange="handleIDInputChange()" disabled>
                                    <option value="月" selected>月</option>
                                    <c:forEach var="month" begin="1" end="12">
                                        <option value="${month}">${month}</option>
                                    </c:forEach>
                                </select>
                                <select name="day" disabled>
                                    <option value="日" selected>日</option>
                                    <c:forEach var="day" begin="1" end="31">
                                        <option value="${day}">${day}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="regist" id="regist" value="登録">
                            <input type="reset" name="reset" id="reset" value="キャンセル">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>
                                <a href="/sante/LoginServlet">ログインはこちら</a>
                            </label>
                        </td>
                    </tr>
                </table>
            </form>
            </div>
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
