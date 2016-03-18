<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="header.jsp"%>


<div class="content">
	<script src="js/item.js"></script>
	<div class="container">
		<div class="col-md-12 bkcl-white">
			<div class="position-nav">
				<ol class="breadcrumb bkcl-white">
					<li><a href="index.htm">首页</a></li>
					<li><a href="#">${item.itemClass.fatherclass}</a></li>
					<li class="active">${item.itemClass.itemclass_name }</li>
				</ol>
			</div>
		</div>
	</div>
	<div class="item container">

		<div class="row">
			<div class="col-md-12">

				<div class="item-top-left">

					<div id="preview">
						<script src="js/itempic.js"></script>
						<SCRIPT src="js/lib.js"></SCRIPT>
						<SCRIPT src="js/picshow.js"></SCRIPT>
						<div class="jqzoom" id="spec-n1">
							<IMG height="350" src="${itemimages[0].imgpath}" jqimg="${itemimages[0].imgpath}"
								width="350">
						</div>
						<div id="spec-n5">
							<div class="control" id="spec-left">
								<img src="images/left.gif" />
							</div>
							<div id="spec-list">
								<ul class="list-h">
								<c:forEach items="${itemimages}" var="iis">
									<li><img src="${iis.imgpath}"></li>
								</c:forEach>	
								</ul>
							</div>
							<div class="control" id="spec-right">
								<img src="images/right.gif" />
							</div>

						</div>
					</div>
				</div>

				<div class="item-top-right">
					<div class="item-info">
						<div class="item-head">
							<div class="item-title">
								${item.itemname}
								<input type="hidden" value="${item.itemid}" id="itemid"/>
								<c:choose>
									<c:when test="${item.sellstatus==0 }">
										<span class="label label-primary item-status">出售中</span>
									</c:when>
									<c:when test="${item.sellstatus==1 }">
										<span class="label label-warning item-status">交易中</span>
									</c:when>
									<c:otherwise>
										<span class="label label-success item-status">已出售</span>
									</c:otherwise>
								</c:choose>


							</div>
							<div class="item-price">
								<span>售价:￥</span>${item.sellprice}
							</div>
							<div class="item-price-down">
								<c:if test="${item.bargain==0}">一口价</c:if>
								<c:if test="${item.bargain==1}">可议价</c:if>
							</div>
							<div class="addfav">
								<a href="javascript:void(0)" id="addtofav">加入收藏</a>
							</div>
							<div class="item-report">
								<a href="#">举报商品</a>
							</div>
							<div class="item-price-up">
								<span>原价:￥</span>${item.originprice}
							</div>
							<div class="item-viewtimes">
								<div class="float-left">
									<span>浏览次数：</span>${item.viewtime}
								</div>

							</div>
						</div>
						<div class="item-detail">
							<div class="item-condition">
								<span class="label label-info">成 色</span>${item.color}成新
							</div>
							<div class="item-pad">
								<span class="label label-info">交易地点</span>${item.tradeposition}
							</div>
							<div class="item-pad">
								<span class="label label-info">卖 家</span>${item.usernormal.nickname }
							</div>
							<div class="item-pad">
								<span class="label label-info">认证状态</span>
								<c:choose>
									<c:when test="${item.usernormal.authen==0 }">未认证</c:when>
									<c:when test="${item.usernormal.authen==1 }">审核中</c:when>
									<c:when test="${item.usernormal.authen==2 }">已认证</c:when>
								</c:choose>
							</div>
							<div class="item-pad">
								<span class="label label-info">联系方式</span><c:if test="${!empty item.usernormal.mobile}">手机：${item.usernormal.mobile }</c:if>
								<c:if test="${!empty item.usernormal.qq}">QQ：${item.usernormal.qq}</c:if>
							</div>
							<div class="item-pad">
								<span class="label label-info">发布时间</span> <fmt:formatDate value="${item.itemcreatime}" pattern="yyyy-MM-dd  HH:mm:ss" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12 item-intr">
				<div class="panel panel-default">
					<div class="panel-body">${item.discreption}</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-7">
				<div class="comment-header">
					<span class="label label-danger comspan">留 言</span>
				</div>

				<div class="comment">
					<div class="Input_Box">
						<textarea class="Input_text"></textarea>
						<div class="Input_Foot">
						<a class="postBtn">确定</a>
						</div>
					</div>
				</div>

				<div class="comment-body comment-padding">
					
					<c:forEach items="${messages }" var="mes">
						<div class="comment-detail">
						<img class="comment-hdpic img-circle" src="${mes.mes_levuserheadpic}">
						<div class="comment-user">
							<span><a href="#">${mes.mes_levusername }</a></span>
						</div>
						<div class="comment-content">${mes.mes_content}</div>
					</div>
					</c:forEach>

					<div class="fy">
						<ul class="pagination">
							<li><a href="#">&laquo;</a></li>
							<li class="active"><a href="#">1</a></li>
							<li class="#"><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&raquo;</a></li>
						</ul>
					</div>
				</div>

				<script src="js/comment.js"></script>
			</div>
			<div class="col-md-5">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="glyphicon glyphicon-info-sign"></span>温馨提示
						</h3>
					</div>
					<div class="panel-body">
						如遇到以下情况请谨慎：<br> <span class=" font-red">1.宝贝价格异常低<br>
							2.图文信息不符<br> 3.卖家要求支付宝等直接付款
						</span><br>
					</div>
				</div>

				<div class="panel panel-default col-md-12 otheritem">
					<h4>卖家的其他物品</h4>
					<div class="row">
						<c:if test="${empty otherItem }"><div class="otheritem-none">该卖家没有其他物品！</div></c:if>
						
						<c:if test="${!empty otherItem }">
							<div class="col-md-12">
								<c:forEach items="${otherItem }" var="otherit">
								<div class="col-md-6">
									<a href="item.htm?id=${otherit.itemid }" class="thumbnail"> <img src="${otherit.itemmainimg }"
										alt="通用的占位符缩略图">
									</a>
									<div class="caption text-center">
										<p>
											<a href="item.htm?id=${otherit.itemid }">${otherit.itemname }</a>
										</p>
									</div>
								</div>
								</c:forEach>
								
							</div>
							</c:if>
					</div>
				</div>

			</div>
		</div>

	</div>
</div>

<%@include file="footer.jsp"%>