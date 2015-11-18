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