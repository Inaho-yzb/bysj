<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<head>
	<title>创建账户</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>	
	<script type="text/javascript" src="../js/registered.js"></script>
</head>
<body class="templatemo-bg-gray">
	<h1 class="margin-bottom-15">注册新用户</h1>
	<div class="container">
		<div class="col-md-12">			
			<form class="form-horizontal templatemo-create-account templatemo-container" role="form" action="#" method="post">
				<div class="form-inner">
					<div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">用户名</label>
			            <input type="text" class="form-control" id="username" placeholder="20个字以内，不能含有符号，可以包含“_” “.”">
			            <label class="color-red" id="username-mes"></label>		            		            		            
			          </div>  
			                  
			        </div>
			        
			        <div class="form-group">
			        	<div class="col-md-12">		          	
			            <label for="nickname" class="control-label">昵称</label>
			            <input type="text" class="form-control" id="nickname" placeholder="20个字以内">		
			            <label class="color-red" id="nickname-mes"></label>	            		            		            
			          </div>     
			        </div>
			        
			        <div class="form-group">
			          <div class="col-md-6">
			            <label for="password" class="control-label">密码</label>
			            <input type="password" class="form-control" id="pwd" placeholder="8-15个字符，只能包含数字和英文">
			            <label class="color-red" id="pwd-mes"></label>	
			          </div>
			          <div class="col-md-6">
			            <label for="password" class="control-label">重复密码</label>
			            <input type="password" class="form-control" id="pwd_confirm" placeholder="8-15个字符，只能包含数字和英文">
			          </div>
			          
			        </div>
			        
			        <div class="form-group">
			          <div class="col-md-12">		          	
			            <label for="username" class="control-label">Email</label>
			            <input type="email" class="form-control" id="email" placeholder="abcd@email.com">	
			            <label class="color-red" id="email-mes"></label>		            		            		            
			          </div>              
			        </div>			
			        <div class="form-group">
			          
			          <div class="col-md-6 templatemo-radio-group">
			          	<label class="control-label">性别：</label>
			          	<label class="radio-inline">
		          			<input type="radio" name="gender" id="genderm" value="option1" checked="true"> 男
		          		</label>
		          		<label class="radio-inline">
		          			<input type="radio" name="gender" id="genderfm" value="option2"> 女
		          		</label>
			          </div>             
			        </div>
			        
			        <div class="form-group">
			          <div class="col-md-12">
			            <label><input type="checkbox" id="check">我已经阅读并同意<a href="javascript:;" data-toggle="modal" data-target="#templatemo_modal">《服务条款》</a> </label>
			          </div>
			        </div>
			        <div class="form-group">
			          <div class="col-md-12">
			            <input value="创建用户" class="btn btn-info" id="submitbtn">
			            <a href="toLogin.htm" class="pull-right">前往登录</a><br/>
			            <a href="../index.htm" class="pull-right">返回首页</a>
			          </div>
			        </div>	
				</div>				    	
		      </form>		      
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="templatemo_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	        <h4 class="modal-title" id="myModalLabel">《服务条款》</h4>
	      </div>
	      
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
</body>
</html>