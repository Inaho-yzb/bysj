$(function(){
	
});

function deleteitem(itemid){
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