<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 
<%@include file="header.jsp" %>
	
	<div class="searchForm">
		<form action="/bops/item.htm" method="post" id="scfrom">
		<table>
			<tr>
				<th>物品名称:</th>
				<td align="left" width="15%">
				<spring:bind path="query.ItemName">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>开始售价：</th>
				<td align="left" width="15%">
				<spring:bind path="query.StartSell">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>结束售价：</th>
				<td align="left" width="15%">
					<spring:bind path="query.EndSell">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>交易地点：</th>
				<td align="left" width="15%">
					<spring:bind path="query.Tradeposition">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
			</tr>
			
			<tr>

				<th>开始原价：</th>
				<td align="left" width="15%">
				<spring:bind path="query.StartOrigin">
					<input type="text" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>结束原价：</th>
				<td align="left" width="15%">
					<spring:bind path="query.EndOrigin">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>议价：</th>
				<td align="left" width="15%">
					<spring:bind path="query.Bargain">
						<select name="${status.expression}" >
							<option value="">请选择</option>
							<option value="0" <c:if test="${status.value}==0">selected="selected"</c:if>>一口价</option>
							<option value="1" <c:if test="${status.value}==1">selected="selected"</c:if>>可议价</option>
						</select>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				<th>用户昵称：</th>
				<td align="left" width="15%">
					<spring:bind path="query.SellerNickName">
						<input type="text" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
			</tr>
			
			<tr>
				<th>发布时间起始：</th>
				<td align="left" width="15%">
				<spring:bind path="query.StartCreateTime">
					<input class="time" type="text" id="starttime" name="${status.expression}" value="${status.value}"/>
					<span>${status.errorMessage}</span>
				</spring:bind>
				</td>
				
				<th>发布时间截至：</th>
				<td align="left" width="15%">
					<spring:bind path="query.EndCreateTime">
						<input class="time" type="text" id="endtime" name="${status.expression}" value="${status.value}"/>
						<span>${status.errorMessage}</span>
					</spring:bind>
				</td>
				
				<th>状态：</th>
				<td align="left" width="15%">
					<spring:bind path="query.SellStatus">
						<select name="${status.expression}">
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
					<a href="javascript:void(0)" class="btn btn-ok">查询</a>
					<a href="javascript:void(0)" class="btn btn-reset">重置</a>
				</td>
				<td>
					<spring:bind path="query.PageNo">
					<input type="hidden" id="_cur_page" name="${status.expression}" value="${status.value}"/>
					</spring:bind>
				</td>
			</tr>
		</table>
		</form>
	</div>
	<div class="dataFrom">
	<table>
		<tbody>
		<tr class="titleth">
			<th>物品名称</th>
			<th>类别</th>
			<th>售价</th>
			<th>原价</th>
			<th>成色</th>
			<th>交易地点</th>
			<th>议价</th>
			<th>出售者</th>
			<th>描述</th>
			<th>发布时间</th>
			<th>出售状态</th>
			<th>操作</th>
		</tr>
			<c:choose>
				<c:when test="${!empty query.data}">
					<c:forEach items="${query.data}" var="q">
						<tr>
							<td>${q.itemname}</td>
							<td>${q.itemclass_name}</td>
							<td>${q.sellprice}</td>
							<td>${q.originprice}</td>
							<td>
								<c:choose>
									<c:when test="${q.color}==10">
										全新
									</c:when>
									<c:otherwise>
										${q.color}成新
									</c:otherwise>
								</c:choose>
							</td>
							<td>${q.tradeposition}</td>
							<td>
								<c:choose>
									<c:when test="${q.bargain}==0">
										一口价
									</c:when>
									<c:otherwise>
										可议价
									</c:otherwise>
								</c:choose>
							</td>
							<td>${q.nickname}</td>
							<td>${q.discreption}</td>
							<td>${q.itemcreatime}</td>
							<td>
								<c:choose>
									<c:when test="${q.sellstatus}==0">
										出售中
									</c:when>
									<c:when test="${q.sellstatus}==1">
										被预定
									</c:when>
									<c:otherwise>
										已售出
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<a href="/item.htm?id=${q.itemid}" target="_blank">查看</a>
							</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					没有数据
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</div>
	<div>
	<c:choose>
		<c:when test="${!empty query && query.totalCount>0}">
		    <div id="_page">
				<input type="hidden" id="_total_page" value="${query.totalPage}" />
				
				<c:choose>
		        <c:when test="${!empty query.firstPage}">
					<a id="_pre_page" href="#" style="font-weight:bold">&laquo;</a>
					<input type="hidden" value="${query.prePage}" />
				</c:when>
				<c:otherwise>
					<a id="_none_pre_page" href="#" style="font-weight:bold">&laquo;</a>
				</c:otherwise>
				</c:choose>
				<c:forEach var="p" begin="${query.beginPage}" end="${query.endPage}">
				<c:choose>
		        	<c:when test="${query.pageNo!=p}">
		        		<a id="_page_no" href="#">${p}</a>
		        	</c:when>
		        	<c:otherwise>
		        		<b> ${p} </b>
		        	</c:otherwise>
		        </c:choose>
		        <c:choose>
		        	<c:when test="${!empty query.lastPage}">
			        	<a id="_next_page" href="#" style="font-weight:bold">&raquo;</a>
						<input type="hidden" value="${query.nextPage}" />
		        	</c:when>
		        	<c:otherwise>
		        		<a id="_none_next_page" href="#" style="font-weight:bold">&raquo;</a>
		        	</c:otherwise>
		        </c:choose>
				</c:forEach>
				<input id="_go_page" type="text" size="2" title="输入页码按回车" maxlength="4" /><a id="_go" href="#" style="color:#000">GO</a>
				页数： [<font color="red">${query.pageNo}</font> / ${query.totalPage} ]  总记录数：${query.totalCount}
		    </div>
	    </c:when>
		<c:otherwise>
			没有结果
		</c:otherwise>
	</c:choose>
	</div>
	
<%@include file="footer.jsp" %>