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
            <!-- お気に入り更新画面の内容 -->
            <div class="content">
                <!-- 一致する結果の有無 -->
                <!-- 条件式は後で記載 *書いたら消すこと -->
                <c:if test="">
                    <p>一致する結果はありません。</p>
                </c:if>
                <!-- 図鑑の内容を要素数分表示させる -->
                <!-- 条件式は後で記載 *書いたら消すこと -->
                <form method="POST" autocomplete="off" action="/sante/BookmarksServlet">
                        <div class="content_bookmarks_check_table">
                            <table>
                                <tr>
                                    <td>お気に入り番号</td>
                                    <td>図鑑番号</td>
                                    <td>ユーザ番号</td>
                                    <td>評価</td>
                                </tr>
                                <!-- ここから下は実際のデータを入れる *書いたら消すこと -->
                                <c:forEach var="bookmarks" items="${bookmarksList}">
                                <tr>
                                    <td>${bookmarks.bookmarks_id}</td>
                                    <td>${bookmarks.libraries_id}</td>
                                    <td>${bookmarks.users_id}</td>
                                    <td>${bookmarks.remarks}</td>

                                </tr>
                                </c:forEach>
                            </table>
                            <input type="checkbox" name="bookmarks_check" id="bookmarks_check">
                            <label for="bookmarks">お気に入り</label>
                        </div>

                    <!-- 送信用submit -->
                    <div class="bookmarks_input">
                        <input type="submit" name="submit" value="更新">
                        <input type="submit" name="submit" value="キャンセル">
                    </div>
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