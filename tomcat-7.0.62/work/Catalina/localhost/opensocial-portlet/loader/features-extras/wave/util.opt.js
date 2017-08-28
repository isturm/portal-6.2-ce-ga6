wave.util=wave.util||{};
wave.util.SPACES_="                                                 ";
wave.util.toSpaces_=function(A){return wave.util.SPACES_.substring(0,A*2)
};
wave.util.isArray_=function(B){try{return B&&typeof (B.length)=="number"
}catch(A){return false
}};
wave.util.printJson=function(C,D,H){if(!C||typeof (C.valueOf())!="object"){if(typeof (C)=="string"){return"'"+C+"'"
}else{if(C instanceof Function){return"[function]"
}}return""+C
}var K=[];
var E=wave.util.isArray_(C);
var L=E?"[]":"{}";
var A=D?"\n":"";
var F=D?" ":"";
var B=0;
var G=H||1;
if(!D){G=0
}K.push(L.charAt(0));
for(var J in C){var I=C[J];
if(B++>0){K.push(", ")
}if(E){K.push(wave.util.printJson(I,D,G+1))
}else{K.push(A);
K.push(wave.util.toSpaces_(G));
K.push(J+": ");
K.push(F);
K.push(wave.util.printJson(I,D,G+1))
}}if(!E){K.push(A);
K.push(wave.util.toSpaces_(G-1))
}K.push(L.charAt(1));
return K.join("")
};