var appServer = window.location.host;
$(function(){
	var status1=false;
	var status2=false;
	var status3=false;
	var status4=false;
	var status5=false;
	$("#username").blur(function(){
		if($("#username").val()==""){
			$("#username-mes").html("用户名不能为空！");
		}else if($("#username").val().length>20||$("#username").val().match("[a-zA-Z0-9_.]{6,20}")==null){
			$("#username-mes").html("用户名格式不正确！");
		}else{
			$.ajax({
				dataType:'json',
				type:"POST",
				url:"/login/ajaxcheckusername.htm",
				data:{"username":$("#username").val()},
				success:function(res){
					if(res.errorCode==0){
						$("#username-mes").html("");
						status1=true;
					}else if(res.errorCode==1){
						$("#username-mes").html("用户名格式不正确！");
					}else{
						$("#username-mes").html("已存在该用户名！！");
					}
				},
				error:function(xhr){
					alert("服务器暂时离线！请稍后再试！");
				}
			});
		}
	});
	
	$("#nickname").blur(function(){
		if($("#nickname").val()==""){
			$("#nickname-mes").html("昵称不能为空！");
		}else if($("#nickname").val().length>20||$("#nickname").val().match("[a-zA-Z0-9_.]{6,20}")==null){
			$("#username-mes").html("昵称格式不正确！");
		}else if($("#nickname-mes").val()==$("#username").val()){
			$("#username-mes").html("昵称不能和用户名相同！");
		}else{
			$("#nickname-mes").html("");
			status2=true;
		}
	});
	
	$("#pwd").blur(function(){
		if($("#pwd_confirm").val()=="" && $("#pwd").val()==""){
			$("#pwd-mes").html("密码不能为空！");
		}else if($("#pwd").val().length>15||$("#pwd").val().match("[a-zA-Z0-9]{8,15}")==null){
			$("#pwd-mes").html("密码格式不正确！");
		}else{
			if($("#pwd").val()!=$("#pwd_confirm").val()){
				$("#pwd-mes").html("两次密码不一样");
			}
			else if($("#pwd").val()==$("#pwd_confirm").val()){
				$("#pwd-mes").html("");
				status3=true;
			}
		}
		
	});
	
	$("#pwd_confirm").blur(function(){
		if($("#pwd_confirm").val()=="" && $("#pwd").val()==""){
			$("#pwd-mes").html("密码不能为空！");
		}else if($("#pwd").val().length>15||$("#pwd").val().match("[a-zA-Z0-9]{8,15}")==null){
			$("#pwd-mes").html("密码格式不正确！");
		}else{
			if($("#pwd").val()!=$("#pwd_confirm").val()){
				$("#pwd-mes").html("两次密码不一样");
			}
			else if($("#pwd").val()==$("#pwd_confirm").val()){
				$("#pwd-mes").html("");
				status3=true;
			}
		}
	});
	
	$("#email").blur(function(){
		if($("#email").val()==""){
			$("#email-mes").html("邮箱不能为空！");
		}else if($("#email").val().match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/)==null){
			$("#email-mes").html("邮箱格式不正确！");
		}else{
			$("#email-mes").html("");
			status4=true;
		}
	});
	
	$("#submitbtn").click(function(){
		if($("#check").prop("checked")){
			if(status1&&status2&&status3&&status4){
				$(".form-horizontal").submit();
			}else{
				alert("请正确填写表单");
				return false;
			}
			
		}else{
			alert("请阅读服务条款并同意！");
		}
	});
	
});