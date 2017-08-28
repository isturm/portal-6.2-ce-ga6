gadgets.rpctx=gadgets.rpctx||{};
if(!gadgets.rpctx.wpm){gadgets.rpctx.wpm=function(){var F,D;
var C;
var E=false;
var A=false;
var G=false;
function B(){var I=false;
function J(K){if(K.data=="postmessage.test"){I=true;
if(typeof K.origin==="undefined"){A=true
}}}gadgets.util.attachBrowserEvent(window,"message",J,false);
window.postMessage("postmessage.test","*");
if(I){E=true
}gadgets.util.removeBrowserEvent(window,"message",J,false)
}function H(K){var L=gadgets.json.parse(K.data);
if(G){if(!L||!L.f){return 
}var J=gadgets.rpc.getRelayUrl(L.f)||gadgets.util.getUrlParameters()["parent"];
var I=gadgets.rpc.getOrigin(J);
if(!A?K.origin!==I:K.domain!==/^.+:\/\/([^:]+).*/.exec(I)[1]){return 
}}F(L)
}return{getCode:function(){return"wpm"
},isParentVerifiable:function(){return true
},init:function(I,J){F=I;
D=J;
B();
if(!E){C=function(L,M,K){L.postMessage(M,K)
}
}else{C=function(L,M,K){window.setTimeout(function(){L.postMessage(M,K)
},0)
}
}gadgets.util.attachBrowserEvent(window,"message",H,false);
D("..",true);
return true
},setup:function(K,J,I){G=I;
if(K===".."){if(G){gadgets.rpc._createRelayIframe(J)
}else{gadgets.rpc.call(K,gadgets.rpc.ACK)
}}return true
},call:function(J,N,M){var L=gadgets.rpc._getTargetWin(J);
var K=gadgets.rpc.getRelayUrl(J)||gadgets.util.getUrlParameters()["parent"];
var I=gadgets.rpc.getOrigin(K);
if(I){C(L,gadgets.json.stringify(M),I)
}else{gadgets.error("No relay set (used as window.postMessage targetOrigin), cannot send cross-domain message")
}return true
},relayOnload:function(J,I){D(J,true)
}}
}()
};