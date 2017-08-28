os.Container={};
os.Container.inlineTemplates_=[];
os.Container.domLoadCallbacks_=null;
os.Container.domLoaded_=false;
os.Container.requiredLibraries_=0;
os.Container.autoProcess_=true;
os.Container.processed_=false;
os.Container.disableAutoProcessing=function(){if(os.Container.processed_){throw Error("Document already processed.")
}os.Container.autoProcess_=false
};
os.disableAutoProcessing=os.Container.disableAutoProcessing;
os.Container.registerDomLoadListener_=function(){var A=window.gadgets;
if(A&&A.util){A.util.registerOnLoadHandler(os.Container.onDomLoad_)
}else{if(typeof (navigator)!="undefined"&&navigator.product&&navigator.product=="Gecko"){window.addEventListener("DOMContentLoaded",os.Container.onDomLoad_,false)
}}if(window.addEventListener){window.addEventListener("load",os.Container.onDomLoad_,false)
}else{if(!document.body){setTimeout(arguments.callee,0);
return 
}var B=window.onload||function(){};
window.onload=function(){B();
os.Container.onDomLoad_()
}
}};
os.Container.onDomLoad_=function(){if(os.Container.domLoaded_){return 
}for(var A=0;
A<os.Container.domLoadCallbacks_.length;
A++){try{os.Container.domLoadCallbacks_[A]()
}catch(B){os.log(B)
}}os.Container.domLoaded_=true
};
os.Container.executeOnDomLoad=function(A){if(os.Container.domLoaded_){setTimeout(A,0)
}else{if(os.Container.domLoadCallbacks_==null){os.Container.domLoadCallbacks_=[];
os.Container.registerDomLoadListener_()
}os.Container.domLoadCallbacks_.push(A)
}};
os.Container.registerDocumentTemplates=function(E){var F=E||document;
var B=F.getElementsByTagName(os.Container.TAG_script_);
for(var C=0;
C<B.length;
++C){var D=B[C];
if(os.Container.isTemplateType_(D.type)){var A=D.getAttribute("tag");
if(A){os.Container.registerTagElement_(D,A)
}else{if(D.getAttribute("name")){os.Container.registerTemplateElement_(D,D.getAttribute("name"))
}}}}};
os.Container.compileInlineTemplates=function(A,G){var H=G||document;
var B=H.getElementsByTagName(os.Container.TAG_script_);
for(var D=0;
D<B.length;
++D){var F=B[D];
if(os.Container.isTemplateType_(F.type)){var C=F.getAttribute("tag");
if(!C||C.length<0){var E=os.compileTemplate(F,C);
if(E){os.Container.inlineTemplates_.push({template:E,node:F})
}else{os.warn("Failed compiling inline template.")
}}}}};
os.Container.getDefaultContext=function(){if((window.gadgets&&gadgets.util.hasFeature("opensocial-data"))||(opensocial.data.getDataContext)){return os.createContext(opensocial.data.getDataContext().getData())
}return os.createContext({})
};
os.Container.renderInlineTemplates=function(H){var J=H||document;
var B=os.Container.getDefaultContext();
var E=os.Container.inlineTemplates_;
for(var G=0;
G<E.length;
++G){var K=E[G].template;
var F=E[G].node;
var A="_T_"+K.id;
var D=true;
var C=J.getElementById(A);
if(!C){C=J.createElement("div");
C.setAttribute("id",A);
F.parentNode.insertBefore(C,F);
D=false
}if((window.gadgets&&gadgets.util.hasFeature("opensocial-data"))||(opensocial.data.DataContext)){var M=F.getAttribute("before")||F.getAttribute("beforeData");
if(M){var N=M.split(/[\, ]+/);
opensocial.data.DataContext.registerListener(N,os.Container.createHideElementClosure(C))
}var I=F.getAttribute("require")||F.getAttribute("requireData");
if(I){var N=I.split(/[\, ]+/);
var L=os.Container.createRenderClosure(K,C);
if("true"==F.getAttribute("autoUpdate")){if(D){opensocial.data.getDataContext().registerDeferredListener_(N,L)
}else{opensocial.data.getDataContext().registerListener(N,L)
}}else{opensocial.data.getDataContext().registerOneTimeListener_(N,L)
}}else{K.renderInto(C,null,B)
}}else{K.renderInto(C,null,B)
}}};
os.Container.createRenderClosure=function(C,B,A,D){var E=function(){var F=D;
var G=A;
if(!F){if(G){F=os.createContext(G)
}else{F=os.Container.getDefaultContext();
G=F.data_
}}C.renderInto(B,G,F)
};
return E
};
os.Container.createHideElementClosure=function(A){var B=function(){displayNone(A)
};
return B
};
os.Container.registerTemplate=function(A){var B=document.getElementById(A);
return os.Container.registerTemplateElement_(B)
};
os.Container.registerTag=function(A){var B=document.getElementById(A);
os.Container.registerTagElement_(B,A)
};
os.Container.renderElement=function(B,D,A){var E=os.getTemplate(D);
if(E){var C=document.getElementById(B);
if(C){E.renderInto(C,A)
}else{os.warn("Element ("+B+") not found to render into.")
}}else{os.warn("Template ("+D+") not registered.")
}};
os.Container.processInlineTemplates=function(A){os.Container.compileInlineTemplates(A);
os.Container.renderInlineTemplates(A)
};
os.Container.processGadget=function(){if(!window.gadgets){return 
}var B=gadgets.util.getFeatureParameters("opensocial-templates");
if(!B){return 
}if(B.disableAutoProcessing&&B.disableAutoProcessing.toLowerCase!="false"){os.Container.autoProcess_=false
}if(B.requireLibrary){if(typeof B.requireLibrary=="string"){os.Container.addRequiredLibrary(B.requireLibrary)
}else{for(var A=0;
A<B.requireLibrary.length;
A++){os.Container.addRequiredLibrary(B.requireLibrary[A])
}}}};
os.Container.executeOnDomLoad(os.Container.processGadget);
os.Container.processWaitingForLibraries_=false;
os.Container.processDocument=function(A,B){if(os.Container.requiredLibraries_>0){os.Container.processWaitingForLibraries_=true;
return 
}os.Container.processWaitingForLibraries_=false;
os.Container.registerDocumentTemplates(B);
os.Container.processInlineTemplates(A,B);
os.Container.processed_=true
};
os.process=os.Container.processDocument;
os.Container.executeOnDomLoad(function(){if(os.Container.autoProcess_){os.Container.processDocument()
}});
os.Container.onLibraryLoad_=function(){if(os.Container.requiredLibraries_>0){os.Container.requiredLibraries_--;
if(os.Container.requiredLibraries_==0&&os.Container.processWaitingForLibraries_){os.Container.processDocument()
}}};
os.Container.addRequiredLibrary=function(A){os.Container.requiredLibraries_++;
os.Loader.loadUrl(A,os.Container.onLibraryLoad_)
};
os.Container.TAG_script_="script";
os.Container.templateTypes_={};
os.Container.templateTypes_["text/os-template"]=true;
os.Container.templateTypes_["text/template"]=true;
os.Container.isTemplateType_=function(A){return os.Container.templateTypes_[A]!=null
};
os.Container.registerTemplateElement_=function(A,C){var B=os.compileTemplate(A,C);
if(B){os.registerTemplate(B)
}else{os.warn("Could not compile template ("+A.id+")")
}return B
};
os.Container.registerTagElement_=function(D,C){var E=os.Container.registerTemplateElement_(D,C);
if(E){var B=C.split(":");
if(B.length==2){var A=os.getNamespace(B[0]);
if(!A){A=os.createNamespace(B[0],null)
}A[B[1]]=os.createTemplateCustomTag(E)
}}};