function checkTel(tel){
   var mobile = /^1[3|5|7|8]\d{9}$/,phone = /^0\d{2,3}-?\d{7,8}$/;
   return mobile.test(tel) || phone.test(tel);
}
function doSubmitForm(){
	var tagName = new RegExp('名称');
	var jyName = $("#jy_name").val();
	if(tagName.test(jyName)){
		alert("请输入名称！");
		return false;
	}
	var tagPhone = new RegExp('电话');
	var jyPhone = $("#jy_phone").val();
	if(tagPhone.test(jyPhone)){
		alert("请输入电话！");
		return false;
	}
	if(!checkTel(jyPhone)){
		alert("请输入有效电话号码！");
		return false;
	}
	var tagMessage = new RegExp('留言');
	var jyMessage = $("#jy_message").val();
	if(tagMessage.test(jyMessage)){
		$("#jy_message").val("");
	}
	var targetUrl = $("#leave_form").attr("action");
	var data = $("#leave_form").serialize();
	$.ajax({
	      type: 'post',
	      dataType: 'json',
	      url: targetUrl,
	      data: data,
	      async: true,
	      success: function(data){
	    	  for(var i=0; i < data.length; i++){
	    		  if(data[i].status){
	    		  	alert("感谢留言！");
	    		  }else{
	    			alert("服务器繁忙... 请重新提交留言！");
	    		  }
	    	  }
	      },
	      error: function(errorMsg) {
	    	  alert("请求数据失败，可能是服务器开小差了");
	      }
	  });
}

function doSubmitJoin(){
	var tagName = new RegExp('名称');
	var amName = $("#am_name").val();
	if(tagName.test(amName)){
		alert("请输入名称！");
		return false;
	}
	var tagPhone = new RegExp('电话');
	var amPhone = $("#am_phone").val();
	if(tagPhone.test(amPhone)){
		alert("请输入电话！");
		return false;
	}
	if(!checkTel(amPhone)){
		alert("请输入有效电话号码！");
		return false;
	}
	var tagCountry = new RegExp('省份');
	var amCountry = $("#country").val();
	if(tagCountry.test(amCountry)){
		alert("请选择就近的省份！");
		return false;
	}
	var tagCity = new RegExp('商城');
	var amCity = $("#city").val();
	if(tagCity.test(amCity)){
		alert("请选择就近的商城！");
		return false;
	}
	var tagQq = new RegExp('QQ');
	var amQq = $("#am_qq").val();
	if(tagQq.test(amQq)){
		$("#am_qq").val("");
	}
	var tagEmail = new RegExp('邮箱');
	var amEmail = $("#am_email").val();
	if(tagEmail.test(amEmail)){
		$("#am_email").val("");
	}
	var tagAdress = new RegExp('详细地址');
	var amAdress = $("#am_adress").val();
	if(tagAdress.test(amAdress)){
		$("#am_adress").val("");
	}
	var tagOpenStatus = new RegExp('开店经验');
	var amOpenStatus = $("#am_openStatus").val();
	if(tagOpenStatus.test(amOpenStatus)){
		$("#am_openStatus").val("");
	}
	var tagShopStatus = new RegExp('有无店铺');
	var amShopStatus = $("#am_shopStatus").val();
	if(tagShopStatus.test(amShopStatus)){
		$("#am_shopStatus").val("");
	}
	var tagMessage = new RegExp('留言');
	var amMessage = $("#am_message").val();
	if(tagMessage.test(amMessage)){
		$("#am_message").val("");
	}
	var targetUrl = $("#join_form").attr("action");
	var data = $("#join_form").serialize();
	$.ajax({
	      type: 'post',
	      dataType: 'json',
	      url: targetUrl,
	      data: data,
	      async: true,
	      success: function(data){
	    	  for(var i=0; i < data.length; i++){
	    		  if(data[i].status){
	    		  	alert("加盟申请提交成功！");
	    		  }else{
	    			alert("服务器繁忙... 请重新提交留言！");
	    		  }
	    	  }
	      },
	      error: function(errorMsg) {
	    	  alert("请求数据失败，可能是服务器开小差了");
	      }
	  });
}

function pcdojz(){
	var qanx = new Array();
	var tanL = '<li><div class="ya_z_cen"><dl><dt><img src="/getQRCode?a=';
	var tanR = '" /></dt><dd><span><p><a href="/ppzxxq?wid=';
	var tanM = '">';
	var tanZ = '</a></p><em>';
	var tanP = '</em><i><a href="/ppzx">查看更多>></a></i></span></dd></dl></div></li>';
	$.ajax({
	      type: 'post',
	      dataType: 'json',
	      url: '/upload/findRecomArticle',
	      async: true,
	      success: function(data){
	    	  for(var i=0; i < data.length; i++){
	    		  var newss = data[i].recomArticles;
	    		  for(var j=0; j < newss.length; j++){
	    			  qanx[j] = tanL + newss[j].imgUrl + tanR + newss[j].id + tanM + newss[j].titleName + tanZ + newss[j].uTime + tanP;
	    		  }
	    		  var zuihou = "";
		    	  var h_left = '<div class="KK_slide_container"><ul class="KK_rslides" id="KK_slider">';
		    	  var h_right = '</ul></div>';
		    	  var prt = "";
		    	  for (m=0;m<qanx.length;m++) {
		    		  prt += qanx[m];
		    	  }
		    	  zuihou = h_left +""+ prt +""+ h_right;
		    	  document.getElementById("pc_aritkf").innerHTML = zuihou;
		    	  $(function () {
		    		    $("#KK_slider").responsiveSlides({
		    		    auto: false,
		    		    pager: false,
		    		    nav: true,
		    		    speed: 500,
		    		    namespace: "KK_slide"
		    		    });
		    		});
	    	  }
	      },
	      error: function(errorMsg) {
	    	  $('#idUser').text("请求数据失败，可能是服务器开小差了");
	      }
	  });
}

