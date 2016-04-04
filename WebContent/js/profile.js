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

function chageitempage(nxtpage,userid){
	$.ajax({
		url:"/user/ajaxprofilenextitems.htm",
		type:'POST',
		data:{"userid":userid,"page":nxtpage},
		success:function(res){
			if(res.errorCode==0){
				var obj = JSON.parse(res.resultStr);
				var itemList = obj.items;
				var page = obj.itempage;
				
				var str = '';
				for(var i=0;i<itemList.length;i++){
					str +='<div class="panel panel-default put-items"><div class="panel-body"><div class="col-md-2">'+
						'<a href="../item.htm?id='+itemList[i].itemid+'"><img class="itemlist-pic" src="'+itemList[i].itemmainimg+'"></a><div>'+
							'<a href="../item.htm?id='+itemList[i].itemid+'">'+itemList[i].itemname+'</a></div><div>';
					if(itemList[i].sellstatus==0){
						str += '出售中';
					}else if(itemList[i].sellstatus==1){
						str += '被预订';
					}else{
						str += '已售出';
					}
					str +='</div></div><div class="col-md-8">'+
						'<div class="col-md-4">'+itemList[i].discreption+'</div>'+
						'<div class="col-md-4">'+
							'<p>原价：￥'+itemList[i].originprice+'</p>'+
							'<p>出售价：￥'+itemList[i].sellprice+'</p>'+
							'<p>浏览次数：'+itemList[i].viewtime+'</p>'+
							'<p>发布时间：</p>'+
							'<p>'+formatDate(new Date(itemList[i].itemcreatime.time)) +'</p>'+
						'</div><div class="col-md-4">'+
							'<p>交易地点：'+itemList[i].tradeposition+'</p>'+
							'<p>卖家：'+$("#navusername").text()+'</p>'+
							'<p>认证状态:';
					if($(".profile-authen").text()=="您已经认证"){
						str+='已认证';
					}else if($(".profile-authen").text()=="审核中"){
						str +="审核中";
					}else{
						str +='未认证';
					}
					
					str+='</p></div></div><div class="col-md-2"><a href="" class="btn btn-primary">修改</a> <a href="" class="btn btn-danger btndelete">删除</a></div></div></div>';
				}
				$("#item-tab").empty().append(str);
				var pg='';
				if(page.prvPage!=0){
					pg+='<li><a href="javascript:void(0) "onclick="chageitempage('+page.prvPage+','+userid+')">&laquo;</a></li>';
				}
				if(page.pageList.length!=0){
					for(var i=0;i<page.pageList.length;i++){
						if(page.currentPage ==page.pageList[i] ){
							pg+='<li class="active"><a>'+page.pageList[i]+'</a></li>';
						}else{
							pg+='<li><a href="javascript:void(0)" onclick="chageitempage('+page.pageList[i]+','+userid+')">'+page.pageList[i]+'</a></li>';
						}
					}
				}
				
				if(page.nextPage!=0){
					pg+='<li><a href="javascript:void(0)" onclick="chageitempage('+page.nextPage+','+userid+')">&raquo;</a></li>';
				}
				$("#itempag").empty().append(pg);
			}else{
				alert(res.errorMes);
			}
		}
	});
}

