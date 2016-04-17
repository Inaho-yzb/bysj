$(function(){
	$("#username").blur(function(){
		if($("#username").val()!=""){
			checkuser();
		}
	});
	
	$("#btn-sub").click(function(){
		if($("#username").val()!="" && $("#password").val()!="" && $("#vali").val()!=""){
			$(".form-signin").submit();
		}else{
			alert("请填写表单！");
			return false;
		}
	});
	
	$("#vali").blur(function(){
		if($("#vali").val()!=""){
			checkvali();
		}
	});
});

function checkuser(){
	$.ajax({
		url:"/checkuser.htm",
		type:"POST",
		data:{"username":$("#username").val()},
		success:function(res){
			if(res.errorCode!=0){
				$("#usernameerror").text("没有该用户");
				return false;
			}else{
				$("#usernameerror").text("");
			}
			return true;
		},
		error:function(xhr){
			alert("服务器连接失败！");
			return false;
		}
	});
}

function checkvali(){
	$.ajax({
		url:"/checkvali.htm",
		cache:false,
		type:"POST",
		data:{"vali":$("#vali").val()},
		success:function(res){
			if(res.errorCode!=0){
				$("#valierror").text("验证码错误！");
				return false;
			}else{
				$("#valierror").text("");
			}
			return true;
		},
		error:function(xhr){
			alert("服务器连接失败！");
			return false;
		}
	});
}