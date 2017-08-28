gadgets.flash=gadgets.flash||{};
gadgets.flash.getMajorVersion=function(){var C=0;
if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){var B=navigator.plugins["Shockwave Flash"];
if(B&&B.description){C=parseInt(B.description.match(/[0-9]+/)[0],10)
}}else{for(var A=10;
A>0;
A--){try{var E=new ActiveXObject("ShockwaveFlash.ShockwaveFlash."+A);
return A
}catch(D){}}}return C
};
gadgets.flash.swfContainerId_=0;
gadgets.flash.embedFlash=function(G,O,M,C){switch(typeof O){case"string":O=document.getElementById(O);
case"object":if(O&&(typeof O.innerHTML==="string")){break
}default:return false
}switch(typeof C){case"undefined":C={};
case"object":break;
default:return false
}if(G.indexOf("//")==0){G=document.location.protocol+G
}var J=gadgets.flash.getMajorVersion();
if(J){var P=parseInt(M,10);
if(isNaN(P)){P=0
}if(J>=P){if(C.width===void 0){C.width="100%"
}if(C.height===void 0){C.height="100%"
}if(typeof C.base!=="string"){var N=document.createElement("a");
N.href=G;
C.base=N.href.match(/^(.*\/)[^\/]*$/)[1]
}if(typeof C.wmode!=="string"){C.wmode="opaque"
}while(!C.id){var D="swfContainer"+gadgets.flash.swfContainerId_++;
if(!document.getElementById(D)){C.id=D
}}var F;
if(navigator.plugins&&navigator.mimeTypes&&navigator.mimeTypes.length){C.type="application/x-shockwave-flash";
C.src=G;
F=document.createElement("embed");
for(var B in C){if(!/^swf_/.test(B)&&!/___$/.test(B)){F.setAttribute(B,C[B])
}}O.innerHTML="";
O.appendChild(F);
return true
}else{var I=function(Q){return !/["<>]/.test(Q)
};
C.movie=G;
var K={width:C.width,height:C.height,classid:"clsid:D27CDB6E-AE6D-11CF-96B8-444553540000"};
if(C.id){K.id=C.id
}var H="<object";
for(var L in K){if(!/___$/.test(L)&&I(L)&&I(K[L])){H+=" "+L+'="'+K[L]+'"'
}}H+=">";
for(var A in C){var E=document.createElement("param");
if(!/^swf_/.test(A)&&!K[A]&&!/___$/.test(A)&&I(A)&&I(C[A])){H+='<param name="'+A+'" value="'+C[A]+'" />'
}}H+="</object>"
}O.innerHTML=H;
return true
}}return false
};
gadgets.flash.embedCachedFlash=function(E,D,C,B){var A=gadgets.io.getProxyUrl(E,{rewriteMime:"application/x-shockwave-flash"});
return gadgets.flash.embedFlash(A,D,C,B)
};
var _IG_GetFlashMajorVersion=gadgets.flash.getMajorVersion;
var _IG_EmbedFlash=function(C,B,A){return gadgets.flash.embedFlash(C,B,A.swf_version,A)
};
var _IG_EmbedCachedFlash=function(C,B,A){return gadgets.flash.embedCachedFlash(C,B,A.swf_version,A)
};