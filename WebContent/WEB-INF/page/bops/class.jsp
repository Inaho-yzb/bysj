<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@include file="header.jsp" %>
<script type="text/javascript" src="/js/bops/class.js"></script>
<div class="dataForm">
	<table>
		<tbody>
			<tr class="titleth">
				<th>ID</th>
				<th>分类名</th>
				<th>父类</th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query}">
					<c:forEach items="${query}" var="q">
						<tr>
							<td>${q.itemclass_id}</td>
							<td>${q.itemclass_name}</td>
							<td>${q.fatherclass}</td>
							<td>
								<a href="javascript:void(0)" id="edititemclass" onclick="editclass(${q.itemclass_id})">修改</a>
								<a href="javascript:void(0)" id="deleteitemclass" onclick="deleteclass(${q.itemclass_id})">删除</a>
							</td>
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


<%@include file="footer.jsp" %>