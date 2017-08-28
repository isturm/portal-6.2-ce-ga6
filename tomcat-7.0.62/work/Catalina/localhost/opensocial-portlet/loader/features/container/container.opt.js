shindig.container.Container=function(A){var B=A||{};
this.preloadedGadgetUrls_={};
this.sites_={};
this.renderDebugParam_=String(shindig.container.util.getSafeJsonValue(B,shindig.container.ContainerConfig.RENDER_DEBUG_PARAM,shindig.container.ContainerConfig.RENDER_DEBUG));
var C=window.__CONTAINER_URI.getQP(this.renderDebugParam_);
this.renderDebug_=(typeof C==="undefined")?Boolean(shindig.container.util.getSafeJsonValue(B,shindig.container.ContainerConfig.RENDER_DEBUG,false)):(C==="1");
this.renderTest_=Boolean(shindig.container.util.getSafeJsonValue(B,shindig.container.ContainerConfig.RENDER_TEST,false));
this.tokenRefreshInterval_=Number(shindig.container.util.getSafeJsonValue(B,shindig.container.ContainerConfig.TOKEN_REFRESH_INTERVAL,30*60*1000));
this.service_=new shindig.container.Service(B);
this.tokenRefreshTimer_=null;
this.registerRpcServices_();
this.onConstructed(B)
};
shindig.container.Container.prototype.newGadgetSite=function(C,A){var B=new shindig.container.GadgetSite(this.service_,C,A);
this.sites_[B.getId()]=B;
return B
};
shindig.container.Container.prototype.getGadgetSite=function(C){for(var B in this.sites_){var A=this.sites_[B];
if(A.getGadgetHolder(C)){return A
}}return null
};
shindig.container.Container.prototype.getGadgetHolder=function(B){var A=this.getGadgetSite(B);
if(A){return A.getGadgetHolder(B)
}else{return null
}};
shindig.container.Container.prototype.navigateGadget=function(E,B,A,F,D){var G=D||function(){};
if(this.renderDebug_){F.nocache=true;
F.debug=true
}if(this.renderTest_){F.testmode=true
}var C=this;
E.navigateTo(B,A,F,function(H){if(H[shindig.container.MetadataResponse.NEEDS_TOKEN_REFRESH]){C.scheduleRefreshTokens_()
}G(H)
})
};
shindig.container.Container.prototype.closeGadget=function(A){var B=A.getId();
A.close();
delete this.sites_[B];
this.unscheduleRefreshTokens_()
};
shindig.container.Container.prototype.preloadGadget=function(A){this.preloadGadgets([A])
};
shindig.container.Container.prototype.preloadGadgets=function(B){var C=shindig.container.util.newMetadataRequest(B);
var A=this;
this.service_.getGadgetMetadata(C,function(D){if(!D.error){for(var E in D){A.addPreloadedGadgetUrl_(E);
if(D[E][shindig.container.MetadatResponse.NEEDS_TOKEN_REFRESH]){A.scheduleRefreshTokens_()
}}}})
};
shindig.container.Container.prototype.getGadgetMetadata=function(A,C){var B=shindig.container.util.newMetadataRequest([A]);
this.service_.getGadgetMetadata(B,C)
};
shindig.container.Container.prototype.onConstructed=function(A){};
shindig.container.ContainerConfig={};
shindig.container.ContainerConfig.RENDER_DEBUG="renderDebug";
shindig.container.ContainerConfig.RENDER_DEBUG_PARAM="renderDebugParam";
shindig.container.ContainerConfig.RENDER_TEST="renderTest";
shindig.container.ContainerConfig.TOKEN_REFRESH_INTERVAL="tokenRefreshInterval";
shindig.container.ContainerRender={};
shindig.container.ContainerRender.CLASS="class";
shindig.container.ContainerRender.DEBUG="debug";
shindig.container.ContainerRender.HEIGHT="height";
shindig.container.ContainerRender.TEST="test";
shindig.container.ContainerRender.VIEW="view";
shindig.container.ContainerRender.WIDTH="width";
shindig.container.Container.prototype.scheduleRefreshTokens_=function(){if(this.isRefreshTokensEnabled_()&&!this.tokenRefreshTimer_){var A=this;
this.tokenRefreshTimer_=window.setInterval(function(){A.refreshTokens_()
},this.tokenRefreshInterval_)
}};
shindig.container.Container.prototype.unscheduleRefreshTokens_=function(){if(this.tokenRefreshTimer_){var A=this.getTokenRefreshableGadgetUrls_();
if(A.length<=0){window.clearInterval(this.tokenRefreshTimer_);
this.tokenRefreshTimer_=null
}}};
shindig.container.Container.prototype.isRefreshTokensEnabled_=function(){return this.tokenRefreshInterval_>0
};
shindig.container.Container.prototype.registerRpcServices_=function(){var A=this;
gadgets.rpc.register("resize_iframe",function(B){var C=A.getGadgetSite(this["f"]);
C.setHeight(B)
})
};
shindig.container.Container.prototype.addPreloadedGadgetUrl_=function(A){this.preloadedGadgetUrls_[A]=null
};
shindig.container.Container.prototype.getTokenRefreshableGadgetUrls_=function(){var A={};
for(var B in this.preloadedGadgetUrls_){var D=this.service_.getCachedGadgetMetadata(B);
if(D[shindig.container.MetadataResponse.NEEDS_TOKEN_REFRESH]){A[B]=null
}}for(var E in this.sites_){var C=this.sites_[E].getActiveGadgetHolder();
var B=C.getUrl();
var D=this.service_.getCachedGadgetMetadata(B);
if(D[shindig.container.MetadataResponse.NEEDS_TOKEN_REFRESH]){A[B]=null
}}return shindig.container.util.toArrayOfJsonKeys(A)
};
shindig.container.Container.prototype.refreshTokens_=function(){var B=this.getTokenRefreshableGadgetUrls_();
var C=shindig.container.util.newTokenRequest(B);
var A=this;
this.service_.getGadgetToken(C,function(D){if(!D.error){for(var F in A.sites_){var E=A.sites_[F].getActiveGadgetHolder();
var G=A.service_.getCachedGadgetMetadata(E.getUrl());
if(G[shindig.container.MetadataResponse.NEEDS_TOKEN_REFRESH]){gadgets.rpc.call(E.getIframeId(),"update_security_token",null,D[E.getUrl()][shindig.container.TokenResponse.TOKEN])
}}}})
};