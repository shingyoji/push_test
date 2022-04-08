<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
	// サーブレットから送られてきたテキストを受け取る
	String confirmName = (String) request.getAttribute("confirmName");
	%>

<body>
	<b>確認画面</b>
	<div>
		<span>氏名：</span>
		<%=confirmName%></br>
		<button onclick="history.back()">戻る</button>
	</div>
</body>
</html>