$(document).ready(function(){
	// 0.4代表遮罩的透明度
	$('.fanner div').css('opacity',0.2);
	$('.fanner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:630},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	// 0.4代表遮罩的透明度
	$('.fbnner div').css('opacity',0.2);
	$('.fbnner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:630},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	// 0.4代表遮罩的透明度
	$('.fcnner div').css('opacity',0.2);
	$('.fcnner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:630},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	// 0.4代表遮罩的透明度
	$('.fdnner div').css('opacity',0.2);
	$('.fdnner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:630},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	// 0.4代表遮罩的透明度
	$('.banner div').css('opacity',0.2);
	$('.banner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:630},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	// 0.4代表遮罩的透明度
	$('.manner div').css('opacity',0.2);
	$('.manner').hover(function(){
		var el = $(this);
		// 先淡出阴影，后淡入文字
		el.find('div').stop().animate({width:950,height:680},'slow',function(){
			el.find('strong,b').fadeIn('fast');
		});
	},function(){
		var el = $(this);
		// 隐藏文字
		el.find('b').stop(true,true).hide();
		el.find('strong').stop(true,true).hide();
		// 去掉遮罩
		el.find('div').stop().animate({width:60,height:60},'fast');
	}).click(function(){
		// 点击图片时打开链接
		window.open($(this).find('a').attr('href'));
	});
	//置顶
	$("#back-to-top").hide();
	$(function () {
		$(window).scroll(function(){
			if ($(window).scrollTop()>100){
				$("#back-to-top").fadeIn(500);
			}else{
				$("#back-to-top").fadeOut(500);
			}
		});
		$("#back-to-top").click(function(){
			$('body,html').animate({scrollTop:0},100);
			return false;
		});
	});
	
});

/* header */
window.onscroll=function(){
    var box= document.getElementById("box");
    var t = document.documentElement.scrollTop || document.body.scrollTop;
    box.style.top=t+"px";
}
$(function () {
    var $menu = $(".menu"), $li_3 = $menu.find('li.li_3'), $li_3_content = $li_3.find('.li_3_content');
	var count;
    $li_3.hover(function () {
    	var $this = $(this);
    	var dang = $li_3.index($this);
    	count = dang-4;
        $li_3_content.eq(count).stop(true, true).fadeIn(0);
    }, function () {
        $li_3_content.eq(count).fadeOut(500, function () {
            $li_3_content.css("display", "none");
        });
    });
});

/* gyrr */
function TabMove(id,index,count){
	var defaultCss="kjy";
	var SelectCss="kjy_a";
	for(var n=1;n<=count;n++)
	{
		document.getElementById("Button"+id+n).className=defaultCss;
		document.getElementById("ContentBox"+id+n).style.display='none';
	}
	document.getElementById("Button"+id+index).className=SelectCss;
	document.getElementById("ContentBox"+id+index).style.display='';
}

function TabMoveWm(id,index,count){
	var defaultCss="kjy";
	var SelectCss="kjy_a";
	for(var n=1;n<=count;n++)
	{
		document.getElementById("Button"+id+n).className=defaultCss;
		document.getElementById("ContentBox"+id+n).style.display='none';
	}
	document.getElementById("Button"+id+index).className=SelectCss;
	document.getElementById("ContentBox"+id+index).style.display='';
	
	if(index==1){
		var datu = '<img src="../images/wm/gsjj/show_gsjj.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>公司简介</a></i><em><a>我们</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
	if(index==2){
		var datu = '<img src="../images/wm/qywh/show_qywh.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>企业文化</a></i><em><a>我们</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
	if(index==3){
		var datu = '<img src="../images/wm/fzlc/show_fzlc.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>发展历程</a></i><em><a>我们</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
}

function TabMovePP(id,index,count){
	var defaultCss="kjy";
	var SelectCss="kjy_a";
	for(var n=1;n<=count;n++)
	{
		document.getElementById("Button"+id+n).className=defaultCss;
		document.getElementById("ContentBox"+id+n).style.display='none';
	}
	document.getElementById("Button"+id+index).className=SelectCss;
	document.getElementById("ContentBox"+id+index).style.display='';
	
	if(index==1){
		var datu = '<img src="../images/pp/ppgs/show_ppgs.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>品牌故事</a></i><em><a>品牌</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
	if(index==2){
		var datu = '<img src="../images/pp/ppfg/show_ppfg.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>品牌风格</a></i><em><a>品牌</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
	if(index==3){
		var datu = '<img src="../images/pp/ppln/show_ppln.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>品牌理念</a></i><em><a>品牌</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
	if(index==4){
		var datu = '<img src="../images/pp/ppzx/show_ppzx.jpg" />';
		document.getElementById("showDT").innerHTML = datu;
		var conent = '<i><a>品牌资讯</a></i><em><a>品牌</a><a>></a></em><em><a>首页</a><a>></a></em>';
		document.getElementById("dahangcon").innerHTML = conent;
	}
}

//分享需要变量
var _title,_source,_sourceUrl,_pic,_showcount,_desc,_summary,_site,
_width = 600,
_height = 600,
_top = (screen.height-_height)/2,
_left = (screen.width-_width)/2,
/*_url = 'www.baidu.com',*/
_url = document.location,
_pic = '';
//分享到新浪微博
function shareToSinaWB(event){
    event.preventDefault();
    var _shareUrl = 'http://v.t.sina.com.cn/share/share.php?&appkey=895033136';     //真实的appkey，必选参数
    _shareUrl += '&url='+ encodeURIComponent(_url||document.location);     //参数url设置分享的内容链接|默认当前页location，可选参数
    _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //参数title设置分享的标题|默认当前页标题，可选参数
    _shareUrl += '&source=' + encodeURIComponent(_source||'');
    _shareUrl += '&sourceUrl=' + encodeURIComponent(_sourceUrl||'');
    _shareUrl += '&content=' + 'utf-8';   //参数content设置页面编码gb2312|utf-8，可选参数
    _shareUrl += '&pic=' + encodeURIComponent(_pic||'');  //参数pic设置图片链接|默认为空，可选参数
    window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',top='+_top+',left='+_left+',toolbar=no,menubar=no,scrollbars=no, resizable=1,location=no,status=0');
}
//分享到QQ空间
function shareToQzone(event){
    event.preventDefault();
    var _shareUrl = 'http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?';
    _shareUrl += 'url=' + encodeURIComponent(_url||document.location);   //参数url设置分享的内容链接|默认当前页location
    _shareUrl += '&showcount=' + _showcount||0;      //参数showcount是否显示分享总数,显示：'1'，不显示：'0'，默认不显示
    _shareUrl += '&desc=' + encodeURIComponent(_desc||'分享的描述');    //参数desc设置分享的描述，可选参数
    _shareUrl += '&summary=' + encodeURIComponent(_summary||'分享摘要');    //参数summary设置分享摘要，可选参数
    _shareUrl += '&title=' + encodeURIComponent(_title||document.title);    //参数title设置分享标题，可选参数
    _shareUrl += '&site=' + encodeURIComponent(_site||'');   //参数site设置分享来源，可选参数
    _shareUrl += '&pics=' + encodeURIComponent(_pic||'');   //参数pics设置分享图片的路径，多张图片以＂|＂隔开，可选参数
    window.open(_shareUrl,'_blank','width='+_width+',height='+_height+',top='+_top+',left='+_left+',toolbar=no,menubar=no,scrollbars=no,resizable=1,location=no,status=0');
}


