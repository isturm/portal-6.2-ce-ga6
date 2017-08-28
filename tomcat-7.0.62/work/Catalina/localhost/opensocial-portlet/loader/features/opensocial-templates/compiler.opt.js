os.SEMICOLON=";";
os.isIe=navigator.userAgent.indexOf("Opera")!=0&&navigator.userAgent.indexOf("MSIE")!=-1;
os.compileXMLNode=function(D,G){var A=[];
for(var F=D.firstChild;
F;
F=F.nextSibling){if(F.nodeType==DOM_ELEMENT_NODE){A.push(os.compileNode_(F))
}else{if(F.nodeType==DOM_TEXT_NODE){if(F!=D.firstChild||!F.nodeValue.match(os.regExps_.ONLY_WHITESPACE)){var E=os.breakTextNode_(F);
for(var B=0;
B<E.length;
B++){A.push(E[B])
}}}}}var C=new os.Template(G);
C.setCompiledNodes_(A);
return C
};
os.compileXMLDoc=function(B,C){var A=B.firstChild;
while(A.nodeType!=DOM_ELEMENT_NODE){A=A.nextSibling
}return os.compileXMLNode(A,C)
};
os.operatorMap={and:"&&",eq:"==",lte:"<=",lt:"<",gte:">=",gt:">",neq:"!=",or:"||",not:"!"};
os.regExps_.SPLIT_INTO_TOKENS=/"(?:[^"\\]|\\.)*"|'(?:[^'\\]|\\.)*'|\w+|[^"'\w]+/g;
os.remapOperators_=function(A){return A.replace(os.regExps_.SPLIT_INTO_TOKENS,function(B){return os.operatorMap.hasOwnProperty(B)?os.operatorMap[B]:B
})
};
os.transformVariables_=function(A){A=os.replaceTopLevelVars_(A);
return A
};
os.variableMap_={my:os.VAR_my,My:os.VAR_my,cur:VAR_this,Cur:VAR_this,"$cur":VAR_this,Top:VAR_top,Context:VAR_loop};
os.replaceTopLevelVars_=function(B){var A;
A=os.regExps_.TOP_LEVEL_VAR_REPLACEMENT;
if(!A){A=/(^|[^.$a-zA-Z0-9])([$a-zA-Z0-9]+)/g;
os.regExps_.TOP_LEVEL_VAR_REPLACEMENT=A
}return B.replace(A,function(D,E,C){if(os.variableMap_.hasOwnProperty(C)){return E+os.variableMap_[C]
}else{return D
}})
};
os.identifierResolver_=function(B,A){return B.hasOwnProperty(A)?B[A]:("get" in B?B.get(A):null)
};
os.setIdentifierResolver=function(A){os.identifierResolver_=A
};
os.getFromContext=function(C,B,D){if(!C){return D
}var A;
if(C.vars_&&C.data_){if(C.data_.nodeType==DOM_ELEMENT_NODE){A=os.getValueFromNode_(C.data_,B);
if(A==null){A=void (0)
}}else{A=os.identifierResolver_(C.data_,B)
}if(typeof (A)=="undefined"){A=os.identifierResolver_(C.vars_,B)
}if(typeof (A)=="undefined"&&C.vars_[os.VAR_my]){A=os.getValueFromNode_(C.vars_[os.VAR_my],B)
}if(typeof (A)=="undefined"&&C.vars_[VAR_top]){A=C.vars_[VAR_top][B]
}}else{if(C.nodeType==DOM_ELEMENT_NODE){A=os.getValueFromNode_(C,B)
}else{A=os.identifierResolver_(C,B)
}}if(typeof (A)=="undefined"||A==null){if(typeof (D)!="undefined"){A=D
}else{A=""
}}else{if(D&&os.isArray(D)&&!os.isArray(A)&&A.list&&os.isArray(A.list)){A=A.list
}}return A
};
os.transformExpression_=function(A,B){A=os.remapOperators_(A);
A=os.transformVariables_(A);
if(os.identifierResolver_){A=os.wrapIdentifiersInExpression(A,B)
}return A
};
os.attributeMap_={"if":ATT_display,repeat:ATT_select,cur:ATT_innerselect};
os.appendJSTAttribute_=function(C,B,D){var A=C.getAttribute(B);
if(A){D=A+";"+D
}C.setAttribute(B,D)
};
os.copyAttributes_=function(F,G,E){var A=null;
for(var C=0;
C<F.attributes.length;
C++){var B=F.attributes[C].nodeName;
var H=F.getAttribute(B);
if(B&&H){if(B=="var"){os.appendJSTAttribute_(G,ATT_vars,F.getAttribute(B)+": $this")
}else{if(B=="context"){os.appendJSTAttribute_(G,ATT_vars,F.getAttribute(B)+": "+VAR_loop)
}else{if(B.length<7||B.substring(0,6)!="xmlns:"){if(os.customAttributes_[B]){os.appendJSTAttribute_(G,ATT_eval,"os.doAttribute(this, '"+B+"', $this, $context)")
}else{if(B=="repeat"){os.appendJSTAttribute_(G,ATT_eval,"os.setContextNode_($this, $context)")
}}var D=os.attributeMap_.hasOwnProperty(B)?os.attributeMap_[B]:B;
var I=(os.attributeMap_[B])?null:os.parseAttribute_(H);
if(I){if(D=="class"){D=".className"
}else{if(D=="style"){D=".style.cssText"
}else{if(G.getAttribute(os.ATT_customtag)){D="."+D
}else{if(os.isIe&&!os.customAttributes_[D]&&D.substring(0,2).toLowerCase()=="on"){D="."+D;
I="new Function("+I+")"
}else{if(D=="selected"&&G.tagName=="OPTION"){D=".selected"
}}}}}if(!A){A=[]
}A.push(D+":"+I)
}else{if(os.attributeMap_.hasOwnProperty(B)){if(H.length>3&&H.substring(0,2)=="${"&&H.charAt(H.length-1)=="}"){H=H.substring(2,H.length-1)
}H=os.transformExpression_(H,B=="repeat"?os.VAR_emptyArray:"null")
}else{if(D=="class"){G.setAttribute("className",H)
}else{if(D=="style"){G.style.cssText=H
}}}if(os.isIe&&!os.customAttributes_.hasOwnProperty(D)&&D.substring(0,2).toLowerCase()=="on"){G.attachEvent(D,new Function(H))
}else{G.setAttribute(D,H)
}}}}}}}if(A){os.appendJSTAttribute_(G,ATT_values,A.join(";"))
}};
os.compileNode_=function(G){if(G.nodeType==DOM_TEXT_NODE){var H=G.cloneNode(false);
return os.breakTextNode_(H)
}else{if(G.nodeType==DOM_ELEMENT_NODE){var F;
if(G.tagName.indexOf(":")>0){if(G.tagName=="os:Repeat"){F=document.createElement(os.computeContainerTag_(G));
F.setAttribute(ATT_select,os.parseAttribute_(G.getAttribute("expression")));
var K=G.getAttribute("var");
if(K){os.appendJSTAttribute_(F,ATT_vars,K+": $this")
}var J=G.getAttribute("context");
if(J){os.appendJSTAttribute_(F,ATT_vars,J+": "+VAR_loop)
}os.appendJSTAttribute_(F,ATT_eval,"os.setContextNode_($this, $context)")
}else{if(G.tagName=="os:If"){F=document.createElement(os.computeContainerTag_(G));
F.setAttribute(ATT_display,os.parseAttribute_(G.getAttribute("condition")))
}else{F=document.createElement("span");
F.setAttribute(os.ATT_customtag,G.tagName);
var A=G.tagName.split(":");
os.appendJSTAttribute_(F,ATT_eval,'os.doTag(this, "'+A[0]+'", "'+A[1]+'", $this, $context)');
var C=G.getAttribute("cur")||"{}";
F.setAttribute(ATT_innerselect,C);
if(G.tagName=="os:render"||G.tagName=="os:Render"||G.tagName=="os:renderAll"||G.tagName=="os:RenderAll"){os.appendJSTAttribute_(F,ATT_values,os.VAR_parentnode+":"+os.VAR_node)
}os.copyAttributes_(G,F,G.tagName)
}}}else{F=os.xmlToHtml_(G)
}if(F&&!os.processTextContent_(G,F)){for(var D=G.firstChild;
D;
D=D.nextSibling){var B=os.compileNode_(D);
if(B){if(os.isArray(B)){for(var I=0;
I<B.length;
I++){F.appendChild(B[I])
}}else{if(B.tagName=="TR"&&F.tagName=="TABLE"){var E=F.lastChild;
while(E&&E.nodeType!=DOM_ELEMENT_NODE&&E.previousSibling){E=E.previousSibling
}if(!E||E.tagName!="TBODY"){E=document.createElement("tbody");
F.appendChild(E)
}E.appendChild(B)
}else{F.appendChild(B)
}}}}}return F
}}return null
};
os.computeContainerTag_=function(B){var C=B.firstChild;
if(C){while(C&&!C.tagName){C=C.nextSibling
}if(C){var A=C.tagName.toLowerCase();
if(A=="option"){return"optgroup"
}if(A=="tr"){return"tbody"
}}}return"span"
};
os.ENTITIES='<!ENTITY nbsp "&#160;">';
os.xmlToHtml_=function(A){var B=document.createElement(A.tagName);
os.copyAttributes_(A,B);
return B
};
os.fireCallbacks=function(A){var B=A.getVariable(os.VAR_callbacks);
while(B.length>0){var C=B.pop();
if(C.onAttach){C.onAttach()
}else{if(typeof (C)=="function"){C.apply({})
}}}};
os.processTextContent_=function(C,B){if(C.childNodes.length==1&&!B.getAttribute(os.ATT_customtag)&&C.firstChild.nodeType==DOM_TEXT_NODE){var A=os.parseAttribute_(C.firstChild.data);
if(B.nodeName=="SCRIPT"){B.text=os.trimWhitespaceForIE_(C.firstChild.data,true,true)
}if(A){B.setAttribute(ATT_content,A)
}else{B.appendChild(document.createTextNode(os.trimWhitespaceForIE_(C.firstChild.data,true,true)))
}return true
}return false
};
os.pushTextNode=function(B,A){if(A.length>0){B.push(document.createTextNode(A))
}};
os.trimWhitespaceForIE_=function(C,D,B){if(os.isIe){var A=C.replace(/[\x09-\x0d ]+/g," ");
if(D){A=A.replace(/^\s/,"")
}if(B){A=A.replace(/\s$/,"")
}return A
}return C
};
os.breakTextNode_=function(G){var A=os.regExps_.VARIABLE_SUBSTITUTION;
var F=G.data;
var B=[];
var C=F.match(A);
while(C){if(C[1].length>0){os.pushTextNode(B,os.trimWhitespaceForIE_(C[1]))
}var D=C[2].substring(2,C[2].length-1);
if(!D){D=VAR_this
}var E=document.createElement("span");
E.setAttribute(ATT_content,os.transformExpression_(D));
B.push(E);
C=F.match(A);
F=C[3];
C=F.match(A)
}if(F.length>0){os.pushTextNode(B,os.trimWhitespaceForIE_(F))
}return B
};
os.transformLiteral_=function(A){return"'"+A.replace(/'/g,"\\'").replace(/\n/g," ").replace(/;/g,"'+os.SEMICOLON+'")+"'"
};
os.parseAttribute_=function(C){if(!C.length){return null
}var A=os.regExps_.VARIABLE_SUBSTITUTION;
var F=C;
var E=[];
var B=F.match(A);
if(!B){return null
}while(B){if(B[1].length>0){E.push(os.transformLiteral_(os.trimWhitespaceForIE_(B[1],E.length==0)))
}var D=B[2].substring(2,B[2].length-1);
if(!D){D=VAR_this
}E.push("("+os.transformExpression_(D)+")");
F=B[3];
B=F.match(A)
}if(F.length>0){E.push(os.transformLiteral_(os.trimWhitespaceForIE_(F,false,true)))
}return E.join("+")
};
os.getValueFromNode_=function(D,B){if(B=="*"){var C=[];
for(var F=D.firstChild;
F;
F=F.nextSibling){C.push(F)
}return C
}if(B.indexOf(":")>=0){B=B.substring(B.indexOf(":")+1)
}var A=D[B];
if(typeof (A)=="undefined"||A==null){A=D.getAttribute(B)
}if(typeof (A)!="undefined"&&A!=null){if(A=="false"){A=false
}else{if(A=="0"){A=0
}}return A
}var E=D[os.VAR_my];
if(!E){E=os.computeChildMap_(D);
D[os.VAR_my]=E
}A=E[B.toLowerCase()];
return A
};
os.identifiersNotToWrap_={};
os.identifiersNotToWrap_["true"]=true;
os.identifiersNotToWrap_["false"]=true;
os.identifiersNotToWrap_["null"]=true;
os.identifiersNotToWrap_["var"]=true;
os.identifiersNotToWrap_[os.VAR_my]=true;
os.identifiersNotToWrap_[VAR_this]=true;
os.identifiersNotToWrap_[VAR_context]=true;
os.identifiersNotToWrap_[VAR_top]=true;
os.identifiersNotToWrap_[VAR_loop]=true;
os.canStartIdentifier=function(A){return(A>="a"&&A<="z")||(A>="A"&&A<="Z")||A=="_"||A=="$"
};
os.canBeInIdentifier=function(A){return os.canStartIdentifier(A)||(A>="0"&&A<="9")||A==":"
};
os.canBeInToken=function(A){return os.canBeInIdentifier(A)||A=="("||A==")"||A=="["||A=="]"||A=="."
};
os.wrapSingleIdentifier=function(A,B,C){if(os.identifiersNotToWrap_.hasOwnProperty(A)&&(!B||B==VAR_context)){return A
}return os.VAR_identifierresolver+"("+(B||VAR_context)+", '"+A+"'"+(C?", "+C:"")+")"
};
os.wrapIdentifiersInToken=function(D,A){if(!os.canStartIdentifier(D.charAt(0))){return D
}if(D.substring(0,os.VAR_msg.length+1)==(os.VAR_msg+".")&&os.gadgetPrefs_){var K=D.split(".")[1];
var B=os.getPrefMessage(K)||"";
return os.parseAttribute_(B)||os.transformLiteral_(B)
}var J=os.tokenToIdentifiers(D);
var F=false;
var G=[];
var C=null;
for(var I=0;
I<J.length;
I++){var H=J[I];
F=os.breakUpParens(H);
if(!F){if(I==J.length-1){C=os.wrapSingleIdentifier(H,C,A)
}else{C=os.wrapSingleIdentifier(H,C)
}}else{G.length=0;
G.push(os.wrapSingleIdentifier(F[0],C));
for(var E=1;
E<F.length;
E+=3){G.push(F[E]);
if(F[E+1]){G.push(os.wrapIdentifiersInExpression(F[E+1]))
}G.push(F[E+2])
}C=G.join("")
}}return C
};
os.wrapIdentifiersInExpression=function(D,E){var A=[];
var C=os.expressionToTokens(D);
for(var B=0;
B<C.length;
B++){A.push(os.wrapIdentifiersInToken(C[B],E))
}return A.join("")
};
os.expressionToTokens=function(J){var H=[];
var F=false;
var G=false;
var I=0;
var B=false;
var C=null;
var D=[];
for(var E=0;
E<J.length;
E++){var A=J.charAt(E);
if(F){if(!B&&A==C){F=false
}else{if(A=="\\"){B=true
}else{B=false
}}D.push(A)
}else{if(A=="'"||A=='"'){F=true;
C=A;
D.push(A);
continue
}if(A=="("){I++
}else{if(A==")"&&I>0){I--
}}if(I>0){D.push(A);
continue
}if(!G&&os.canStartIdentifier(A)){if(D.length>0){H.push(D.join(""));
D.length=0
}G=true;
D.push(A);
continue
}if(G){if(os.canBeInToken(A)){D.push(A)
}else{H.push(D.join(""));
D.length=0;
G=false;
D.push(A)
}}else{D.push(A)
}}}H.push(D.join(""));
return H
};
os.tokenToIdentifiers=function(E){var H=false;
var B=null;
var G=false;
var C=[];
var A=[];
for(var D=0;
D<E.length;
D++){var F=E.charAt(D);
if(H){if(!G&&F==B){H=false
}else{if(F=="\\"){G=true
}else{G=false
}}C.push(F);
continue
}else{if(F=="'"||F=='"'){C.push(F);
H=true;
B=F;
continue
}}if(F=="."&&!H){A.push(C.join(""));
C.length=0;
continue
}C.push(F)
}A.push(C.join(""));
return A
};
os.breakUpParens=function(L){var G=L.indexOf("(");
var E=L.indexOf("[");
if(G<0&&E<0){return false
}var I=[];
if(G<0||(E>=0&&E<G)){G=0;
I.push(L.substring(0,E))
}else{E=0;
I.push(L.substring(0,G))
}var D=null;
var K=false;
var F=null;
var B=0;
var C=false;
var H=[];
for(var J=E+G;
J<L.length;
J++){var A=L.charAt(J);
if(K){if(!C&&A==F){K=false
}else{if(A=="\\"){C=true
}else{C=false
}}H.push(A)
}else{if(A=="'"||A=='"'){K=true;
F=A;
H.push(A);
continue
}if(B==0){if(A=="("||A=="["){D=A;
B++;
I.push(A);
H.length=0
}}else{if((D=="("&&A==")")||(D=="["&&A=="]")){B--;
if(B==0){I.push(H.join(""));
I.push(A)
}else{H.push(A)
}}else{if(A==D){B++
}H.push(A)
}}}}return I
};