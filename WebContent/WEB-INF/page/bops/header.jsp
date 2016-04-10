<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML>
<html>
<head>
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/bops/dpl-min.css" rel="stylesheet" type="text/css" />
<link href="/css/bops/bui-min.css" rel="stylesheet" type="text/css" />
<link href="/css/bops/main-min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery.js" ></script>
<script type="text/javascript">
$(function(){
	$("#ft").on("click",slidde);
	$("#bk").on("click",slidde2);
});

var status = 0;

function slidde(){
	if(status == 0){
		$("#front-sys").hide();
		status = 1;
	}else{
		$("#front-sys").show();
		status = 0;
	}
}

var status2 = 0;
function slidde2(){
	if(status2 == 0){
		$("#bk-sys").hide();
		status2 = 1;
	}else{
		$("#bk-sys").show();
		status2 = 0;
	}
}

</script>
</head>
<body>
	<c:set var="us" value="${pageContext.request.requestURL}"/>
	<div class="header">

		<div class="dl-title">
			<!--<img src="/chinapost/Public/assets/img/top.png">-->
		</div>

		<div class="dl-log">
			欢迎您，<span class="dl-log-user">${sessionScope.sysuser.loginName}</span><a href="/bops/logout.htm" title="退出系统"
				class="dl-log-quit">[退出]</a>
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
			</ul>
		</div>
		<ul id="J_NavContent" class="dl-tab-conten">

			<li class="dl-tab-item">
				<div class="dl-second-nav" style="height: 879px;">
					<div class="dl-second-tree" id="J_1Tree">
						<ul class="bui-side-menu bui-menu" aria-disabled="false"
							style="height: 879px;" aria-pressed="false">
							<li class="bui-menu-item menu-second" aria-disabled="false" data-id="menu-item1" aria-pressed="false">
							<div class="bui-menu-title" id="ft">
								<s></s><span class="bui-menu-title-text">前台管理</span>
							</div>
								<ul class="bui-menu" aria-disabled="false" aria-pressed="false" id="front-sys">
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/item')}"> bui-menu-item-selected</c:if>"
										aria-disabled="false" data-id="12"><a
										href="/bops/item.htm"><em>物品管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/itemclass.htm')}"> bui-menu-item-selected</c:if>'" aria-disabled="false"
										data-id="12"><a href="/bops/itemclass.htm"><em>类别管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/user')}"> bui-menu-item-selected</c:if>'" aria-disabled="false"
										data-id="3" aria-pressed="false"><a
										href="/bops/user.htm"><em>用户管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/message')}"> bui-menu-item-selected</c:if>'" aria-disabled="false"
										data-id="4" aria-pressed="false"><a
										href="/bops/message.htm"><em>评论管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/report')}"> bui-menu-item-selected</c:if>'" aria-disabled="false"
										data-id="4" aria-pressed="false"><a
										href="/bops/report.htm"><em>举报管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/authen')}"> bui-menu-item-selected</c:if>'" aria-disabled="false"
										data-id="6" aria-pressed="false"><a
										href="/bops/authen.htm"><em>认证管理</em></a></li>
								</ul>
							</li>
							
							<li class="bui-menu-item menu-second" aria-disabled="false" data-id="menu-item1" aria-pressed="false">
								<div class="bui-menu-title" id="bk">
									<s></s><span class="bui-menu-title-text">后台管理</span>
								</div>
								<ul class="bui-menu" aria-disabled="false" aria-pressed="false" id="bk-sys">
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/admin')}"> bui-menu-item-selected</c:if>" aria-disabled="false"
										data-id="4" aria-pressed="false"><a
										href="/bops/admin.htm"><em>管理员管理</em></a></li>
									<li class="bui-menu-item menu-leaf <c:if test="${fn:contains(us,'/bops/addnewadmin')}"> bui-menu-item-selected</c:if>" aria-disabled="false"
										data-id="4" aria-pressed="false"><a
										href="/bops/addnewadmin.htm"><em>新增管理员</em></a></li>
								</ul>
							</li>
						</ul>
					</div>

				</div>
				<div class="dl-inner-tab" id="J_1Tab">