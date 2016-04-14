<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@include file="header.jsp" %>

<div class="searchForm">
	<form action="/bops/admin.htm" method="post" id="scform">
		<table>
			<tr>
				<th>登录名:</th>
				<td align="left" width="15%"><spring:bind path="query.LoginName">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

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
				<th>登录名</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.ID}</td>
							<td>${q.loginName}</td>
							<td><fmt:formatDate value="${q.createTime}"
									pattern="yyyy-MM-dd  HH:mm:ss" /></td>
							<td><a href="javascript:void(0)" id="deleteitem"onclick="deleteSysuser(${q.ID})">删除</a></td>
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