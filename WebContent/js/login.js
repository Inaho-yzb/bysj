$(function(){
  var COOKIE_NAME = 'username';
   if(COOKIE_NAME){ //如果这个cookie变量确实存在；
      //把cookie变量的值设置为username的值；
     $("#username").val($.cookie(COOKIE_NAME ));
   }
    $("#check").click(function(){
     $.cookie(COOKIE_NAME, ($("#username").val()) , { path: '/', expires: 30 });
});  //$.cook()中第一个参数就是我们定义的变量名称；第一个是我们要获取的值；第三个：path：'/'（路径，一般不用改），erxpires：（要保存的时间；案例中的10是10天）
})