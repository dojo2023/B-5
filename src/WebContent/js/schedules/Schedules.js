'use strict';

const weeks = ['日', '月', '火', '水', '木', '金', '土']
const date = new Date()
let year = date.getFullYear()
let month = date.getMonth() + 1
const config = {
	show: 1,
}

function showCalendar(year, month) {
	for (let i = 0; i < config.show; i++) {
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
				calendarHtml += '<td class="is-disabled">'+ num +'</td>'
			} else if (dayCount > endDayCount) {
				// 末尾の日数を超えた
				let num = dayCount - endDayCount
				calendarHtml +='<td class="is-disabled">' + num+'</td>'
				dayCount++
			} else {
				calendarHtml += `<td class="calendar_td" data-date="${year}/${month}/${dayCount}"><a href="AddSchedulesServlet">${dayCount}</a></td>`
				dayCount++
			}
		}
		calendarHtml += '</tr>'
	}
	calendarHtml += '</table>'

	return calendarHtml
}

//表示されているカレンダーの年月を取得
let year_month;
let display_year_month;
let display_year = year;
//月は1桁の時は前に0をつける
let display_month_pre;
let display_month = month;

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

	year_month = document.getElementById("calendar");

	display_year_month = year_month.querySelector("h1").textContent;
	//console.log("year_day:" + display_year_month);
	display_year = display_year_month.substring(0, 4);
	//console.log("year:" + display_year);
	//月は1桁の時は前に0をつける
	display_month_pre = display_year_month.substring(5, 8);
	display_month = display_month_pre.padStart(2, '0');


	//console.log("month:" + display_month);


	weight_insert();
}

document.querySelector('#prev').addEventListener('click', moveCalendar)
document.querySelector('#next').addEventListener('click', moveCalendar)

document.addEventListener("click", function (e) {
    if (e.target.classList.contains("calendar_td")) {
        // dataを日付型に型変換し年、月、日で分解し格納
        var OnclickDate = new Date(e.target.dataset.date);
        var selected_year = OnclickDate.getFullYear();
         var selected_month = (OnclickDate.getMonth() + 1).toString().padStart(2, '0');
        var selected_day = OnclickDate.getDate().toString().padStart(2, '0');

        var date_input = document.getElementsByName("select_day")[0];
        date_input.value = selected_year + "-" + selected_month + "-" + selected_day;
    }
})

showCalendar(year, month)

const start = document.addEventListener("DOMContentLoaded", schedules_insert());

function schedules_insert() {

	//セッションスコープの内容を取得
	//const list = document.getElementById("schedules_list");
	//データの個数を取得
	const end_num = document.querySelector(".true").id;

	console.log(end_num);
	//console.log(list);
	//htmlのclass名が「calender_td」のものを取得
	const calender_td = document.querySelectorAll(".calendar_td");




	//セッションスコープの内容がある限り続ける
	for (let i = 0; i <= end_num; i++) {
		const id = document.getElementById("id" + i).value;
		const name = document.getElementById("name" + i).value;
		const dt = document.getElementById("dt" + i).value;
		const date = document.getElementById("date" + i).value;
		//const time = document.getElementById("time" + i).value;
		const date_year = date.substring(0, 4)
		const date_month = date.substring(5, 7)
		const date_day = date.substring(8)
		console.log("id:" + id);
		console.log("dt:" + date);
		console.log("date_year:" + date_year);
		console.log("date_month:" + date_month);
		console.log("date_day:" + date_day);

		//カレンダーにセッションスコープの日時のデータが有ればその日のtdに追加
		for (let i = 1; i <= calender_td.length; i++) {
			//年月日で一緒かどうかを判別
			if (display_year == date_year && display_month == date_month && i == date_day) {
				calender_td[i - 1].innerText = i + "\n" + name;
				//console.log(calender_td[i].textContent);
			}

		}
	}

}

/**
 *
 */