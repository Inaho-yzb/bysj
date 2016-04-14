function deleteuser(id){
	hrHuTui.popout({
		type:"info",
		title:"删除用户",
		content:"确定删除该用户?",
		onOk:function(callback){
			$.ajax({
				url:"/bops/deleteuser.htm",
				type:"POST",
				data:{"userid":id},
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