<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="header.jsp"%>

<div class="content">
	<script src="../js/jquery-confirm.js"></script>
	<script src="../js/profile.js"></script>
	<link href="../css/jquery-confirm.css" rel="stylesheet" media="screen">
	<script src="${pageContext.request.contextPath}/js/uploadfile.js"></script>
	<div class="container">
		<div class="col-md-12">
			<div class="prof-first">
				<div class="cghd  bkcl-white">
					<img src="../${usernormal.headimg} " class="prof-hdpic img-circle">
					<div class="text-center">
						<a href="javascript:void(0)" onclick="changeHead()" id="changehd">更改头像</a>
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
				
				<div class="righthd">
					<h1>更改头像</h1>
					<input type="file" name="uploadfile"  id="cghdipt"/>
					<button class="btn btn-default subhdimg" style="margin-top:20px;">提交</button>
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
								<c:when test="${usernormal.authen==0 }"><span id="authenstatus">未认证</span></c:when>
								<c:when test="${usernormal.authen==1 }"><span id="authenstatus">审核中</span></c:when>
								<c:when test="${usernormal.authen==2 }"><span id="authenstatus">已认证</span></c:when>
							</c:choose>
							</div>
							<div>
								<a class="btn btn-success profile-editbtn" data-toggle="modal" data-target="#profile-info">修改</a>
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
					<div id="item-tab">
					<c:forEach items="${items}" var="item">
						<div class="panel panel-default put-items">
							<div class="panel-body">
								<div class="col-md-2">
									<a href="${pageContext.request.contextPath}/item.htm?id=${item.itemid}"><img class="itemlist-pic" src="${item.itemmainimg}"></a>
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
									<c:if test="${item.sellstatus!=2}">
									<div>
										<a class="btn btn-default" onclick="changeStatus(${item.itemid},${item.sellstatus})">更改状态</a>
									</div>
									</c:if>
								</div>
								<div class="col-md-8">
									<div class="col-md-4">${item.discreption}</div>
									<div class="col-md-4">
										<p>原价：￥${item.originprice }</p>
										<p>出售价：￥${item.sellprice}</p>
										<p>浏览次数：${item.viewtime}</p>
										<p>发布时间：</p>
										<p><fmt:formatDate value="${item.itemcreatime}"
									pattern="yyyy-MM-dd  HH:mm:ss" /></p>
									</div>
									<div class="col-md-4">
										<p>交易地点：${item.tradeposition}</p>
										<p>卖家：${usernormal.nickname}</p>
										<p>认证状态:<c:choose>
								<c:when test="${usernormal.authen==0 }">未认证</c:when>
								<c:when test="${usernormal.authen==1 }">审核中</c:when>
								<c:when test="${usernormal.authen==2 }">已认证</c:when>
							</c:choose></p>
									</div>
								</div>
								<div class="col-md-2">
									<a href="javascript:void(0)" onclick="editItem(${item.itemid})" class="btn btn-primary">修改</a> 
									<a class="btn btn-danger" onclick="deletemyitems(${item.itemid})">删除</a>
								</div>
							</div>
						</div>
						</c:forEach>
						</div>
						
						<c:if test="${!empty items}">
						<div class="put-items">
							<ul class="pagination" id="itempag">
								 <c:if test="${!empty itempage.prvPage}"><li><a href="javascript:void(0)"onclick="toMesPage(${itempage.prvPage})">&laquo;</a></li></c:if>
							
							<c:forEach items="${itempage.pageList}" var="p">
								<c:choose>
									<c:when test="${itempage.currentPage==p}">
										<li class="active"><a>${p}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="javascript:void(0)" onclick="chageitempage(${p},${usernormal.usernormal_id})">${p}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${!empty itempage.nextPage}"><li><a href="javascript:void(0)" onclick="chageitempage(${itempage.nextPage},${usernormal.usernormal_id})">&raquo;</a></li></c:if>
							</ul>
						</div>
						</c:if>
					</div>
					
					<div class=<c:choose><c:when test="${tag=='favitems'}">"tab-pane fade in active"</c:when><c:otherwise>"tab-pane fade"</c:otherwise></c:choose> id="favitems">
						<div id="fav-tab">
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
										<p><fmt:formatDate value="${fav.itemcreatime}"
									pattern="yyyy-MM-dd  HH:mm:ss" /></p>
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
										
									</div>
								</div>
								<div class="col-md-2">
									<a class="btn btn-danger" onclick="deletefav(${fav.itemid})">删除</a>
								</div>

							</div>
						</div>
						</c:forEach>
						</div>
						<c:if test="${!empty favs}">
						<div class="put-items">
							<ul class="pagination" id="favpag">
								<c:if test="${!empty favpage.prvPage}"><li><a href="javascript:void(0)"onclick="changefavpage(${favpage.prvPage})">&laquo;</a></li></c:if>
							
								<c:forEach items="${favpage.pageList}" var="p">
								<c:choose>
									<c:when test="${favpage.currentPage==p}">
										<li class="active"><a>${p}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="javascript:void(0)" onclick="chagefavpage(${p},${usernormal.usernormal_id})">${p}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${!empty favpage.nextPage}"><li><a href="javascript:void(0)" onclick="chagefavpage(${favpage.nextPage},${usernormal.usernormal_id})">&raquo;</a></li></c:if>
							</ul>
						</div>
						</c:if>
					</div>
					
					<div class="tab-pane fade" id="message">
						<div id="mes-tab">
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
						</div>
						<c:if test="${!empty messages}">
						<div class="profile-message">
							<ul class="pagination" id="mespag">
								<c:if test="${!empty mespage.prvPage}"><li><a href="javascript:void(0)"onclick="chagemespage(${mespage.prvPage})">&laquo;</a></li></c:if>
							
								<c:forEach items="${mespage.pageList}" var="p">
								<c:choose>
									<c:when test="${mespage.currentPage==p}">
										<li class="active"><a>${p}</a></li>
									</c:when>
									<c:otherwise>
										<li><a href="javascript:void(0)" onclick="chagemespage(${p},${usernormal.usernormal_id})">${p}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							<c:if test="${!empty mespage.nextPage}"><li><a href="javascript:void(0)" onclick="chagemespage(${mespage.nextPage},${usernormal.usernormal_id})">&raquo;</a></li></c:if>
							</ul>
						</div>
						</c:if>
					</div>
					<div class="tab-pane fade" id="authen">
						<div class="profile-authen">
							<c:choose>
							<c:when test="${usernormal.authen==2 }">
								<div>您已经认证！</div>
							</c:when>
							<c:when test="${usernormal.authen==0 }">
							<div id="authenframe">
								<table style="margin-top:20px;border-collapse:separate; border-spacing:10px;">
									<tbody>
										<tr>
											<th>姓名：</th><td><input id="atname"/></td>
										</tr>
										<tr>
											<th>证件号：</th><td><input id="atid"/></td>
										</tr>
										<tr>
											<th>上传证件照：</th><td><input type="file" id="authenfile" name="uploadfile" accept=".jpg,.jpeg,.png,.gif" style="width:200px"><label id="filelabe"></label></td>
										</tr>
										<tr>
											<td>
											<button class="btn btn-primary" id="btn-subauthen">
												提交
											</button>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
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