<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>カレンダー|santé!</title>
    <!-- hrefの後ろにcssのリンクを書く -->
    <link rel="stylesheet" href="css/Schedules.css">
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
            <!-- 各ページへのリンク -->
            <nav>
                <ul>
                    <li><a href="/sante/CalendarServlet">カレンダー</a></li>
                    <li><a href="/sante/LibrariesServlet">図鑑</a></li>
                    <li><a href="/sante/CountsServlet">集計</a></li>
                    <li><a href="/sante/MypageServlet">マイページ</a></li>
                    <li><a href="/sante/UsersResultServlet">ログアウト</a></li>
                </ul>
            </nav>
        </header>
    </div>
    <!-- body -->
    <div class="body">
        <body>
            <button id="prev" type="button">前の月</button>
            <button id="next" type="button">次の月</button>
            <div id="calendar"></div>
            <script>

            const weeks = ['日', '月', '火', '水', '木', '金', '土']
            const date = new Date()
            let year = date.getFullYear()
            let month = date.getMonth() + 1
            const config = {
                show: 1,
            }

            function showCalendar(year, month) {
                for (i = 0; i < config.show; i++) {
                    const calendarHtml = createCalendar(year, month)
                    const sec = document.createElement('section')
                    sec.innerHTML = calendarHtml
                    document.querySelector('#calendar').appendChild(sec)

                    month++
                    if (month > 12) {
                        year++
                        month = 1
                    }
                }
            }

            function createCalendar(year, month) {
                const startDate = new Date(year, month - 1, 1) // 月の最初の日を取得
                const endDate = new Date(year, month, 0) // 月の最後の日を取得
                const endDayCount = endDate.getDate() // 月の末日
                const lastMonthEndDate = new Date(year, month - 2, 0) // 前月の最後の日の情報
                const lastMonthendDayCount = lastMonthEndDate.getDate() // 前月の末日
                const startDay = startDate.getDay() // 月の最初の日の曜日を取得
                let dayCount = 1 // 日にちのカウント
                let calendarHtml = '' // HTMLを組み立てる変数

                calendarHtml += '<h1>' + year + '/' + month + '</h1>'
                calendarHtml += '<table>'

                // 曜日の行を作成
                for (let i = 0; i < weeks.length; i++) {
                    calendarHtml += '<td>' + weeks[i] + '</td>'
                }

                for (let w = 0; w < 6; w++) {
                    calendarHtml += '<tr>'

                    for (let d = 0; d < 7; d++) {
                        if (w == 0 && d < startDay) {
                            // 1行目で1日の曜日の前
                            let num = lastMonthendDayCount - startDay + d + 1
                            calendarHtml += '<td class="is-disabled">' + num + '</td>'
                        } else if (dayCount > endDayCount) {
                            // 末尾の日数を超えた
                            let num = dayCount - endDayCount
                            calendarHtml += '<td class="is-disabled">' + num + '</td>'
                            dayCount++
                        } else {
                            calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}">${dayCount}</td>`
                            dayCount++
                        }
                    }
                    calendarHtml += '</tr>'
                }
                calendarHtml += '</table>'

                return calendarHtml
            }

            function moveCalendar(e) {
                document.querySelector('#calendar').innerHTML = ''

                if (e.target.id === 'prev') {
                    month--

                    if (month < 1) {
                        year--
                        month = 12
                    }
                }

                if (e.target.id === 'next') {
                    month++

                    if (month > 12) {
                        year++
                        month = 1
                    }
                }

                showCalendar(year, month)
            }

            document.querySelector('#prev').addEventListener('click', moveCalendar)
            document.querySelector('#next').addEventListener('click', moveCalendar)

            document.addEventListener("click", function (e) {
                if (e.target.classList.contains("calendar_td")) {
                    // dataを日付型に型変換し年、月、日で分解し格納
                    var OnclickDate = new Date(e.target.dataset.date);
                    var selected_year = OnclickDate.getFullYear();
                    var selected_month = OnclickDate.getMonth() + 1;
                    var selected_day = OnclickDate.getDate();
                    // 過去か未来かで分岐処理
                    if (OnclickDate > date) {
                        alert( "未来" + selected_year + "年" + selected_month + "月" + selected_day + "日");
                    }else{
                        alert( "過去" + selected_year + "年" + selected_month + "月" + selected_day + "日");
                    }
                }
            })

            showCalendar(year, month)
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