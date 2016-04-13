<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="header.jsp" %>

<div class="searchForm">
	<form action="/bops/authen.htm" method="post" id="scform">
		<table>
			<tr>
				<th>用户ID:</th>
				<td align="left" width="15%"><spring:bind path="query.UserId">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>
					
				<th>状态：</th>
				<td align="left" width="15%"><spring:bind
						path="query.Status">
						<select name="${status.expression}">
							<option value="">请选择</option>
							<option value="0"
								<c:if test="${status.value==0}">selected="selected"</c:if>>待审核</option>
							<option value="1"
								<c:if test="${status.value==1}">selected="selected"</c:if>>审核通过</option>
							<option value="2"
								<c:if test="${status.value==2}">selected="selected"</c:if>>审核未通过</option>
						</select>
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
				<th>ID</th>
				<th>验证姓名</th>
				<th>证件号码</th>
				<th>证件图片</th>
				<th>用户ID</th>
				<th>用户昵称</th>
				<th>创建时间</th>
				<th>状态</th>
				<th>审核时间</th>
				<th>审核管理员</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.ID}</td>
							<td>${q.authenName}</td>
							<td>${q.idCode}</td>
							<td>查看</td>
							<td>${q.userId}</td>
							<td>${q.userNickName}</td>
							<td>${q.createTime}</td>
							<td><c:choose>
									<c:when test="${q.status==0}">
										待审核
									</c:when>
									<c:when test="${q.status==1}">
										审核通过
									</c:when>
									<c:otherwise>
										未通过
									</c:otherwise>
								</c:choose></td>
							<td>${q.auditTime}</td>
							<td>${q.auditSysUserName}</td>
							<td><a href="javascript:void(0)" id="deleteitem"onclick="deleteAuthen(${q.ID})">删除</a></td>
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


<%@include file="footer.jsp" %>