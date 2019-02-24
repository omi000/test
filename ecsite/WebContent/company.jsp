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
		<title>Campany</title>

		<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="header">
		<div id="pr">
		</div>
</div>
<div id="main">
		<div id="top">
				<p>company</p>
		</div>
		<div id="syousai">
			<div id="haitatu" class="a">
				<h1>>配達について</h1>
				<a href='<s:url action="GoHomeAction"/>'></a>
			</div>
			<div id="souryou" class="a">
				<h1>>送料について</h1>
			</div>
			<div id="kessai" class="a">
				<h1>>決済について</h1>
			</div>
			<div id="henpin" class="a">
				<h1>>返品について</h1>
			</div>


		</div>

</div>
<footer>
		<ul>
			<li><a href='<s:url action="LoginAction"/>' class="white">ログイン</a></li>
			<li><a href='<s:url action="BuyItemAction"/>' class="white">商品購入</a></li>
			<li><a href='<s:url action="CreateUserAction"/>' class="white">新規登録</a></li>


		</ul>
</footer>

</body>
</html>