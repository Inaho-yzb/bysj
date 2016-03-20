<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head lang="zh-CN">
<title>个人主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/javascript.js"></script>
<script src="${pageContext.request.contextPath}/js/bopspop.js"></script>

<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/popstyle.css" rel="stylesheet">
</head>

<body>
	<div class="header">
		<div class="navbar-custop">
			<div class="container">
				<nav class="navbar navbar-default navbar-custom">
					<ul class="nav navbar-nav">
						<c:choose>
						<c:when test="${empty username}">
							<li><a href="login/toLogin.htm">登录</a></li>
							<li><a href="login/toRegistered.htm">免费注册</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/user/toProfile.htm" id="navusername">${username }</a></li>
							<li><a href="${pageContext.request.contextPath}/user/quit.htm">登出</a></li>
						</c:otherwise>
						</c:choose>
						
					</ul>

					<ul class="nav navbar-nav" style="float: right">
						<li><a href="${pageContext.request.contextPath}/user/toProfile.htm?tag=myitems">我的物品</a></li>
						<li><a href="${pageContext.request.contextPath}/user/toProfile.htm?tag=favitems"><span class="glyphicon glyphicon-heart">
							</span> 收藏夹</a></li>
						<li><a href="#">联系客服</a></li>
					</ul>
				</nav>
			</div>
		</div>

		<div class="navbar-custop2">
			<div class="container">


				<nav class="navbar navbar-default navbar-custom navbar-custom2">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/index.htm">首页</a></li>
						<li><a href="1.htm">随便逛逛</a></li>
						<li><a href="2.htm">低价商品</a></li>
						<li><a href="3.htm">热门物品</a></li>
					</ul>


					<form id="indexsearch" class="navbar-form navbar-right">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="搜跳蚤">
						</div>
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search searchbtn"> </span>
						</button>
					</form>

				</nav>



			</div>
		</div>
	</div>