var JsonRpcContainer=function(C){opensocial.Container.call(this);
var H=C.path;
this.path_=H.replace("%host%",document.location.host);
var F=C.invalidatePath;
this.invalidatePath_=F.replace("%host%",document.location.host);
var G=C.supportedFields;
var E={};
for(var B in G){if(G.hasOwnProperty(B)){E[B]={};
for(var D=0;
D<G[B].length;
D++){var A=G[B][D];
E[B][A]=true
}}}this.environment_=new opensocial.Environment(C.domain,E);
this.securityToken_=shindig.auth.getSecurityToken();
gadgets.rpc.register("shindig.requestShareApp_callback",JsonRpcContainer.requestShareAppCallback_)
};
var JsonRpcRequestItem=function(B,A){this.rpc=B;
this.processData=A||function(C){return C
};
this.processResponse=function(C,F,E,D){var G=E?JsonRpcContainer.translateHttpError(E.code):null;
return new opensocial.ResponseItem(C,E?null:this.processData(F),G,D)
}
};
(function(){var A={};
JsonRpcContainer.inherits(opensocial.Container);
JsonRpcContainer.prototype.getEnvironment=function(){return this.environment_
};
JsonRpcContainer.prototype.requestShareApp=function(F,H,C,D){var E="cId_"+Math.random();
A[E]=C;
var B=gadgets.util.unescapeString(H.getField(opensocial.Message.Field.BODY));
if(!B||B.length===0){var G=gadgets.util.unescapeString(H.getField(opensocial.Message.Field.BODY_ID));
B=gadgets.Prefs.getMsg(G)
}gadgets.rpc.call("..","shindig.requestShareApp",null,E,F,B)
};
JsonRpcContainer.requestShareAppCallback_=function(F,G,C,E){callback=A[F];
if(callback){A[F]=null;
var D=null;
if(E){D={recipientIds:E}
}var B=new opensocial.ResponseItem(null,D,C);
callback(B)
}};
JsonRpcContainer.prototype.requestCreateActivity=function(E,C,B){B=B||function(){};
var D=opensocial.newDataRequest();
var F=opensocial.newIdSpec({userId:"VIEWER"});
D.add(this.newCreateActivityRequest(F,E),"key");
D.send(function(G){B(G.get("key"))
})
};
JsonRpcContainer.prototype.requestData=function(G,K){K=K||function(){};
var E=G.getRequestObjects();
var I=E.length;
if(I===0){window.setTimeout(function(){K(new opensocial.DataResponse({},true))
},0);
return 
}var L=new Array(I);
for(var F=0;
F<I;
F++){var J=E[F];
L[F]=J.request.rpc;
if(J.key){L[F].id=J.key
}}var C=function(X){if(X.errors[0]){JsonRpcContainer.generateErrorResponse(X,E,K);
return 
}X=X.result||X.data;
var N=false;
var W={};
for(var R=0;
R<X.length;
R++){X[X[R].id]=X[R]
}for(var O=0;
O<E.length;
O++){var Q=E[O];
var P=X[O];
if(Q.key&&P.id!==Q.key){throw"Request key("+Q.key+") and response id("+P.id+") do not match"
}var M=P.result||P.data;
var U=P.error;
var T="";
if(U){T=U.message
}var S=Q.request.processResponse(Q.request,M,U,T);
N=N||S.hadError();
if(Q.key){W[Q.key]=S
}}var V=new opensocial.DataResponse(W,N);
K(V)
};
var H={CONTENT_TYPE:"JSON",METHOD:"POST",AUTHORIZATION:"SIGNED",POST_DATA:gadgets.json.stringify(L)};
var B=[this.path_];
var D=shindig.auth.getSecurityToken();
if(D){B.push("?st=",encodeURIComponent(D))
}this.sendRequest(B.join(""),C,H,"application/json")
};
JsonRpcContainer.prototype.sendRequest=function(B,E,C,D){gadgets.io.makeNonProxiedRequest(B,E,C,D)
};
JsonRpcContainer.generateErrorResponse=function(B,E,G){var C=JsonRpcContainer.translateHttpError(B.rc||B.result.error||B.data.error)||opensocial.ResponseItem.Error.INTERNAL_ERROR;
var F={};
for(var D=0;
D<E.length;
D++){F[E[D].key]=new opensocial.ResponseItem(E[D].request,null,C)
}G(new opensocial.DataResponse(F,true))
};
JsonRpcContainer.translateHttpError=function(B){if(B==501){return opensocial.ResponseItem.Error.NOT_IMPLEMENTED
}else{if(B==401){return opensocial.ResponseItem.Error.UNAUTHORIZED
}else{if(B==403){return opensocial.ResponseItem.Error.FORBIDDEN
}else{if(B==400){return opensocial.ResponseItem.Error.BAD_REQUEST
}else{if(B==500){return opensocial.ResponseItem.Error.INTERNAL_ERROR
}else{if(B==404){return opensocial.ResponseItem.Error.BAD_REQUEST
}else{if(B==417){return opensocial.ResponseItem.Error.LIMIT_EXCEEDED
}}}}}}}};
JsonRpcContainer.prototype.makeIdSpec=function(B){return opensocial.newIdSpec({userId:B})
};
JsonRpcContainer.prototype.translateIdSpec=function(B){var E=B.getField("userId");
var D=B.getField("groupId");
if(!opensocial.Container.isArray(E)){E=[E]
}for(var C=0;
C<E.length;
C++){if(E[C]==="OWNER"){E[C]="@owner"
}else{if(E[C]==="VIEWER"){E[C]="@viewer"
}}}if(D==="FRIENDS"){D="@friends"
}else{if(D=="ALL"){D="@all"
}else{if(D==="SELF"||!D){D="@self"
}}}return{userId:E,groupId:D}
};
JsonRpcContainer.prototype.newFetchPersonRequest=function(E,D){var B=this.newFetchPeopleRequest(this.makeIdSpec(E),D);
var C=this;
return new JsonRpcRequestItem(B.rpc,function(F){return C.createPersonFromJson(F,D)
})
};
JsonRpcContainer.prototype.newFetchPeopleRequest=function(B,D){var E={method:"people.get"};
E.params=this.translateIdSpec(B);
FieldTranslations.addAppDataAsProfileFields(D);
FieldTranslations.translateStandardArguments(D,E.params);
FieldTranslations.translateNetworkDistance(B,E.params);
if(D.profileDetail){FieldTranslations.translateJsPersonFieldsToServerFields(D.profileDetail);
E.params.fields=D.profileDetail
}var C=this;
return new JsonRpcRequestItem(E,function(I){var H;
if(I.list){H=I.list
}else{H=[I]
}var G=[];
for(var F=0;
F<H.length;
F++){G.push(C.createPersonFromJson(H[F],D))
}return new opensocial.Collection(G,I.startIndex,I.totalResults)
})
};
JsonRpcContainer.prototype.createPersonFromJson=function(B,C){FieldTranslations.translateServerPersonToJsPerson(B,C);
return new JsonPerson(B)
};
JsonRpcContainer.prototype.getFieldsList=function(B){if(this.hasNoKeys(B)||this.isWildcardKey(B[0])){return[]
}else{return B
}};
JsonRpcContainer.prototype.hasNoKeys=function(B){return !B||B.length===0
};
JsonRpcContainer.prototype.isWildcardKey=function(B){return B==="*"
};
JsonRpcContainer.prototype.newFetchPersonAppDataRequest=function(B,D,C){var E={method:"appdata.get"};
E.params=this.translateIdSpec(B);
E.params.appId="@app";
E.params.fields=this.getFieldsList(D);
FieldTranslations.translateNetworkDistance(B,E.params);
return new JsonRpcRequestItem(E,function(F){return opensocial.Container.escape(F,C,true)
})
};
JsonRpcContainer.prototype.newUpdatePersonAppDataRequest=function(B,C){var D={method:"appdata.update"};
D.params={userId:["@viewer"],groupId:"@self"};
D.params.appId="@app";
D.params.data={};
D.params.data[B]=C;
D.params.fields=B;
return new JsonRpcRequestItem(D)
};
JsonRpcContainer.prototype.newRemovePersonAppDataRequest=function(B){var C={method:"appdata.delete"};
C.params={userId:["@viewer"],groupId:"@self"};
C.params.appId="@app";
C.params.fields=this.getFieldsList(B);
return new JsonRpcRequestItem(C)
};
JsonRpcContainer.prototype.newFetchActivitiesRequest=function(B,C){var D={method:"activities.get"};
D.params=this.translateIdSpec(B);
D.params.appId="@app";
FieldTranslations.translateStandardArguments(C,D.params);
FieldTranslations.translateNetworkDistance(B,D.params);
return new JsonRpcRequestItem(D,function(F){F=F.list;
var G=[];
for(var E=0;
E<F.length;
E++){G.push(new JsonActivity(F[E]))
}return new opensocial.Collection(G)
})
};
JsonRpcContainer.prototype.newActivity=function(B){return new JsonActivity(B,true)
};
JsonRpcContainer.prototype.newAlbum=function(B){return new JsonAlbum(B)
};
JsonRpcContainer.prototype.newMediaItem=function(D,B,C){C=C||{};
C.mimeType=D;
C.url=B;
return new JsonMediaItem(C)
};
JsonRpcContainer.prototype.newCreateActivityRequest=function(B,C){var D={method:"activities.create"};
D.params=this.translateIdSpec(B);
D.params.appId="@app";
FieldTranslations.translateNetworkDistance(B,D.params);
D.params.activity=C.toJsonObject();
return new JsonRpcRequestItem(D)
};
JsonRpcContainer.prototype.invalidateCache=function(){var F={method:"cache.invalidate"};
var C={invalidationKeys:["@viewer"]};
F.params=C;
var E={CONTENT_TYPE:"JSON",METHOD:"POST",AUTHORIZATION:"SIGNED",POST_DATA:gadgets.json.stringify(F)};
var B=[this.invalidatePath_];
var D=shindig.auth.getSecurityToken();
if(D){B.push("?st=",encodeURIComponent(D))
}this.sendRequest(B.join(""),null,E,"application/json")
}
})();
JsonRpcContainer.prototype.newMessage=function(A,B){return new JsonMessage(A,B)
};
JsonRpcContainer.prototype.newMessageCollection=function(A){return new JsonMessageCollection(A)
};
JsonRpcContainer.prototype.newFetchMessageCollectionsRequest=function(A,B){var C={method:"messages.get"};
C.params=this.translateIdSpec(A);
return new JsonRpcRequestItem(C,function(E){E=E.list;
var F=[];
for(var D=0;
D<E.length;
D++){F.push(new JsonMessageCollection(E[D]))
}return new opensocial.Collection(F)
})
};
JsonRpcContainer.prototype.newFetchMessagesRequest=function(A,C,B){var D={method:"messages.get"};
D.params=this.translateIdSpec(A);
D.params.msgCollId=C;
return new JsonRpcRequestItem(D,function(G){G=G.list;
var F=[];
for(var E=0;
E<G.length;
E++){F.push(new JsonMessage(G[E]))
}return new opensocial.Collection(F)
})
};
JsonRpcContainer.prototype.newCreateAlbumRequest=function(B,A){var C={method:"albums.create"};
C.params=this.translateIdSpec(B);
C.params.appId="@app";
C.params.album=A.toJsonObject();
return new JsonRpcRequestItem(C)
};
JsonRpcContainer.prototype.newDeleteAlbumRequest=function(A,B){var C={method:"albums.delete"};
C.params=this.translateIdSpec(A);
C.params.appId="@app";
C.params.albumId=B;
return new JsonRpcRequestItem(C)
};
JsonRpcContainer.prototype.newFetchAlbumsRequest=function(A,B){var C={method:"albums.get"};
C.params=this.translateIdSpec(A);
C.params.appId="@app";
return new JsonRpcRequestItem(C,function(F){F=F.list;
var D=[];
for(var E=0;
E<F.length;
E++){D.push(new JsonAlbum(F[E]))
}return new opensocial.Collection(D)
})
};
JsonRpcContainer.prototype.newCreateMediaItemRequest=function(A,C,B){var D={method:"mediaItems.create"};
D.params=this.translateIdSpec(A);
D.params.appId="@app";
D.params.albumId=C;
D.params.mediaItem=B.toJsonObject();
return new JsonRpcRequestItem(D)
};
JsonRpcContainer.prototype.newFetchMediaItemsRequest=function(A,B,C){var D={method:"mediaItems.get"};
D.params=this.translateIdSpec(A);
D.params.appId="@app";
D.params.albumId=B;
return new JsonRpcRequestItem(D,function(G){G=G.list;
var F=[];
for(var E=0;
E<G.length;
E++){F.push(new JsonMediaItem(G[E]))
}return new opensocial.Collection(F)
})
};