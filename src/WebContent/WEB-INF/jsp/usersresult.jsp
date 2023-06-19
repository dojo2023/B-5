<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登録結果</title>
    <link href="" rel="stylesheet">
</head>
<body>
<div class="wrapper">
    <h1 id="logo">
    <a href="/sante/LoginServlet"><img src="" alt=""></a>
  	</h1>
    <h2>ログイン・登録結果</h2>
    <%-- メッセージ表示 --%>
    <% if (request.getAttribute("message") != null) { %>
        <p><%= request.getAttribute("message") %></p>
    <% } %>
    <p><a href="/sante/LoginServlet">戻ります</a></p>
      <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright やすお. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
</body>
</html>