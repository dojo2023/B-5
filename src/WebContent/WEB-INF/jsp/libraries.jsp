<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <!-- 図鑑上部の各機能 -->
            <div class="libararies_feature">
                <form method="POST" autocomplete="off" action="/sante/LibrariesServlet">
                    <input type="text" name="search_box" placeholder="キーワード">
                    <input type="submit" name="submit" value="検索">
                    <input type="submit" name="submit" value="絞り込み">
                    <input type="submit" name="submit" value="投稿">
                </form>
            </div>
            <br>
            <!-- 図鑑の内容 -->
            <div class="content">
                <!-- 一致する結果の有無 -->
                <c:choose>
                    <c:when test="${not empty searchList or not empty narrowList or not empty librariesList}">
                        <div class="content_table">
                            <table>
                                <tr>
                                    <td>番号</td>
                                    <td>銘柄</td>
                                    <td>酒類</td>
                                    <td>種類</td>
                                    <td>度数</td>
                                    <td>産地</td>
                                    <td>備考</td>

                                </tr>
                                <c:forEach var="libraries" items="${not empty narrowList ? narrowList : not empty searchList ? searchList : librariesList}">
                                    <tr>
                                        <td>${libraries.libraries_id}</td>
                                        <td>${libraries.libraries_description}</td>
                                        <td>${libraries.libraries_genre}</td>
                                        <td>${libraries.libraries_kind}</td>
                                        <td>${libraries.libraries_alcon}</td>
                                        <td>${libraries.libraries_from}</td>
                                        <td>${libraries.libraries_remarks}</td>

                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="result_not_found">
                            <p>一致する結果はありません。</p>
                        </div>
                    </c:otherwise>
                </c:choose>

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
