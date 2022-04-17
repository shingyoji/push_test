<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.label {
	border-width: 0pt;
}
</style>
</head>
<body>
	<%
	// サーブレットから送られてきたテキストを受け取る
	String rConfirmName = (String) request.getAttribute("confirmName");
	String sConfirmName = (String) session.getAttribute("confirmName");
	String confirmTel = (String) request.getAttribute("confirmTel");
	String confirmBirthday = (String) request.getAttribute("confirmBirthday");
	String confirmGender = (String) request.getAttribute("confirmGender");
	String genderLabel = "未選択";
	switch (confirmGender) {
	case "1":
		genderLabel = "男";
		break;
	case "2":
		genderLabel = "女";
		break;
	case "9":
		genderLabel = "その他";
		break;
	}
	String confirmMail = (String) request.getAttribute("confirmMail");
	String confirmName = rConfirmName != null ? rConfirmName : sConfirmName;
	%>
	<b>確認画面</b>
	<div>
		<form method='post' action='complete'>
			<span>氏名：</span> <input type="text" value="<%=confirmName%>"
				name="compName" readonly="true" tabindex="-1" class="label"></br>
			<span>電話番号：</span><input type="text" value="<%=confirmTel%>"
				name="compTel" readonly="true" tabindex="-1" class="label"></br>
			<span>生年月日：</span><input type="text" value="<%=confirmBirthday%>"
				name="compBirthday" readonly="true" tabindex="-1" class="label"></br> <span>性別：</span><input type="text"
				value="<%=genderLabel%>" readonly="true"
				tabindex="-1" class="label"><input type="hidden"
				value="<%=confirmGender%>" name="compGender" ></br> <span>メールアドレス：</span><input type="text"
				value="<%=confirmMail%>" name="compMail" readonly="true"
				tabindex="-1" class="label"></br>
			<button onclick="history.back()">戻る</button>
			<input type="submit" value="登録">
		</form>
	</div>
</body>
</html>