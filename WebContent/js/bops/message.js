function authen(id){
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
					url:"/bops/authenmes.htm",
					type:"POST",
					data:{"id":id,"status":v},
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

function deletemessage(id){
		hrHuTui.popout({
			type:"info",
			title:"删除留言",
			content:"确定删除该留言?",
			onOk:function(callback){
				$.ajax({
					url:"/bops/deletemes.htm",
					type:"POST",
					data:{"mesid":id},
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