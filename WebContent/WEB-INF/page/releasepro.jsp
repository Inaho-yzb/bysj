<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="header.jsp"%>

<style>
#release-head h2 {
	text-align: center;
	line-height: 40px;
}

.formtb {
	margin-left: auto;
	margin-right: auto;
}

.formtb tr {
	height: 50px;
}

.formtb th {
	width: 30%;
	text-align: right;
}

.formtb td{
	padding-right: 10px;
}

.formtb textarea {
	min-height: 150px;
	resize: none
}

.formtb-sub{
	width: 300px;
    margin-left: auto;
    margin-right: auto;
}

.formtb-sub button{
	width:80px;
	margin-left:30px;
}
</style>
<script src="${pageContext.request.contextPath}/js/uploadfile.js"></script>
<script src="${pageContext.request.contextPath}/js/releasepro.js"></script>
<div class="panel panel-default container">
	<div class="panel-body">
		<div id="release-head">
			<h2>发布物品</h2>
		</div>
		<div id="release-content">
			<table class="formtb">
				<tbody>
					<tr>
						<th>商品名：</th>
						<td><input id="itemname" name="itemname" class="form-control" placeholder="请输入商品名"/></td>
						<td width="150px"><span id="itemnameerror" class="color-red"></span></td>
					</tr>
					
					<tr>
						<th>分类：</th>
						<td>
							<select id="itemclass" name="itemclass" class="form-control">
								<option value="">请选择</option>
								<c:forEach items="${itemClassList}" var="clas">
									<option value="${clas.itemclass_id}">${clas.itemclass_name}</option>
								</c:forEach>
							</select>
						</td>
						<td width="150px"><span id="itemclasserror" class="color-red"></span></td>
					</tr>
					
					<tr>
						<th>售价：</th>
						<td>
							<div class="input-group">
								<input id="itemsellprice" name="itemsellprice"
									class="form-control" placeholder="请输入出售价格" onkeyup="value=value.replace(/[^\d\.]/g,'')"/> <span class="input-group-addon">元</span>
							</div>
						</td>
						<td width="150px"><span id="itemsellpriceerror" class="color-red"></span></td>
					</tr>
					<tr>
						<th>原价：</th>
						<td>
							<div class="input-group">
								<input id="itemoriginprice" name="itemoriginprice"
									class="form-control" placeholder="请输入原价" onkeyup="value=value.replace(/[^\d\.]/g,'')"/> <span class="input-group-addon">元</span>
							</div>
						</td>
						<td width="150px"><span id="itemoriginpriceerror" class="color-red"></span></td>
					</tr>
					<tr>
						<th>接受议价：</th>
						<td><input id="itembargain-y" name="itembargain" type="radio"
							checked="checked" value="1">是<input id="itembargain-n"
							name="itembargain" type="radio" value="2">否</td>
					</tr>
					<tr>
						<th>成色：</th>
						<td>
							<div class="input-group">
								 <select class="form-control" id="itemuse">
								 	<option value="10">全新</option>
         							<option value="9.9">9.9</option>
         							<option value="9">9</option>
         							<option value="8">8</option>
         							<option value="7">7</option>
         							<option value="6">6</option>
         							<option value="5">5</option>
         							<option value="4">4</option>
         							<option value="3">3</option>
      							 </select>
								<span class="input-group-addon">成新</span>
							</div>
						</td>
					</tr>

					<tr>
						<th>交易地点：</th>
						<td><input id="itemtradeposition" name="itemtradeposition"
							class="form-control" placeholder="请输入交易地点"></td>
						<td width="150px"><span id="itemtradepositionerror" class="color-red"></span></td>
					</tr>
					<tr>
						<th>物品描述：</th>
						<td><textarea class="form-control" placeholder="请输入物品描述" id="itemdescription"></textarea></td>
						<td width="150px"><span id="itemdescriptionerror" class="color-red"></span></td>
					</tr>
					<tr>
						<th>物品图片：</th>
						<td>
							<div>
								<input type="file" id="inputfile" name="uploadfile"  multiple="multiple">
								<label id="filelabe"></label>
							</div>
						</td>
						<td width="150px"><span id="itemfileerror" class="color-red"></span></td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="formtb-sub">
			<button type="button" class="btn btn-primary" id="btn-ok">发布</button>
			<button type="button" class="btn btn-default">重置</button>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>