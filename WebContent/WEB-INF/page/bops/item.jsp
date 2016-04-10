<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<%@include file="header.jsp" %>
	
	<div class="searchForm">
		<table>
			<tr>
				<th>物品名称:</th>
				<td><spring:bind path="query.ItemName">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>开始售价：</th>
				<td>
				<spring:bind path="query.StartSell">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>结束售价：</th>
				<td>
					<spring:bind path="query.EndSell">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>交易地点：</th>
				<td>
					<spring:bind path="query.Tradeposition">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
			</tr>
			
			<tr>

				<th>开始原价：</th>
				<td>
				<spring:bind path="query.StartSell">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>结束原价：</th>
				<td>
					<spring:bind path="query.EndSell">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>议价：</th>
				<td>
					<spring:bind path="query.Tradeposition">
						<select name="${status.expression}" value="${status.value}">
							<option value="">请选择</option>
							<option value="0" <c:if test="${status.value}==0">selected="selected"</c:if>>一口价</option>
							<option value="1" <c:if test="${status.value}==1">selected="selected"</c:if>>可议价</option>
						</select>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>用户昵称：</th>
				<td>
					<spring:bind path="query.SellerNickName">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
			</tr>
			
			<tr>
				<th>发布时间起始：</th>
				<td>
				<spring:bind path="query.StartCreateTime">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>发布时间截至：</th>
				<td>
					<spring:bind path="query.EndCreateTime">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				
				<th>状态：</th>
				<td>
					<spring:bind path="query.Tradeposition">
						<select name="${status.expression}" value="${status.value}">
							<option value="">请选择</option>
							<option value="0" <c:if test="${status.value}==0">selected="selected"</c:if>>发布中</option>
							<option value="1" <c:if test="${status.value}==1">selected="selected"</c:if>>被预定</option>
							<option value="2" <c:if test="${status.value}==2">selected="selected"</c:if>>已售出</option>
						</select>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
			</tr>
			
			<tr>
				<td>
					<button>查询</button>
					<button>重置</button>
				</td>
				
			</tr>
		</table>
	</div>
	<div class="dataFrom">
		<c:choose>
			<c:when test="${!empty query.data}">
			</c:when>
			<c:otherwise>
				没有数据
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		
	</div>
<%@include file="footer.jsp" %>