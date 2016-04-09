<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
    <title>后台管理系统</title>
	<meta charset="UTF-8">
   	<link rel="stylesheet" type="text/css" href="../css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../css/style.css" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/bootstrap.js"></script>
    <script type="text/javascript" src="../js/bops/login.js"></script>
    <style type="text/css">
        body {
            padding-top: 40px;
            padding-bottom: 40px;
            background-color: #f5f5f5;
        }

        .form-signin {
            max-width: 500px;
            padding: 19px 29px 29px;
            margin: 0 auto 20px;
            background-color: #fff;
            border: 1px solid #e5e5e5;
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"],
        .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
        }

		.form-signin-heading{
			text-align:center;
		}
		.form-signin tr td,th{
		}
		th{
			text-align:right;
		}
		.input-medium{
			width:80px;
		}
    </style>  
</head>
<body>
<div class="container">

    <form class="form-signin" method="post" action="adminlogin.htm">
    	<table style="width:75%;margin-left:auto;margin-right:auto">
    	<tbody>
    	<tr>
        	<th colspan="2"><h2 class="form-signin-heading">登录系统</h2></th>
        </tr>
        <tr>
        	<th>帐号：</th>
        	<td><input type="text" name="username" class="input-block-level" placeholder="账号" id="username"><span id="usernameerror"></span></td>
        </tr>
        <tr>
        	<th>密码：</th>
        	<td><input type="password" name="password" class="input-block-level" placeholder="密码" id="password"><span id="pwderror"></span></td>
        </tr>
        <tr>
        	<th>验证码：</th>
        	<td><input type="text" name="verify" class="input-medium" placeholder="验证码" id="vali">
        	<img id="imgObj" alt="验证码" src="/code.htm" onclick="changeImg()"/>
        	<span id="valierror"></span>
        	</td>
        </tr>
        <tr>
        	<td colspan="2" style="color:red">${error}</td>
        </tr>
        <tr>
        	<td align="right" colspan="2"><button class="btn btn-large btn-primary" style="margin-right:50px;" id="btn-sub">登录</button>
        </tr>
        </tbody>
        </table>
    </form>

</div>
</body>
</html>