if(gadgets&&gadgets.rpc){osapi._handleGadgetRpcMethod=function(A){var F=new Array(A.length);
var E=0;
var H=this.callback;
var B=function(K,J){J({})
};
for(var D=0;
D<A.length;
D++){var G=osapi;
if(A[D].method.indexOf("_")==-1){var I=A[D].method.split(".");
for(var C=0;
C<I.length;
C++){if(G.hasOwnProperty(I[C])){G=G[I[C]]
}else{G=B;
break
}}}else{G=B
}G(A[D].params,function(J){return function(K){F[J]={id:A[J].id,data:K};
E++;
if(E==A.length){H(F)
}}
}(D))
}};
osapi.container={};
osapi.container.listMethods=function(A,C){var B=[];
recurseNames(osapi,"",5,B);
C(B)
};
function recurseNames(C,D,E,B){if(E==0){return 
}for(var F in C){if(C.hasOwnProperty(F)){if(F.indexOf("_")==-1){var A=typeof (C[F]);
if(A=="function"){B.push(D+F)
}else{if(A=="object"){recurseNames(C[F],D+F+".",E-1,B)
}}}}}}gadgets.rpc.register("osapi._handleGadgetRpcMethod",osapi._handleGadgetRpcMethod)
};