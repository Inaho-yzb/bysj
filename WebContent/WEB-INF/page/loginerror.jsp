<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE>
<html>
<head>
<title>失败</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<style>
.frame{
  width:400px;
height:200px;
margin-left:auto;
margin-right:auto;
background-color:#fff;
border:1px solid #eee;
}
.suc{
 width:400px;;
text-align:center;
height:30px;
line-height:30px;
}
.content{
width:320px;
word-wrap:break-word;
margin-left:auto;
margin-right:auto;
margin-top:50px;
}
.fot{
	width:320px;
	padding-left:37px;
}
</style>
</head>
<body style="background-color:#F7F7F7">
	<div class="frame">
		<div class="suc"><h1>注册失败</h1></div>
		<div class="content">
			<p>注册失败，${errorMes}</p>
		</div>
		<div class="fot">
			<a href="../index.htm">返回首页</a>
		</div>
	</div>
</body>
</html>
