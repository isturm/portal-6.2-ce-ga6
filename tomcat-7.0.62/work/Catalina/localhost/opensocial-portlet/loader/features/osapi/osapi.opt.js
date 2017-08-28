(function(){osapi._registerMethod=function(G,F){var A=typeof ___!=="undefined";
if(G=="newBatch"){return 
}var D=G.split(".");
var C=osapi;
for(var B=0;
B<D.length-1;
B++){C[D[B]]=C[D[B]]||{};
C=C[D[B]]
}var E=function(J){var I=osapi.newBatch();
var H={};
H.execute=function(M){var K=A?___.untame(M):M;
var L=A?___.USELESS:this;
I.add(G,this);
I.execute(function(N){if(N.error){K.call(L,N.error)
}else{K.call(L,N[G])
}})
};
if(A){___.markInnocent(H.execute,"execute")
}J=J||{};
J.userId=J.userId||"@viewer";
J.groupId=J.groupId||"@self";
H.method=G;
H.transport=F;
H.rpc=J;
return H
};
if(A&&typeof ___.markInnocent!=="undefined"){___.markInnocent(E,G)
}if(C[D[D.length-1]]){gadgets.warn("Skipping duplicate osapi method definition "+G+" on transport "+F.name)
}else{C[D[D.length-1]]=E
}}
})();