$(function(){
				
	   $(".jqzoom").jqueryzoom({
			xzoom:400,
			yzoom:400,
			offset:10,
			position:"right",
			preload:1,
			lens:1
		});
	   
		$("#spec-list").jdMarquee({
			deriction:"left",
			width:350,
			height:56,
			step:2,
			speed:4,
			delay:10,
			control:true,
			_front:"#spec-right",
			_back:"#spec-left"
		});
		
		$("#spec-list img").bind("mouseover",function(){
			var src=$(this).attr("src");
			$("#spec-n1 img").eq(0).attr({
				src:src.replace("\/n5\/","\/n1\/"),
				jqimg:src.replace("\/n5\/","\/n0\/")
			});
			$(this).css({
				"border":"2px solid #ff6600",
				"padding":"1px"
			});
		}).bind("mouseout",function(){
			$(this).css({
				"border":"1px solid #ccc",
				"padding":"2px"
			});
		});	
		
		$("#addtofav").bind("click",function(){
			$.ajax({
				url:"ajaxaddtofav.htm",
				type:"POST",
				data:{"itemid":$("#itemid").val()},
				success:function(data){
					if(data.errorCode==0){
						hrHuTui.popout({
							type:"success",
							title:"加入收藏",
							content:"添加成功！"
						});
					}else if(data.errorCode==1){
						hrHuTui.popout({
							type:"error",
							title:"失败",
							content:"操作失败"
						});
					}else{
						location.href="login/toLogin.htm?url=item.htm%3Fid="+$("#itemid").val();
					}
					
				},
				error:function(xhr){
					hrHuTui.popout({
						type:"error",
						title:"失败",
						content:"操作失败"
					});
				}
			});
		});
});

