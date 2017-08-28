if(typeof wave=="undefined"){wave={}
}if(typeof wave.ui=="undefined"){wave.ui={}
}wave.ui.BASE="http://wave-api.appspot.com/public/";
wave.ui.cssLoaded=false;
wave.ui.loadCss=function(){if(wave.ui.cssLoaded){return 
}wave.ui.cssLoaded=true;
var A=document.createElement("link");
A.setAttribute("rel","stylesheet");
A.setAttribute("type","text/css");
A.setAttribute("href",wave.ui.BASE+"wave.ui.css");
document.getElementsByTagName("head")[0].appendChild(A)
};
wave.ui.makeButton=function(A){wave.ui.loadCss();
A.innerHTML="<span>"+A.innerHTML+"</span>";
A.className+=" wavebutton"
};
wave.ui.makeDialog=function(D,G,I){wave.ui.loadCss();
var C=D.innerHTML;
D.innerHTML="";
var A=document.createElement("div");
A.className="wavedialoghead";
var H=document.createElement("span");
var F=document.createElement("div");
F.className="wavedialogclose";
function E(){D.style.display="none"
}F.onclick=I||E;
H.appendChild(F);
H.appendChild(document.createTextNode(G));
A.appendChild(H);
D.appendChild(A);
var B=document.createElement("div");
B.className="wavedialogbody";
B.innerHTML=C;
D.appendChild(B);
D.className+=" wavedialog"
};
wave.ui.makeFrame=function(A){wave.ui.loadCss();
A.innerHTML='<div class="waveboxhead"><span>&nbsp;</span></div><div class="waveboxbody">'+A.innerHTML+"</div>";
A.className+=" wavebox"
};