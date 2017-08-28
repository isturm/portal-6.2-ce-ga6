opensocial=opensocial||{};
opensocial.template=opensocial.template||{};
var os=opensocial.template;
os.log=function(B){var A=window.console;
if(A&&A.log){A.log(B)
}};
window.log=os.log;
os.warn=function(A){os.log("WARNING: "+A)
};
os.isArray=function(A){return typeof (A)=="object"&&typeof (A.length)=="number"&&typeof (A.push)=="function"
};
os.ATT_customtag="customtag";
os.VAR_my="$my";
os.VAR_cur="$cur";
os.VAR_node="$node";
os.VAR_msg="Msg";
os.VAR_parentnode="$parentnode";
os.VAR_uniqueId="$uniqueId";
os.VAR_identifierresolver="$_ir";
os.VAR_emptyArray="$_ea";
os.VAR_callbacks="$callbacks_";
os.EMPTY_ARRAY=[];
os.regExps_={ONLY_WHITESPACE:/^[ \t\n]*$/,VARIABLE_SUBSTITUTION:/^([\w\W]*?)(\$\{[^\}]*\})([\w\W]*)$/};
os.compileTemplate=function(B,D){if(typeof (B)=="string"){return os.compileTemplateString(B,D)
}D=D||B.name;
var C=B.value||B.innerHTML;
C=os.trim(C);
var A=os.compileTemplateString(C,D,B);
if(!B.name){B.name=A.id
}return A
};
os.compileTemplateString=function(C,D,A){C=opensocial.xmlutil.prepareXML(C,A);
var B=gadgets.jsondom.parse(C,D);
return os.compileXMLDoc(B,D)
};
os.renderTemplateNode_=function(C,A){var B=domCloneElement(C);
if(B.removeAttribute){B.removeAttribute(STRING_id)
}jstProcess(A,B);
return B
};
os.elementIdCounter_=0;
os.createTemplateCustomTag=function(A){return function(D,E,C){C.setVariable(os.VAR_my,D);
C.setVariable(os.VAR_node,D);
C.setVariable(os.VAR_uniqueId,os.elementIdCounter_++);
var B=A.render(E,C);
os.markNodeToSkip(B);
return B
}
};
os.computeChildMap_=function(D){var F={};
for(var B=0;
B<D.childNodes.length;
B++){var G=D.childNodes[B];
if(!G.tagName){continue
}var A=G.getAttribute(os.ATT_customtag);
if(A){var E=A.split(":");
E.length==2?A=E[1]:A=E[0]
}else{A=G.tagName
}A=A.toLowerCase();
var C=F[A];
if(!C){F[A]=G
}else{if(os.isArray(C)){C.push(G)
}else{F[A]=[];
F[A].push(C);
F[A].push(G)
}}}return F
};
os.createNodeAccessor_=function(A){return function(B){return os.getValueFromNode_(A,B)
}
};
os.gadgetPrefs_=null;
if(window.gadgets&&window.gadgets["Prefs"]){os.gadgetPrefs_=new window.gadgets["Prefs"]()
}os.getPrefMessage=function(A){if(!os.gadgetPrefs_){return null
}return os.gadgetPrefs_.getMsg(A)
};
os.customAttributes_={};
os.registerAttribute_=function(B,A){os.customAttributes_[B]=A
};
os.doAttribute=function(C,B,D,A){if(!os.customAttributes_.hasOwnProperty(B)){return 
}var E=os.customAttributes_[B];
E(C,C.getAttribute(B),D,A)
};
os.doTag=function(D,I,M,G,A){var E=os.getCustomTag(I,M);
if(!E){os.warn("Custom tag <"+I+":"+M+"> not defined.");
return 
}var K=null;
for(var C=D.firstChild;
C;
C=C.nextSibling){if(C.nodeType==DOM_ELEMENT_NODE){if(K==null){var B=D[PROP_jstcache]?D[PROP_jstcache][ATT_innerselect]:null;
if(B){var G=A.jsexec(B,D);
K=A.clone(G,0,0)
}else{K=A
}}jstProcess(K,C);
os.markNodeToSkip(C)
}}K=A.clone({},0,0);
var L=E.call(null,D,G,K);
if(!L&&typeof (L)!="string"){throw Error("Custom tag <"+I+":"+M+"> failed to return anything.")
}if(typeof (L)=="string"){D.innerHTML=L?L:""
}else{if(os.isArray(L)){os.removeChildren(D);
for(var F=0;
F<L.length;
F++){if(L[F].nodeType==DOM_ELEMENT_NODE||L[F].nodeType==DOM_TEXT_NODE){D.appendChild(L[F]);
if(L[F].nodeType==DOM_ELEMENT_NODE){os.markNodeToSkip(L[F])
}}}}else{var H=A.getVariable(os.VAR_callbacks);
var J=null;
if(L.nodeType==DOM_ELEMENT_NODE){J=L
}else{if(L.root&&L.root.nodeType==DOM_ELEMENT_NODE){J=L.root
}}if(J&&J!=D&&(!J.parentNode||J.parentNode.nodeType==DOM_DOCUMENT_FRAGMENT_NODE)){os.removeChildren(D);
D.appendChild(J);
os.markNodeToSkip(J)
}if(L.onAttach){H.push(L)
}}}};
os.setContextNode_=function(B,A){if(B.nodeType==DOM_ELEMENT_NODE){A.setVariable(os.VAR_node,B)
}};
os.markNodeToSkip=function(A){A.setAttribute(ATT_skip,"true");
A.removeAttribute(ATT_select);
A.removeAttribute(ATT_eval);
A.removeAttribute(ATT_values);
A.removeAttribute(ATT_display);
A[PROP_jstcache]=null;
A.removeAttribute(ATT_jstcache)
};