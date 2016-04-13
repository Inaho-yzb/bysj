<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="header.jsp"%>

<script type="text/javascript" src="/js/bops/user.js"></script>
<div class="searchForm">
	<form action="/bops/user.htm" method="post" id="scform">
		<table>
			<tr>
				<th>用户名:</th>
				<td align="left" width="15%"><spring:bind path="query.Username">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>昵称：</th>
				<td align="left" width="15%"><spring:bind
						path="query.NickName">
						<input type="text" name="${status.expression}"
							value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>Email：</th>
				<td align="left" width="15%"><spring:bind path="query.Email">
						<input type="text" name="${status.expression}"
							value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind></td>
				<th>手机：</th>
				<td align="left" width="15%"><spring:bind
						path="query.Mobile">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>
			</tr>

			<tr>
				<th>qq：</th>
				<td align="left" width="15%"><spring:bind
						path="query.QQ">
						<input type="text" name="${status.expression}"
							value="${status.value}"
							onkeyup="value=value.replace(/[^\d.]/g,'')" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>
				<th>创建时间起始：</th>
				<td align="left" width="15%"><spring:bind
						path="query.StartCreateTime">
						<input class="time" type="text" id="starttime"
							name="${status.expression}" value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>创建时间截至：</th>
				<td align="left" width="15%"><spring:bind
						path="query.EndCreateTime">
						<input class="time" type="text" id="endtime"
							name="${status.expression}" value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>认证状态：</th>
				<td align="left" width="15%"><spring:bind
						path="query.Authen">
						<select name="${status.expression}">
							<option value="">请选择</option>
							<option value="0"
								<c:if test="${status.value==0}">selected="selected"</c:if>>未认证</option>
							<option value="1"
								<c:if test="${status.value==1}">selected="selected"</c:if>>待审核</option>
							<option value="2"
								<c:if test="${status.value==2}">selected="selected"</c:if>>已认证</option>
						</select>
						<span>${status.errorMessage}</span>
					</spring:bind></td>
			</tr>

			<tr>
				<td><a href="javascript:void(0)" class="btn btn-ok">查询</a> <a
					href="javascript:void(0)" class="btn btn-reset">重置</a></td>
				<td><spring:bind path="query.pageNo">
						<input type="hidden" id="_cur_page" name="${status.expression}"
							value="${status.value}" />
					</spring:bind></td>
			</tr>
		</table>
	</form>
</div>
<div class="dataForm">
	<table>
		<tbody>
			<tr class="titleth">
				<th>用户名</th>
				<th>昵称</th>
				<th>Email</th>
				<th>手机</th>
				<th>QQ</th>
				<th>学校</th>
				<th>班级</th>
				<th>认证状态</th>
				<th>经验</th>
				<th>发布物品数</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.username}</td>
							<td>${q.nickname}</td>
							<td>${q.email}</td>
							<td>${q.mobile}</td>
							<td>${q.qq}</td>
							<td>${q.school}</td>
							<td>${q.userclass}</td>
							<td><c:choose>
									<c:when test="${q.authen==0}">
										未认证
									</c:when>
									<c:when test="${q.authen==1}">
										待审核
									</c:when>
									<c:otherwise>
										已认证
									</c:otherwise>
								</c:choose></td>
							<td>${q.levexp}</td>
							<td>${q.itemcount}</td>
							<td>${q.usernormalcreatime}</td>
							<td><a href="javascript:void(0)" id="deleteitem"onclick="deleteuser(${q.usernormal_id})">删除</a></td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td>没有数据</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
<%@include file="pg.jsp" %>
<%@include file="footer.jsp"%>