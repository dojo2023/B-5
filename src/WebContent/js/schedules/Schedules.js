'use strict';

// 現在の年と月を取得
var currentDate = new Date();
var year = currentDate.getFullYear();
var month = currentDate.getMonth() + 1; // 0から11で表されるため、1を加えて月を表す

var selectedDate = null;



// カレンダーを生成
function generateCalendar(year, month) {
    var calendarBody = document.getElementById('calendar-body');
    calendarBody.innerHTML = '';

    // 当月の日数を取得
    var currentMonthLastDate = new Date(year, month, 0).getDate();

    // 当月の最初の曜日を取得
    var firstDayOfWeek = new Date(year, month - 1, 1).getDay();

    var date = 1;
    var isCurrentMonth = false;

    for (var i = 0; i < 6; i++) {
        var row = document.createElement('tr');

        for (var j = 0; j < 7; j++) {
            var cell = document.createElement('td');

            if (i === 0 && j < firstDayOfWeek) {
                // 前月の最終日を取得
                var prevMonthLastDate = new Date(year, month - 1, 0).getDate();
                // var prevMonthDate = prevMonthLastDate - firstDayOfWeek + j + 1;
                // cell.textContent = prevMonthDate;
                // cell.classList.add('prev-month');
            } else if (date > currentMonthLastDate) {
                // 翌月の日にちを表示しない
                cell.classList.add('next-month');
            } else {
                cell.textContent = date;

                if (year === currentDate.getFullYear() && month === currentDate.getMonth() + 1 && date === currentDate.getDate()) {
                    cell.classList.add('current-date');
                    isCurrentMonth = true;
                }

                date++;
            }

            row.appendChild(cell);
        }

        calendarBody.appendChild(row);
    }

    // 前月・次月ボタンの状態を制御
    var prevButton = document.getElementById('prev-button');
    var nextButton = document.getElementById('next-button');

    if (!isCurrentMonth) {
        prevButton.disabled = false;
        nextButton.disabled = false;
    } else {
        prevButton.disabled = false;
        nextButton.disabled = false;
    }

    // 日付セルのクリックイベントの設定
    var dateCells = document.querySelectorAll('#calendar-body td');
    dateCells.forEach(function(cell) {
        if (!cell.classList.contains('prev-month') && !cell.classList.contains('next-month')) {
            cell.addEventListener('click', function() {
                // 選択した日付を更新
                var selectedDay = parseInt(cell.textContent);
                selectedDate = new Date(year, month - 1, selectedDay);

                // 選択状態のスタイルを設定
                dateCells.forEach(function(cell) {
                    cell.classList.remove('selected-date');
                });
                cell.classList.add('selected-date');

                // 選択した日付を表示
                var selectedDateText = selectedDate.toLocaleDateString('ja-JP', { year: 'numeric', month: 'short', day: 'numeric' });
                document.getElementById('selected-date').textContent = selectedDateText;
            });
        }
    });
}

// 前月を表示
function showPreviousMonth() {
    if (month === 1) {
        year--;
        month = 12;
    } else {
        month--;
    }

    generateCalendar(year, month);
    document.querySelector('#yearMonth').innerHTML = year + "年 " + month + "月";
}

// 次月を表示
function showNextMonth() {
    if (month === 12) {
        year++;
        month = 1;
    } else {
        month++;
    }

    generateCalendar(year, month);
    document.querySelector('#yearMonth').innerHTML = year + "年 " + month + "月";
}

// カレンダー生成とボタンのクリックイベントの設定
document.addEventListener('DOMContentLoaded', function() {
    generateCalendar(year, month);

    var prevButton = document.getElementById('prev-button');
    prevButton.addEventListener('click', showPreviousMonth);

    var nextButton = document.getElementById('next-button');
    nextButton.addEventListener('click', showNextMonth);

});

function clickDisplayAlert() {
    var selected_year = selectedDate.getFullYear();
    var selected_month = selectedDate.getMonth() + 1;
    var selected_day = selectedDate.getDate();
    alert(selected_year + "年" + selected_month + "月" + selected_day + "日");
  }

var selected_year = document.getElementById("calenderYear");
var selected_month = document.getElementById("calenderMonth");


//年月を表示
document.querySelector('#yearMonth').innerHTML = year + "年 " + month + "月";
/**
 *
 */