$(function(){
	var status1=false;
	var status2=false;
	var status3=false;
	var status4=false;
	var status5=false;
	$("#username").blur(function(){
		if($("#username").val()==""){
			$("#username-mes").html("用户名不能为空！");
		}else{
			$("#username-mes").html("");
			status1=true;
		}
	});
	
	$("#nickname").blur(function(){
		if($("#nickname").val()==""){
			$("#nickname-mes").html("昵称不能为空！");
		}else{
			$("#nickname-mes").html("");
			status2=true;
		}
	});
	
	$("#pwd").blur(function(){
		if($("#pwd_confirm").val()=="" && $("#pwd").val()==""){
			$("#pwd-mes").html("密码不能为空！");
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
		}else{
			$("#email-mes").html("");
			status4=true;
		}
	});
	
	$("#submitbtn").click(function(){
		if($("#check").prop("checked")){
			if(status1&&status2&&status3&&status4){
				$(this).submit();
			}else{
				alert("请正确填写表单");
				return false;
			}
			
		}else{
			alert("请阅读服务条款并同意！");
		}
	});
	
});