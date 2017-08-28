os.createContext=function(D,F){var A=JsEvalContext.create(D);
A.setVariable(os.VAR_callbacks,[]);
var E=os.getContextDefaults_();
for(var C in E){if(E.hasOwnProperty(C)){A.setVariable(C,E[C])
}}A.setVariable(os.VAR_emptyArray,os.EMPTY_ARRAY);
if(F){for(var B in F){if(F.hasOwnproperty(B)){A.setVariable(B,F[B])
}}}return A
};
os.contextDefaults_=null;
os.getContextDefaults_=function(){if(!os.contextDefaults_){os.contextDefaults_={};
os.contextDefaults_[os.VAR_emptyArray]=os.EMPTY_ARRAY;
os.contextDefaults_[os.VAR_identifierresolver]=os.getFromContext;
if(window.JSON&&JSON.parse){os.contextDefaults_["osx:parseJson"]=JSON.parse
}else{if(window.gadgets&&gadgets.json&&gadgets.json.parse){os.contextDefaults_["osx:parseJson"]=gadgets.json.parse
}}}return os.contextDefaults_
};
os.Template=function(A){this.templateRoot_=document.createElement("span");
this.id=A||("template_"+os.Template.idCounter_++)
};
os.Template.idCounter_=0;
os.registeredTemplates_={};
os.registerTemplate=function(A){os.registeredTemplates_[A.id]=A
};
os.unRegisterTemplate=function(A){delete os.registeredTemplates_[A.id]
};
os.getTemplate=function(A){return os.registeredTemplates_[A]
};
os.Template.prototype.setCompiledNode_=function(A){os.removeChildren(this.templateRoot_);
this.templateRoot_.appendChild(A)
};
os.Template.prototype.setCompiledNodes_=function(A){os.removeChildren(this.templateRoot_);
for(var B=0;
B<A.length;
B++){this.templateRoot_.appendChild(A[B])
}};
os.Template.prototype.render=function(A,B){if(!B){B=os.createContext(A)
}return os.renderTemplateNode_(this.templateRoot_,B)
};
os.Template.prototype.renderInto=function(C,B,D){if(!D){D=os.createContext(B)
}var A=this.render(B,D);
os.removeChildren(C);
os.appendChildren(A,C);
os.fireCallbacks(D)
};