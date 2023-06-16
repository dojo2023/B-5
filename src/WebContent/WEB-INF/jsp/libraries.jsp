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
            <!-- 図鑑上部の各機能 -->
            <div class="libararies_feature">
                <form method="POST" autocomplete="off" action="/santé/LibrariesServlet">
                    <input type="text" name="search_box" placeholder="キーワード">
                    <input type="submit" name="search" value="検索">
                    <input type="submit" name="narrow" value="絞り込み">
                    <input type="submit" name="post" value="投稿">
                    <input type="submit" name="bookmarks" value="お気に入り">
                </form>
            </div>
            <br>
            <!-- 図鑑の内容 -->
            <div class="content">
                <!-- 一致する結果の有無 -->
                <!-- 条件式は後で記載　*書いたら消すこと -->
                <c:if test="">
                    <p>一致する結果はありません。</p>
                </c:if>
                <!-- 図鑑の内容を要素数分表示させる -->
                <!-- 条件式は後で記載　*書いたら消すこと -->
                <c:forEach var="" items="">
                    <div class="content_table">
                        <table>
                            <tr>
                                <td>銘柄</td>
                                <td>種類</td>
                                <td>度数</td>
                                <td>産地</td>
                                <td>備考</td>
                            </tr>
                            <!-- ここから下は実際のデータを入れる *書いたら消すこと -->
                            <tr>
                                <td>銘柄</td>
                                <td>種類</td>
                                <td>度数</td>
                                <td>産地</td>
                                <td>備考</td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
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