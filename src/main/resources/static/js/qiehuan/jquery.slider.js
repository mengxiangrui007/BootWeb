(function(){
    var $root = $('#slideshow'), root_w = $root.width();
    var p = $root.find('> div.img > span'), n = p.children().length;
    p.children().eq(0).clone().appendTo(p);
    var cur = 0, max = n - 1, pt = 0, stay = 5 * 1000, dur = 0.6 * 1000, btns;
    var wid = $(document.body).width();
    var iwid = wid*0.68;
    var iwid1 = wid*0.32;
    var iwid2 = (wid*0.32)/2;
    var iwid3 = iwid2/1.5;
    var hao_w = iwid+iwid3;
    
    function onoff(on, off){
    	(on !== -1) && btns.eq(on).addClass('on');
    	(off !== -1) && btns.eq(off).removeClass('on');
    }
    //right
    function dgo(n, comp){
    	//alert(comp);
    	var idx = n > max ? 0 : n;
    	onoff(idx, cur);
    	cur = idx;
    	p.stop().animate({left: -1 * hao_w * n},{duration: dur, complete: comp});
		if(idx == 0){
			p.children().eq(n-1).clone().appendTo('.pattern');
		}else{
			$('.pattern').empty()
		};
    }
    //left
    function go(dir, slast){
    	
        pt = +new Date();
        if(dir === 0){
            onoff(cur, -1);
            p.css({left: -1 * hao_w * cur});
            return;
        }
        var t;
        if(dir > 0){
            t = cur + 1;
            if(t > max && !slast){
                t = 0;
            }
            if(t <= max){
                return dgo(t);
            }
            return dgo(t, function(){
                p.css({left: 0});
            });
        }else{
            t = cur - 1;
            if(t < 0){
                t = max;
                p.css({left: -1 * hao_w * (max + 1)});
                return dgo(t);
            }else{
                return dgo(t);
            }
        }
    }
    
    var pn_btn = $('<s class="prev"><i></i></s><s class="next"><i></i></s>');
    btns = $((new Array(n + 1)).join('<i></i>')).each(function(idx, el){
    	
    	$(el).data({idx: idx});
    });

    $('<div class="btns"/ >').append(
    	$('<b/>').append(btns).delegate('i', 'click',function(ev){
    		dgo($(this).data('idx'));
    	})
    ).delegate('s', 'click', function(ev){
    	go($(this).is('.prev') ? -1 : 1, true);
    }).append(pn_btn).appendTo($root);
    go(1);
    
    //自动播放
    if($root.attr('rel') == 'auto-play'){
    	var si = setInterval(function(){
            var now = +new Date();
            if (now - pt < stay) {
                return;
            }
            go(1, true);
        }, 5000);
		p.mouseover(function(){ clearInterval(si);})
		p.mouseout(function(){
			si = setInterval(function(){
				var now = +new Date();
				if (now - pt < stay) {
					return;
				}
				go(1, true);
			}, 5000);
		})
    }
	$('#slideshow').css({
		'width':wid+'px'
	});
	$('#slideshow .img').css({
		'width':iwid+'px',
		'float':'left',
		'margin-left':iwid2+'px',
		'display':'block'
	});
	$('#slideshow .img span').css({
		'left':iwid2+'px',
		'padding-left':(iwid3/1.8)+'px',
		'width': wid*6+'px'
	});
	$('#slideshow .img span a').css({
		'width':iwid+'px',
		'float':'left',
		'margin-left':(iwid2/1.5)+'px',
		'display':'block'
	});
	$('#slideshow .btns').css({
		'left':iwid2/2+'px'
	});
	$('.paging').css({
		'width':iwid2,
		'left':-(iwid+iwid2/3.4)+'px'
	});
})();