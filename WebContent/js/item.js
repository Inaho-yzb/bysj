$(function(){
				
		
		$("#addtofav").bind("click",function(){
			$.ajax({
				url:"/ajaxaddtofav.htm",
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
				content:"<option value='0'>虚假物品</option><option value='1'>违法物品</option><option value='2'>广告、诈骗、淫秽色情、反动等内容</option><option value='3'>价格与物品不相符</option>" ,
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

function toMesPage(nxtPage,itemid){
	$.ajax({
		url:"ajaxitemnextmes.htm",
		type:'POST',
		data:{"itemid":itemid,"nxtPage":nxtPage},
		success:function(res){
			if(res.errorCode==0){
				var obj = JSON.parse(res.resultStr);
				var mesList = obj.mesList;
				var page = obj.page;
				$("#meslist").empty();
				for(var i=0;i<mesList.length;i++){
					var str = '<div class="comment-detail"><img class="comment-hdpic img-circle" src="'+mesList[i].mes_levuserheadpic+'"><div class="comment-user"><span>'+mesList[i].mes_levusername+'</span></div><div class="comment-content">'+mesList[i].mes_content+'</div></div>';
					$("#meslist").append(str);
				}
				var pg='';
				if(page.prvPage!=0){
					pg+='<li><a href="javascript:void(0) "onclick="toMesPage('+page.prvPage+','+itemid+')">&laquo;</a></li>';
				}
				if(page.pageList.length!=0){
					for(var i=0;i<page.pageList.length;i++){
						if(page.currentPage ==page.pageList[i] ){
							pg+='<li class="active"><a>'+page.pageList[i]+'</a></li>';
						}else{
							pg+='<li><a href="javascript:void(0)" onclick="toMesPage('+page.pageList[i]+','+itemid+')">'+page.pageList[i]+'</a></li>';
						}
					}
				}
				
				if(page.nextPage!=0){
					pg+='<li><a href="javascript:void(0)" onclick="toMesPage('+page.nextPage+','+itemid+')">&raquo;</a></li>';
				}
				$(".pagination").empty().append(pg);
			}else{
				alert(res.errorMes);
			}
		}
	});
}

