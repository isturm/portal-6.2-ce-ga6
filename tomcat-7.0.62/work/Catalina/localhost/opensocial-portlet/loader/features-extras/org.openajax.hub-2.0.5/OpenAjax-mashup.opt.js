var OpenAjax=OpenAjax||{};
if(!OpenAjax.hub){OpenAjax.hub=function(){var B={};
var A="org.openajax.hub.";
return{implementer:"http://openajax.org",implVersion:"2.0.5",specVersion:"2.0",implExtraData:{},libraries:B,registerLibrary:function(F,E,D,C){B[F]={prefix:F,namespaceURI:E,version:D,extraData:C};
this.publish(A+"registerLibrary",B[F])
},unregisterLibrary:function(C){this.publish(A+"unregisterLibrary",B[C]);
delete B[C]
}}
}();
OpenAjax.hub.Error={BadParameters:"OpenAjax.hub.Error.BadParameters",Disconnected:"OpenAjax.hub.Error.Disconnected",Duplicate:"OpenAjax.hub.Error.Duplicate",NoContainer:"OpenAjax.hub.Error.NoContainer",NoSubscription:"OpenAjax.hub.Error.NoSubscription",NotAllowed:"OpenAjax.hub.Error.NotAllowed",WrongProtocol:"OpenAjax.hub.Error.WrongProtocol",IncompatBrowser:"OpenAjax.hub.Error.IncompatBrowser"};
OpenAjax.hub.SecurityAlert={LoadTimeout:"OpenAjax.hub.SecurityAlert.LoadTimeout",FramePhish:"OpenAjax.hub.SecurityAlert.FramePhish",ForgedMsg:"OpenAjax.hub.SecurityAlert.ForgedMsg"};
OpenAjax.hub._debugger=function(){};
OpenAjax.hub.ManagedHub=function(B){if(!B||!B.onPublish||!B.onSubscribe){throw new Error(OpenAjax.hub.Error.BadParameters)
}this._p=B;
this._onUnsubscribe=B.onUnsubscribe?B.onUnsubscribe:null;
this._scope=B.scope||window;
if(B.log){var A=this;
this._log=function(D){try{B.log.call(A._scope,"ManagedHub: "+D)
}catch(C){OpenAjax.hub._debugger()
}}
}else{this._log=function(){}
}this._subscriptions={c:{},s:null};
this._containers={};
this._seq=0;
this._active=true;
this._isPublishing=false;
this._pubQ=[]
};
OpenAjax.hub.ManagedHub.prototype.subscribeForClient=function(A,B,C){this._assertConn();
if(this._invokeOnSubscribe(B,A)){return this._subscribe(B,this._sendToClient,this,{c:A,sid:C})
}throw new Error(OpenAjax.hub.Error.NotAllowed)
};
OpenAjax.hub.ManagedHub.prototype.unsubscribeForClient=function(A,B){this._unsubscribe(B);
this._invokeOnUnsubscribe(A,B)
};
OpenAjax.hub.ManagedHub.prototype.publishForClient=function(A,B,C){this._assertConn();
this._publish(B,C,A)
};
OpenAjax.hub.ManagedHub.prototype.disconnect=function(){this._active=false;
for(var A in this._containers){this.removeContainer(this._containers[A])
}};
OpenAjax.hub.ManagedHub.prototype.getContainer=function(B){var A=this._containers[B];
return A?A:null
};
OpenAjax.hub.ManagedHub.prototype.listContainers=function(){var A=[];
for(var B in this._containers){A.push(this._containers[B])
}return A
};
OpenAjax.hub.ManagedHub.prototype.addContainer=function(B){this._assertConn();
var A=B.getClientID();
if(this._containers[A]){throw new Error(OpenAjax.hub.Error.Duplicate)
}this._containers[A]=B
};
OpenAjax.hub.ManagedHub.prototype.removeContainer=function(B){var A=B.getClientID();
if(!this._containers[A]){throw new Error(OpenAjax.hub.Error.NoContainer)
}B.remove();
delete this._containers[A]
};
OpenAjax.hub.ManagedHub.prototype.subscribe=function(B,E,D,H,C){this._assertConn();
this._assertSubTopic(B);
if(!E){throw new Error(OpenAjax.hub.Error.BadParameters)
}D=D||window;
if(!this._invokeOnSubscribe(B,null)){this._invokeOnComplete(H,D,null,false,OpenAjax.hub.Error.NotAllowed);
return 
}var F=this;
function G(J,K,M,I){if(F._invokeOnPublish(J,K,I,null)){try{E.call(D,J,K,C)
}catch(L){OpenAjax.hub._debugger();
F._log("caught error from onData callback to Hub.subscribe(): "+L.message)
}}}var A=this._subscribe(B,G,D,C);
this._invokeOnComplete(H,D,A,true);
return A
};
OpenAjax.hub.ManagedHub.prototype.publish=function(A,B){this._assertConn();
this._assertPubTopic(A);
this._publish(A,B,null)
};
OpenAjax.hub.ManagedHub.prototype.unsubscribe=function(A,C,B){this._assertConn();
if(!A){throw new Error(OpenAjax.hub.Error.BadParameters)
}this._unsubscribe(A);
this._invokeOnUnsubscribe(null,A);
this._invokeOnComplete(C,B,A,true)
};
OpenAjax.hub.ManagedHub.prototype.isConnected=function(){return this._active
};
OpenAjax.hub.ManagedHub.prototype.getScope=function(){return this._scope
};
OpenAjax.hub.ManagedHub.prototype.getSubscriberData=function(C){this._assertConn();
var D=C.split(".");
var A=D.pop();
var B=this._getSubscriptionObject(this._subscriptions,D,0,A);
if(B){return B.data
}throw new Error(OpenAjax.hub.Error.NoSubscription)
};
OpenAjax.hub.ManagedHub.prototype.getSubscriberScope=function(C){this._assertConn();
var D=C.split(".");
var A=D.pop();
var B=this._getSubscriptionObject(this._subscriptions,D,0,A);
if(B){return B.scope
}throw new Error(OpenAjax.hub.Error.NoSubscription)
};
OpenAjax.hub.ManagedHub.prototype.getParameters=function(){return this._p
};
OpenAjax.hub.ManagedHub.prototype._sendToClient=function(B,C,D,A){if(!this.isConnected()){return 
}if(this._invokeOnPublish(B,C,A,D.c)){D.c.sendToClient(B,C,D.sid)
}};
OpenAjax.hub.ManagedHub.prototype._assertConn=function(){if(!this.isConnected()){throw new Error(OpenAjax.hub.Error.Disconnected)
}};
OpenAjax.hub.ManagedHub.prototype._assertPubTopic=function(A){if(!A||A===""||(A.indexOf("*")!=-1)||(A.indexOf("..")!=-1)||(A.charAt(0)==".")||(A.charAt(A.length-1)==".")){throw new Error(OpenAjax.hub.Error.BadParameters)
}};
OpenAjax.hub.ManagedHub.prototype._assertSubTopic=function(B){if(!B){throw new Error(OpenAjax.hub.Error.BadParameters)
}var E=B.split(".");
var A=E.length;
for(var C=0;
C<A;
C++){var D=E[C];
if((D==="")||((D.indexOf("*")!=-1)&&(D!="*")&&(D!="**"))){throw new Error(OpenAjax.hub.Error.BadParameters)
}if((D=="**")&&(C<A-1)){throw new Error(OpenAjax.hub.Error.BadParameters)
}}};
OpenAjax.hub.ManagedHub.prototype._invokeOnComplete=function(C,A,B,F,E){if(C){try{A=A||window;
C.call(A,B,F,E)
}catch(D){OpenAjax.hub._debugger();
this._log("caught error from onComplete callback: "+D.message)
}}};
OpenAjax.hub.ManagedHub.prototype._invokeOnPublish=function(B,C,A,E){try{return this._p.onPublish.call(this._scope,B,C,A,E)
}catch(D){OpenAjax.hub._debugger();
this._log("caught error from onPublish callback to constructor: "+D.message)
}return false
};
OpenAjax.hub.ManagedHub.prototype._invokeOnSubscribe=function(B,A){try{return this._p.onSubscribe.call(this._scope,B,A)
}catch(C){OpenAjax.hub._debugger();
this._log("caught error from onSubscribe callback to constructor: "+C.message)
}return false
};
OpenAjax.hub.ManagedHub.prototype._invokeOnUnsubscribe=function(A,C){if(this._onUnsubscribe){var B=C.slice(0,C.lastIndexOf("."));
try{this._onUnsubscribe.call(this._scope,B,A)
}catch(D){OpenAjax.hub._debugger();
this._log("caught error from onUnsubscribe callback to constructor: "+D.message)
}}};
OpenAjax.hub.ManagedHub.prototype._subscribe=function(A,E,D,C){var F=A+"."+this._seq;
var B={scope:D,cb:E,data:C,sid:this._seq++};
var G=A.split(".");
this._recursiveSubscribe(this._subscriptions,G,0,B);
return F
};
OpenAjax.hub.ManagedHub.prototype._recursiveSubscribe=function(A,E,B,D){var C=E[B];
if(B==E.length){D.next=A.s;
A.s=D
}else{if(typeof A.c=="undefined"){A.c={}
}if(typeof A.c[C]=="undefined"){A.c[C]={c:{},s:null};
this._recursiveSubscribe(A.c[C],E,B+1,D)
}else{this._recursiveSubscribe(A.c[C],E,B+1,D)
}}};
OpenAjax.hub.ManagedHub.prototype._publish=function(B,D,A){if(this._isPublishing){this._pubQ.push({t:B,d:D,p:A});
return 
}this._safePublish(B,D,A);
while(this._pubQ.length>0){var C=this._pubQ.shift();
this._safePublish(C.t,C.d,C.p)
}};
OpenAjax.hub.ManagedHub.prototype._safePublish=function(B,C,A){this._isPublishing=true;
var D=B.split(".");
this._recursivePublish(this._subscriptions,D,0,B,C,A);
this._isPublishing=false
};
OpenAjax.hub.ManagedHub.prototype._recursivePublish=function(K,J,G,B,C,E){if(typeof K!="undefined"){var D;
if(G==J.length){D=K
}else{this._recursivePublish(K.c[J[G]],J,G+1,B,C,E);
this._recursivePublish(K.c["*"],J,G+1,B,C,E);
D=K.c["**"]
}if(typeof D!="undefined"){var A=D.s;
while(A){var I=A.scope;
var F=A.cb;
var H=A.data;
if(typeof F=="string"){F=I[F]
}F.call(I,B,C,H,E);
A=A.next
}}}};
OpenAjax.hub.ManagedHub.prototype._unsubscribe=function(B){var C=B.split(".");
var A=C.pop();
if(!this._recursiveUnsubscribe(this._subscriptions,C,0,A)){throw new Error(OpenAjax.hub.Error.NoSubscription)
}};
OpenAjax.hub.ManagedHub.prototype._recursiveUnsubscribe=function(I,H,E,D){if(typeof I=="undefined"){return false
}if(E<H.length){var C=I.c[H[E]];
if(!C){return false
}this._recursiveUnsubscribe(C,H,E+1,D);
if(!C.s){for(var F in C.c){return true
}delete I.c[H[E]]
}}else{var B=I.s;
var A=null;
var G=false;
while(B){if(D==B.sid){G=true;
if(B==I.s){I.s=B.next
}else{A.next=B.next
}break
}A=B;
B=B.next
}if(!G){return false
}}return true
};
OpenAjax.hub.ManagedHub.prototype._getSubscriptionObject=function(A,F,C,B){if(typeof A!="undefined"){if(C<F.length){var D=A.c[F[C]];
return this._getSubscriptionObject(D,F,C+1,B)
}var E=A.s;
while(E){if(B==E.sid){return E
}E=E.next
}}return null
};
OpenAjax.hub._hub=new OpenAjax.hub.ManagedHub({onSubscribe:function(A,B){return true
},onPublish:function(B,C,A,D){return true
}});
OpenAjax.hub.subscribe=function(A,D,C,B){if(typeof D==="string"){C=C||window;
D=C[D]||null
}return OpenAjax.hub._hub.subscribe(A,D,C,null,B)
};
OpenAjax.hub.unsubscribe=function(A){return OpenAjax.hub._hub.unsubscribe(A)
};
OpenAjax.hub.publish=function(A,B){OpenAjax.hub._hub.publish(A,B)
};
OpenAjax.hub.registerLibrary("OpenAjax","http://openajax.org/hub","2.0",{})
};