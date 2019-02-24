<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta name="description" content=""/>
	<meta name="keywords" content=""/>
	<title>UserListDelete画面</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserListDeleteComplete</p>
		</div>

					<s:if test="message != null">
				<h3><s:property value="message"/></h3>
			</s:if>

			<div id="text-right">
				<p>管理者画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>

			</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>