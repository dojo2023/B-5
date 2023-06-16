<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>図鑑|santé !</title>
    <!-- hrefの後ろにcssのリンクを書く -->
    <link rel="stylesheet" href=>
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
            <!-- 各ページへのリンク -->
            <nav>
                <ul>
                    <li><a href="/santé/CalendarServlet">カレンダー</a></li>
                    <li><a href="/santé/LibrariesServlet">図鑑</a></li>
                    <li><a href="/santé/CountsServlet">集計</a></li>
                    <li><a href="/santé/MypageServlet">マイページ</a></li>
                    <li><a href="/santé/UsersResultServlet">ログアウト</a></li>
                </ul>
            </nav>
        </header>
    </div>
    <!-- body -->
    <div class="body">

        <body>
            <!-- ダミーデータ入れてます。*変更したら削除 -->
            <form method="POST" autocomplete="off" action="/santé/NarrowLibrariesServlet.java">
                <div class="description">
                    <label>酒類:</label>
                    <select name="description" id="description">
                        <option>-選択-</option>
                    </select>
                </div>
                <div class="kind">
                    <label>種類:</label>
                    <select name="kind" id="kind" disabled>
                        <option>-選択-</option>
                    </select>
                </div>
                <div class="alcoholcontent">
                    <label>度数:</label>
                    <select name="">
                        <option hidden>-選択-</option>
                        <option>0%~9%</option>
                        <option>10%~19%</option>
                        <option>20%~29%</option>
                        <option>30%~39%</option>
                        <option>40%~49%</option>
                        <option>50%~59%</option>
                        <option>60%~69%</option>
                        <option>70%~79%</option>
                        <option>80%~89%</option>
                        <option>90%~99%</option>
                    </select>
                </div>
                <div class="from">
                    <label>産地:</label>
                    <select name="from" id="from" disabled>
                        <option hidden>-選択-</option>
                    </select>
                </div>
                <div class="remarks">
                    <input type="checkbox" name="remarks" id="remarks">
                    <label for="remarks">お気に入り</label>
                </div>
                <input type="submit" name="narrow" value="絞り込み">
                <input type="submit" name="cancel" value="キャンセル">
            </form>
            <script>
                const first_categories = [
                    '日本酒',
                    '焼酎',
                    'ワイン'
                ];

                const second_categories = [
                    { first_category: '日本酒', name: '甘口' },
                    { first_category: '日本酒', name: '辛口' },
                    { first_category: '焼酎', name: '麦焼酎' },
                    { first_category: '焼酎', name: '芋焼酎' },
                    { first_category: '焼酎', name: '米焼酎' },
                    { first_category: '焼酎', name: '蕎麦焼酎' },
                    { first_category: 'ワイン', name: '赤ワイン' },
                    { first_category: 'ワイン', name: '白ワイン' },
                    { first_category: 'ワイン', name: 'スパークリング' }
                ];

                const forth_categories = [
                    { first_category: '日本酒', name: '新潟県' },
                    { first_category: '日本酒', name: '山口県' },
                    { first_category: '日本酒', name: '長野県' },
                    { first_category: '焼酎', name: '鹿児島県' },
                    { first_category: '焼酎', name: '福岡県' },
                    { first_category: 'ワイン', name: 'フランス' },
                ]

                const first_categories_select = document.getElementById('description');
                const second_categories_select = document.getElementById('kind');
                const forth_categories_select = document.getElementById('from');
            </script>
            <!-- 仮のjsリンクです。要修正 -->

            <script src="/js/libraries/NarrowLibraries.js"></script>
        </body>
    </div>
    <!-- footer -->
    <div class="footer">
        <footer>

        </footer>
    </div>
</div>

</html>