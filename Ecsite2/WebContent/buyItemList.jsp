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
		<title>BuyItem画面</title>
		<link rel="stylesheet" href="css/style.css">

		<style type="text/css">
		.item{
			border:2px solid rgba(0,0,0,0.5);
			height:350px;
			width:30%;
			float:left;
			border-radius:5px;
			border-spacing:5;
			margin-left:20px;
			margin-top:20px;

		}

		img{
			margin-top:50px;

		}
		</style>

	</head>
<body>
	<div id="header">
			<div id="pr">
			</div>
	</div>
	<div id="main">
		<div id="top">
			<p>buyItem</p>
		</div>
		<div id="item_group">
			<div class="item">
				<img src="note.jpg" height="200px" width="200px">
				<p><a href='<s:url action="BuyItemAction"/>'>ノートBOOK</a></p>
				<p>120円(+税)</p>
			</div>
			<div class="item">
				<img src="pencil.jpg" height="200px" width="200px">
				<p><a href='<s:url action="BuyPencilAction"/>'>えんぴつ</a></p>
				<p>60円(+税)</p>
			</div>
			<div class="item">
				<img src="pencase.jpg" height="200px" width="200px">
				<p><a href='<s:url action="BuyItemAction"/>'>ペンケース</a></p>
				<p>800円(+税)</p>
			</div>
			<div class="item">
				<img src="rubber.jpg" height="200px" width="200px">
				<p><a href='<s:url action="BuyItemAction"/>'>消しゴム</a></p>
				<p>100円(+税)</p>
			</div>

		</div>

	</div>

	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>