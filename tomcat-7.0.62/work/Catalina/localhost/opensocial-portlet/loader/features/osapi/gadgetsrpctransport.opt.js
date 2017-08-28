if(gadgets&&gadgets.rpc){(function(){function A(E,D){var C=function(G){if(!G){D({code:500,message:"Container refused the request"})
}else{if(G.error){D(G)
}else{var F={};
for(var H=0;
H<G.length;
H++){F[G[H].id]=G[H]
}D(F)
}}};
gadgets.rpc.call("..","osapi._handleGadgetRpcMethod",C,E)
}function B(C){var F={name:"gadgets.rpc",execute:A};
var K=C["osapi.services"];
if(K){for(var D in K){if(K.hasOwnProperty(D)){if(D==="gadgets.rpc"){var E=K[D];
for(var H=0;
H<E.length;
H++){osapi._registerMethod(E[H],F)
}}}}}if(osapi.container&&osapi.container.listMethods){var G=gadgets.util.runOnLoadHandlers;
var I=2;
var J=function(){I--;
if(I==0){G()
}};
gadgets.util.runOnLoadHandlers=J;
osapi.container.listMethods({}).execute(function(L){if(!L.error){for(var M=0;
M<L.length;
M++){if(L[M]!="container.listMethods"){osapi._registerMethod(L[M],F)
}}}J()
});
window.setTimeout(J,500)
}}if(gadgets.config&&gadgets.config.isGadget){gadgets.config.register("osapi.services",null,B)
}})()
};