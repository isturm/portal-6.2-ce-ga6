(function(){var I=null;
var J={};
var F=gadgets.util.escapeString;
var D={};
var H={};
var E="en";
var B="US";
var A=0;
function C(){var L=gadgets.util.getUrlParameters();
for(var K in L){if(L.hasOwnProperty(K)){if(K.indexOf("up_")===0&&K.length>3){J[K.substr(3)]=String(L[K])
}else{if(K==="country"){B=L[K]
}else{if(K==="lang"){E=L[K]
}else{if(K==="mid"){A=L[K]
}}}}}}}function G(){for(var K in H){if(typeof J[K]==="undefined"){J[K]=H[K]
}}}gadgets.Prefs=function(){if(!I){C();
G();
I=this
}return I
};
gadgets.Prefs.setInternal_=function(M,O){var N=false;
if(typeof M==="string"){if(!J.hasOwnProperty(M)||J[M]!==O){N=true
}J[M]=O
}else{for(var L in M){if(M.hasOwnProperty(L)){var K=M[L];
if(!J.hasOwnProperty(L)||J[L]!==K){N=true
}J[L]=K
}}}return N
};
gadgets.Prefs.setMessages_=function(K){D=K
};
gadgets.Prefs.setDefaultPrefs_=function(K){H=K
};
gadgets.Prefs.prototype.getString=function(K){if(K===".lang"){K="lang"
}return J[K]?F(J[K]):""
};
gadgets.Prefs.prototype.setDontEscape_=function(){F=function(K){return K
}
};
gadgets.Prefs.prototype.getInt=function(K){var L=parseInt(J[K],10);
return isNaN(L)?0:L
};
gadgets.Prefs.prototype.getFloat=function(K){var L=parseFloat(J[K]);
return isNaN(L)?0:L
};
gadgets.Prefs.prototype.getBool=function(K){var L=J[K];
if(L){return L==="true"||L===true||!!parseInt(L,10)
}return false
};
gadgets.Prefs.prototype.set=function(K,L){throw new Error("setprefs feature required to make this call.")
};
gadgets.Prefs.prototype.getArray=function(N){var O=J[N];
if(O){var K=O.split("|");
for(var M=0,L=K.length;
M<L;
++M){K[M]=F(K[M].replace(/%7C/g,"|"))
}return K
}return[]
};
gadgets.Prefs.prototype.setArray=function(K,L){throw new Error("setprefs feature required to make this call.")
};
gadgets.Prefs.prototype.getMsg=function(K){return D[K]||""
};
gadgets.Prefs.prototype.getCountry=function(){return B
};
gadgets.Prefs.prototype.getLang=function(){return E
};
gadgets.Prefs.prototype.getModuleId=function(){return A
}
})();