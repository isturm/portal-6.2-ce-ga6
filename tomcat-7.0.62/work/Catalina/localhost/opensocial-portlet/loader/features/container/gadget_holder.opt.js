shindig.container.GadgetHolder=function(B,A){this.siteId_=B;
this.el_=A;
this.gadgetInfo_=null;
this.viewParams_=null;
this.renderParams_=null;
this.iframeId_=null;
this.securityToken_=null;
this.onConstructed()
};
shindig.container.GadgetHolder.prototype.onConstructed=function(){};
shindig.container.GadgetHolder.prototype.getElement=function(){return this.el_
};
shindig.container.GadgetHolder.prototype.getIframeId=function(){return this.iframeId_
};
shindig.container.GadgetHolder.prototype.getGadgetInfo=function(){return this.gadgetInfo_
};
shindig.container.GadgetHolder.prototype.dispose=function(){this.gadgetInfo_=null
};
shindig.container.GadgetHolder.prototype.getUrl=function(){return(this.gadgetInfo_)?this.gadgetInfo_.url:null
};
shindig.container.GadgetHolder.prototype.getView=function(){return this.renderParams_[shindig.container.RenderParam.VIEW]
};
shindig.container.GadgetHolder.prototype.getIframeElement=function(){return this.el_.firstChild
};
shindig.container.GadgetHolder.prototype.setSecurityToken=function(A){this.securityToken_=A;
return this
};
shindig.container.GadgetHolder.prototype.render=function(C,A,E){this.iframeId_=shindig.container.GadgetHolder.IFRAME_ID_PREFIX_+this.siteId_;
this.gadgetInfo_=C;
this.viewParams_=A;
this.renderParams_=E;
if(!this.gadgetInfo_[shindig.container.MetadataResponse.VIEWS][this.getView()]){throw"View "+this.view_+" unsupported in "+this.gadgetInfo_.url
}this.el_.innerHTML=this.getIframeHtml_();
var D=shindig.uri(this.gadgetInfo_[shindig.container.MetadataResponse.IFRAME_URL]);
var B=shindig.uri().setSchema(D.getSchema()).setAuthority(D.getAuthority()).setPath("/gadgets/files/container/rpc_relay.html");
gadgets.rpc.setRelayUrl(this.iframeId_,B.toString());
gadgets.rpc.setAuthToken(this.iframeId_,D.getFP("rpctoken"))
};
shindig.container.GadgetHolder.IFRAME_ID_PREFIX_="__gadget_";
shindig.container.GadgetHolder.prototype.getIframeHtml_=function(){var C={id:this.iframeId_,name:this.iframeId_,src:this.getIframeUrl_(),scrolling:"no",marginwidth:"0",marginheight:"0",frameborder:"0",vspace:"0",hspace:"0","class":this.renderParams_[shindig.container.RenderParam.CLASS],height:this.renderParams_[shindig.container.RenderParam.HEIGHT],width:this.renderParams_[shindig.container.RenderParam.WIDTH]};
var A=[];
A.push("<iframe ");
for(var B in C){var D=C[B];
if(D){A.push(B+'="'+D+'" ')
}}A.push("></iframe>");
return A.join("")
};
shindig.container.GadgetHolder.prototype.getIframeUrl_=function(){var B=shindig.uri(this.gadgetInfo_[shindig.container.MetadataResponse.IFRAME_URL]);
B.setQP("debug",this.renderParams_[shindig.container.RenderParam.DEBUG]?"1":"0");
B.setQP("nocache",this.renderParams_[shindig.container.RenderParam.NO_CACHE]?"1":"0");
B.setQP("testmode",this.renderParams_[shindig.container.RenderParam.TEST_MODE]?"1":"0");
B.setQP("view",this.getView());
this.updateUserPrefParams_(B);
B.setQP("parent",window.__CONTAINER_URI.getOrigin());
if(this.securityToken_){B.setExistingP("st",this.securityToken_)
}B.setFP("mid",String(this.siteId_));
if(this.hasViewParams_()){var A=gadgets.json.stringify(this.viewParams_);
B.setFP("view-params",A)
}return B.toString()
};
shindig.container.GadgetHolder.prototype.updateUserPrefParams_=function(E){var D=this.renderParams_[shindig.container.RenderParam.USER_PREFS];
if(D){for(var A in D){var C="up_"+A;
var B=D[A];
if(B instanceof Array){B=B.join("|")
}E.setExistingP(C,B)
}}};
shindig.container.GadgetHolder.prototype.hasViewParams_=function(){for(var A in this.viewParams_){return true
}return false
};