<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html class="html">
<head>
    <meta charset="UTF-8">
    <!-- 機能名|santé ! -->
    <title>ログイン|santé !</title>
    <!-- hrefの後ろにcssのリンクを書く -->
    <link rel="stylesheet" href="">

</head>
<body>
    <div class="wrapper">
        <!-- header -->
        <div class="header">
            <header>

            </header>
        </div>
        <!-- body -->
        <div class="body">
            <h1>

            </h1>
            <h2>ログイン</h2>
            <form method="POST" action="/sante/LoginServlet">
                <table>
                    <tr>
                        <td>
                            <label>ニックネーム:<br>
                                <input type="text" name="nickname" id="nickname" oninput="handleIDInputChange()">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>パスワード:<br>
                                <input type="password" name="password" id="password">
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="login" value="ログイン" onclick="saveCredentials()">
                            <input type="reset" name="reset" value="リセット">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>
                                <a href="/sante/RegistServlet">新規登録はこちら</a>
                            </label>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <!-- footer -->
        <div class="footer">
            <footer>

            </footer>
        </div>
    </div>
</body>
</html>
