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
							'<p>卖家：'+$(".nickname").text()+'</p>'+
							'<p>认证状态:';
						str+=$("#authenstatus").text().trim();
					
					str+='</p></div></div><div class="col-md-2"><a href="javascript:void(0)" onclick="editItem('+itemList[i].itemid+')" class="btn btn-primary">修改</a> <a href="" class="btn btn-danger btndelete">删除</a></div></div></div>';
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
							'<p>卖家：'+itemList[i].nickname+'</p>'+
							'<p>认证状态:';
					str+=$("#authenstatus").text().trim();
					
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

function editItem(itemid){
	$.ajax({
		url:"/user/getitemdetail.htm",
		type:"POST",
		data:{"itemid":itemid},
		success:function(res){
			if(res.errorCode==0){
				var item = JSON.parse(res.resultStr);
				var str;
				str='<table style="margin-left:auto;margin-right:auto;margin-top:30px;"><tbody>'+
				'<tr><th>商品名：</th><td><input id="itemname" name="itemname" class="form-control" placeholder="请输入商品名" value="'+item.itemname+'"></td></tr>'+
				'<tr><th>售价：</th><td><div class="input-group"><input id="itemsellprice" value="'+item.sellprice+'" name="itemsellprice" class="form-control" placeholder="请输入出售价格" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')"> <span class="input-group-addon">元</span></div></td>'+
			'</tr><tr><th>原价：</th><td><div class="input-group"><input id="itemoriginprice" value="'+item.originprice+'" name="itemoriginprice" class="form-control" placeholder="请输入原价" onkeyup="value=value.replace(/[^\\d\\.]/g,\'\')"> <span class="input-group-addon">元</span></div></td>';
				if(item.bargain==1){
					str += '</tr><tr><th>接受议价：</th><td><input id="itembargain-y" name="itembargain" type="radio" checked="checked" value="0">是<input id="itembargain-n" name="itembargain" type="radio" value="1">否</td></tr>';
				}else{
					str += '</tr><tr><th>接受议价：</th><td><input id="itembargain-y" name="itembargain" type="radio"  value="0">是<input id="itembargain-n"  checked="checked" name="itembargain" type="radio" value="1">否</td></tr>'
				}
			
			str += '<tr><th>成色：</th><td><div class="input-group"><select class="form-control" id="itemuse">';
			for(var i=3;i<=10;i++){
				if(item.color==i){
					if(i!=10){
						str += '<option value="'+i+'" selected="true">'+i+'</option>';
					}else{
						str += '<option value="'+i+'" selected="true">全新</option>';
					}
				}else{
					if(i!=10){
						str += '<option value="'+i+'">'+i+'</option>';
					}else{
						str += '<option value="'+i+'">全新</option>';
					}
				}
			}
				str += '</select><span class="input-group-addon">成新</span></div></td></tr>'+
			'<tr><th>交易地点：</th><td><input id="itemtradeposition" value="'+item.tradeposition+'" name="itemtradeposition" class="form-control" placeholder="请输入交易地点"></td></tr>'+
			'<tr><th>物品描述：</th><td><textarea placeholder="请输入物品描述" id="itemdescription" style="width:300px;height:150px"></textarea></td></tr></tbody></table>';
				$s = $(str);
				$s[0].getElementsByTagName("textarea")[0].innerHTML=item.discreption;
				hrHuTui.popout({
					width:600,
					height:500,
					type:"text",
					title:"修改物品详情",
					content:$s,
					onOk:function(callback){
						if(checkDetail()){
							$.ajax({
								url:"/user/ajaxupdateitem.htm",
								type:"POST",
								data:{"itemid":itemid,"itemname":$("#itemname").val(),"itemsellprice":$("#itemsellprice").val(),"itemoriginprice":$("#itemoriginprice").val(),"bargain":$("input[type='radio'][checked='checked']").val(),"color":$("#itemuse").val(),"itemtradeposition":$("#itemtradeposition").val(),"itemdescription":$("#itemdescription").val()},
								success:function(res){
									if(res.errorCode==0){
										alert("更新成功！");
										location.reload();
										return true;
									}else{
										alert("出错了！");
										return false;
									}
								}
							});
						}else{
							return false;
						}
					}
				});
			}else{
				alert(res.errorMes);
			}
		},
		error:function(xhr){
			
		}
	});
}

function checkDetail(){
	if($("#itemname").val()==""){
		alert('物品名不能为空！');
		return false;
	}
	if($("#itemsellprice").val()==""){
		alert('出售价格不能为空！');
		return false;
	}
	if($("#itemoriginprice").val()==""){
		alert('原价不能为空！');
		return false;
	}
	if($("#itemtradeposition").val()==""){
		alert('交易地点不能为空！');
		return false;
	}
	
	return true;
}

function deletemyitems(itemid){
	hrHuTui.popout({
		type:"info",
		title:"确认",
		content:"确定删除吗？不可恢复！",
		onOk:function(callback){
			$.ajax({
				url:"/user/deletemyitem.htm",
				type:"POST",
				data:{"itemid":itemid},
				success:function(res){
					if(res.errorCode==0){
						alert("操作成功！");
						location.reload();
						return ture;
					}else{
						alert("操作失败！");
						return false;
					}
				},
				error:function(xhr){
					alert("服务器连接失败！");
					return false;
				}
			});
		}
	});
}

function deletefav(itemid){
	hrHuTui.popout({
		type:"info",
		title:"确认",
		content:"确定删除吗？",
		onOk:function(callback){
			$.ajax({
				url:"/user/deletefav.htm",
				type:"POST",
				data:{"itemid":itemid},
				success:function(res){
					if(res.errorCode==0){
						alert("操作成功！");
						location.reload();
						return ture;
					}else{
						alert("操作失败！");
						return false;
					}
				},
				error:function(xhr){
					alert("服务器连接失败！");
					return false;
				}
			});
		}
	});
}

function changeStatus(itemid,status){
	var str;
	if(status==0){
		str = '出售中';
	}else if(status==1){
		str = '被预定';
	}
	
	hrHuTui.popout({
		type:"select",
		title:"更改状态",
		nttext:['当前状态：'+str],
		content:"<option value='0'>出售中</option><option value='1'>被预定</option><option value='2'>已售出</option>",
		onOk:function(v,callback){
			if(confirm("确定更改？")){
				$.ajax({
					url:"/user/changeItemstatus.htm",
					type:"post",
					data:{"itemid":itemid,"status":v},
					success:function(res){
						if(res.errorCode==0){
							alert("更改成功！");
							location.reload();
							return true;
						}else{
							alert("操作失败！");
							return false;
						}
					},
					error:function(xhr){
						alert("服务器连接失败，请稍后再试！");
						return true;
					}
				});
			}else{
				return false;
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