function chagefavpage(nxtpage,userid){
	$.ajax({
		url:"/user/ajaxprofilenextfav.htm",
		type:'POST',
		data:{"userid":userid,"page":nxtpage},
		success:function(res){
			if(res.errorCode==0){
				var obj = JSON.parse(res.resultStr);
				var itemList = obj.favItems;
				var page = obj.favpage;
				
				var str = '';
				for(var i=0;i<itemList.length;i++){
					str +='<div class="panel panel-default put-items"><div class="panel-body"><div class="col-md-2">'+
						'<a href="../item.htm?id='+itemList[i].itemid+'"><img class="itemlist-pic" src="'+itemList[i].itemmainimg+'"></a><div>'+
							'<a href="../item.htm?id='+itemList[i].itemid+'">'+itemList[i].itemname+'</a></div><div>';
					if(itemList[i].sellstatus==0){
						str += '出售中';
					}else if(itemList[i].sellstatus==1){
						str += '被预订';
					}else{
						str += '已售出';
					}
					str +='</div></div><div class="col-md-8">'+
						'<div class="col-md-4">'+itemList[i].discreption+'</div>'+
						'<div class="col-md-4">'+
							'<p>原价：￥'+itemList[i].originprice+'</p>'+
							'<p>出售价：￥'+itemList[i].sellprice+'</p>'+
							'<p>浏览次数：'+itemList[i].viewtime+'</p>'+
							'<p>发布时间：</p>'+
							'<p>'+formatDate(new Date(itemList[i].itemcreatime.time)) +'</p>'+
						'</div><div class="col-md-4">'+
							'<p>交易地点：'+itemList[i].tradeposition+'</p>'+
							'<p>卖家：'+$("#navusername").text()+'</p>'+
							'<p>认证状态:';
					if($(".profile-authen").text()=="您已经认证"){
						str+='已认证';
					}else if($(".profile-authen").text()=="审核中"){
						str +="审核中";
					}else{
						str +='未认证';
					}
					
					str+='</p></div></div><div class="col-md-2"> <a href="" class="btn btn-danger btndelete">删除</a></div></div></div>';
				}
				$("#fav-tab").empty().append(str);
				var pg='';
				if(page.prvPage!=0){
					pg+='<li><a href="javascript:void(0) "onclick="chagefavpage('+page.prvPage+','+userid+')">&laquo;</a></li>';
				}
				if(page.pageList.length!=0){
					for(var i=0;i<page.pageList.length;i++){
						if(page.currentPage ==page.pageList[i] ){
							pg+='<li class="active"><a>'+page.pageList[i]+'</a></li>';
						}else{
							pg+='<li><a href="javascript:void(0)" onclick="chagefavpage('+page.pageList[i]+','+userid+')">'+page.pageList[i]+'</a></li>';
						}
					}
				}
				
				if(page.nextPage!=0){
					pg+='<li><a href="javascript:void(0)" onclick="chagefavpage('+page.nextPage+','+userid+')">&raquo;</a></li>';
				}
				$("#favpag").empty().append(pg);
			}else{
				alert(res.errorMes);
			}
		}
	});
}

function chagemespage(nxtpage,userid){
	$.ajax({
		url:"/user/ajaxprofilenextmes.htm",
		type:'POST',
		data:{"userid":userid,"page":nxtpage},
		success:function(res){
			if(res.errorCode==0){
				var obj = JSON.parse(res.resultStr);
				var mesList = obj.messages;
				var page = obj.mespage;
				
				var str = '';
				for(var i=0;i<mesList.length;i++){
					str +='<div class="panel panel-default profile-message"><div class="panel-body">'+
						'<div class="col-md-2">商品：'+mesList[i].mes_itemname+'<img class="itemlist-pic" src="'+mesList[i].mes_itemmainimg+'"></div>'+
						'<div class="col-md-8">'+
						'<h4>'+mesList[i].mes_levusername+':</h4>'+
						'<p>'+mesList[i].mes_content+'</p></div>'+
					'<div class="col-md-2 profile-message-opr"><div class="badge bkcl-red">未读</div>'+
						'<a type="button"  onclick="checkMes('+mesList[i].mes_id+','+mesList[i].mes_itemid+')" class="btn btn-info profile-message-checkbtn">查看</a></div></div></div>' 
				}
				$("#mes-tab").empty().append(str);
				
				
				var pg='';
				if(page.prvPage!=0){
					pg+='<li><a href="javascript:void(0) "onclick="chagemespage('+page.prvPage+','+userid+')">&laquo;</a></li>';
				}
				if(page.pageList.length!=0){
					for(var i=0;i<page.pageList.length;i++){
						if(page.currentPage ==page.pageList[i] ){
							pg+='<li class="active"><a>'+page.pageList[i]+'</a></li>';
						}else{
							pg+='<li><a href="javascript:void(0)" onclick="chagemespage('+page.pageList[i]+','+userid+')">'+page.pageList[i]+'</a></li>';
						}
					}
				}
				
				if(page.nextPage!=0){
					pg+='<li><a href="javascript:void(0)" onclick="chagemespage('+page.nextPage+','+userid+')">&raquo;</a></li>';
				}
				$("#mespag").empty().append(pg);
			}else{
				alert(res.errorMes);
			}
		}
	});
}

function   formatDate(now)   {     
    var   year=now.getFullYear();     
    var   month=now.getMonth()+1;     
    var   date=now.getDate();     
    var   hour=now.getHours();     
    var   minute=now.getMinutes();     
    var   second=now.getSeconds();     
    return   year+"-"+month+"-"+date+"   "+hour+":"+minute+":"+second;     
} 