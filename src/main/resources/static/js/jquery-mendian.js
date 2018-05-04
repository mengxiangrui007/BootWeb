/* mdzs */
var array=new Array(8);
array[0]=["省份","商城"];
array[1]=["北京市","新燕莎购物广场","绿地启航国际","长楹天街","城乡贸易中心","育知东路华联商厦","石景山万达广场","怀柔万达广场"];
array[2]=["湖北省","武商亚贸","众圆武商","武商黄石","襄阳武商","港隆百货","安良百货","九号中商广场","美美百货","21世纪购物中心","世贸广场","销品茂中商百货"];
array[3]=["重庆市","綦江万达广场"];
array[4]=["四川省","武侯万达广场"];
array[5]=["贵州省","贵阳万达广场"];
array[6]=["河北省","泰达广场中商世贸"];
array[7]=["山东省","东营万达广场","李沧万达广场","滨城万达广场"];
function add1(value){
	var city1=document.getElementById("city");
	var option1=city1.getElementsByTagName("option");
    for(var t=0;t<option1.length;t++){
        op2=option1[t];
        city1.removeChild(op2);
        t--;
    }
    for(var i=0;i<array.length;i++){
        var arr=array[i];
        var firstvalue=arr[0];
        if(arr[0]==value){ 
            for(var j=1;j<arr.length;j++){
                var arr2=arr[j];
                var op=document.createElement("option");
                var tex1=document.createTextNode(arr2);
                op.appendChild(tex1);
                city1.appendChild(op);
            }
        }
    }
}

function bianhuan(){
	var shop = [[100,1],[110,8],[111,1],[112,3],[113,2],[114,3],[115,1],[116,2],[120,2],[121,4],[122,3],[123,3],[124,1],[125,4],[126,3],[127,3],[128,3],[129,3],[1210,1],[130,3],[140,3],[150,1],[160,1],[170,3],[171,3],[172,3]];
	var country1=document.getElementById("country");
	var obj1=country1.getElementsByTagName("option");
	var city1=document.getElementById("city");
	var obj2=city1.getElementsByTagName("option");
	for (i=0;i<obj1.length;i++) {
		if (obj1[i].selected== true ) {
			for (j=0;j<obj2.length;j++) {
				if (obj2[j].selected== true ) {
					var sum = "1"+i+j;
					for(var m in shop){
						var shopNum = shop[m][0];
						var imgNum = shop[m][1];
						if(parseInt(sum) == parseInt(shopNum)){
							var contents = new Array();
							for (k=0;k<imgNum;k++) {
								contents[k] = '<li><img src="images/md_img/y'+i+'r'+j+'s'+k+'.jpg" /></li>';
							}
							var haode = "";
							var f_left = '<div class="TT_slide_container"><ul class="TT_rslides" id="TT_slider">';
							var f_right = '</ul></div>';
							var yy = "";
							for (m=0;m<contents.length;m++) {
								yy += contents[m];
							}
							haode = f_left +""+ yy +""+ f_right;
							document.getElementById("qiehuan").innerHTML = haode;
							$(function () {
    							$("#TT_slider").responsiveSlides({
									auto: true,
									pager: false,
									nav: true,
									speed: 1000,
									namespace: "TT_slide"
								});
							});
						}
					}	
				}
			}
		}
	}
}



