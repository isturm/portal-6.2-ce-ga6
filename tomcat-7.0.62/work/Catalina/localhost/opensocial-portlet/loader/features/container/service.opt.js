shindig.container.Service=function(A){var B=A||{};
this.apiHost_=String(shindig.container.util.getSafeJsonValue(B,shindig.container.ServiceConfig.API_HOST,window.__API_URI.getOrigin()));
this.apiPath_=String(shindig.container.util.getSafeJsonValue(B,shindig.container.ServiceConfig.API_PATH,"/api/rpc/cs"));
this.sameDomain_=Boolean(shindig.container.util.getSafeJsonValue(B,shindig.container.ServiceConfig.SAME_DOMAIN,false));
this.cachedMetadatas_={};
this.cachedTokens_={};
this.initializeOsapi_();
this.onConstructed(B)
};
shindig.container.Service.prototype.onConstructed=function(A){};
shindig.container.Service.prototype.getGadgetMetadata=function(C,B){var D=B||function(){};
var A=this;
osapi.gadgets.metadata.get(C).execute(function(E){if(E.error){D({error:"Failed to retrieve gadget metadata.",errorCode:"NOLOAD"})
}else{for(var G in E){var F=E[G];
A.cachedMetadatas_[G]=F
}D(E)
}})
};
shindig.container.Service.prototype.getGadgetToken=function(C,B){var D=B||function(){};
var A=this;
osapi.gadgets.token.get(C).execute(function(E){if(E.error){D({error:"Failed to retrieve gadget token.",errorCode:"NOLOAD"})
}else{for(var F in E){A.cachedTokens_[F]=E[F]
}D(E)
}})
};
shindig.container.Service.prototype.getCachedGadgetMetadata=function(A){return this.cachedMetadatas_[A]
};
shindig.container.Service.prototype.getCachedGadgetToken=function(A){return this.cachedTokens_[A]
};
shindig.container.Service.prototype.initializeOsapi_=function(){var B=this.apiHost_+this.apiPath_;
var A={};
A["gadgets.rpc"]=["container.listMethods"];
A[B]=["gadgets.metadata.get","gadgets.token.get"];
gadgets.config.init({osapi:{endPoints:[B]},"osapi.services":A})
};
shindig.container.ServiceConfig={};
shindig.container.ServiceConfig.API_HOST="apiHost";
shindig.container.ServiceConfig.API_PATH="apiPath";