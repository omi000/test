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
	<title>ItemList画面</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>
			<s:if test="itemList==null">
				<h3>在庫はありません。</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>在庫は以下になります。</h3>
				<table border="1">
					<tr>
						<td></td>
						<td>商品ID</td>
						<td>商品名</td>
						<td>単価</td>
						<td>在庫数</td>
						<td>登録日</td>
					</tr>
					<s:iterator value="itemList">
						<tr>
							<td><input type="checkbox" name="ck" value="id"></td>
							<td><s:property value="id"/></td>
							<td><s:property value="itemName"/></td>
							<td><s:property value="totalPrice"/></td>
							<td><s:property value="totalStock"/></td>
							<td><s:property value="insert_date"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="ItemListDeleteConfirmAction">
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