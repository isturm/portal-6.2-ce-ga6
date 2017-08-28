gadgets.window=gadgets.window||{};
(function(){var B;
function A(F,D){var E=window.getComputedStyle(F,"");
var G=E.getPropertyValue(D);
G.match(/^([0-9]+)/);
return parseInt(RegExp.$1,10)
}function C(){var E=0;
var D=[document.body];
while(D.length>0){var I=D.shift();
var H=I.childNodes;
for(var G=0;
G<H.length;
G++){var J=H[G];
if(typeof J.offsetLeft!=="undefined"&&typeof J.scrollWidth!=="undefined"){var F=J.offsetLeft+J.scrollWidth+A(J,"margin-right");
E=Math.max(E,F)
}D.push(J)
}}return E+A(document.body,"border-right")+A(document.body,"margin-right")+A(document.body,"padding-right")
}gadgets.window.adjustWidth=function(F){var I=parseInt(F,10);
var J=false;
if(isNaN(I)){J=true;
var H=gadgets.window.getViewportDimensions().width;
var E=document.body;
var K=document.documentElement;
if(document.compatMode==="CSS1Compat"&&K.scrollWidth){I=K.scrollWidth!==H?K.scrollWidth:K.offsetWidth
}else{if(navigator.userAgent.indexOf("AppleWebKit")>=0){I=C()
}else{if(E&&K){var D=K.scrollWidth;
var G=K.offsetWidth;
if(K.clientWidth!==G){D=E.scrollWidth;
G=E.offsetWidth
}if(D>H){I=D>G?D:G
}else{I=D<G?D:G
}}}}}if(I!==B&&!isNaN(I)&&!(J&&I===0)){B=I;
gadgets.rpc.call(null,"setIframeWidth",null,I)
}}
}());