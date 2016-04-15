function editclass(id){
	var t = $(event.target).parent().siblings()[2].innerText;
	$.ajax({
		url:"/bops/findallfc.htm",
		aysnc:"false",
		type:"GET",
		success:function(res){
			if(res.errorCode==0){
				var claz = JSON.parse(res.resultStr);
				var str = "<option value=''>请选择</option><option value='1'>无</option>";
				if(t!=""){
				for(var i=0;i<claz.length;i++){
					str+="<option value='"+claz[i].itemclass_id+"'>"+claz[i].itemclass_name+"</option>";
				}
				hrHuTui.popout({
					type:"selandinput",
					title:"修改物品类别",
					nttext:["名称：","父类："],
					content:str,
					onOk:function(callback){
						var ipt = $("#popinput").val();
						var sele = $("#pop-select").val();
						if(ipt!="" && sele!=""){
							$.ajax({
								url:"/bops/editclass.htm",
								type:"POST",
								data:{"classname":ipt,"fid":sele,"id":id},
								success:function(res){
									if(res.errorCode==0){
										alert("修改成功！");
										location.reload();
										return true;
									}else{
										alert("失败！");
										return false;
									}
								},
								error:function(xhr){
									alert("服务器连接失败！");
								}
							});
						}else{
							alert("请填写完整数据！");
							return false;
						}
					}
				});
				}else{
					hrHuTui.popout({
						type:"input",
						title:"修改物品类别",
						nttext:["名称："],
						onOk:function(v,callback){
							if(v!=""){
								$.ajax({
									url:"/bops/editclass.htm",
									type:"POST",
									data:{"classname":ipt,"fid":0,"id":id},
									success:function(res){
										if(res.errorCode==0){
											alert("修改成功！");
											location.reload();
											return true;
										}else{
											alert("失败！");
											return false;
										}
									},
									error:function(xhr){
										alert("服务器连接失败！");
									}
								});
							}else{
								alert("请填写数据！");
								return false;
							}
						}
					});
				}
				
			}
		}
	});
	

}
