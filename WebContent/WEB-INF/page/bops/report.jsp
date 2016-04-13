<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="header.jsp" %>

<div class="searchForm">
	<form action="/bops/report.htm" method="post" id="scform">
		<table>
			<tr>
				<th>物品ID:</th>
				<td align="left" width="15%"><spring:bind path="query.ItemId">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>举报用户昵称：</th>
				<td align="left" width="15%"><spring:bind path="query.UserNickName">
						<input type="text" name="${status.expression}"
							value="${status.value}"/>
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
				<th>举报ID</th>
				<th>物品ID</th>
				<th>物品名称</th>
				<th>举报者ID</th>
				<th>留言者昵称</th>
				<th>举报理由</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.id}</td>
							<td>${q.itemid}</td>
							<td>${q.itemname}</td>
							<td>${q.userid}</td>
							<td>${q.nickname}</td>
							<td><c:choose>
									<c:when test="${q.reasonid==0}">
										虚假物品
									</c:when>
									<c:when test="${q.reasonid==1}">
										违法物品
									</c:when>
									<c:when test="${q.reasonid==2}">
										广告、诈骗、淫秽色情、反动等内容
									</c:when>
									<c:otherwise>
										价格与物品不相符
									</c:otherwise>
								</c:choose></td>
							<td><a href="javascript:void(0)" id="deleteitem"onclick="deleteuser(${q.id})">删除</a></td>
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