<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pg">
	<c:choose>
		<c:when test="${!empty query && query.totalCount>0}">
			<div id="_page">
				<input type="hidden" id="_total_page" value="${query.totalPage}" />

				<c:choose>
					<c:when test="${!empty query.firstPage}">
						<a id="_pre_page" href="javascript:void(0)"
							style="font-weight: bold">&laquo;</a>
						<input type="hidden" value="${query.prePage}" id="prepage" />
					</c:when>
					<c:otherwise>
						<a id="_none_pre_page" style="font-weight: bold">&laquo;</a>
					</c:otherwise>
				</c:choose>
				<c:forEach var="p" begin="${query.beginPage}" end="${query.endPage}">
					<c:choose>
						<c:when test="${query.pageNo!=p}">
							<a id="_page_no">${p}</a>
						</c:when>
						<c:otherwise>
							<b> ${p} </b>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${!empty query.lastPage}">
							<a id="_next_page" href="javascript:void(0)"
								style="font-weight: bold">&raquo;</a>
							<input type="hidden" value="${query.nextPage}" id="nextpage" />
						</c:when>
						<c:otherwise>
							<a id="_none_next_page" style="font-weight: bold">&raquo;</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<input id="_go_page" type="text" size="2" title="输入页码按回车"
					maxlength="4" /><a id="_go" href="javascript:void(0)"
					style="color: #000">GO</a> 页数： [<font color="red">${query.pageNo}</font>
				/ ${query.totalPage} ] 总记录数：${query.totalCount}
			</div>
		</c:when>
		<c:otherwise>
			<div id="_page">没有结果</div>
		</c:otherwise>
	</c:choose>
</div>