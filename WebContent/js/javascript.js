$(function(){
	$(".navbar-custom2 li a").each(function(){
		$this = $(this);
		if($this[0].href==String(window.location)){
			$this.addClass("sele");
		}
	});

	//首先将#back-to-top隐藏
        $("#totop").hide();
        //当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
        $(function () {
            $(window).scroll(function(){
                if ($(window).scrollTop()>100){
                    $("#totop").show();
                }
                else
                {
                    $("#totop").hide();
                }
            });
            //当点击跳转链接后，回到页面顶部位置
            $("#totop").click(function(){
                $('body,html').animate({scrollTop:0},500);
                return false;
            });
        });
});

var appServer = window.location.host;