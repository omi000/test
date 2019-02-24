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
		<title>ItemListDeleteConfirm</title>
		<link rel="stylesheet" href="css/style.css">

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript">
		function submitAction(url) {
			$('form').attr('action', url);
			$('form').submit();
		}

		</script>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemListDeleteConfirm</p>
		</div>
		<div>
			<table>
				<s:form>
				<p>全ての商品情報を削除してよろしいですか？</p>
				<tr>
					<td>
						<input type="button" value="OK" onclick="submitAction('ItemListDeleteCompleteAction')"/>
					</td>
					<td>
						<input type="button" value="戻る" onclick="submitAction('ItemListAction')"/>
					</td>
				</tr>
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