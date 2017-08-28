gadgets.window=gadgets.window||{};
(function(){var C;
function A(F,D){var E=window.getComputedStyle(F,"");
var G=E.getPropertyValue(D);
G.match(/^([0-9]+)/);
return parseInt(RegExp.$1,10)
}function B(){var E=0;
var D=[document.body];
while(D.length>0){var I=D.shift();
var H=I.childNodes;
for(var G=0;
G<H.length;
G++){var J=H[G];
if(typeof J.offsetTop!=="undefined"&&typeof J.scrollHeight!=="undefined"){var F=J.offsetTop+J.scrollHeight+A(J,"margin-bottom");
E=Math.max(E,F)
}D.push(J)
}}return E+A(document.body,"border-bottom")+A(document.body,"margin-bottom")+A(document.body,"padding-bottom")
}gadgets.window.adjustHeight=function(I){var F=parseInt(I,10);
var E=false;
if(isNaN(F)){E=true;
var K=gadgets.window.getViewportDimensions().height;
var D=document.body;
var J=document.documentElement;
if(document.compatMode==="CSS1Compat"&&J.scrollHeight){F=J.scrollHeight!==K?J.scrollHeight:J.offsetHeight
}else{if(navigator.userAgent.indexOf("AppleWebKit")>=0){F=B()
}else{if(D&&J){var G=J.scrollHeight;
var H=J.offsetHeight;
if(J.clientHeight!==H){G=D.scrollHeight;
H=D.offsetHeight
}if(G>K){F=G>H?G:H
}else{F=G<H?G:H
}}}}}if(F!==C&&!isNaN(F)&&!(E&&F===0)){C=F;
gadgets.rpc.call(null,"resize_iframe",null,F)
}}
}());
var _IG_AdjustIFrameHeight=gadgets.window.adjustHeight;