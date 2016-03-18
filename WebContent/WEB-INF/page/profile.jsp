<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="header.jsp"%>

<div class="content">
	<script src="../js/jquery-confirm.js"></script>
	<script src="../js/profile.js"></script>
	<link href="../css/jquery-confirm.css" rel="stylesheet" media="screen">
	<div class="container">
		<div class="col-md-12">
			<div class="prof-first">
				<div class="cghd  bkcl-white">
					<img src="../${usernormal.headimg} " class="prof-hdpic img-circle">
					<div class="text-center">
						<a href="">更改头像</a>
					</div>
				</div>

				<div class="prof-detail  bkcl-white">
					<div class="nickname">${usernormal.nickname}</div>

					<div class="hassolt">已卖出商品数：</div>
					<div class="level">
						等级：
						<fmt:formatNumber type='number' value='${usernormal.levexp/1000}'
							maxFractionDigits="0"></fmt:formatNumber>
					</div>
					<div class="progress progress-striped active profile-strip">
						<div class="progress-bar progress-bar-success" role="progressbar"
							aria-valuenow="60" aria-valuemin="0" aria-valuemax="100"
							style="width: ${usernormal.levexp/nextexp*100}%;"></div>
					</div>
					<div>
						当前经验：${usernormal.levexp }/${nextexp}
					</div>
					<a href="releasepro.htm" class="btn btn-info profile-putitems">发布商品</a>
				</div>
			</div>

			<div class="profile-tab">
				<ul id="myTab" class="nav nav-tabs">
					<li class=<c:if test="${empty tag}">"active"</c:if>><a href="#profile-doc" data-toggle="tab">
							个人资料 </a></li>
					<li class=<c:if test="${tag=='myitems'}">"active"</c:if>><a href="#items" data-toggle="tab" >已发布商品</a></li>
					<li class=<c:if test="${tag=='favitems'}">"active"</c:if>><a href="#favitems" data-toggle="tab">我的收藏</a></li>
					<li><a href="#message" data-toggle="tab">消息列表</a></li>
					<li><a href="#authen" data-toggle="tab">认证</a></li>
				</ul>
				<div id="myTabContent" class="tab-content">
					<div class=<c:choose><c:when test="${empty tag}">"tab-pane fade in active"</c:when><c:otherwise>"tab-pane fade"</c:otherwise></c:choose> id="profile-doc">
						<div class="profile-doc">
							<h3>帐号信息</h3>

						</div>
						<div class="profile-doc-detail">
							<span>帐号:${usernormal.username}</span>
						</div>

						<div class="profile-doc">
							<h3>个人信息</h3>
						</div>
						<div class="profile-doc-detail">
							<div>昵称：${usernormal.nickname}</div>
							<div>手机：${usernormal.mobile}</div>
							<div>Q Q：${usernormal.qq}</div>
							<div>学院：${usernormal.school}</div>
							<div>班级：${usernormal.userclass}</div>
							<div>认证状态：<c:choose>
								<c:when test="${usernormal.authen==0 }">未认证</c:when>
								<c:when test="${usernormal.authen==1 }">审核中</c:when>
								<c:when test="${usernormal.authen==2 }">已认证</c:when>
							</c:choose>
							</div>
							<div>
								<a class="btn btn-success profile-editbtn" data-toggle="modal"
									data-target="#profile-info">修改</a>
							</div>
							<div class="modal fade" id="profile-info" tabindex="-1"
								role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">×</button>
											<h4 class="modal-title" id="myModalLabel">修改信息</h4>
										</div>
										<form action="editUsernormalProfile.htm" method="post">
											<div class="modal-body">

												<div class="modal-body-input">
													昵称：<input type="text" name="nickname" value="${usernormal.nickname}" />
												</div>
												<div class="modal-body-input">
													手机：<input type="text" name="mobile" value="${usernormal.mobile}" />
												</div>
												<div class="modal-body-input">
													Q Q：<input type="text" name="qq" value="${usernormal.qq}" />
												</div>
												<div class="modal-body-input">
													学院：<input type="text" name="school" value="${usernormal.school}" />
												</div>
												<div class="modal-body-input">
													班级：<input type="text" name="userclass" value="${usernormal.userclass}" />
												</div>
												
												

											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">关闭</button>
												<button type="submit" class="btn btn-primary">提交更改
												</button>
											</div>
										</form>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
						</div>

					</div>
					<div class=<c:choose><c:when test="${tag=='myitems'}">"tab-pane fade in active"</c:when><c:otherwise>"tab-pane fade"</c:otherwise></c:choose> id="items">
					
					<c:forEach items="${items}" var="item">
						<div class="panel panel-default put-items">
							<div class="panel-body">
								<div class="col-md-2">
									<a href="${pageContext.request.contextPath}/item.htm?id=${item.itemid }"><img class="itemlist-pic" src="${item.itemmainimg}"></a>
									<div>
										<a href="${pageContext.request.contextPath}/item.htm?id=${item.itemid }">${item.itemname}</a>
									</div>
									<div>
										<c:choose>
											<c:when test="${item.sellstatus==0 }">出售中</c:when>
											<c:when test="${item.sellstatus==1 }">被预订</c:when>
											<c:when test="${item.sellstatus==2 }">已售出</c:when>
										</c:choose>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-4">${item.discreption}</div>
									<div class="col-md-4">
										<p>原价：￥${item.originprice }</p>
										<p>出售价：￥${item.sellprice}</p>
										<p>浏览次数：${item.viewtime}</p>
										<p>发布时间：</p>
										<p>${item.itemcreatime}</p>
									</div>
									<div class="col-md-4">
										<p>交易地点：${item.tradeposition}</p>
										<p>卖家：${usernormal.nickname}</p>
										<p>认证状态:<c:choose>
								<c:when test="${usernormal.authen==0 }">未认证</c:when>
								<c:when test="${usernormal.authen==1 }">审核中</c:when>
								<c:when test="${usernormal.authen==2 }">已认证</c:when>
							</c:choose></p>
										<p>留言：0</p>
										<p>收藏：0</p>
									</div>
								</div>
								<div class="col-md-2">
									<a href="" class="btn btn-primary">修改</a> <a href=""
										class="btn btn-danger btndelete">删除</a>
								</div>
							</div>
						</div>
						</c:forEach>

						

						<div class="put-items">
							<ul class="pagination">
								<li><a href="#">&laquo;</a></li>
								<li class="active"><a href="#">1</a></li>
								<li class="disabled"><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>

					</div>
					
					<div class=<c:choose><c:when test="${tag=='favitems'}">"tab-pane fade in active"</c:when><c:otherwise>"tab-pane fade"</c:otherwise></c:choose> id="favitems">
						
						<c:forEach items="${favs}" var="fav">
						<div class="panel panel-default put-items">
							<div class="panel-body">
								<div class="col-md-2">
									<a href="${pageContext.request.contextPath}/item.htm?id=${fav.itemid }"><img class="itemlist-pic" src="${fav.itemmainimg}"></a>
									<div class="">
										<a href="${pageContext.request.contextPath}/item.htm?id=${fav.itemid }">${fav.itemname}</a>
									</div>
									<div>
										<c:choose>
											<c:when test="${fav.sellstatus==0 }">出售中</c:when>
											<c:when test="${fav.sellstatus==1 }">被预订</c:when>
											<c:when test="${fav.sellstatus==2 }">已售出</c:when>
										</c:choose>
									</div>
								</div>
								<div class="col-md-8">
									<div class="col-md-4">${fav.discreption}</div>
									<div class="col-md-4">
										<p>原价：￥${fav.originprice}</p>
										<p>出售价：￥${fav.sellprice}</p>
										<p>浏览次数：${fav.viewtime}</p>
										<p>发布时间：</p>
										<p>${fav.itemcreatime }</p>
									</div>
									<div class="col-md-4">
										<p>交易地点：${fav.tradeposition}</p>
										<p>卖家：${fav.nickname }</p>
										<p>认证状态:
											<c:choose>
								<c:when test="${fav.sellerauthen==0 }">未认证</c:when>
								<c:when test="${fav.sellerauthen==1 }">审核中</c:when>
								<c:when test="${fav.sellerauthen==2 }">已认证</c:when>
							</c:choose>
										</p>
										<p>留言：0</p>
										<p>收藏：0</p>
									</div>
								</div>
								<div class="col-md-2">
									<a class="btn btn-danger btndelete">删除</a>
								</div>

							</div>
						</div>
						</c:forEach>

						<div class="put-items">
							<ul class="pagination">
								<li><a href="#">&laquo;</a></li>
								<li class="active"><a href="#">1</a></li>
								<li class="disabled"><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>
					</div>
					<div class="tab-pane fade" id="message">
					
						<c:forEach items="${messages}" var="message">
						<div class="panel panel-default profile-message">
							<div class="panel-body">
								<div class="col-md-2">
									商品：${message.mes_itemname } <img class="itemlist-pic" src="${message.mes_itemmainimg}">
								</div>

								<div class="col-md-8">
									<h4>${message.mes_levusername}:</h4>
									<p>${message.mes_content}</p>
								</div>
								<div class="col-md-2 profile-message-opr">
									<div class="badge bkcl-red">未读</div>
									<a type="button"  onclick="checkMes(${message.mes_id},${message.mes_itemid})"
										class="btn btn-info profile-message-checkbtn">查看</a>
								</div>
							</div>
						</div> 
						</c:forEach>


						<div class="profile-message">
							<ul class="pagination">
								<li><a href="#">&laquo;</a></li>
								<li class="active"><a href="#">1</a></li>
								<li class="disabled"><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
						</div>

					</div>
					<div class="tab-pane fade" id="authen">
						<div class="profile-authen">
							<c:choose>
							<c:when test="${usernormal.authen==2 }">
								<div>您已经认证！</div>
							</c:when>
							<c:when test="${usernormal.authen==0 }">
							<a href="" class="btn btn-primary btn-lg">身份证认证</a> <a href=""
								class="btn btn-primary btn-lg">学生证认证</a>
							</c:when>
							<c:otherwise>
								<div>审核中</div>
							</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
</div>


<%@include file="footer.jsp"%>