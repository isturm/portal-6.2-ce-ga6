shindig.errors={};
shindig.errors.SUBCLASS_RESPONSIBILITY="subclass responsibility";
shindig.errors.TO_BE_DONE="to be done";
shindig.callAsyncAndJoin=function(E,A,D){var F=E.length;
var C=[];
for(var B=0;
B<E.length;
B++){var G=function(H){var I=E[H];
if(typeof I==="string"){I=D[I]
}I.call(D,function(J){C[H]=J;
if(--F===0){A(C)
}})
};
G(B)
}};
shindig.Extensible=function(){};
shindig.Extensible.prototype.setDependencies=function(A){for(var B in A){this[B]=A[B]
}};
shindig.Extensible.prototype.getDependencies=function(A){return this[A]
};
shindig.UserPrefStore=function(){};
shindig.UserPrefStore.prototype.getPrefs=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.UserPrefStore.prototype.savePrefs=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.DefaultUserPrefStore=function(){shindig.UserPrefStore.call(this)
};
shindig.DefaultUserPrefStore.inherits(shindig.UserPrefStore);
shindig.DefaultUserPrefStore.prototype.getPrefs=function(A){};
shindig.DefaultUserPrefStore.prototype.savePrefs=function(A){};
shindig.GadgetService=function(){};
shindig.GadgetService.prototype.setHeight=function(B,A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.GadgetService.prototype.setTitle=function(A,B){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.GadgetService.prototype.setUserPref=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.IfrGadgetService=function(){shindig.GadgetService.call(this);
gadgets.rpc.register("resize_iframe",this.setHeight);
gadgets.rpc.register("set_pref",this.setUserPref);
gadgets.rpc.register("set_title",this.setTitle);
gadgets.rpc.register("requestNavigateTo",this.requestNavigateTo);
gadgets.rpc.register("requestSendMessage",this.requestSendMessage)
};
shindig.IfrGadgetService.inherits(shindig.GadgetService);
shindig.IfrGadgetService.prototype.setHeight=function(A){if(A>shindig.container.maxheight_){A=shindig.container.maxheight_
}var B=document.getElementById(this.f);
if(B){B.style.height=A+"px"
}};
shindig.IfrGadgetService.prototype.setTitle=function(B){var A=document.getElementById(this.f+"_title");
if(A){A.innerHTML=B.replace(/&/g,"&amp;").replace(/</g,"&lt;")
}};
shindig.IfrGadgetService.prototype.setUserPref=function(G,B,D){var F=shindig.container.gadgetService.getGadgetIdFromModuleId(this.f);
var E=shindig.container.getGadget(F);
for(var C=1,A=arguments.length;
C<A;
C+=2){this.userPrefs[arguments[C]].value=arguments[C+1]
}E.saveUserPrefs()
};
shindig.IfrGadgetService.prototype.requestSendMessage=function(A,D,B,C){if(B){window.setTimeout(function(){B(new opensocial.ResponseItem(null,null,opensocial.ResponseItem.Error.NOT_IMPLEMENTED,null))
},0)
}};
shindig.IfrGadgetService.prototype.requestNavigateTo=function(A,D){var E=shindig.container.gadgetService.getGadgetIdFromModuleId(this.f);
var B=shindig.container.gadgetService.getUrlForView(A);
if(D){var C=gadgets.json.stringify(D);
if(C.length>0){B+="&appParams="+encodeURIComponent(C)
}}if(B&&document.location.href.indexOf(B)==-1){document.location.href=B
}};
shindig.IfrGadgetService.prototype.getUrlForView=function(A){if(A==="canvas"){return"/canvas"
}else{if(A==="profile"){return"/profile"
}else{return null
}}};
shindig.IfrGadgetService.prototype.getGadgetIdFromModuleId=function(A){return parseInt(A.match(/_([0-9]+)$/)[1],10)
};
shindig.LayoutManager=function(){};
shindig.LayoutManager.prototype.getGadgetChrome=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.StaticLayoutManager=function(){shindig.LayoutManager.call(this)
};
shindig.StaticLayoutManager.inherits(shindig.LayoutManager);
shindig.StaticLayoutManager.prototype.setGadgetChromeIds=function(A){this.gadgetChromeIds_=A
};
shindig.StaticLayoutManager.prototype.getGadgetChrome=function(B){var A=this.gadgetChromeIds_[B.id];
return A?document.getElementById(A):null
};
shindig.FloatLeftLayoutManager=function(A){shindig.LayoutManager.call(this);
this.layoutRootId_=A
};
shindig.FloatLeftLayoutManager.inherits(shindig.LayoutManager);
shindig.FloatLeftLayoutManager.prototype.getGadgetChrome=function(C){var B=document.getElementById(this.layoutRootId_);
if(B){var A=document.createElement("div");
A.className="gadgets-gadget-chrome";
A.style.cssFloat="left";
B.appendChild(A);
return A
}else{return null
}};
shindig.Gadget=function(B){this.userPrefs={};
if(B){for(var A in B){if(B.hasOwnProperty(A)){this[A]=B[A]
}}}if(!this.secureToken){this.secureToken="john.doe:john.doe:appid:cont:url:0:default"
}};
shindig.Gadget.prototype.getUserPrefs=function(){return this.userPrefs
};
shindig.Gadget.prototype.saveUserPrefs=function(){shindig.container.userPrefStore.savePrefs(this)
};
shindig.Gadget.prototype.getUserPrefValue=function(B){var A=this.userPrefs[B];
return typeof (A.value)!="undefined"&&A.value!=null?A.value:A["default"]
};
shindig.Gadget.prototype.render=function(A){if(A){var B=this;
this.getContent(function(C){A.innerHTML=C;
B.finishRender(A)
})
}};
shindig.Gadget.prototype.getContent=function(A){shindig.callAsyncAndJoin(["getTitleBarContent","getUserPrefsDialogContent","getMainContent"],function(B){A(B.join(""))
},this)
};
shindig.Gadget.prototype.getTitleBarContent=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.Gadget.prototype.getUserPrefsDialogContent=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.Gadget.prototype.getMainContent=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.Gadget.prototype.finishRender=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.Gadget.prototype.getAdditionalParams=function(){return""
};
shindig.BaseIfrGadget=function(A){shindig.Gadget.call(this,A);
this.serverBase_="/gadgets/";
this.queryIfrGadgetType_()
};
shindig.BaseIfrGadget.inherits(shindig.Gadget);
shindig.BaseIfrGadget.prototype.GADGET_IFRAME_PREFIX_="remote_iframe_";
shindig.BaseIfrGadget.prototype.CONTAINER="default";
shindig.BaseIfrGadget.prototype.cssClassGadget="gadgets-gadget";
shindig.BaseIfrGadget.prototype.cssClassTitleBar="gadgets-gadget-title-bar";
shindig.BaseIfrGadget.prototype.cssClassTitle="gadgets-gadget-title";
shindig.BaseIfrGadget.prototype.cssClassTitleButtonBar="gadgets-gadget-title-button-bar";
shindig.BaseIfrGadget.prototype.cssClassGadgetUserPrefsDialog="gadgets-gadget-user-prefs-dialog";
shindig.BaseIfrGadget.prototype.cssClassGadgetUserPrefsDialogActionBar="gadgets-gadget-user-prefs-dialog-action-bar";
shindig.BaseIfrGadget.prototype.cssClassTitleButton="gadgets-gadget-title-button";
shindig.BaseIfrGadget.prototype.cssClassGadgetContent="gadgets-gadget-content";
shindig.BaseIfrGadget.prototype.rpcToken=(2147483647*Math.random())|0;
shindig.BaseIfrGadget.prototype.rpcRelay="../container/rpc_relay.html";
shindig.BaseIfrGadget.prototype.getTitleBarContent=function(A){var B=this.hasViewablePrefs_()?'<a href="#" onclick="shindig.container.getGadget('+this.id+').handleOpenUserPrefsDialog();return false;" class="'+this.cssClassTitleButton+'">settings</a> ':"";
A('<div id="'+this.cssClassTitleBar+"-"+this.id+'" class="'+this.cssClassTitleBar+'"><span id="'+this.getIframeId()+'_title" class="'+this.cssClassTitle+'">'+(this.title?this.title:"Title")+'</span> | <span class="'+this.cssClassTitleButtonBar+'">'+B+'<a href="#" onclick="shindig.container.getGadget('+this.id+').handleToggle();return false;" class="'+this.cssClassTitleButton+'">toggle</a></span></div>')
};
shindig.BaseIfrGadget.prototype.getUserPrefsDialogContent=function(A){A('<div id="'+this.getUserPrefsDialogId()+'" class="'+this.cssClassGadgetUserPrefsDialog+'"></div>')
};
shindig.BaseIfrGadget.prototype.setServerBase=function(A){this.serverBase_=A
};
shindig.BaseIfrGadget.prototype.getServerBase=function(){return this.serverBase_
};
shindig.BaseIfrGadget.prototype.getMainContent=function(A){var B=this;
window.setTimeout(function(){B.getMainContent(A)
},0)
};
shindig.BaseIfrGadget.prototype.getIframeId=function(){return this.GADGET_IFRAME_PREFIX_+this.id
};
shindig.BaseIfrGadget.prototype.getUserPrefsDialogId=function(){return this.getIframeId()+"_userPrefsDialog"
};
shindig.BaseIfrGadget.prototype.getUserPrefsParams=function(){var B="";
for(var A in this.getUserPrefs()){B+="&up_"+encodeURIComponent(A)+"="+encodeURIComponent(this.getUserPrefValue(A))
}return B
};
shindig.BaseIfrGadget.prototype.handleToggle=function(){var B=document.getElementById(this.getIframeId());
if(B){var A=B.parentNode;
var C=A.style.display;
A.style.display=C?"":"none"
}};
shindig.BaseIfrGadget.prototype.hasViewablePrefs_=function(){for(var B in this.getUserPrefs()){var A=this.userPrefs[B];
if(A.type!="hidden"){return true
}}return false
};
shindig.BaseIfrGadget.prototype.handleOpenUserPrefsDialog=function(){if(this.userPrefsDialogContentLoaded){this.showUserPrefsDialog()
}else{var C=this;
var B="ig_callback_"+this.id;
window[B]=function(D){C.userPrefsDialogContentLoaded=true;
C.buildUserPrefsDialog(D);
C.showUserPrefsDialog()
};
var A=document.createElement("script");
A.src="http://www.gmodules.com/ig/gadgetsettings?mid="+this.id+"&output=js"+this.getUserPrefsParams()+"&url="+this.specUrl;
document.body.appendChild(A)
}};
shindig.BaseIfrGadget.prototype.buildUserPrefsDialog=function(A){var B=document.getElementById(this.getUserPrefsDialogId());
B.innerHTML=A+'<div class="'+this.cssClassGadgetUserPrefsDialogActionBar+'"><input type="button" value="Save" onclick="shindig.container.getGadget('+this.id+').handleSaveUserPrefs()"> <input type="button" value="Cancel" onclick="shindig.container.getGadget('+this.id+').handleCancelUserPrefs()"></div>';
B.childNodes[0].style.display=""
};
shindig.BaseIfrGadget.prototype.showUserPrefsDialog=function(A){var B=document.getElementById(this.getUserPrefsDialogId());
B.style.display=(A||A===undefined)?"":"none"
};
shindig.BaseIfrGadget.prototype.hideUserPrefsDialog=function(){this.showUserPrefsDialog(false)
};
shindig.BaseIfrGadget.prototype.handleSaveUserPrefs=function(){this.hideUserPrefsDialog();
var A=document.getElementById("m_"+this.id+"_numfields").value;
for(var D=0;
D<A;
D++){var B=document.getElementById("m_"+this.id+"_"+D);
var F="m_"+this.id+"_up_";
var C=B.name.substring(F.length);
var E=B.value;
this.userPrefs[C].value=E
}this.saveUserPrefs();
this.refresh()
};
shindig.BaseIfrGadget.prototype.handleCancelUserPrefs=function(){this.hideUserPrefsDialog()
};
shindig.BaseIfrGadget.prototype.refresh=function(){var A=this.getIframeId();
document.getElementById(A).src=this.getIframeUrl()
};
shindig.BaseIfrGadget.prototype.queryIfrGadgetType_=function(){var C={context:{country:"default",language:"default",view:"default",container:"default"},gadgets:[{url:this.specUrl,moduleId:1}]};
var B={CONTENT_TYPE:"JSON",METHOD:"POST",POST_DATA:gadgets.json.stringify(C)};
var A=this.serverBase_+"metadata?st="+this.secureToken;
gadgets.io.makeNonProxiedRequest(A,D,B,"application/javascript");
var E=this;
function D(J){var K=false;
var F=J.data.gadgets[0].features;
for(var H=0;
H<F.length;
H++){if(F[H]==="pubsub-2"){K=true;
break
}}var I=K?shindig.OAAIfrGadget:shindig.IfrGadget;
for(var G in I){if(I.hasOwnProperty(G)){E[G]=I[G]
}}}};
shindig.IfrGadget={getMainContent:function(A){var B=this.getIframeId();
gadgets.rpc.setRelayUrl(B,this.serverBase_+this.rpcRelay);
gadgets.rpc.setAuthToken(B,this.rpcToken);
A('<div class="'+this.cssClassGadgetContent+'"><iframe id="'+B+'" name="'+B+'" class="'+this.cssClassGadget+'" src="about:blank" frameborder="no" scrolling="no"'+(this.height?' height="'+this.height+'"':"")+(this.width?' width="'+this.width+'"':"")+"></iframe></div>")
},finishRender:function(A){window.frames[this.getIframeId()].location=this.getIframeUrl()
},getIframeUrl:function(){return this.serverBase_+"ifr?container="+this.CONTAINER+"&mid="+this.id+"&nocache="+shindig.container.nocache_+"&country="+shindig.container.country_+"&lang="+shindig.container.language_+"&view="+shindig.container.view_+(this.specVersion?"&v="+this.specVersion:"")+(shindig.container.parentUrl_?"&parent="+encodeURIComponent(shindig.container.parentUrl_):"")+(this.debug?"&debug=1":"")+this.getAdditionalParams()+this.getUserPrefsParams()+(this.secureToken?"&st="+this.secureToken:"")+"&url="+encodeURIComponent(this.specUrl)+"#rpctoken="+this.rpcToken+(this.viewParams?"&view-params="+encodeURIComponent(gadgets.json.stringify(this.viewParams)):"")+(this.hashData?"&"+this.hashData:"")
}};
shindig.OAAIfrGadget={getMainContent:function(A){A('<div id="'+this.cssClassGadgetContent+"-"+this.id+'" class="'+this.cssClassGadgetContent+'"></div>')
},finishRender:function(A){var B={className:this.cssClassGadget,frameborder:"no",scrolling:"no"};
if(this.height){B.height=this.height
}if(this.width){B.width=this.width
}new OpenAjax.hub.IframeContainer(gadgets.pubsub2router.hub,this.getIframeId(),{Container:{onSecurityAlert:function(D,C){gadgets.error("Security error for container "+D.getClientID()+" : "+C);
D.getIframe().src="about:blank"
}},IframeContainer:{parent:document.getElementById(this.cssClassGadgetContent+"-"+this.id),uri:this.getIframeUrl(),tunnelURI:shindig.uri(this.serverBase_+this.rpcRelay).resolve(shindig.uri(window.location.href)),iframeAttrs:B}})
},getIframeUrl:function(){return this.serverBase_+"ifr?container="+this.CONTAINER+"&mid="+this.id+"&nocache="+shindig.container.nocache_+"&country="+shindig.container.country_+"&lang="+shindig.container.language_+"&view="+shindig.container.view_+(this.specVersion?"&v="+this.specVersion:"")+(this.debug?"&debug=1":"")+this.getAdditionalParams()+this.getUserPrefsParams()+(this.secureToken?"&st="+this.secureToken:"")+"&url="+encodeURIComponent(this.specUrl)+(this.viewParams?"&view-params="+encodeURIComponent(gadgets.json.stringify(this.viewParams)):"")+(this.hashData?"#"+this.hashData:"")
}};
shindig.Container=function(){this.gadgets_={};
this.parentUrl_=document.location.href+"://"+document.location.host;
this.country_="ALL";
this.language_="ALL";
this.view_="default";
this.nocache_=1;
this.maxheight_=2147483647
};
shindig.Container.inherits(shindig.Extensible);
shindig.Container.prototype.gadgetClass=shindig.Gadget;
shindig.Container.prototype.userPrefStore=new shindig.DefaultUserPrefStore();
shindig.Container.prototype.gadgetService=new shindig.GadgetService();
shindig.Container.prototype.layoutManager=new shindig.StaticLayoutManager();
shindig.Container.prototype.setParentUrl=function(A){this.parentUrl_=A
};
shindig.Container.prototype.setCountry=function(A){this.country_=A
};
shindig.Container.prototype.setNoCache=function(A){this.nocache_=A
};
shindig.Container.prototype.setLanguage=function(A){this.language_=A
};
shindig.Container.prototype.setView=function(A){this.view_=A
};
shindig.Container.prototype.setMaxHeight=function(A){this.maxheight_=A
};
shindig.Container.prototype.getGadgetKey_=function(A){return"gadget_"+A
};
shindig.Container.prototype.getGadget=function(A){return this.gadgets_[this.getGadgetKey_(A)]
};
shindig.Container.prototype.createGadget=function(A){return new this.gadgetClass(A)
};
shindig.Container.prototype.addGadget=function(A){A.id=this.getNextGadgetInstanceId();
this.gadgets_[this.getGadgetKey_(A.id)]=A
};
shindig.Container.prototype.addGadgets=function(A){for(var B=0;
B<A.length;
B++){this.addGadget(A[B])
}};
shindig.Container.prototype.renderGadgets=function(){for(var A in this.gadgets_){this.renderGadget(this.gadgets_[A])
}};
shindig.Container.prototype.renderGadget=function(A){throw Error(shindig.errors.SUBCLASS_RESPONSIBILITY)
};
shindig.Container.prototype.nextGadgetInstanceId_=0;
shindig.Container.prototype.getNextGadgetInstanceId=function(){return this.nextGadgetInstanceId_++
};
shindig.Container.prototype.refreshGadgets=function(){for(var A in this.gadgets_){this.gadgets_[A].refresh()
}};
shindig.IfrContainer=function(){shindig.Container.call(this)
};
shindig.IfrContainer.inherits(shindig.Container);
shindig.IfrContainer.prototype.gadgetClass=shindig.BaseIfrGadget;
shindig.IfrContainer.prototype.gadgetService=new shindig.IfrGadgetService();
shindig.IfrContainer.prototype.setParentUrl=function(A){if(!A.match(/^http[s]?:\/\//)){A=document.location.href.match(/^[^?#]+\//)[0]+A
}this.parentUrl_=A
};
shindig.IfrContainer.prototype.renderGadget=function(B){var A=this.layoutManager.getGadgetChrome(B);
B.render(A)
};
shindig.container=new shindig.IfrContainer();