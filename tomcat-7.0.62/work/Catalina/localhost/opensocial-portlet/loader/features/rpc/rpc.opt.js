if(!gadgets.rpc){gadgets.rpc=function(){var a="__cb";
var g="";
var h="__ack";
var E=500;
var V=10;
var M={};
var j={};
var S={};
var R={};
var P=0;
var I={};
var J={};
var e={};
var D={};
var K={};
var T={};
var Q=(window.top!==window.self);
var O=window.name;
var Y=function(){};
var d=0;
var m=1;
var A=2;
var f=(function(){function q(r){return function(){gadgets.log("gadgets.rpc."+r+"("+gadgets.json.stringify(Array.prototype.slice.call(arguments))+"): call ignored. [caller: "+document.location+", isChild: "+Q+"]")
}
}return{getCode:function(){return"noop"
},isParentVerifiable:function(){return true
},init:q("init"),setup:q("setup"),call:q("call")}
})();
if(gadgets.util){D=gadgets.util.getUrlParameters()
}function Z(){return typeof window.postMessage==="function"?gadgets.rpctx.wpm:typeof window.postMessage==="object"?gadgets.rpctx.wpm:window.ActiveXObject?gadgets.rpctx.nix:navigator.userAgent.indexOf("WebKit")>0?gadgets.rpctx.rmr:navigator.product==="Gecko"?gadgets.rpctx.frameElement:gadgets.rpctx.ifpc
}function H(v,t){var r=W;
if(!t){r=f
}K[v]=r;
var q=T[v]||[];
for(var s=0;
s<q.length;
++s){var u=q[s];
u.t=U(v);
r.call(v,u.f,u)
}T[v]=[]
}var X=false,i=false;
function b(){if(i){return 
}function q(){X=true
}gadgets.util.attachBrowserEvent(window,"unload",q,false);
i=true
}function G(q,u,r,t,s){if(!R[u]||R[u]!==r){gadgets.error("Invalid auth token. "+R[u]+" vs "+r);
Y(u,A)
}s.onunload=function(){if(J[u]&&!X){Y(u,m);
gadgets.rpc.removeReceiver(u)
}};
b();
t=gadgets.json.parse(decodeURIComponent(t));
W.relayOnload(u,t)
}function n(r){if(r&&typeof r.s==="string"&&typeof r.f==="string"&&r.a instanceof Array){if(R[r.f]){if(R[r.f]!==r.t){gadgets.error("Invalid auth token. "+R[r.f]+" vs "+r.t);
Y(r.f,A)
}}if(r.s===h){window.setTimeout(function(){H(r.f,true)
},0);
return 
}if(r.c){r.callback=function(s){gadgets.rpc.call(r.f,a,null,r.c,s)
}
}var q=(M[r.s]||M[g]).apply(r,r.a);
if(r.c&&typeof q!=="undefined"){gadgets.rpc.call(r.f,a,null,r.c,q)
}}}function N(s){if(!s){return""
}s=s.toLowerCase();
if(s.indexOf("//")==0){s=window.location.protocol+s
}if(s.indexOf("://")==-1){s=window.location.protocol+"//"+s
}var t=s.substring(s.indexOf("://")+3);
var q=t.indexOf("/");
if(q!=-1){t=t.substring(0,q)
}var v=s.substring(0,s.indexOf("://"));
var u="";
var w=t.indexOf(":");
if(w!=-1){var r=t.substring(w+1);
t=t.substring(0,w);
if((v==="http"&&r!=="80")||(v==="https"&&r!=="443")){u=":"+r
}}return v+"://"+t+u
}function p(r){if(typeof r==="undefined"||r===".."){return window.parent
}r=String(r);
var q=window.frames[r];
if(q){return q
}q=document.getElementById(r);
if(q&&q.contentWindow){return q.contentWindow
}return null
}var W=Z();
M[g]=function(){gadgets.warn("Unknown RPC service: "+this.s)
};
M[a]=function(r,q){var s=I[r];
if(s){delete I[r];
s(q)
}};
function l(t,r,q){if(J[t]===true){return 
}if(typeof J[t]==="undefined"){J[t]=0
}var s=document.getElementById(t);
if(t===".."||s!=null){if(W.setup(t,r,q)===true){J[t]=true;
return 
}}if(J[t]!==true&&J[t]++<V){window.setTimeout(function(){l(t,r,q)
},E)
}else{K[t]=f;
J[t]=true
}}function c(r,u){if(typeof e[r]==="undefined"){e[r]=false;
var t=gadgets.rpc.getRelayUrl(r);
if(N(t)!==N(window.location.href)){return false
}var s=p(r);
try{e[r]=s.gadgets.rpc.receiveSameDomain
}catch(q){gadgets.error("Same domain call failed: parent= incorrectly set.")
}}if(typeof e[r]==="function"){e[r](u);
return true
}return false
}function o(r,q,s){if(!/http(s)?:\/\/.+/.test(q)){if(q.indexOf("//")==0){q=window.location.protocol+q
}else{if(q.charAt(0)=="/"){q=window.location.protocol+"//"+window.location.host+q
}else{if(q.indexOf("://")==-1){q=window.location.protocol+"//"+q
}}}}j[r]=q;
S[r]=!!s
}function U(q){return R[q]
}function C(q,s,r){s=s||"";
R[q]=String(s);
l(q,s,r)
}function B(q,s){function t(x){var z=x?x.rpc:{};
var v=z.parentRelayUrl;
if(v.substring(0,7)!=="http://"&&v.substring(0,8)!=="https://"&&v.substring(0,2)!=="//"){if(typeof D.parent==="string"&&D.parent!==""){if(v.substring(0,1)!=="/"){var u=D.parent.lastIndexOf("/");
v=D.parent.substring(0,u+1)+v
}else{v=N(D.parent)+v
}}}var y=!!z.useLegacyProtocol;
o("..",v,y);
if(y){W=gadgets.rpctx.ifpc;
W.init(n,H)
}var w=s||D.forcesecure||false;
C("..",q,w)
}var r={parentRelayUrl:gadgets.config.NonEmptyStringValidator};
gadgets.config.register("rpc",r,t)
}function k(t,q,u){var r=u||D.forcesecure||false;
var s=q||D.parent;
if(s){o("..",s);
C("..",t,r)
}}function L(s,u,q,t){if(!gadgets.util){return 
}var y=document.getElementById(s);
if(!y){throw new Error("Cannot set up gadgets.rpc receiver with ID: "+s+", element not found.")
}var w=u||y.src;
o(s,w);
var x=gadgets.util.getUrlParameters(y.src);
var r=q||x.rpctoken;
var v=t||x.forcesecure;
C(s,r,v)
}function F(q,s,u,t){if(q===".."){var r=u||D.rpctoken||D.ifpctok||"";
if(window.__isgadget===true){B(r,t)
}else{k(r,s,t)
}}else{L(q,s,u,t)
}}return{config:function(q){if(typeof q.securityCallback==="function"){Y=q.securityCallback
}},register:function(r,q){if(r===a||r===h){throw new Error("Cannot overwrite callback/ack service")
}if(r===g){throw new Error("Cannot overwrite default service: use registerDefault")
}M[r]=q
},unregister:function(q){if(q===a||q===h){throw new Error("Cannot delete callback/ack service")
}if(q===g){throw new Error("Cannot delete default service: use unregisterDefault")
}delete M[q]
},registerDefault:function(q){M[g]=q
},unregisterDefault:function(){delete M[g]
},forceParentVerifiable:function(){if(!W.isParentVerifiable()){W=gadgets.rpctx.ifpc
}},call:function(q,r,w,u){q=q||"..";
var v="..";
if(q===".."){v=O
}++P;
if(w){I[P]=w
}var t={s:r,f:v,c:w?P:0,a:Array.prototype.slice.call(arguments,3),t:R[q],l:S[q]};
if(q!==".."&&!document.getElementById(q)){gadgets.log("WARNING: attempted send to nonexistent frame: "+q);
return 
}if(c(q,t)){return 
}var s=K[q];
if(!s){if(!T[q]){T[q]=[t]
}else{T[q].push(t)
}return 
}if(S[q]){s=gadgets.rpctx.ifpc
}if(s.call(q,v,t)===false){K[q]=f;
W.call(q,v,t)
}},getRelayUrl:function(r){var q=j[r];
if(q&&q.substring(0,1)==="/"){if(q.substring(1,2)==="/"){q=document.location.protocol+q
}else{q=document.location.protocol+"//"+document.location.host+q
}}return q
},setRelayUrl:o,setAuthToken:C,setupReceiver:F,getAuthToken:U,removeReceiver:function(q){delete j[q];
delete S[q];
delete R[q];
delete J[q];
delete e[q];
delete K[q]
},getRelayChannel:function(){return W.getCode()
},receive:function(r,q){if(r.length>4){n(gadgets.json.parse(decodeURIComponent(r[r.length-1])))
}else{G.apply(null,r.concat(q))
}},receiveSameDomain:function(q){q.a=Array.prototype.slice.call(q.a);
window.setTimeout(function(){n(q)
},0)
},getOrigin:N,getReceiverOrigin:function(s){var r=K[s];
if(!r){return null
}if(!r.isParentVerifiable(s)){return null
}var q=gadgets.rpc.getRelayUrl(s)||gadgets.util.getUrlParameters().parent;
return gadgets.rpc.getOrigin(q)
},init:function(){if(W.init(n,H)===false){W=f
}if(Q){F("..")
}},_getTargetWin:p,_createRelayIframe:function(q,s){var v=gadgets.rpc.getRelayUrl("..");
if(!v){return null
}var u=v+"#..&"+O+"&"+q+"&"+encodeURIComponent(gadgets.json.stringify(s));
var r=document.createElement("iframe");
r.style.border=r.style.width=r.style.height="0px";
r.style.visibility="hidden";
r.style.position="absolute";
function t(){document.body.appendChild(r);
r.src='javascript:"<html></html>"';
r.src=u
}if(document.body){t()
}else{gadgets.util.registerOnLoadHandler(function(){t()
})
}return r
},ACK:h,RPC_ID:O,SEC_ERROR_LOAD_TIMEOUT:d,SEC_ERROR_FRAME_PHISH:m,SEC_ERROR_FORGED_MSG:A}
}();
gadgets.rpc.init()
};