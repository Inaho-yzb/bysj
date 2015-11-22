<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="header.jsp"%>

<div class="content">
	<script src="${pageContext.request.contextPath}/js/index.js"></script>
	<div class="firstblock">
		<div class="container">
			<div class="row">

				<div class="col-md-3 col-cus">
					<ul class="nav nav-pills nav-stacked navlist">

						<c:forEach items="${fatherClass}" var="fc">
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/${fc.itemclass_id}.png"><a href="itemlist.html?fid=${fc.itemclass_id}">${fc.itemclass_name }</a>
									<span class="navlist-li-div-span"> <c:forEach
											items="${childClass}" var="cc">
											<c:if test="${cc.key==fc.itemclass_id}">
												<c:forEach items="${cc.value}" var="ccn">
													<a href="itemlist.html?id=${ccn.itemclass_id }">${ccn.itemclass_name}</a>
												</c:forEach>
											</c:if>
										</c:forEach>
									</span>
								</div>
							</li>
						</c:forEach>

					</ul>
				</div>

				<div class="col-md-6 col-cus">
					<div id="myCarousel" class="carousel slide slide-cus">
						<!-- 轮播（Carousel）指标 -->
						<ol class="carousel-indicators">
							<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
							<li data-target="#myCarousel" data-slide-to="1"></li>
							<li data-target="#myCarousel" data-slide-to="2"></li>
						</ol>
						<!-- 轮播（Carousel）项目 -->
						<div class="carousel-inner">
							<div class="item active">
								<img src="images/1118.png" alt="First slide">
							</div>
							<div class="item">
								<img src="images/5555.png" alt="Second slide">
							</div>
							<div class="item">
								<img src="images/6666.png" alt="Third slide">
							</div>
						</div>
						<!-- 轮播（Carousel）导航 -->
						<a class="carousel-control left cc-cus" href="#myCarousel"
							data-slide="prev">&lsaquo;</a> <a
							class="carousel-control right cc-cus" href="#myCarousel"
							data-slide="next">&rsaquo;</a>
					</div>
				</div>

				<div class="col-md-3 col-cus">
					<div class="row bkcl-gray">
						<div class="col-md-6 product-launch">
							<div class="bkcl-white fb-laun">
								<a href="#"> <span>发布闲置</span>
								</a>

							</div>
						</div>

						<div class="col-md-6 product-launch">
							<div class="bkcl-white fb-laun">
								<a href="#">发布需求</a>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="qrcode">
							<span>我们的微信公众号</span> <img src="images/qcode.png">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="colshow">

		<c:forEach items="${fatherClass }" var="fcl">
			<div class="container">
				<div class="floorhd-1">
					<h4>
						<a href="itemlist.html?fid=${fcl.itemclass_id}">${fcl.itemclass_name}</a>
					</h4>
				</div>
				<c:forEach items="${itemList}" var="iteml">
					<c:if test="${iteml.key==fcl.itemclass_id}">

						<div class="row proshow-row">
							<c:forEach items="${iteml.value}" var="itm">
								<div class="col-md-2">
									<div class="thumbnail proshow-row-col-pic">
										<a href="item.html?id=${itm.itemid}"><img src="${itm.itemmainimg}"></a>
									</div>
									<div class="proshow-entity">
										<div class="simp-proname">
											<a href="item.html?id=${itm.itemid}">${itm.itemname}</a> <span class="simp-proname-price">￥${itm.sellprice}</span>
										</div>
										<div class="simp-prointro">
											<span>${itm.usernormal.school}</span> <span
												class="simp-prointro-right"> <c:choose>
													<c:when test="${itm.usernormal.authen==2}">
												认证用户
											</c:when>
													<c:otherwise>
												未认证用户
											</c:otherwise>
												</c:choose>
											</span>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
				
				</c:if>
		</c:forEach>
	</div>

	</c:forEach>


</div>


</div>



<%@include file="footer.jsp"%>