function pcdoxq(){
	var qanx = new Array();
	var tanA = '<li><dl>';
	
	var LeA = '<dd><span><b><a href="/ppzxxq?wid=';
	var LeB = '">';
	var LeC = '</a></b><p>';
	var LeD = '</p></span></dd>';
	
	var RiA = '<dt><span><b><a href="/ppzxxq?wid=';
	var RiB = '">';
	var RiC = '</a></b><p>';
	var RiD = '</p></span></dt>';
	
	var tanB = '</dl></li>';
	$.ajax({
	      type: 'post',
	      dataType: 'json',
	      url: '/upload/findRecomArticleTen',
	      async: true,
	      success: function(data){
	    	  for(var i=0; i < data.length; i++){
	    		  var newss = data[i].recomArticles;
	    		  var ks = 0;
	    		  var km = 0;
	    		  var kn = 0;
	    		  var ka = "";
	    		  var kb = "";
	    		  for(var j=0; j < newss.length; j++){
	    			  if(j%2==0){
	    				  ka = LeA + newss[j].id + LeB + newss[j].titleName + LeC + newss[j].uTime + LeD;
	    				  km = 1;
	    			  }
	    			  if(j%2==1){
	    				  kb = RiA + newss[j].id + RiB + newss[j].titleName + RiC + newss[j].uTime + RiD;
	    				  kn = 1;
	    			  }
	    			  if((km+kn)==2){
	    				  qanx[ks] = tanA + ka + kb + tanB;
	    				  km = 0;
	    				  kn = 0;
	    				  ks++;
	    			  }
	    		  }
	    		  var zuihou = "";
		    	  var h_left = '<div class="PP_slide_container"><ul class="PP_rslides" id="PP_slider">';
		    	  var h_right = '</ul></div>';
		    	  var prt = "";
		    	  for (m=0;m<qanx.length;m++) {
		    		  prt += qanx[m];
		    	  }
		    	  zuihou = h_left +""+ prt +""+ h_right;
		    	  document.getElementById("pc_arttxq").innerHTML = zuihou;
		    	  $(function () {
		    		    $("#PP_slider").responsiveSlides({
		    		    auto: false,
		    		    pager: false,
		    		    nav: true,
		    		    speed: 500,
		    		    namespace: "PP_slide"
		    		    });
		    		});
	    	  }
	      },
	      error: function(errorMsg) {
	    	  $('#idUser').text("请求数据失败，可能是服务器开小差了");
	      }
	  });
}

function apdojz(){
	var qanx = new Array();
	var tanL = '<li><div class="ap_ya_d_cen"><dl><dt><img src="/getQRCode?a=';
	var tanR = '" /></dt><dd><span><p><a href="/ppzxxq?wid=';
	var tanM = '">';
	var tanZ = '</a></p><em>';
	var tanP = '</em><i><a href="/ppzx">查看更多>></a></i></span></dd></dl></div></li>';
	$.ajax({
	      type: 'post',
	      dataType: 'json',
	      url: '/upload/findRecomArticle',
	      async: true,
	      success: function(data){
	    	  for(var i=0; i < data.length; i++){
	    		  var newss = data[i].recomArticles;
	    		  for(var j=0; j < newss.length; j++){
	    			  qanx[j] = tanL + newss[j].imgUrl + tanR + newss[j].id + tanM + newss[j].titleName + tanZ + newss[j].uTime + tanP;
	    		  }
	    		  var zuihou = "";
		    	  var h_left = '<div class="MM_slide_container"><ul class="MM_rslides" id="MM_slider">';
		    	  var h_right = '</ul></div>';
		    	  var prt = "";
		    	  for (m=0;m<qanx.length;m++) {
		    		  prt += qanx[m];
		    	  }
		    	  zuihou = h_left +""+ prt +""+ h_right;
		    	  document.getElementById("ap_aritJZ").innerHTML = zuihou;
		    	  $(function () {
		    		    $("#MM_slider").responsiveSlides({
		    		    auto: false,
		    		    pager: false,
		    		    nav: true,
		    		    speed: 500,
		    		    namespace: "MM_slide"
		    		    });
		    		});
	    	  }
	      },
	      error: function(errorMsg) {
	    	  $('#idUser').text("请求数据失败，可能是服务器开小差了");
	      }
	  });
}
















