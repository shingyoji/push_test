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
	String textName = (String) request.getAttribute("textName");
	String errMsg = (String) request.getAttribute("errMsg");
	%>
	<b>入力画面</b>
	<div>
		<font color="red"><%=errMsg != null ? errMsg : ""%></font>
	</div>
	<div>
		<form method='post' action='confirm'>
			<span>氏名：</span> <input type="text" placeholder="氏名を入力してください"
				name="inputName"></br> <span>電話番号：</span> <input type="text"
				placeholder="ハイフンなし半角数字で入力してください" name="inputTel"></br> <span>生年月日：</span>
			<input type="text" placeholder="例)1996/08/19" name="inputBirthday"></br>
			<span>性別：</span><select name="inputGender">
				<option value="" selected hidden>選択してください</option>
				<option value="1">男</option>
				<option value="2">女</option>
				<option value="9">その他</option>
			</select></br> <span>メールアドレス：</span> <input type="text"
				placeholder="半角英数字で入力してください" name="inputMail"></br> <input
				type="submit" value="確認">
		</form>
	</div>
</body>
</html>