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
	width: 50%;
}

.formtb tr {
	height: 50px;
}

.formtb th {
	width: 30%;
	text-align: right;
}

.formtb td {
	width: 70%
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
						<td><input id="itemname" name="itemname" class="form-control" /></td>
					</tr>
					<tr>
						<th>售价：</th>
						<td>
							<div class="input-group">
								<input id="itemsellprice" name="itemsellprice"
									class="form-control" /> <span class="input-group-addon">元</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>原价：</th>
						<td>
							<div class="input-group">
								<input id="itemoriginprice" name="itemoriginprice"
									class="form-control" /> <span class="input-group-addon">元</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>接受议价：</th>
						<td><input id="itembargain-y" name="itembargain" type="radio"
							checked="checked">是<input id="itembargain-n"
							name="itembargain" type="radio">否</td>
					</tr>
					<tr>
						<th>成色：</th>
						<td>
							<div class="input-group">
								<input id="itemcolor" name="itemcolor" class="form-control" />
								<span class="input-group-addon">成新</span>
							</div>
						</td>
					</tr>

					<tr>
						<th>交易地点：</th>
						<td><input id="itemtradeposition" name="itemtradeposition"
							class="form-control"></td>
					</tr>

					<tr>
						<th>手机号码：</th>
						<td><input id="itemmobile" name="itemmobile"
							class="form-control"></td>
					</tr>

					<tr>
						<th>QQ号：</th>
						<td><input id="itemqq" name="itemqq" class="form-control"></td>
					</tr>
					<tr>
						<th>物品描述：</th>
						<td><textarea class="form-control"></textarea></td>
					</tr>
					<tr>
						<th>物品图片：</th>
						<td>
							<div>
								<input type="file" id="inputfile" name="uploadfile">
								<label id="filelabe"></label>
							</div>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
		<div class="formtb-sub">
			<button type="button" class="btn btn-primary">发布</button>
			<button type="button" class="btn btn-default">重置</button>
		</div>
	</div>
</div>

<%@include file="footer.jsp"%>