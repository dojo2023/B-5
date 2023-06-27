<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html class="html">

<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>図鑑|santé !</title>
    <!-- hrefの後ろにcssのリンクを書く -->
    <link rel="stylesheet" type="text/css" href="css/Main.css">
	<link rel="stylesheet" type="text/css" href="css/Libraries.css">
</head>

<div class="wrapper">
    <!-- header -->
    <div class="header">
        <header>
			<img src = "/sante/img/background1.png" class = "headerbackground">
			<ul class="header_ul">
				<li class="header_li"><a href="/sante/CalendarServlet" ><img src = "/sante/img/calendar_leaf.png" alt="カレンダー" class="calendar_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/LibrariesServlet"><img src = "/sante/img/libraries_leaf.png" alt="図鑑" class="libraries_leaf" width="16%"></a></li>
                <li class="header_li"><a href="/sante/CountsServlet"><img src = "/sante/img/counts_leaf.png" alt="集計" class="counts_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/MypageServlet"><img src = "/sante/img/mypage_leaf.png" alt="マイページ" class="mypage_leaf" width="11%"></a></li>
                <li class="header_li"><a href="/sante/LogoutServlet"><img src = "/sante/img/logout_leaf.png" alt="ログアウト" class="logout_leaf" width="11%"></a></li>
			</ul>
		</header>
    </div>
    <!-- body -->
    <div class="body">

        <body>
            <!-- ダミーデータ入れてます。*変更したら削除 -->
            <form method="POST" autocomplete="off" action="/sante/NarrowLibrariesServlet">
                <div class="genre">
                    <label>酒類:</label>
                    <select name="genre" id="genre">
                        <option value="">-選択-</option>
                        <c:forEach var="category" items="${first_categories}">
                            <option value="${category}">${category}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="kind">
                    <label>種類:</label>
                    <select name="kind" id="kind" disabled>
                        <option value="">-選択-</option>
                        <c:forEach var="category" items="${second_categories}">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="from">
                    <label>産地:</label>
                    <select name="from" id="from" disabled>
                        <option value="">-選択-</option>
                        <c:forEach var="category" items="${forth_categories}">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>^
                    </select>
                </div>
                <div class="remarks">
                    <input type="checkbox" name="remarks" id="remarks">
                    <label for="remarks">お気に入り</label>
                </div>
                <input type="submit" name="submit" value="絞り込み">
                <input type="submit" name="submit" value="キャンセル">
            </form>
            <script>
                const first_categories = [
                    '日本酒',
                    '焼酎',
                    'ワイン',
                    'ビール'
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
                    { first_category: 'ワイン', name: 'スパークリング' },
                    { first_category: 'ビール', name: '甘口' },
                    { first_category: 'ビール', name: '辛口' }
                ];

                const forth_categories = [
                    { first_category: '日本酒', name: '新潟県' },
                    { first_category: '日本酒', name: '山口県' },
                    { first_category: '日本酒', name: '長野県' },
                    { first_category: '焼酎', name: '鹿児島県' },
                    { first_category: '焼酎', name: '福岡県' },
                    { first_category: 'ワイン', name: 'フランス' },
                    { first_category: 'ビール', name: '東京' },
                    { first_category: 'ビール', name: '北海道' }
                ]

                const first_categories_select = document.getElementById('genre');
                const second_categories_select = document.getElementById('kind');
                const forth_categories_select = document.getElementById('from');
            </script>

            <script src="js/libraries/NarrowLibraries.js"></script>
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
