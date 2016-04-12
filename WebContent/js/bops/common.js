$(function(){
	$(".btn-ok").click(function(){
		$("#_cur_page").val("1");
		$("#scform").submit();
	});
	
	$("#_pre_page").click(function(){
		$("#_cur_page").val($("#prepage").val());
		$("#scform").submit();
	});
	
	$("#_page_no").click(function(){
		$("#_cur_page").val($("#_page_no").text());
		$("#scform").submit();
	});
	
	$("#_next_page").click(function(){
		$("#_cur_page").val($("#nextpage").val());
		$("#scform").submit();
	});
	
	$("#_go").click(function(){
		if($("#_go_page").val()>$("#_total_page").val()||$("#_go_page").val()==""){
			alert("请输入正确的页数！");
		}else{
			$("#_cur_page").val($("#_go_page").val());
			$("#scform").submit();
		}
	});
	
	$(".btn-reset").click(function(){
		$(".searchForm").find("input").each(function(e){
			this.value="";
		});
		$(".searchForm").find("select").each(function(e){
			this.value="";
		});
	});
});