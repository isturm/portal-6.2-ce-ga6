(function(){var A=function(){var C={};
var B=[];
var F=function(G,H){if(H&&G){B.push({key:G,request:H})
}return C
};
var E=function(H){var G={method:H.request.method,id:H.key};
if(H.request.rpc){G.params=H.request.rpc
}return G
};
var D=function(G){var H={};
var O={};
var J=0;
var K=[];
for(var M=0;
M<B.length;
M++){var I=B[M].request.transport;
if(!O[I.name]){K.push(I);
J++
}O[I.name]=O[I.name]||[];
O[I.name].push(E(B[M]))
}var N=function(S){if(S.error){H.error=S.error
}for(var R=0;
R<B.length;
R++){var Q=B[R].key;
var P=S[Q];
if(P){if(P.error){H[Q]=P
}else{H[Q]=P.data||P.result
}}}J--;
if(J===0){G(H)
}};
for(var L=0;
L<K.length;
L++){K[L].execute(O[K[L].name],N)
}if(J==0){window.setTimeout(function(){G(H)
},0)
}};
C.execute=D;
C.add=F;
return C
};
osapi.newBatch=A
})();