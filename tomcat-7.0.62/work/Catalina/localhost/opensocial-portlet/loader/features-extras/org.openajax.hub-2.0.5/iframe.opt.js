var OpenAjax=OpenAjax||{};
OpenAjax.hub=OpenAjax.hub||{};
OpenAjax.gadgets=typeof OpenAjax.gadgets==="object"?OpenAjax.gadgets:typeof gadgets==="object"?gadgets:{};
OpenAjax.gadgets.rpctx=OpenAjax.gadgets.rpctx||{};
(function(){if(typeof gadgets==="undefined"){if(typeof oaaConfig==="undefined"){var scripts=document.getElementsByTagName("script");
var reHub=/openajax(?:managedhub-(?:all|core).*|-mashup)\.js$/i;
for(var i=scripts.length-1;
i>=0;
i--){var src=scripts[i].getAttribute("src");
if(!src){continue
}var m=src.match(reHub);
if(m){var config=scripts[i].getAttribute("oaaConfig");
if(config){try{oaaConfig=eval("({ "+config+" })")
}catch(e){}}break
}}}if(typeof oaaConfig!=="undefined"&&oaaConfig.gadgetsGlobal){gadgets=OpenAjax.gadgets
}}})();
if(!OpenAjax.hub.IframeContainer){(function(){OpenAjax.hub.IframeContainer=function(I,O,S){E(arguments);
var M=this;
var D=S.Container.scope||window;
var T=false;
var R={};
var N;
var P;
var K=S.IframeContainer.timeout||15000;
var C;
if(S.Container.log){var J=function(V){try{S.Container.log.call(D,"IframeContainer::"+O+": "+V)
}catch(U){OpenAjax.hub._debugger()
}}
}else{J=function(){}
}this._init=function(){I.addContainer(this);
P=OpenAjax.hub.IframeContainer._rpcRouter.add(O,this);
N=A(S,D,J);
var V=null;
var U=OpenAjax.gadgets.rpc.getRelayChannel();
if(S.IframeContainer.tunnelURI){if(U!=="wpm"&&U!=="nix"){throw new Error(OpenAjax.hub.Error.IncompatBrowser)
}}else{J("WARNING: Parameter 'IframeContaienr.tunnelURI' not specified. Connection will not be fully secure.");
if(U==="rmr"){V=OpenAjax.gadgets.rpc.getOrigin(S.IframeContainer.uri)+"/robots.txt"
}}F();
OpenAjax.gadgets.rpc.setupReceiver(P,V);
L()
};
this.sendToClient=function(V,W,U){OpenAjax.gadgets.rpc.call(P,"openajax.pubsub",null,"pub",V,W,U)
};
this.remove=function(){H();
clearTimeout(C);
OpenAjax.gadgets.rpc.removeReceiver(P);
var U=document.getElementById(P);
U.parentNode.removeChild(U);
OpenAjax.hub.IframeContainer._rpcRouter.remove(P)
};
this.isConnected=function(){return T
};
this.getClientID=function(){return O
};
this.getPartnerOrigin=function(){if(T){var U=OpenAjax.gadgets.rpc.getReceiverOrigin(P);
if(U){return(/^([a-zA-Z]+:\/\/[^:]+).*/.exec(U)[1])
}}return null
};
this.getParameters=function(){return S
};
this.getHub=function(){return I
};
this.getIframe=function(){return document.getElementById(P)
};
function E(U){var V=U[0],X=U[1],W=U[2];
if(!V||!X||!W||!W.Container||!W.Container.onSecurityAlert||!W.IframeContainer||!W.IframeContainer.parent||!W.IframeContainer.uri){throw new Error(OpenAjax.hub.Error.BadParameters)
}}this._handleIncomingRPC=function(Z,V,X){switch(Z){case"pub":I.publishForClient(M,V,X);
break;
case"sub":var U="";
try{R[X]=I.subscribeForClient(M,V,X)
}catch(Y){U=Y.message
}return U;
case"uns":var W=R[X];
I.unsubscribeForClient(M,W);
delete R[X];
return X;
case"con":G();
return true;
case"dis":L();
H();
if(S.Container.onDisconnect){try{S.Container.onDisconnect.call(D,M)
}catch(Y){OpenAjax.hub._debugger();
J("caught error from onDisconnect callback to constructor: "+Y.message)
}}return true
}};
this._onSecurityAlert=function(U){Q(B[U])
};
function F(){var Z=document.createElement("span");
S.IframeContainer.parent.appendChild(Z);
var X='<iframe id="'+P+'" name="'+P+'" src="javascript:\'<html></html>\'"';
var b="";
var V=S.IframeContainer.iframeAttrs;
if(V){for(var U in V){switch(U){case"style":for(var Y in V.style){b+=Y+":"+V.style[Y]+";"
}break;
case"className":X+=' class="'+V[U]+'"';
break;
default:X+=" "+U+'="'+V[U]+'"'
}}}b+="visibility:hidden;";
X+=' style="'+b+'"></iframe>';
Z.innerHTML=X;
var W;
if(S.IframeContainer.tunnelURI){W="&parent="+encodeURIComponent(S.IframeContainer.tunnelURI)+"&forcesecure=true"
}else{W="&oahParent="+encodeURIComponent(OpenAjax.gadgets.rpc.getOrigin(window.location.href))
}var a="";
if(P!==O){a="&oahId="+P.substring(P.lastIndexOf("_")+1)
}document.getElementById(P).src=S.IframeContainer.uri+"#rpctoken="+N+W+a
}function G(){function U(V){if(V){T=true;
clearTimeout(C);
document.getElementById(P).style.visibility="visible";
if(S.Container.onConnect){try{S.Container.onConnect.call(D,M)
}catch(W){OpenAjax.hub._debugger();
J("caught error from onConnect callback to constructor: "+W.message)
}}}}OpenAjax.gadgets.rpc.call(P,"openajax.pubsub",U,"cmd","con")
}function H(){if(T){T=false;
document.getElementById(P).style.visibility="hidden";
for(var U in R){I.unsubscribeForClient(M,R[U])
}R={}
}}function Q(U){try{S.Container.onSecurityAlert.call(D,M,U)
}catch(V){OpenAjax.hub._debugger();
J("caught error from onSecurityAlert callback to constructor: "+V.message)
}}function L(){C=setTimeout(function(){Q(OpenAjax.hub.SecurityAlert.LoadTimeout);
M._handleIncomingRPC=function(){}
},K)
}this._init()
};
OpenAjax.hub.IframeHubClient=function(F){if(!F||!F.HubClient||!F.HubClient.onSecurityAlert){throw new Error(OpenAjax.hub.Error.BadParameters)
}var E=this;
var M=F.HubClient.scope||window;
var I=false;
var G={};
var H=0;
var K;
if(F.HubClient.log){var J=function(O){try{F.HubClient.log.call(M,"IframeHubClient::"+K+": "+O)
}catch(N){OpenAjax.hub._debugger()
}}
}else{J=function(){}
}this._init=function(){var N=OpenAjax.gadgets.util.getUrlParameters();
if(!N.parent){var O=N.oahParent+"/robots.txt";
OpenAjax.gadgets.rpc.setupReceiver("..",O)
}if(F.IframeHubClient&&F.IframeHubClient.requireParentVerifiable&&OpenAjax.gadgets.rpc.getReceiverOrigin("..")===null){OpenAjax.gadgets.rpc.removeReceiver("..");
throw new Error(OpenAjax.hub.Error.IncompatBrowser)
}OpenAjax.hub.IframeContainer._rpcRouter.add("..",this);
K=OpenAjax.gadgets.rpc.RPC_ID;
if(N.oahId){K=K.substring(0,K.lastIndexOf("_"))
}};
this.connect=function(O,N){if(I){throw new Error(OpenAjax.hub.Error.Duplicate)
}function P(Q){if(Q){I=true;
if(O){try{O.call(N||window,E,true)
}catch(R){OpenAjax.hub._debugger();
J("caught error from onComplete callback to connect(): "+R.message)
}}}}OpenAjax.gadgets.rpc.call("..","openajax.pubsub",P,"con")
};
this.disconnect=function(O,N){if(!I){throw new Error(OpenAjax.hub.Error.Disconnected)
}I=false;
var P=null;
if(O){P=function(Q){try{O.call(N||window,E,true)
}catch(R){OpenAjax.hub._debugger();
J("caught error from onComplete callback to disconnect(): "+R.message)
}}
}OpenAjax.gadgets.rpc.call("..","openajax.pubsub",P,"dis")
};
this.getPartnerOrigin=function(){if(I){var N=OpenAjax.gadgets.rpc.getReceiverOrigin("..");
if(N){return(/^([a-zA-Z]+:\/\/[^:]+).*/.exec(N)[1])
}}return null
};
this.getClientID=function(){return K
};
this.subscribe=function(O,R,Q,S,P){D();
C(O);
if(!R){throw new Error(OpenAjax.hub.Error.BadParameters)
}Q=Q||window;
var N=""+H++;
G[N]={cb:R,sc:Q,d:P};
function T(U){if(U!==""){delete G[N]
}if(S){try{S.call(Q,N,U==="",U)
}catch(V){OpenAjax.hub._debugger();
J("caught error from onComplete callback to subscribe(): "+V.message)
}}}OpenAjax.gadgets.rpc.call("..","openajax.pubsub",T,"sub",O,N);
return N
};
this.publish=function(N,O){D();
L(N);
OpenAjax.gadgets.rpc.call("..","openajax.pubsub",null,"pub",N,O)
};
this.unsubscribe=function(N,P,O){D();
if(!N){throw new Error(OpenAjax.hub.Error.BadParameters)
}if(!G[N]||G[N].uns){throw new Error(OpenAjax.hub.Error.NoSubscription)
}G[N].uns=true;
function Q(R){delete G[N];
if(P){try{P.call(O||window,N,true)
}catch(S){OpenAjax.hub._debugger();
J("caught error from onComplete callback to unsubscribe(): "+S.message)
}}}OpenAjax.gadgets.rpc.call("..","openajax.pubsub",Q,"uns",null,N)
};
this.isConnected=function(){return I
};
this.getScope=function(){return M
};
this.getSubscriberData=function(N){D();
if(G[N]){return G[N].d
}throw new Error(OpenAjax.hub.Error.NoSubscription)
};
this.getSubscriberScope=function(N){D();
if(G[N]){return G[N].sc
}throw new Error(OpenAjax.hub.Error.NoSubscription)
};
this.getParameters=function(){return F
};
this._handleIncomingRPC=function(R,O,P,N){if(R==="pub"){if(G[N]&&!G[N].uns){try{G[N].cb.call(G[N].sc,O,P,G[N].d)
}catch(Q){OpenAjax.hub._debugger();
J("caught error from onData callback to subscribe(): "+Q.message)
}}}if(O==="con"){return true
}return false
};
function D(){if(!I){throw new Error(OpenAjax.hub.Error.Disconnected)
}}function C(O){if(!O){throw new Error(OpenAjax.hub.Error.BadParameters)
}var R=O.split(".");
var N=R.length;
for(var P=0;
P<N;
P++){var Q=R[P];
if((Q==="")||((Q.indexOf("*")!=-1)&&(Q!="*")&&(Q!="**"))){throw new Error(OpenAjax.hub.Error.BadParameters)
}if((Q=="**")&&(P<N-1)){throw new Error(OpenAjax.hub.Error.BadParameters)
}}}function L(N){if(!N||N===""||(N.indexOf("*")!=-1)||(N.indexOf("..")!=-1)||(N.charAt(0)==".")||(N.charAt(N.length-1)==".")){throw new Error(OpenAjax.hub.Error.BadParameters)
}}this._init()
};
OpenAjax.hub.IframeContainer._rpcRouter=function(){var E={};
function D(){var F=E[this.f];
if(F){return F._handleIncomingRPC.apply(F,arguments)
}}function C(H,F){var G=E[H];
if(G){G._onSecurityAlert.call(G,F)
}}return{add:function(H,F){function G(K,J){if(K===".."){if(!E[".."]){E[".."]=J
}return 
}var I=K;
while(document.getElementById(I)){I=K+"_"+((32767*Math.random())|0).toString(16)
}E[I]=J;
return I
}OpenAjax.gadgets.rpc.register("openajax.pubsub",D);
OpenAjax.gadgets.rpc.config({securityCallback:C});
B[OpenAjax.gadgets.rpc.SEC_ERROR_LOAD_TIMEOUT]=OpenAjax.hub.SecurityAlert.LoadTimeout;
B[OpenAjax.gadgets.rpc.SEC_ERROR_FRAME_PHISH]=OpenAjax.hub.SecurityAlert.FramePhish;
B[OpenAjax.gadgets.rpc.SEC_ERROR_FORGED_MSG]=OpenAjax.hub.SecurityAlert.ForgedMsg;
this.add=G;
return G(H,F)
},remove:function(F){delete E[F]
}}
}();
var B={};
function A(H,E,D){if(!OpenAjax.hub.IframeContainer._prng){var C=new Date().getTime()+Math.random()+document.cookie;
OpenAjax.hub.IframeContainer._prng=OpenAjax._smash.crypto.newPRNG(C)
}var G=H.IframeContainer||H.IframeHubClient;
if(G&&G.seed){try{var J=G.seed.call(E);
OpenAjax.hub.IframeContainer._prng.addSeed(J)
}catch(F){OpenAjax.hub._debugger();
D("caught error from 'seed' callback: "+F.message)
}}var I=(G&&G.tokenLength)||6;
return OpenAjax.hub.IframeContainer._prng.nextRandomB64Str(I)
}})()
};