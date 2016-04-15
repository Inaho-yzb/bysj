<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<%@include file="header.jsp" %>
<script type="text/javascript" src="/js/bops/addnewadmin.js"></script>
<div>
	<table>
		<tbody>
			<tr>
				<th>登录名</th>
				<td><input type="text" id="loginname"/></td><td><span id="nameerror"></span></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input type="password" id="password"/></td><td><span id="pwderror"></span></td>
			</tr>
			<tr>
				<th>重复密码</th>
				<td><input type="password" id="repassword"/></td><td></td>
			</tr>
			<tr>
				<td colspan="3">
					<a href="javascript:void(0)" class="btn btn-ok">提交</a>
					<a href="javascript:void(0)" class="btn btn-reset">重置</a>
				<td>
			</tr>
		</tbody>
	</table>
</div>
<%@include file="footer.jsp" %>