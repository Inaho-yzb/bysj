<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="header.jsp" %>

<div class="searchForm">
	<form action="/bops/message.htm" method="post" id="scform">
		<table>
			<tr>
				<th>物品ID:</th>
				<td align="left" width="15%"><spring:bind path="query.Itemid">
						<input type="text" name="${status.expression}"
							value="${status.value}" />
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>留言用户ID：</th>
				<td align="left" width="15%"><spring:bind path="query.LevUserid">
						<input type="text" name="${status.expression}"
							value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind></td>

				<th>内容：</th>
				<td align="left" width="15%"><spring:bind path="query.Content">
						<input type="text" name="${status.expression}"
							value="${status.value}"/>
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
			</tr>

			<tr>
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
				<th>留言ID</th>
				<th>物品ID</th>
				<th>物品名称</th>
				<th>留言者ID</th>
				<th>留言者昵称</th>
				<th>内容</th>
				<th>状态</th>
				<th>创建时间</th>
				<th></th>
				<th>操作</th>
			</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.mes_id}</td>
							<td>${q.mes_itemid}</td>
							<td>${q.mes_itemname}</td>
							<td>${q.mes_levuserid}</td>
							<td>${q.mes_levusername}</td>
							<td>${q.mes_content}</td>
							<td><c:choose>
									<c:when test="${q.mes_status==0}">
										待审核
									</c:when>
									<c:when test="${q.mes_status==1}">
										审核通过
									</c:when>
									<c:otherwise>
										未通过
									</c:otherwise>
								</c:choose></td>
							<td>${q.createtime}</td>
							<td>${q.audittime}</td>
							<td><a href="javascript:void(0)" id="deleteitem"onclick="deleteuser(${q.mes_id})">删除</a></td>
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