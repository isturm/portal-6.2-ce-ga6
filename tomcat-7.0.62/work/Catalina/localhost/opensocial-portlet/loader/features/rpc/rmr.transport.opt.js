gadgets.rpctx=gadgets.rpctx||{};
if(!gadgets.rpctx.rmr){gadgets.rpctx.rmr=function(){var G=500;
var E=10;
var H={};
var B;
var I;
function K(P,N,O,M){var Q=function(){document.body.appendChild(P);
P.src="about:blank";
if(M){P.onload=function(){L(M)
}
}P.src=N+"#"+O
};
if(document.body){Q()
}else{gadgets.util.registerOnLoadHandler(function(){Q()
})
}}function C(O){if(typeof H[O]==="object"){return 
}var P=document.createElement("iframe");
var M=P.style;
M.position="absolute";
M.top="0px";
M.border="0";
M.opacity="0";
M.width="10px";
M.height="1px";
P.id="rmrtransport-"+O;
P.name=P.id;
var N=gadgets.rpc.getRelayUrl(O);
if(!N){N=gadgets.rpc.getOrigin(gadgets.util.getUrlParameters()["parent"])+"/robots.txt"
}H[O]={frame:P,receiveWindow:null,relayUri:N,searchCounter:0,width:10,waiting:true,queue:[],sendId:0,recvId:0};
if(O!==".."){K(P,N,A(O))
}D(O)
}function D(O){var Q=null;
H[O].searchCounter++;
try{var N=gadgets.rpc._getTargetWin(O);
if(O===".."){Q=N.frames["rmrtransport-"+gadgets.rpc.RPC_ID]
}else{Q=N.frames["rmrtransport-.."]
}}catch(P){}var M=false;
if(Q){M=F(O,Q)
}if(!M){if(H[O].searchCounter>E){return 
}window.setTimeout(function(){D(O)
},G)
}}function J(N,P,T,S){var O=null;
if(T!==".."){O=H[".."]
}else{O=H[N]
}if(O){if(P!==gadgets.rpc.ACK){O.queue.push(S)
}if(O.waiting||(O.queue.length===0&&!(P===gadgets.rpc.ACK&&S&&S.ackAlone===true))){return true
}if(O.queue.length>0){O.waiting=true
}var M=O.relayUri+"#"+A(N);
try{O.frame.contentWindow.location=M;
var Q=O.width==10?20:10;
O.frame.style.width=Q+"px";
O.width=Q
}catch(R){return false
}}return true
}function A(N){var O=H[N];
var M={id:O.sendId};
if(O){M.d=Array.prototype.slice.call(O.queue,0);
M.d.push({s:gadgets.rpc.ACK,id:O.recvId})
}return gadgets.json.stringify(M)
}function L(X){var U=H[X];
var Q=U.receiveWindow.location.hash.substring(1);
var Y=gadgets.json.parse(decodeURIComponent(Q))||{};
var N=Y.d||[];
var O=false;
var T=false;
var V=0;
var M=(U.recvId-Y.id);
for(var P=0;
P<N.length;
++P){var S=N[P];
if(S.s===gadgets.rpc.ACK){I(X,true);
if(U.waiting){T=true
}U.waiting=false;
var R=Math.max(0,S.id-U.sendId);
U.queue.splice(0,R);
U.sendId=Math.max(U.sendId,S.id||0);
continue
}O=true;
if(++V<=M){continue
}++U.recvId;
B(S)
}if(O||(T&&U.queue.length>0)){var W=(X==="..")?gadgets.rpc.RPC_ID:"..";
J(X,gadgets.rpc.ACK,W,{ackAlone:O})
}}function F(P,S){var O=H[P];
try{var N=false;
N="document" in S;
if(!N){return false
}N=typeof S.document=="object";
if(!N){return false
}var R=S.location.href;
if(R==="about:blank"){return false
}}catch(M){return false
}O.receiveWindow=S;
function Q(){L(P)
}if(typeof S.attachEvent==="undefined"){S.onresize=Q
}else{S.attachEvent("onresize",Q)
}if(P===".."){K(O.frame,O.relayUri,A(P),P)
}else{L(P)
}return true
}return{getCode:function(){return"rmr"
},isParentVerifiable:function(){return true
},init:function(M,N){B=M;
I=N;
return true
},setup:function(O,M){try{C(O)
}catch(N){gadgets.warn("Caught exception setting up RMR: "+N);
return false
}return true
},call:function(M,O,N){return J(M,N.s,O,N)
}}
}()
};