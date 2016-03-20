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
							content:"添加成功！",
							onOk:function(callback){
								$(".addfav").empty().append("<span>已在收藏中</span>");								
							}
						});
					}else if(data.errorCode==1){
						hrHuTui.popout({
							type:"error",
							title:"失败",
							content:"操作失败"
						});
					}else if(data.errorCode==3){
						hrHuTui.popout({
							type:"info",
							title:"提示",
							content:"该物品已经在你的收藏中"
						});
					}
					else{
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
		
		$("#reportitem").bind("click",function(){
			if($("#navusername").text()==""){
				location.href="login/toLogin.htm?url=item.htm%3Fid="+$("#itemid").val();
			}else{
			hrHuTui.popout({
				type:"select",
				title:"请选择举报理由",
				nttext:["请选择举报理由："],
				content:"<option value='1'>虚假物品</option><option value='2'>违法物品</option><option value='3'>广告、诈骗、淫秽色情、反动等内容</option><option value='4'>价格与物品不相符</option>" ,
				onOk:function(v,callback){
					$.ajax({
						url:"ajaxreportitem.htm",
						type:"POST",
						data:{"itemid":$("#itemid").val(),"reasonid":v},
						dataType:"json",
						success:function(data){
							if(data.errorCode==0){
								alert("举报成功！");
								$(".item-report").empty().append("<span>您已经举报此物品</span>");
							}else if(data.errorCode==1){
								hrHuTui.popout({
									type:"error",
									title:"失败",
									content:"操作失败！"
								});
							}else if(data.errorCode==3){
								hrHuTui.popout({
									type:"info",
									title:"提示",
									content:"该物品已经被您举报！"
								});
							}else{
								location.href="login/toLogin.htm?url=item.htm%3Fid="+$("#itemid").val();
							}
							
						},error:function(xhr){
							hrHuTui.popout({
								type:"error",
								title:"失败",
								content:"操作失败"
							});
						}
					});
				}
			});
			}
		});
		
		$(".postBtn").bind("click",function(){
			if($(".Input_text").val()==""){
				hrHuTui.popout({
					type:"info",
					title:"提示",
					content:"请输入评论！"
				});
			}else if($(".Input_text").val().length>256){
				hrHuTui.popout({
					type:"info",
					title:"提示",
					content:"评论在256个字以内！"
				});
			}else{
				$.ajax({
					url:"addMessage.htm",
					type:"POST",
					dataType:"json",
					data:{"itemid":$("#itemid").val(),"content":$(".Input_text").val()},
					success:function(data){
						if(data.errorCode==0){
							hrHuTui.popout({
								type:"success",
								title:"成功",
								content:"评论提交成功！请等待审核！"
							});
							$(".Input_text").val("");
						}else if(data.errorCode==1){
							hrHuTui.popout({
								type:"error",
								title:"失败",
								content:"操作失败！"
							});
						}else if(data.errorCode==3){
							hrHuTui.popout({
								type:"error",
								title:"失败",
								content:"数据非法！"
							});
						}else if(data.errorCode==2){
							location.href="login/toLogin.htm?url=item.htm%3Fid="+$("#itemid").val();
						}
					},
					error:function(xhr){
						hrHuTui.popout({
							type:"error",
							title:"失败",
							content:"操作失败！"
						});
					}
				});
			}
		});
});

