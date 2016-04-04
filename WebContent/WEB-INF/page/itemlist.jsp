<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>

<div class="content">
	<div class="container bkcl-white pnv">
		<div class="position-nav">
			<ol class="breadcrumb bkcl-white">
				<li><a href="index.htm">首页</a></li>
				<li><a
					href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}">${navFatherItemClass.itemclass_name}</a></li>
				<c:if test="${!empty navChildItemClass}">
					<li><a
						href="itemlist.htm?id=${navChildItemClass.itemclass_id}">${navChildItemClass.itemclass_name}</a></li>
				</c:if>
			</ol>
		</div>
		<div class="col-md-3">
			<div class="panel panel-default itemclass">
				<div class="panel-body">
				<c:if test="${!empty itemChildClassList}">
					<c:forEach items="${itemChildClassList}" var="itemChildClass">
						<span><a
							href="itemlist.htm?id=${itemChildClass.itemclass_id}">
								${itemChildClass.itemclass_name}</a> </span>
					</c:forEach>
				</c:if>
				<c:if test="${empty itemChildClassList}">
					<span>无子栏目</span>
				</c:if>
				</div>
			</div>
		</div>

		<div class="col-md-9">
			<div class="sort-btn">
				<div class="btn-group">
					<div class="btn-group">
						<button type="button" class="btn btn-default dropdown-toggle"data-toggle="dropdown">
							价格<span class="caret"></span>
						</button>
						<ul class="dropdown-menu sorts">
							<li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.currentPage}&sort=0">从高到低</a></li>
							<li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.currentPage}&sort=1">从低到高</a></li>
						</ul>
					</div>
					<div class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
						发布时间<span class="caret"></span>
					</button>
					<ul class="dropdown-menu sorts">
							<li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.currentPage}&sort=2">从近到远</a></li>
							<li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.currentPage}&sort=3">从远到近</a></li>
					</ul>
					</div class="btn-group">
				</div>
			</div>

			<div class="itemlist">

				<c:forEach items="${itemlist }" var="item">
					<div class="panel panel-default itemlist-item">
						<div class="panel-body">
							<div class="col-md-2">
								<img class="itemlist-pic" src="${item.itemmainimg }">
							</div>
							<div class="col-md-8">
								<div class="itemlist-detail">
									<div class="itemlist-title">
										<a href="item.htm?id=${item.itemid}">${item.itemname }</a>
									</div>
									<div class="font-red itemlist-price">
										<span>￥</span>${item.sellprice }
									</div>
									<div class="itemlist-intro">${item.discreption}</div>
									<div>
										<div>
											<span class="itemlist-mesfav"><a href="item.htm?id=${item.itemid}">留言</a>${item.mescount}</span>
											<span class="itemlist-mesfav"><a href="item.htm?id=${item.itemid}">收藏</a>${item.favcount}</span>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-2 pad-lf-clr pad-rt-clr">
								<div class="itemlist-seller">
									<img class="itemlist-seller-pic img-circle"
										src="images/qcode.png">
									<div class="itemlist-seller-name">
										<div>
											<span style="color: blue">${item.username}</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>



			</div>

			<div class="float-right pagi">
				<ul class="pagination">
					<c:choose>
						<c:when test="${!empty navChildItemClass}">
							<c:if test="${!empty page.prvPage}">
								<li><a href="itemlist.htm?id=${navChildItemClass.itemclass_id}&pa=${page.prvPage}&sort=${order}">&laquo;</a></li>
							</c:if>

							<c:forEach items="${page.pageList}" var="p">
								<c:choose>
									<c:when test="${page.currentPage==p}">
										<li  class="active"><a>${p}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="itemlist.htm?id=${navChildItemClass.itemclass_id}&pa=${p}&sort=${order}">${p}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							
							<c:if test="${!empty page.nextPage}"><li><a href="itemlist.htm?id=${navChildItemClass.itemclass_id}&pa=${page.nextPage}&sort=${order}">&raquo;</a></li></c:if>
							
						</c:when>
						<c:otherwise>
							
								<c:if test="${!empty page.prvPage}"><li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.prvPage}&sort=${order}">&laquo;</a></li></c:if>
							
							<c:forEach items="${page.pageList}" var="p">
								<c:choose>
									<c:when test="${page.currentPage==p}">
										<li  class="active"><a>${p}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${p}&sort=${order}">${p}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${!empty page.nextPage}"><li><a href="itemlist.htm?fid=${navFatherItemClass.itemclass_id}&pa=${page.nextPage}&sort=${order}">&raquo;</a></li></c:if>
						</c:otherwise>
					</c:choose>
					<div class="float-right pagecount">共${page.pageCount}页</div>

				</ul>
			</div>
		</div>
	</div>
</div>


<%@include file="footer.jsp"%>