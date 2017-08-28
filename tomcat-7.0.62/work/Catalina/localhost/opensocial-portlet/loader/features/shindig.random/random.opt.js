shindig.random=(function(){var D=Math.random();
var E="0123456789ABCDEF";
var G=1;
var B=((screen.width*screen.width)+screen.height)*1000000;
function F(L){var J=shindig.sha1();
J.update(L);
var H=J.digest();
var K="";
for(var I=0;
I<H.length;
I++){K+=E.charAt(Math.floor(H[I]/16))+E.charAt(H[I]%16)
}return K
}var A=window.onmousemove||function(){return false
};
window.onmousemove=function(I){if(window.event){I=event
}var H=(I.screenX+I.clientX)<<16;
H+=(I.screenY+I.clientY);
H*=new Date().getTime()%1000000;
G=(G*H)%B;
return A.call(window,Array.prototype.slice.call(arguments))
};
var C=F(document.cookie+"|"+document.location+"|"+(new Date()).getTime()+"|"+D);
return function(){var H=G;
H+=parseInt(C.substr(0,20),16);
C=F(C);
return H/(B+Math.pow(16,20))
}
})();