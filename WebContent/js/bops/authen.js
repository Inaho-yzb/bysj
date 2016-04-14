function checkauthenimg(){
	var ss = $(event.target).parent().siblings().get(10);
	var img = ss;
	hrHuTui.popout({
		type:"text",
		width:600,
		height:600,
		title:"认证图片",
		content:img.innerHTML
	});
}

function deleteAuthen(id){
	hrHuTui.popout({
		type:"info",
		title:"删除物品",
		content:"确定删除该物品?",
		onOk:function(callback){
			$.ajax({
				url:"/bops/deleteitem.htm",
				type:"POST",
				data:{"itemid":itemid},
				success:function(res){
					if(res.errorCode==0){
						alert("删除成功！");
						location.reload();
						return true;
					}else{
						alert(res.errorMes);
						return false;
					}
				},
				error:function(xhr){
					alert("服务器连接失败！");
					return true;
				}
			});
		}
	});
}

function auditUser(id,userid){
	hrHuTui.popout({
		type:"select",
		title:"审核",
		nttext:['请选择审核结果：'],
		content:"<option value='''>请选择</option><option value='1'>审核通过</option><option value='2'>审核不通过</option>",
		onOk:function(v,callback){
			if(v==""){
				alert("请选择审核结果！");
				return false;
			}else{
				$.ajax({
					url:"/bops/authenuser.htm",
					type:"POST",
					data:{"id":id,"status":v,"userid":userid},
					success:function(res){
						if(res.errorCode==0){
							alert("审核成功！");
							location.reload();
							return true;
						}else{
							alert(res.errorMes);
							return false;
						}
					}
				});
			}
		}
	});
}