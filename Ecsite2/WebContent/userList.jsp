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
	<title>UserList画面</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>UserList</p>
		</div>
		<div>
			<s:if test="userList==null">
				<h3>ユーザーは未登録です。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<td>番号</td>
						<td>ID</td>
						<td>PASS</td>
						<td>名前</td>
						<td>登録日</td>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="loginId"/></td>
							<td><s:property value="loginPassword"/></td>
							<td><s:property value="userName"/></td>
							<td><s:property value="insert_date"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">

					<s:submit value="削除" method="execute"/>
				</s:form>
			</s:elseif>
			<div id="text-right">
				<p>戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a></p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>