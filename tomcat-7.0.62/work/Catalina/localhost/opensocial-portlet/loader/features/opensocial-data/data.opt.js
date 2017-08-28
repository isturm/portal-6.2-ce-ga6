opensocial.data.ATTR_KEY="key";
opensocial.data.SCRIPT_TYPE="text/os-data";
opensocial.data.NSMAP={};
opensocial.data.VAR_REGEX=/^([\w\W]*?)(\$\{[^\}]*\})([\w\W]*)$/;
opensocial.data.RequestDescriptor=function(C){this.tagName=C.tagName;
this.tagParts=this.tagName.split(":");
this.attributes={};
this.dependencies=false;
for(var B=0;
B<C.attributes.length;
++B){var A=C.attributes[B].nodeName;
if(A){var D=C.getAttribute(A);
if(A&&D){this.attributes[A]=D;
this.computeNeededKeys_(D)
}}}this.key=this.attributes[opensocial.data.ATTR_KEY];
this.register_()
};
opensocial.data.RequestDescriptor.prototype.hasAttribute=function(A){return !!this.attributes[A]
};
opensocial.data.RequestDescriptor.prototype.getAttribute=function(B){var A=this.attributes[B];
if(!A){return A
}var C=opensocial.data.parseExpression_(A);
if(!C){return A
}return opensocial.data.DataContext.evalExpression(C)
};
opensocial.data.parseExpression_=function(C){if(!C.length){return null
}var A=opensocial.data.VAR_REGEX;
var F=C;
var E=[];
var B=F.match(A);
if(!B){return null
}while(B){if(B[1].length>0){E.push(opensocial.data.transformLiteral_(B[1]))
}var D=B[2].substring(2,B[2].length-1);
E.push("("+D+")");
F=B[3];
B=F.match(A)
}if(F.length>0){E.push(opensocial.data.transformLiteral_(F))
}return E.join("+")
};
opensocial.data.transformLiteral_=function(A){return"'"+A.replace(/'/g,"\\'").replace(/\n/g," ")+"'"
};
opensocial.data.RequestDescriptor.prototype.sendRequest=function(){var B=opensocial.data.NSMAP[this.tagParts[0]];
var A=null;
if(B){A=B[this.tagParts[1]]
}if(!A){throw Error("Data handler undefined for "+this.tagName)
}A(this)
};
opensocial.data.RequestDescriptor.prototype.getSendRequestClosure=function(){var A=this;
return function(){A.sendRequest()
}
};
opensocial.data.RequestDescriptor.prototype.computeNeededKeys_=function(E){var A=opensocial.data.VAR_REGEX;
var B=E.match(A);
while(B){var D=B[2].substring(2,B[2].length-1);
var C=D.split(".")[0];
if(!this.neededKeys){this.neededKeys={}
}this.neededKeys[C]=true;
B=B[3].match(A)
}};
opensocial.data.RequestDescriptor.prototype.register_=function(){opensocial.data.registerRequestDescriptor(this)
};
opensocial.data.DataContext.evalExpression=function(A){return(new Function("context","with (context) return "+A))(opensocial.data.DataContext.getData())
};
opensocial.data.requests_={};
opensocial.data.registerRequestDescriptor=function(A){if(opensocial.data.requests_[A.key]){throw Error("Request already registered for "+A.key)
}opensocial.data.requests_[A.key]=A
};
opensocial.data.currentAPIRequest_=null;
opensocial.data.currentAPIRequestKeys_=null;
opensocial.data.currentAPIRequestCallbacks_=null;
opensocial.data.getCurrentAPIRequest=function(){if(!opensocial.data.currentAPIRequest_){opensocial.data.currentAPIRequest_=opensocial.newDataRequest();
opensocial.data.currentAPIRequestKeys_=[];
opensocial.data.currentAPIRequestCallbacks_={}
}return opensocial.data.currentAPIRequest_
};
opensocial.data.addToCurrentAPIRequest=function(C,B,A){opensocial.data.getCurrentAPIRequest().add(C,B);
opensocial.data.currentAPIRequestKeys_.push(B);
if(A){opensocial.data.currentAPIRequestCallbacks_[B]=A
}window.setTimeout(opensocial.data.sendCurrentAPIRequest_,0)
};
opensocial.data.sendCurrentAPIRequest_=function(){if(opensocial.data.currentAPIRequest_){opensocial.data.currentAPIRequest_.send(opensocial.data.createSharedRequestCallback_());
opensocial.data.currentAPIRequest_=null
}};
opensocial.data.createSharedRequestCallback_=function(){var B=opensocial.data.currentAPIRequestKeys_;
var A=opensocial.data.currentAPIRequestCallbacks_;
return function(C){opensocial.data.onAPIResponse(C,B,A)
}
};
opensocial.data.onAPIResponse=function(C,F,E){for(var B=0;
B<F.length;
B++){var A=F[B];
var D=C.get(A);
if(!D.hadError()){var G=opensocial.data.extractJson_(D,A);
if(E[A]){E[A](A,G)
}else{opensocial.data.DataContext.putDataSet(A,G)
}}}};
opensocial.data.extractJson_=function(E,D){var G=E.getData();
if(G.array_){var A=[];
for(var C=0;
C<G.array_.length;
C++){A.push(G.array_[C].fields_)
}G=A;
var F=opensocial.data.requests_[D];
if(F.tagName=="os:PeopleRequest"){var B=F.getAttribute("groupId");
if((!B||B=="@self")&&G.length==1){G=G[0]
}}}else{G=G.fields_||G
}return G
};
opensocial.data.registerRequestHandler=function(B,D){var A=B.split(":");
var C=opensocial.data.NSMAP[A[0]];
if(!C){if(!opensocial.xmlutil.NSMAP[A[0]]){opensocial.xmlutil.NSMAP[A[0]]=null
}C=opensocial.data.NSMAP[A[0]]={}
}else{if(C[A[1]]){throw Error("Request handler "+A[1]+" is already defined.")
}}C[A[1]]=D
};
opensocial.data.processDocumentMarkup=function(D){var E=D||document;
var A=E.getElementsByTagName("script");
for(var B=0;
B<A.length;
++B){var C=A[B];
if(C.type==opensocial.data.SCRIPT_TYPE){opensocial.data.loadRequests(C)
}}opensocial.data.registerRequestDependencies();
opensocial.data.executeRequests()
};
if(window.gadgets&&window.gadgets["util"]){gadgets.util.registerOnLoadHandler(opensocial.data.processDocumentMarkup)
}opensocial.data.loadRequests=function(A){if(typeof (A)=="string"){opensocial.data.loadRequestsFromMarkup_(A);
return 
}var B=A;
A=B.value||B.innerHTML;
opensocial.data.loadRequestsFromMarkup_(A)
};
opensocial.data.loadRequestsFromMarkup_=function(A){A=opensocial.xmlutil.prepareXML(A);
var C=opensocial.xmlutil.parseXML(A);
var B=C.firstChild;
while(B.nodeType!=1){B=B.nextSibling
}opensocial.data.processDataNode_(B)
};
opensocial.data.processDataNode_=function(A){for(var C=A.firstChild;
C;
C=C.nextSibling){if(C.nodeType==1){var B=new opensocial.data.RequestDescriptor(C)
}}};
opensocial.data.registerRequestDependencies=function(){for(var A in opensocial.data.requests_){var C=opensocial.data.requests_[A];
var E=C.neededKeys;
var D=[];
for(var B in E){if(opensocial.data.DataContext.getDataSet(B)==null&&opensocial.data.requests_[B]){D.push(B)
}}if(D.length>0){opensocial.data.DataContext.registerListener(D,C.getSendRequestClosure());
C.dependencies=true
}}};
opensocial.data.executeRequests=function(){for(var A in opensocial.data.requests_){var B=opensocial.data.requests_[A];
if(!B.dependencies){B.sendRequest()
}}};
opensocial.data.transformSpecialValue=function(A){if(A.substring(0,1)=="@"){return A.substring(1).toUpperCase()
}return A
};
opensocial.data.addFieldsToParams_=function(C,B){if(!B){return 
}var A=B.replace(/(^\s*|\s*$)/g,"").split(/\s*,\s*/);
C[opensocial.DataRequest.PeopleRequestFields.PROFILE_DETAILS]=A
};
(function(){opensocial.data.registerRequestHandler("os:ViewerRequest",function(B){var C={};
opensocial.data.addFieldsToParams_(C,B.getAttribute("fields"));
var A=opensocial.data.getCurrentAPIRequest().newFetchPersonRequest("VIEWER",C);
opensocial.data.addToCurrentAPIRequest(A,B.key)
});
opensocial.data.registerRequestHandler("os:OwnerRequest",function(B){var C={};
opensocial.data.addFieldsToParams_(C,B.getAttribute("fields"));
var A=opensocial.data.getCurrentAPIRequest().newFetchPersonRequest("OWNER",C);
opensocial.data.addToCurrentAPIRequest(A,B.key)
});
opensocial.data.registerRequestHandler("os:PeopleRequest",function(E){var C=E.getAttribute("userId");
var B=E.getAttribute("groupId")||"@self";
var A={};
A.userId=opensocial.data.transformSpecialValue(C);
if(B!="@self"){A.groupId=opensocial.data.transformSpecialValue(B)
}var F={};
opensocial.data.addFieldsToParams_(F,E.getAttribute("fields"));
var D=opensocial.data.getCurrentAPIRequest().newFetchPeopleRequest(opensocial.newIdSpec(A),F);
opensocial.data.addToCurrentAPIRequest(D,E.key)
});
opensocial.data.registerRequestHandler("os:ActivitiesRequest",function(E){var C=E.getAttribute("userId");
var B=E.getAttribute("groupId")||"@self";
var A={};
A.userId=opensocial.data.transformSpecialValue(C);
if(B!="@self"){A.groupId=opensocial.data.transformSpecialValue(B)
}var D=opensocial.data.getCurrentAPIRequest().newFetchActivitiesRequest(opensocial.newIdSpec(A));
opensocial.data.addToCurrentAPIRequest(D,E.key)
});
opensocial.data.registerRequestHandler("os:HttpRequest",function(C){var A=C.getAttribute("href");
var B=C.getAttribute("format")||"json";
var D={};
D[gadgets.io.RequestParameters.CONTENT_TYPE]=B.toLowerCase()=="text"?gadgets.io.ContentType.TEXT:gadgets.io.ContentType.JSON;
D[gadgets.io.RequestParameters.METHOD]=gadgets.io.MethodType.GET;
gadgets.io.makeRequest(A,function(E){opensocial.data.DataContext.putDataSet(C.key,E.data)
},D)
})
})();
(opensocial.data.populateParams_=function(){if(window.gadgets&&gadgets.util.hasFeature("views")){opensocial.data.DataContext.putDataSet("ViewParams",gadgets.views.getParams())
}})();