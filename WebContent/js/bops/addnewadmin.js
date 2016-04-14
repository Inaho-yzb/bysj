$(function(){
	$("#loginname").blur(function(){
		var loginname = $(this).val();
		if(loginname!=""){
			$.ajax({
				url:"/checkuser.htm",
				type:"POST",
				data:{"username":loginname},
				success:function(res){
					if(res.errorCode!=0){
						$("#nameerror").text("");
					}else{
						$("#nameerror").text("已存在该用户名！");
					}
				},
				error:function(xhr){
					alert("服务器连接失败！");
				}
			});
		}else{
			$("#nameerror").text("请输入用户名！")
		}
		
	});
	
	$("#password").blur(function(){
		var p1 = $("#password").val();
		var p2 = $("#repassword").val();
		if(p1==""){
			$("#pwderror").text("请输入密码！");
		}else{
			if(p2!="" && p1!=p2){
				$("#pwderror").text("两次密码不同!");
			}else if(p2!="" && p1==p2){
				$("#pwderror").text("");
			}
		}
	});
	
	$("#repassword").blur(function(){
		var p1 = $("#password").val();
		var p2 = $("#repassword").val();
		if(p2==""){
			$("#pwderror").text("请重复密码！");
		}else{
			if(p1!="" && p1!=p2){
				$("#pwderror").text("两次密码不同!");
			}else if(p2!="" && p1==p2){
				$("#pwderror").text("");
			}
		}
	});
	
	$(".btn-ok").click(function(){
		if($("#nameerror").text()=="" && $("#pwderror").text()==""){
			$.ajax({
				url:"/bops/addnewadmin.htm",
				type:"POST",
				data:{"username":$("#loginname").val(),"password":$("#password").val()},
				success:function(res){
					if(res.errorCode==0){
						hrHuTui.popout({type:"success",title:"创建成功",content:"管理员创建成功！"});
					}else{
						hrHuTui.popout({type:"error",title:"创建失败",content:"创建失败！"});
					}
				},
				error:function(xhr){
					alert("服务器连接失败！");
				}
			});
		}
		
	});
	
});
