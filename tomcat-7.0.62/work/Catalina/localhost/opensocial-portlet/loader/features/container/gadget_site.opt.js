shindig.container.GadgetSite=function(B,C,A){this.service_=B;
this.currentGadgetEl_=C;
this.loadingGadgetEl_=A||null;
this.id_=shindig.container.GadgetSite.nextUniqueId_++;
this.parentId_=null;
this.currentGadgetHolder_=null;
this.loadingGadgetHolder_=null;
this.onConstructed()
};
shindig.container.GadgetSite.prototype.onConstructed=function(){};
shindig.container.GadgetSite.prototype.setHeight=function(C){var A=this.getActiveGadgetHolder();
if(A){var B=A.getIframeElement();
if(B){B.style.height=C+"px"
}}return this
};
shindig.container.GadgetSite.prototype.setWidth=function(C){var A=this.getActiveGadgetHolder();
if(A){var B=A.getIframeElement();
if(B){B.style.width=C+"px"
}}return this
};
shindig.container.GadgetSite.prototype.setParentId=function(A){this.parentId_=A;
return this
};
shindig.container.GadgetSite.prototype.getId=function(){return this.id_
};
shindig.container.GadgetSite.prototype.getActiveGadgetHolder=function(){return this.loadingGadgetHolder_||this.currentGadgetHolder_
};
shindig.container.GadgetSite.prototype.getFeature=function(A,B){var C=B||this.getActiveGadgetHolder().getGadgetInfo();
return C[shindig.container.MetadataResponse.FEATURES]&&C[shindig.container.MetadataResponse.FEATURES][A]
};
shindig.container.GadgetSite.prototype.getGadgetHolder=function(A){if(this.currentGadgetHolder_&&this.currentGadgetHolder_.getIframeId()==A){return this.currentGadgetHolder_
}if(this.loadingGadgetHolder_&&this.loadingGadgetHolder_.getIframeId()==A){return this.loadingGadgetHolder_
}return null
};
shindig.container.GadgetSite.prototype.getParentId=function(){return this.parentId_
};
shindig.container.GadgetSite.prototype.navigateTo=function(B,A,G,D){var H=D||function(){};
var E=this.service_.getCachedGadgetMetadata(B);
if(E){this.render(E,A,G);
H(E)
}else{var F=shindig.container.util.newMetadataRequest([B]);
var C=this;
this.service_.getGadgetMetadata(F,function(I){if(!I.error){var J=I[B];
C.render(J,A,G);
H(J)
}else{H(I)
}})
}};
shindig.container.GadgetSite.prototype.render=function(H,K,C){var F=this.currentGadgetHolder_?this.currentGadgetHolder_.getUrl():null;
var D=null;
if(F==H.url){D=this.currentGadgetHolder_.getView()
}var B=this.loadingGadgetEl_||this.currentGadgetEl_;
this.loadingGadgetHolder_=new shindig.container.GadgetHolder(this.id_,B);
var G=C[shindig.container.RenderParam.VIEW]||K[shindig.container.ViewParam.VIEW]||D||"default";
var J=H[shindig.container.MetadataResponse.VIEWS][G];
var A=this.getFeature("loadstate",H)||this.getFeature("shell",H);
var E={};
for(var I in C){E[I]=C[I]
}if(A){E[shindig.container.RenderParam.HEIGHT]="0"
}E[shindig.container.RenderParam.VIEW]=G;
E[shindig.container.RenderParam.HEIGHT]=C[shindig.container.RenderParam.HEIGHT]||J[shindig.container.MetadataResponse.PREFERRED_HEIGHT]||H[shindig.container.MetadataResponse.MODULE_PREFS][shindig.container.MetadataResponse.HEIGHT]||String(shindig.container.GadgetSite.DEFAULT_HEIGHT_);
E[shindig.container.RenderParam.WIDTH]=C[shindig.container.RenderParam.WIDTH]||J[shindig.container.MetadataResponse.PREFERRED_WIDTH]||H[shindig.container.MetadataResponse.MODULE_PREFS][shindig.container.MetadataResponse.WIDTH]||String(shindig.container.GadgetSite.DEFAULT_WIDTH_);
this.updateSecurityToken_(H,E);
this.loadingGadgetHolder_.render(H,K,E);
this.loaded_=false;
this.resizeOnLoad_=A;
if(!A){this.setLoadState_("loaded")
}};
shindig.container.GadgetSite.prototype.rpcCall=function(A,C,B){if(this.currentGadgetHolder_){gadgets.rpc.call(this.currentGadgetHolder_.getIframeId(),A,C,B)
}};
shindig.container.GadgetSite.prototype.updateSecurityToken_=function(C,D){var A=this.service_.getCachedGadgetToken(C.url);
if(A){var B=A[shindig.container.TokenResponse.TOKEN];
this.loadingGadgetHolder_.setSecurityToken(B)
}};
shindig.container.GadgetSite.prototype.close=function(){if(this.loadingGadgetEl_&&this.loadingGadgetEl_.firstChild){this.loadingGadgetEl_.removeChild(this.loadingGadgetEl_.firstChild)
}if(this.currentGadgetEl_&&this.currentGadgetEl_.firstChild){this.currentGadgetEl_.removeChild(this.currentGadgetEl_.firstChild)
}if(this.loadingGadgetHolder_){this.loadingGadgetHolder_.dispose()
}if(this.currentGadgetHolder_){this.currentGadgetHolder_.dispose()
}};
shindig.container.GadgetSite.nextUniqueId_=0;
shindig.container.GadgetSite.prototype.setLoadState_=function(A){if(!this.loaded_&&A=="loaded"){this.onload_()
}};
shindig.container.GadgetSite.prototype.onload_=function(){this.loaded_=true;
try{gadgets.rpc.call(this.loadingGadgetHolder_.getIframeId(),"onLoad",null);
if(this.resizeOnLoad_){this.setHeight()
}}catch(A){gadgets.log(A)
}this.swapBuffers_();
if(this.currentGadgetHolder_){this.currentGadgetHolder_.dispose()
}this.currentGadgetHolder_=this.loadingGadgetHolder_;
this.loadingGadgetHolder_=null
};
shindig.container.GadgetSite.prototype.swapBuffers_=function(){if(this.loadingGadgetEl_){this.loadingGadgetEl_.style.left="";
this.loadingGadgetEl_.style.position="";
this.currentGadgetEl_.style.position="absolute";
this.currentGadgetEl_.style.left="-2000px";
var A=this.currentGadgetEl_;
this.currentGadgetEl_=this.loadingGadgetEl_;
this.loadingGadgetEl_=A
}};
shindig.container.GadgetSite.DEFAULT_HEIGHT_=200;
shindig.container.GadgetSite.DEFAULT_WIDTH_=320;