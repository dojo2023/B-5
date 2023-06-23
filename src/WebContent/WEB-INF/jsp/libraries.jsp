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
            <!-- 図鑑上部の各機能 -->
            <div class="libararies_feature">
                <form method="POST" autocomplete="off" action="/sante/LibrariesServlet">
                    <input type="text" name="search_box" placeholder="キーワード">
                    <input type="submit" name="submit" value="検索">
                    <input type="submit" name="submit" value="絞り込み">
                    <input type="submit" name="submit" value="投稿">
                    <input type="submit" name="submit" value="お気に入り">
                </form>
            </div>
            <br>
            <!-- 図鑑の内容 -->
            <div class="content">
                <!-- 一致する結果の有無 -->
                <!-- 条件式は後で記載 *書いたら消すこと -->
                <c:if test="${empty searchList }">
                	<c:if test="${empty librariesList }">
                    <div class="result_not_found">
                        <p>一致する結果はありません。</p>
                    </div>
                    </c:if>
                </c:if>
                <!-- 図鑑の内容を要素数分表示させる -->
                <!-- 条件式は後で記載 *書いたら消すこと -->

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
                                <td>公開</td>
                            </tr>
                            <!-- ここから下は実際のデータを入れる *書いたら消すこと -->
                            <c:forEach var="libraries" items="${empty searchList ? librariesList : searchList}">
                            <tr>
                            	<td>${libraries.libraries_id}</td>
                                <td>${libraries.libraries_description}</td>
                                <td>${libraries.libraries_genre}</td>
                                <td>${libraries.libraries_kind}</td>
                                <td>${libraries.libraries_alcon}</td>
                                <td>${libraries.libraries_from}</td>
                                <td>${libraries.libraries_remarks}</td>
                                <td>${libraries.libraries_public}</td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>

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