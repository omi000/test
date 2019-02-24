<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="Content-Style-Type" content="text/css"/>
		<meta http-equiv="Content-Script-Type" content="text/javascript"/>
		<meta http-equiv="imagetoolbar" content="no"/>
		<meta name="description" content=""/>
		<meta name="keywords" content=""/>
		<title>Admin画面</title>

		<link rel="stylesheet" href="css/style.css">
</head>
<body>
		<div id="header">
				<div id="pr">
				</div>
		</div>
		<div id="main">
				<div id="top">
						<p>管理者画面</p>
				</div>
				<div id="item">
						<div id="box">
							<div id="titlebox"><span id="title">商品</span></div>
							<div id="text-center">
									<s:form action="ItemListAction">
										<s:submit value="商品一覧"/>
									</s:form>
									<s:form action="ItemCreateAction">
										<s:submit value="商品追加"/>
									</s:form>
							</div>
						</div>
				</div>
				<div id="user">
						<div id="box">
							<div id="titlebox"><span id="title">ユーザー</span></div>
							<div id="text-center">
									<s:form action="UserListAction">
										<s:submit value="ユーザー一覧"/>
									</s:form>
									<s:form action ="UserCreateAction">
										<s:submit value="ユーザー追加"/>
									</s:form>
							</div>
						</div>
				</div>
		</div>
		<div id="footer">
				<div id="pr">
				</div>
		</div>

</body>
</html>