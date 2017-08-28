var tamings___=tamings___||[];
var bridge___;
tamings___.push(function(A){___.tamesTo(gadgets.flash.embedFlash,(function(){var B=(function(){var G=document.createElement("iframe");
G.width=1;
G.height=1;
G.border=0;
document.body.appendChild(G);
var E=G.contentWindow.Object;
document.body.removeChild(G);
var F=function(J){var I=typeof J,H;
if(I==="number"||I==="boolean"||I==="string"){return J
}if(I==="object"){var K=new E;
for(H in J){if(/__$/.test(H)){continue
}K[H]=F(J[H])
}if(J.length!==undefined){K.length=J.length
}return K
}return(void 0)
};
return F
})();
var D=document.createElement("div");
D.appendChild(document.createTextNode("bridge"));
document.body.appendChild(D);
gadgets.flash.embedFlash("/container/Bridge.swf",D,10,{allowNetworking:"always",allowScriptAccess:"all",width:0,height:0,flashvars:"logging=true"});
bridge___=D.childNodes[0];
bridge___.channels=[];
callJS=function(F,E){var G=___.getNewModuleHandler().getImports().$v;
return G.cf(G.ro(F),E)
};
onFlashBridgeReady=function(){var E=bridge___.channels.length;
for(var F=0;
F<E;
++F){bridge___.registerChannel(bridge___.channels[F])
}delete bridge___.channels;
var G=___.getNewModuleHandler().getImports().$v.getOuters();
if(G.onFlashBridgeReady){callJS("onFlashBridgeReady",[])
}};
return ___.frozenFunc(function C(H,L,K,E){if(typeof L==="string"){var G=___.getNewModuleHandler().getImports().$v;
L=G.cm(G.ro("document"),"getElementById",[L])
}else{if(typeof L!=="object"||!L.node___){return false
}}var J="_flash"+(""+Math.random()).substring(2);
var I={};
for(i in E){if(i.match(/___$/)){continue
}var M=i.toLowerCase();
if(M==="allownetworking"||M==="allowscriptaccess"){continue
}var F=typeof E[i];
if(F!=="string"&&F!=="number"){continue
}I[i]=E[i]
}I.allowNetworking="never";
I.allowScriptAccess="none";
if(!I.flashVars){I.flashVars=""
}I.flashVars+="&channel="+J;
gadgets.flash.embedFlash(H,L.node___,10,I);
if(bridge___.channels){bridge___.channels.push(J)
}else{bridge___.registerChannel(J)
}return ___.primFreeze({callSWF:(function(N){return ___.func(function(P,O){return bridge___.callSWF(""+N,""+P,B(O))
})
})(J)})
})
})())
});