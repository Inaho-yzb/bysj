<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bops/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="/css/bops/bui-min.css" rel="stylesheet" type="text/css" />
<link href="/css/bops/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<div class="header">

		<div class="dl-title">
			<!--<img src="/chinapost/Public/assets/img/top.png">-->
		</div>

		<div class="dl-log">
			欢迎您，<span class="dl-log-user">root</span><a href="" title="退出系统" class="dl-log-quit">[退出]</a>
		</div>
	</div>
	<div class="content">
		<div class="dl-main-nav">
			<div class="dl-inform">
				<div class="dl-inform-title">
					<s class="dl-inform-icon dl-up"></s>
				</div>
			</div>
			<ul id="J_Nav" class="nav-list ks-clear">
				<li class="nav-item dl-selected"><div
						class="nav-item-inner nav-home">系统管理</div>
					<div class="nav-item-mask"></div></li>
				<li class="nav-item"><div class="nav-item-inner nav-order">业务管理</div>
					<div class="nav-item-mask"></div></li>

			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

			<li class="dl-tab-item"><div class="dl-second-nav"
					style="height: 879px;">
					<div class="dl-second-tree" id="J_1Tree">
						<ul class="bui-side-menu bui-menu" aria-disabled="false"
							style="height: 879px;" aria-pressed="false">
							<li class="bui-menu-item menu-second" aria-disabled="false"
								data-id="menu-item1" aria-pressed="false"><div
									class="bui-menu-title">
									<s></s><span class="bui-menu-title-text">系统管理</span>
								</div>
								<ul class="bui-menu" aria-disabled="false" aria-pressed="false">
									<li class="bui-menu-item menu-leaf bui-menu-item-selected"
										aria-disabled="false" data-id="12"><a
										href="Node/index.html"><em>机构管理</em></a></li>
									<li class="bui-menu-item menu-leaf" aria-disabled="false"
										data-id="3" aria-pressed="false"><a
										href="Role/index.html"><em>角色管理</em></a></li>
									<li class="bui-menu-item menu-leaf" aria-disabled="false"
										data-id="4" aria-pressed="false"><a
										href="User/index.html"><em>用户管理</em></a></li>
									<li class="bui-menu-item menu-leaf" aria-disabled="false"
										data-id="6" aria-pressed="false"><a
										href="Menu/index.html"><em>菜单管理</em></a></li>
								</ul></li>
						</ul>
					</div>
					
				</div>
				<div class="dl-inner-tab" id="J_1Tab">
					
				