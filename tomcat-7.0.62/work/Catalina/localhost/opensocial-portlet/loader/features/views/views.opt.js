gadgets.views=function(){var E=null;
var B={};
var D={};
function A(H){if(!H){H=window.event
}var G;
if(H.target){G=H.target
}else{if(H.srcElement){G=H.srcElement
}}if(G.nodeType===3){G=G.parentNode
}if(G.nodeName.toLowerCase()==="a"){var F=G.getAttribute("href");
if(F&&F[0]!=="#"&&F.indexOf("://")===-1){gadgets.views.requestNavigateTo(E,F);
if(H.stopPropagation){H.stopPropagation()
}if(H.preventDefault){H.preventDefault()
}H.returnValue=false;
H.cancelBubble=true;
return false
}}return false
}function C(I){var H=I.views||{};
for(var L in H){if(H.hasOwnProperty(L)){if(L!="rewriteLinks"){var M=H[L];
if(!M){continue
}B[L]=new gadgets.views.View(L,M.isOnlyVisible);
var F=M.aliases||[];
for(var K=0,J;
(J=F[K]);
++K){B[J]=new gadgets.views.View(L,M.isOnlyVisible)
}}}}var G=gadgets.util.getUrlParameters();
if(G["view-params"]){D=gadgets.json.parse(G["view-params"])||D
}E=B[G.view]||B["default"];
if(H.rewriteLinks){gadgets.util.attachBrowserEvent(document,"click",A,false)
}}gadgets.config.register("views",null,C);
return{bind:function(W,U){if(typeof W!=="string"){throw new Error("Invalid urlTemplate")
}if(typeof U!=="object"){throw new Error("Invalid environment")
}var R=/^([a-zA-Z0-9][a-zA-Z0-9_\.\-]*)(=([a-zA-Z0-9\-\._~]|(%[0-9a-fA-F]{2}))*)?$/,Y=new RegExp("\\{([^}]*)\\}","g"),V=/^-([a-zA-Z]+)\|([^|]*)\|(.+)$/,M=[],Q=0,K,J,H,P,L,G,N,S;
function I(a,Z){return U.hasOwnProperty(a)?U[a]:Z
}function F(Z){if(!(J=Z.match(R))){throw new Error("Invalid variable : "+Z)
}}function X(d,Z,c){var a,b=d.split(",");
for(a=0;
a<b.length;
++a){F(b[a]);
if(c(Z,I(J[1]),J[1])){break
}}return Z
}function T(Z){if((typeof Z==="object")||(typeof Z==="function")){for(var a in Z){if(Z.hasOwnProperty(a)){return false
}}return true
}return false
}while((K=Y.exec(W))){M.push(W.substring(Q,K.index));
Q=Y.lastIndex;
if((J=K[1].match(R))){H=J[1];
P=J[2]?J[2].substr(1):"";
M.push(I(H,P))
}else{if((J=K[1].match(V))){L=J[1];
G=J[2];
N=J[3];
S=0;
switch(L){case"neg":S=1;
case"opt":if(X(N,{flag:S},function(a,Z){if(typeof Z!=="undefined"&&!T(Z)){a.flag=!a.flag;
return 1
}return 0
}).flag){M.push(G)
}break;
case"join":M.push(X(N,[],function(b,a,Z){if(typeof a==="string"){b.push(Z+"="+a)
}else{if(typeof a==="object"){for(var c in a){if(a.hasOwnProperty(c)){b.push(c+"="+a[c])
}}}}}).join(G));
break;
case"list":F(N);
var O=I(J[1]);
if(typeof O==="object"&&typeof O.join==="function"){M.push(O.join(G))
}break;
case"prefix":S=1;
case"suffix":F(N);
O=I(J[1],J[2]&&J[2].substr(1));
if(typeof O==="string"){M.push(S?G+O:O+G)
}else{if(typeof O==="object"&&typeof O.join==="function"){M.push(S?G+O.join(G):O.join(G)+G)
}}break;
default:throw new Error("Invalid operator : "+L)
}}else{throw new Error("Invalid syntax : "+K[0])
}}}M.push(W.substr(Q));
return M.join("")
},requestNavigateTo:function(F,H,G){if(typeof F!=="string"){F=F.getName()
}gadgets.rpc.call(null,"requestNavigateTo",null,F,H,G)
},getCurrentView:function(){return E
},getSupportedViews:function(){return B
},getParams:function(){return D
}}
}();
gadgets.views.View=function(A,B){this.name_=A;
this.isOnlyVisible_=!!B
};
gadgets.views.View.prototype.getName=function(){return this.name_
};
gadgets.views.View.prototype.getUrlTemplate=function(){return gadgets.config&&gadgets.config.views&&gadgets.config.views[this.name_]&&gadgets.config.views[this.name_].urlTemplate
};
gadgets.views.View.prototype.bind=function(A){return gadgets.views.bind(this.getUrlTemplate(),A)
};
gadgets.views.View.prototype.isOnlyVisibleGadget=function(){return this.isOnlyVisible_
};
gadgets.views.ViewType=gadgets.util.makeEnum(["CANVAS","HOME","PREVIEW","PROFILE","FULL_PAGE","DASHBOARD","POPUP"]);