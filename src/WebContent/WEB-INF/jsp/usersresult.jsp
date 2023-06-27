<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="html">
<head>
    <meta charset="UTF-8">
    <title>結果|santé !</title>
   <link rel="stylesheet" type="text/css" href="css/Main.css">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<header>
<img src = "/sante/img/background1.png" class = "headerbackground">
</header>
<body>
<div class="wrapper">
    <h1 id="logo">
    <a href="/sante/LoginServlet"></a>
  	</h1>
    <div align = "center"><img src="/sante/img/closedDoor.png" class="result_body" 	width = "78%"
	height = "180%"></div>
    <%-- メッセージ表示 --%>
    <% if (request.getAttribute("message") != null) { %>
        <p class = "error_message"><%= request.getAttribute("message") %></p>
    <% } %>
   <p class = "return_message"><a href="/sante/LoginServlet">戻ります</a></p>
      <!-- フッター（ここから） -->
  <div id="footer">
   <p>&copy;Copyright 美酒乱-Michelin-. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->
</div>
</body>
</html>