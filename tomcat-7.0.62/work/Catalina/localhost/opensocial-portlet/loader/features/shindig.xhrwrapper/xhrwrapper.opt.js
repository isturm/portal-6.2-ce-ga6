shindig.xhrwrapper=shindig.xhrwrapper||{};
(function(){var H=window.XMLHttpRequest;
var I=window.ActiveXObject;
shindig.xhrwrapper.createXHR=function(){var M=["MSXML2.XMLHTTP.6.0","MSXML2.XMLHTTP.3.0","MSXML2.XMLHTTP"];
if(typeof I!="undefined"){for(var N=0;
N<M.length;
N++){try{return new I(M[N])
}catch(L){}}}if(typeof H!="undefined"){return new H()
}return undefined
};
shindig.xhrwrapper.XhrWrapper=function(){this.config_=E.gadgets.config.get("shindig.xhrwrapper");
this.onreadystatechange=null;
this.readyState=0
};
shindig.xhrwrapper.XhrWrapper.prototype.abort=function(){this.aborted_=true
};
shindig.xhrwrapper.XhrWrapper.prototype.getAllResponseHeaders=function(){if(!this.responseHeaders_){return null
}var L="";
for(var M in this.responseHeaders_){L+=M+": "+this.responseHeaders_[M]+"\n"
}return L
};
shindig.xhrwrapper.XhrWrapper.prototype.getResponseHeader=function(M){if(!this.responseHeaders_){return null
}var L=this.responseHeaders_[M.toLowerCase()];
return L?L:null
};
shindig.xhrwrapper.XhrWrapper.prototype.open=function(N,M,L){this.method_=N;
this.url_=new C(M);
this.aborted_=false;
this.requestHeaders_={};
this.responseHeaders_={};
this.baseUrl_=new C(this.config_.contentUrl);
this.fixRequestUrl_();
if(!this.baseUrl_.hasSameOrigin(this.url_)){throw new Error("A gadget at "+this.config_.contentUrl+" tried to access "+M+" via XMLHttpRequest.")
}if(L===false){throw new Error("xhrwrapper does not support synchronous XHR.")
}this.multipart=false;
this.readyState=1;
this.responseText=null;
this.responseXML=null;
this.status=0;
this.statusText=null
};
shindig.xhrwrapper.XhrWrapper.prototype.send=function(L){B();
try{this.aborted_=false;
var M=this;
var O={};
O[gadgets.io.RequestParameters.METHOD]=this.method_;
O[gadgets.io.RequestParameters.HEADERS]=this.requestHeaders_;
O[gadgets.io.RequestParameters.GET_FULL_HEADERS]=true;
O[gadgets.io.RequestParameters.POST_DATA]=L;
if(this.config_.authorization){if(this.config_.authorization=="oauth"){O[gadgets.io.RequestParameters.AUTHORIZATION]=gadgets.io.AuthorizationType.OAUTH;
O[gadgets.io.RequestParameters.OAUTH_SERVICE_NAME]=this.config_.oauthService;
if(this.config_.oauthTokenName){O[gadgets.io.RequestParameters.OAUTH_TOKEN_NAME]=this.config_.oauthTokenName
}}else{if(this.config_.authorization=="signed"){O[gadgets.io.RequestParameters.AUTHORIZATION]=gadgets.io.AuthorizationType.SIGNED
}}}gadgets.io.makeRequest(this.url_.toString(),function(P){M.callback_(P)
},O)
}catch(N){throw N
}finally{J()
}};
shindig.xhrwrapper.XhrWrapper.prototype.setRequestHeader=function(M,L){this.requestHeaders_[M]=L
};
shindig.xhrwrapper.XhrWrapper.prototype.callback_=function(M){if(this.aborted_){return 
}this.readyState=4;
this.responseHeaders_=M.headers;
this.responseText=M.text;
B();
try{this.responseXML=opensocial.xmlutil.parseXML(M.text)
}catch(L){this.responseXML=null
}finally{J()
}this.status=M.rc;
if(M.errors){this.statusText=M.errors[0]
}if(this.onreadystatechange){var N={};
N.type="readystatechange";
N.srcElement=this;
N.target=this;
this.onreadystatechange(N)
}};
shindig.xhrwrapper.XhrWrapper.prototype.fixRequestUrl_=function(){this.url_.fullyQualify(this.baseUrl_);
var M=new C(window.location.href);
if(this.url_.hasSameOrigin(M)){this.url_.schema=this.baseUrl_.schema;
this.url_.authority=this.baseUrl_.authority;
var L=M.path.length;
if(this.url_.path.substr(0,L)==M.path){this.url_.path=this.baseUrl_.path+this.url_.path.substr(L)
}}};
function C(O){this.schema="";
this.authority="";
this.path="";
this.filename="";
this.query="";
this.fragment="";
var R=O;
var Q=R.indexOf("#");
if(Q!=-1){this.fragment=R.substr(Q);
R=R.substr(0,Q)
}var N=R.indexOf("?");
if(N!=-1){this.query=R.substr(N);
R=R.substr(0,N)
}var P=R.indexOf("//");
if(P!=-1){this.schema=R.substr(0,P);
R=R.substr(P+2);
var M=R.indexOf("/");
if(M!=-1){this.authority=R.substr(0,M);
R=R.substr(M)
}else{this.authority=R;
R=""
}}var L=R.lastIndexOf("/");
if(L!=-1){this.path=R.substr(0,L+1);
R=R.substr(L+1)
}this.filename=R
}C.prototype.hasSameOrigin=function(L){return this.schema==L.schema&&this.authority==L.authority
};
C.prototype.fullyQualify=function(L){if(this.schema==""){this.schema=L.schema
}if(this.authority==""){this.authority=L.authority;
if(this.path==""||this.path[0]!="/"){this.path=L.path+this.path
}}};
C.prototype.toString=function(){var L="";
if(this.schema){L+=this.schema
}if(this.authority){L+="//"+this.authority
}if(this.path){L+=this.path
}if(this.filename){L+=this.filename
}if(this.query){L+=this.query
}if(this.fragment){L+=this.fragment
}return L
};
function K(L){var N;
if(typeof L=="string"&&(L.substr(0,14).toLowerCase()=="msxml2.xmlhttp"||L.toLowerCase()=="microsoft.xmlhttp")){N=new shindig.xhrwrapper.XhrWrapper()
}else{N=new I(L)
}for(var M in N){this[M]=N[M]
}}var E={};
var A={};
var D=["gadgets","opensocial","shindig"];
function G(Q,P){var O=Q?Q:this;
var L=P?P:this;
for(var M in D){var N=D[M];
if(typeof O[N]!="undefined"){L[N]=O[N]
}}}function B(){G(null,A);
G(E,null)
}function J(){G(A,null)
}G(null,E);
if(window.XMLHttpRequest){window.XMLHttpRequest=shindig.xhrwrapper.XhrWrapper
}if(window.ActiveXObject){window.ActiveXObject=K
}var F={contentUrl:gadgets.config.NonEmptyStringValidator};
gadgets.config.register("shindig.xhrwrapper",F)
})();