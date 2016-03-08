$(function() {

	$("#itemname").blur(function() {
		var value = $("#itemname").val();
		if (value == "") {
			$("#itemnameerror").text("商品名不能为空！");
		} else {
			$("#itemnameerror").text("");
		}
	});

	$("#itemsellprice").blur(function() {
		var value = $("#itemsellprice").val();
		if (value == "") {
			$("#itemsellpriceerror").text("出售价格不能为空！");
		} else if (value.match(/^(0|([1-9]\d{0,9}(\.\d{1,2})?))$/) == null) {
			$("#itemsellpriceerror").text("出售价格不正确！");
		} else {
			$("#itemsellpriceerror").text("");
		}
	});

	$("#itemoriginprice").blur(function() {
		var value = $("#itemoriginprice").val();
		if (value == "") {
			$("#itemoriginpriceerror").text("原价不能为空！");
		} else if (value.match(/^(0|([1-9]\d{0,9}(\.\d{1,2})?))$/) == null) {
			$("#itemoriginpriceerror").text("原价不正确！");
		} else {
			$("#itemoriginpriceerror").text("");
		}
	});

	$("#itemtradeposition").blur(function() {
		var value = $("#itemtradeposition").val();
		if (value == "") {
			$("#itemtradepositionerror").text("请填写交易地点！");
		} else {
			$("#itemtradepositionerror").text("");
		}
	});
	
	$("#itemclass").blur(function(){
		var value = $("#itemclass").val();
		if(value==""){
			$("#itemclasserror").text("请选择物品类别！");
		}else{
			$("#itemtradepositionerror").text("");
		}
	});

	$("#btn-ok").click(
			function() {
				if ($("#itemnameerror").text() != ""
						|| $("#itemsellpriceerror").text() != ""
						|| $("#itemoriginpriceerror").text() != ""
						|| $("#itemtradepositionerror").text() != ""
						|| $("#itemname").val() == ""
								|| $("#itemsellprice").val() == ""
								|| $("#itemoriginprice").val() == "" || 
								$("#itemtradeposition").val() == ""||$("#itemclass").val()=="") {
					hrHuTui.popout({
						type : "info",
						title : "表单不完整！",
						content : "请填正确表单！"
					});
				}else{
					ajaxSubmit();
				}
			});

})
function ajaxSubmit() {
	$("input[name=uploadfile]").upload({
		url : "/user/uploaditem.htm",
		// 其他表单数据
		params : {
			itemname :$("#itemname").val(),
			sellprice:$("#itemsellprice").val(),
			originprice:$("#itemoriginprice").val(),
			bargain:$("input[type=radio][checked]").val(),
			color:$("#itemuse").val(),
			tradeposition: $("#itemtradeposition").val(),
			description:$("#itemdescription").val()
		},
		// 上传完成后, 返回json, text
		dataType : 'json',
		onSend : function(obj, str) {
			return true;
		},
		// 上传之后回调
		onComplate : function(data) {
			alert(data);
		}
	});
	$("input[name=uploadfile]").upload("ajaxSubmit")
}