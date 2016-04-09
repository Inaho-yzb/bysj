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

function changeImg() {
    var imgSrc = $("#imgObj");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", chgUrl(src));
}
//时间戳   
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳   
function chgUrl(url) {
    var timestamp = (new Date()).valueOf();
    url = url.substring(0, 17);
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}