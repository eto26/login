<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- strutsタグを使うよ。今回はsとしてタグを使うよ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<s:form action = "LoginAction">
		<s:textfield name = "name"/>
		<s:password name = "password"/>
		<s:submit value = "ログイン"/>
	</s:form>
	<!-- ユーザが入力した情報にそれぞれname、password
	という名前をつけて、LoginActionに送信(submit)するよ -->

</body>
</html>