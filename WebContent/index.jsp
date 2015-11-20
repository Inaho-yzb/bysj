<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@include file="header.jsp" %>

<div class="content">
			<script src="${pageContext.request.contextPath}/js/index.js"></script>
			<div class="firstblock">
				<div class="container">
				<div class="row">

					<div class="col-md-3 col-cus">
						<ul class="nav nav-pills nav-stacked navlist">
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/1.png"><a href="#">代步工具</a><span class="navlist-li-div-span"><a href="#">自行车</a><a href="#">电动车</a><a href="#">摩托车</a></span>
								</div>

								<div>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/2.png"><a href="#">数码设备</a><span class="navlist-li-div-span"><a href="#">手机</a><a href="#">电脑</a><a href="#">相机</a></span>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/6.png"><a href="#">电器设备</a><span class="navlist-li-div-span"><a href="#">电吹风</a><a href="#">电风扇</a><a href="#">电水壶</a></span>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/8.png"><a href="#">衣物伞帽</a><span class="navlist-li-div-span"><a href="#">女装</a><a href="#">女鞋</a><a href="#">箱包</a></span>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div">
									<img src="images/9.png"><a href="#">图书教材</a><span class="navlist-li-div-span"><a href="#">教材</a><a href="#">小说</a><a href="#">漫画</a></span>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div"><img src="images/10.png"><a href="#">租赁</a>							</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div"><img src="images/11.png"><a href="#">生活娱乐</a>
								</div>
							</li>
							<li class="navlist-li">
								<div class="navlist-li-div"><img src="images/12.png"><a href="#">其他</a>
								</div>
							</li>
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
								data-slide="prev">&lsaquo;</a>
							<a class="carousel-control right cc-cus" href="#myCarousel" 
								data-slide="next">&rsaquo;</a>  
						</div> 
					</div>

					<div class="col-md-3 col-cus">
						<div class="row bkcl-gray">
							<div class="col-md-6 product-launch">
								<div class="bkcl-white fb-laun">
									<a href="#">
										<span>发布闲置</span>
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
								<span>我们的微信公众号</span>
								<img src="images/qcode.png">
							</div>
						</div>
					</div>
				</div>
				</div>
			</div>

			<div class="colshow">
				<div class="container">
					<div class="floorhd-1">
						<h4>
							<a href="">代步工具</a>
						</h4>					
					</div>

					<div class="row proshow-row">
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob2.png"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob3.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="container">
					<div class="floorhd-2">
						<h4>
							代步工具
						</h4>
					</div>

					<div class="row proshow-row">
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob2.png"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob3.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>

			<div class="container">
					<div class="floorhd-1">
						<h4>
							代步工具
						</h4>
					</div>

					<div class="row proshow-row">
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob2.png"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob3.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

						<div class="col-md-2">
							<div class="thumbnail proshow-row-col-pic">
								<a href="#"><img src="images/mob4.jpg"></a>								
							</div>
							<div class="proshow-entity">
								<div class="simp-proname">
									<a>iphone5s</a>
									<span class="simp-proname-price">￥5000</span>
								</div>
								<div class="simp-prointro">
									<span>数信学院</span>
									<span class="simp-prointro-right">认证用户</span>
								</div>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>


<%@include file="footer.jsp" %>