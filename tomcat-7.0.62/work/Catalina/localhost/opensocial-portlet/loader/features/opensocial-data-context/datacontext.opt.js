var opensocial=opensocial||{};
opensocial.data=opensocial.data||{};
opensocial.data.DataContext=function(){var E=[];
var B={};
var A=function(I,K,J){if(typeof K==="undefined"||K===null){return 
}B[I]=K;
if(!(J===false)){C(I)
}};
var G=function(K,O,M,N){var I=!!M;
var L={keys:{},callback:O,oneTime:I};
if(typeof K==="string"){L.keys[K]=true;
if(K!="*"){K=[K]
}}else{for(var J=0;
J<K.length;
J++){L.keys[K[J]]=true
}}E.push(L);
if(N&&K!=="*"&&H(L.keys)){window.setTimeout(function(){F(L,K)
},1)
}};
var H=function(J){if(J["*"]){return true
}for(var I in J){if(typeof B[I]==="undefined"){return false
}}return true
};
var F=function(J,I){if(H(J.keys)){J.callback(I);
if(J.oneTime){D(J)
}}};
var D=function(J){for(var I=0;
I<E.length;
++I){if(E[I]==J){E.splice(I,1);
return 
}}};
var C=function(L){if(typeof (L)=="string"){L=[L]
}for(var K=0;
K<E.length;
++K){var M=E[K];
for(var I=0;
I<L.length;
I++){var J=L[I];
if(M.keys[J]||M.keys["*"]){F(M,L);
break
}}}};
return{getData:function(){var J={};
for(var I in B){if(B.hasOwnProperty(I)){J[I]=B[I]
}}return J
},registerListener:function(I,J){G(I,J,false,true)
},registerOneTimeListener_:function(I,J){G(I,J,true,true)
},registerDeferredListener_:function(I,J){G(I,J,false,false)
},getDataSet:function(I){return B[I]
},putDataSet:function(I,J){A(I,J,true)
},putDataSets:function(I){var K=[];
for(var J in I){K.push(J);
A(J,I[J],false)
}C(K)
}}
}();
opensocial.data.getDataContext=function(){return opensocial.data.DataContext
};