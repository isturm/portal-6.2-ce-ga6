shindig.uri=(function(){var A=new RegExp("^(?:([^:/?#]+):)?(?://([^/?#]*))?([^?#]*)(?:\\?([^#]*))?(?:#(.*))?");
return function(Y){var R="";
var N="";
var C="";
var H="";
var D=null;
var I="";
var J=null;
var L=window.decodeURIComponent?decodeURIComponent:unescape;
var X=window.encodeURIComponent?encodeURIComponent:escape;
var K=null;
function U(a){if(a.match(A)===null){throw"Malformed URL: "+a
}R=RegExp.$1;
N=RegExp.$2;
C=RegExp.$3;
H=RegExp.$4;
I=RegExp.$5
}function T(f){var e=[];
for(var c=0,a=f.length;
c<a;
++c){var b=f[c][0];
var d=f[c][1];
if(d===undefined){continue
}e.push(X(b)+(d!==null?"="+X(d):""))
}return e.join("&")
}function Q(){if(D){H=T(D);
D=null
}return H
}function Z(){if(J){I=T(J);
J=null
}return I
}function O(a){D=D||F(H);
return S(D,a)
}function W(a){J=J||F(I);
return S(J,a)
}function B(b,a){D=M(D||F(H),b,a);
return K
}function G(b,a){J=M(J||F(I),b,a);
return K
}function V(){return[R,R!==""?":":"",N!==""?"//":"",N].join("")
}function P(){var b=Q();
var a=Z();
return[V(),C,b!==""?"?":"",b,a!==""?"#":"",a].join("")
}function F(h){var g=[];
var f=h.split("&");
for(var c=0,a=f.length;
c<a;
++c){var e=f[c].split("=");
var b=e.shift();
var d=null;
if(e.length>0){d=e.join("").replace(/\+/g," ")
}g.push([b,d!=null?L(d):null])
}return g
}function S(a,d){for(var c=0,b=a.length;
c<b;
++c){if(a[c][0]==d){return a[c][1]
}}return undefined
}function M(e,f,d){var h=f;
if(typeof f==="string"){h={};
h[f]=d
}for(var c in h){var g=false;
for(var b=0,a=e.length;
!g&&b<a;
++b){if(e[b][0]==c){e[b][1]=h[c];
g=true
}}if(!g){e.push([c,h[c]])
}}return e
}function E(b,a){b=b||"";
if(b[0]===a){b=b.substr(a.length)
}return b
}if(typeof Y==="object"&&typeof Y.toString==="function"){U(Y.toString())
}else{if(Y){U(Y)
}}K={getSchema:function(){return R
},getAuthority:function(){return N
},getOrigin:V,getPath:function(){return C
},getQuery:Q,getFragment:Z,getQP:O,getFP:W,setSchema:function(a){R=a;
return K
},setAuthority:function(a){N=a;
return K
},setPath:function(a){C=(a[0]==="/"?"":"/")+a;
return K
},setQuery:function(a){D=null;
H=E(a,"?");
return K
},setFragment:function(a){J=null;
I=E(a,"#");
return K
},setQP:B,setFP:G,setExistingP:function(a,b){if(O(a,b)!==undefined){B(a,b)
}if(W(a,b)!==undefined){G(a,b)
}return K
},toString:P};
return K
}
})();