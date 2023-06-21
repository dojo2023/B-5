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
    <link rel="stylesheet" href="">
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
                    <c:forEach var="e" items="">
                        <div class="content_bookmarks_check_table">
                            <table>
                                <tr>
                                    <td>銘柄</td>
                                    <td>酒類</td>
                                    <td>種類</td>
                                    <td>度数</td>
                                    <td>産地</td>
                                    <td>備考</td>
                                </tr>
                                <!-- ここから下は実際のデータを入れる *書いたら消すこと -->
                                <tr>
                                    <td>${description}</td>
                                    <td>${genre}</td>
                                    <td>${kind}</td>
                                    <td>${alcoholcontent}</td>
                                    <td>${from}</td>
                                    <td>${remarks}</td>
                                </tr>
                            </table>
                            <input type="checkbox" name="bookmarks_check" id="bookmarks_check">
                            <label for="bookmarks">お気に入り</label>
                        </div>
                    </c:forEach>
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

        </footer>
    </div>
</div>

</html>