$(function(){
	$(".btndelete").click(function(){
		$.confirm({
		    title: '确认删除？',
		    content: '确认删除该商品？',
		    confirm: function(){
		        alert('已经删除');
		    },
		    cancel: function(){
		        alert('未删除')
		    }
		});
	});
	
});

function checkMes(id,itemid){
	$.ajax({
		url:"/user/ajaxCheckMes.htm",
		dataType:"json",
		type:"POST",
		data:{"id":id},
		success:function(res){
			result = res;
			if(res.errorCode==0){
				location.href ="/item.htm?id="+itemid;
			}else if(res.errorCode==1){
				alert("请求错误！");
			}
		}
	});
}
