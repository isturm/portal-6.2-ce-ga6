shindig.cookies={};
shindig.cookies.JsType_={UNDEFINED:"undefined"};
shindig.cookies.isDef=function(A){return typeof A!=shindig.cookies.JsType_.UNDEFINED
};
shindig.cookies.set=function(C,I,H,B,D){if(/;=/g.test(C)){throw new Error('Invalid cookie name "'+C+'"')
}if(/;/g.test(I)){throw new Error('Invalid cookie value "'+I+'"')
}if(!shindig.cookies.isDef(H)){H=-1
}var F=D?";domain="+D:"";
var J=B?";path="+B:"";
var E;
if(H<0){E=""
}else{if(H===0){var G=new Date(1970,1,1);
E=";expires="+G.toUTCString()
}else{var A=new Date((new Date).getTime()+H*1000);
E=";expires="+A.toUTCString()
}}document.cookie=C+"="+I+F+J+E
};
shindig.cookies.get=function(B,G){var F=B+"=";
var D=String(document.cookie);
for(var H=-1;
(H=D.indexOf(F,H+1))>=0;
){var C=H;
while(--C>=0){var E=D.charAt(C);
if(E==";"){C=-1;
break
}}if(C==-1){var A=D.indexOf(";",H);
if(A<0){A=D.length
}return D.substring(H+F.length,A)
}}return G
};
shindig.cookies.remove=function(B,A,C){var D=shindig.cookies.containsKey(B);
shindig.cookies.set(B,"",0,A,C);
return D
};
shindig.cookies.getKeyValues_=function(){var E=String(document.cookie);
var G=E.split(/\s*;\s*/);
var F=[],A=[],C,B;
for(var D=0;
B=G[D];
D++){C=B.indexOf("=");
if(C==-1){F.push("");
A.push(B)
}else{F.push(B.substring(0,C));
A.push(B.substring(C+1))
}}return{keys:F,values:A}
};
shindig.cookies.getKeys=function(){return shindig.cookies.getKeyValues_().keys
};
shindig.cookies.getValues=function(){return shindig.cookies.getKeyValues_().values
};
shindig.cookies.isEmpty=function(){return document.cookie===""
};
shindig.cookies.getCount=function(){var A=String(document.cookie);
if(A===""){return 0
}var B=A.split(/\s*;\s*/);
return B.length
};
shindig.cookies.containsKey=function(B){var A={};
return shindig.cookies.get(B,A)!==A
};
shindig.cookies.containsValue=function(C){var A=shindig.cookies.getKeyValues_().values;
for(var B=0;
B<A.length;
B++){if(A[B]==C){return true
}}return false
};
shindig.cookies.clear=function(){var B=shindig.cookies.getKeyValues_().keys;
for(var A=B.length-1;
A>=0;
A--){shindig.cookies.remove(B[A])
}};
shindig.cookies.MAX_COOKIE_LENGTH=3950;