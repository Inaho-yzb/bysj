 $(function(){
	// 初始化轮播
						  
	 $("#myCarousel").carousel('cycle');
	
	 $("#releasebtn").bind("click",function(){
		 $.ajax({
			 url:"/login/ajaxchecklogin.htm",
			 type:"get",
			 success:function(res){
				 if(res.errorCode==0){
					 location.href ="/user/releasepro.htm";
				 }else{
					 hrHuTui.popout({
						 type:"info",
						 title:"请登录！",
						 content:"请先登录！",
						 onOk:function(callback){
							 location.href ="/login/toLogin.htm?url=user%2Freleasepro.htm"; 
						 }
					 });
				 }
			 },
			 error:function(xhr){
				 hrHuTui.popout({
					 type:"error",
					 title:"错误！",
					 content:"嗯··服务器好像睡着了，稍后再试吧！"
				 });
			 }
		 });
	 });
});
