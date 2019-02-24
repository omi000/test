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
		<title>CreateItem画面</title>
		<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>CreateItem</p>
		</div>
		<div>
			<s:if test="errorMessage !=''">
				<s:property value="errorMessage" escape="false"/>
			</s:if>
			<table>
				<s:form action="ItemCreateConfirmAction">
					<tr>
						<td>
							<label>商品名:</label>
						</td>
						<td>
							<input type="text" name="itemName" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<label>値段:</label>
						</td>
						<td>
							<input type="text" name="itemPrice" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<label>在庫数:</label>
						</td>
						<td>
							<input type="text" name="itemCount" value=""/>
						</td>
					</tr>
					<s:submit value="登録"/>
				</s:form>
			</table>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>

</body>
</html>