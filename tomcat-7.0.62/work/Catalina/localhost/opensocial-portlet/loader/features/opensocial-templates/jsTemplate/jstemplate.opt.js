var ATT_select="jsselect";
var ATT_instance="jsinstance";
var ATT_display="jsdisplay";
var ATT_values="jsvalues";
var ATT_vars="jsvars";
var ATT_eval="jseval";
var ATT_transclude="transclude";
var ATT_content="jscontent";
var ATT_skip="jsskip";
var ATT_innerselect="jsinnerselect";
var ATT_jstcache="jstcache";
var PROP_jstcache="__jstcache";
var STRING_jsts="jsts";
var CHAR_asterisk="*";
var CHAR_dollar="$";
var CHAR_period=".";
var CHAR_ampersand="&";
var STRING_div="div";
var STRING_id="id";
var STRING_asteriskzero="*0";
var STRING_zero="0";
function jstProcess(A,D,C){var B=new JstProcessor;
if(MAPS_DEBUG&&C){B.setDebugging(C)
}JstProcessor.prepareTemplate_(D);
B.document_=ownerDocument(D);
B.run_(bindFully(B,B.jstProcessOuter_,A,D));
if(MAPS_DEBUG&&C){log("jstProcess:\n"+B.getLogs().join("\n"))
}}function JstProcessor(){if(MAPS_DEBUG){this.logs_=[]
}}JstProcessor.jstid_=0;
JstProcessor.jstcache_={};
JstProcessor.jstcache_[0]={};
JstProcessor.jstcacheattributes_={};
JstProcessor.attributeValues_={};
JstProcessor.attributeList_=[];
JstProcessor.prepareTemplate_=function(A){if(!A[PROP_jstcache]){domTraverseElements(A,function(B){JstProcessor.prepareNode_(B)
})
}};
var JST_ATTRIBUTES=[[ATT_select,jsEvalToFunction],[ATT_display,jsEvalToFunction],[ATT_values,jsEvalToValues],[ATT_vars,jsEvalToValues],[ATT_eval,jsEvalToExpressions],[ATT_transclude,jsEvalToSelf],[ATT_content,jsEvalToFunction],[ATT_skip,jsEvalToFunction],[ATT_innerselect,jsEvalToFunction]];
JstProcessor.prepareNode_=function(E){if(E[PROP_jstcache]){return E[PROP_jstcache]
}var C=domGetAttribute(E,ATT_jstcache);
if(C!=null){return E[PROP_jstcache]=JstProcessor.jstcache_[C]
}var M=JstProcessor.attributeValues_;
var D=JstProcessor.attributeList_;
D.length=0;
for(var G=0,L=jsLength(JST_ATTRIBUTES);
G<L;
++G){var B=JST_ATTRIBUTES[G][0];
var K=domGetAttribute(E,B);
M[B]=K;
if(K!=null){D.push(B+"="+K)
}}if(D.length==0){domSetAttribute(E,ATT_jstcache,STRING_zero);
return E[PROP_jstcache]=JstProcessor.jstcache_[0]
}var J=D.join(CHAR_ampersand);
if(C=JstProcessor.jstcacheattributes_[J]){domSetAttribute(E,ATT_jstcache,C);
return E[PROP_jstcache]=JstProcessor.jstcache_[C]
}var A={};
for(var G=0,L=jsLength(JST_ATTRIBUTES);
G<L;
++G){var H=JST_ATTRIBUTES[G];
var B=H[0];
var F=H[1];
var K=M[B];
if(K!=null){A[B]=F(K);
if(MAPS_DEBUG){A.jstAttributeValues=A.jstAttributeValues||{};
A.jstAttributeValues[B]=K
}}}C=STRING_empty+ ++JstProcessor.jstid_;
domSetAttribute(E,ATT_jstcache,C);
JstProcessor.jstcache_[C]=A;
JstProcessor.jstcacheattributes_[J]=C;
return E[PROP_jstcache]=A
};
JstProcessor.prototype.run_=function(F){var H=this;
var K=H.calls_=[];
var J=H.queueIndices_=[];
var E=H.arrayPool_=[];
F();
var D,G;
var A,C,B;
var I;
while(K.length){D=K[K.length-1];
G=J[J.length-1];
if(G>=D.length){H.recycleArray_(K.pop());
J.pop();
continue
}A=D[G++];
C=D[G++];
B=D[G++];
J[J.length-1]=G;
A.call(H,C,B)
}};
JstProcessor.prototype.push_=function(A){this.calls_.push(A);
this.queueIndices_.push(0)
};
JstProcessor.prototype.setDebugging=function(A){if(MAPS_DEBUG){this.debugging_=A
}};
JstProcessor.prototype.createArray_=function(){if(this.arrayPool_.length){return this.arrayPool_.pop()
}else{return[]
}};
JstProcessor.prototype.recycleArray_=function(A){arrayClear(A);
this.arrayPool_.push(A)
};
JstProcessor.prototype.jstProcessOuter_=function(C,E){var F=this;
var H=F.jstAttributes_(E);
if(MAPS_DEBUG&&F.debugging_){F.logState_("Outer",E,H.jstAttributeValues)
}var B=H[ATT_transclude];
if(B){var G=jstGetTemplate(B);
if(G){domReplaceChild(G,E);
var D=F.createArray_();
D.push(F.jstProcessOuter_,C,G);
F.push_(D)
}else{domRemoveNode(E)
}return 
}var A=H[ATT_select];
if(A){F.jstSelect_(C,E,A)
}else{F.jstProcessInner_(C,E)
}};
JstProcessor.prototype.jstProcessInner_=function(B,P){var M=this;
var G=M.jstAttributes_(P);
if(MAPS_DEBUG&&M.debugging_){M.logState_("Inner",P,G.jstAttributeValues)
}var K=G[ATT_display];
if(K){var A=B.jsexec(K,P);
if(MAPS_DEBUG&&M.debugging_){M.logs_.push(ATT_display+": "+A+"<br/>")
}if(!A){displayNone(P);
return 
}displayDefault(P)
}var Q=G[ATT_vars];
if(Q){M.jstVars_(B,P,Q)
}Q=G[ATT_values];
if(Q){M.jstValues_(B,P,Q)
}var H=G[ATT_eval];
if(H){for(var E=0,N=jsLength(H);
E<N;
++E){B.jsexec(H[E],P)
}}var O=G[ATT_skip];
if(O){var D=B.jsexec(O,P);
if(MAPS_DEBUG&&M.debugging_){M.logs_.push(ATT_skip+": "+D+"<br/>")
}if(D){return 
}}var J=G[ATT_content];
if(J){M.jstContent_(B,P,J)
}else{var F=M.createArray_();
var R=null;
for(var L=P.firstChild;
L;
L=L.nextSibling){if(L.nodeType==DOM_ELEMENT_NODE){if(!R){R=B;
var C=G[ATT_innerselect];
if(C&&C!=VAR_this){R=B.clone(B.jsexec(C,P),0,0)
}}F.push(M.jstProcessOuter_,R,L)
}}if(F.length){M.push_(F)
}}};
JstProcessor.prototype.jstSelect_=function(A,P,L){var K=this;
var N=A.jsexec(L,P);
var Q=domGetAttribute(P,ATT_instance);
var H=false;
if(Q){if(Q.charAt(0)==CHAR_asterisk){Q=parseInt10(Q.substr(1));
H=true
}else{Q=parseInt10((Q))
}}var R=isArray(N);
var G=R?jsLength(N):1;
var C=(R&&G==0);
if(R){if(C){if(!Q){domSetAttribute(P,ATT_instance,STRING_asteriskzero);
displayNone(P)
}else{domRemoveNode(P)
}}else{displayDefault(P);
if(Q===null||Q===STRING_empty||(H&&Q<G-1)){var E=K.createArray_();
var F=Q||0;
var D,M,J;
for(D=F,M=G-1;
D<M;
++D){var B=domCloneNode(P);
domInsertBefore(B,P);
jstSetInstance((B),N,D);
J=A.clone(N[D],D,G);
E.push(K.jstProcessInner_,J,B,JsEvalContext.recycle,J,null)
}jstSetInstance(P,N,D);
J=A.clone(N[D],D,G);
E.push(K.jstProcessInner_,J,P,JsEvalContext.recycle,J,null);
K.push_(E)
}else{if(Q<G){var O=N[Q];
jstSetInstance(P,N,Q);
var J=A.clone(O,Q,G);
var E=K.createArray_();
E.push(K.jstProcessInner_,J,P,JsEvalContext.recycle,J,null);
K.push_(E)
}else{domRemoveNode(P)
}}}}else{if(N==null){displayNone(P)
}else{displayDefault(P);
var J=A.clone(N,0,1);
var E=K.createArray_();
E.push(K.jstProcessInner_,J,P,JsEvalContext.recycle,J,null);
K.push_(E)
}}};
JstProcessor.prototype.jstVars_=function(E,F,A){for(var D=0,C=jsLength(A);
D<C;
D+=2){var B=A[D];
var G=E.jsexec(A[D+1],F);
E.setVariable(B,G)
}};
JstProcessor.prototype.jstValues_=function(B,N,O){for(var D=0,L=jsLength(O);
D<L;
D+=2){var H=O[D];
var K=B.jsexec(O[D+1],N);
if(H.charAt(0)==CHAR_dollar){B.setVariable(H,K)
}else{if(H.charAt(0)==CHAR_period){var M=H.substr(1).split(CHAR_period);
var F=N;
var E=jsLength(M);
for(var C=0,G=E-1;
C<G;
++C){var A=M[C];
if(!F[A]){F[A]={}
}F=F[A]
}F[M[E-1]]=K
}else{if(H){if(typeof K==TYPE_boolean){if(K){domSetAttribute(N,H,H)
}else{domRemoveAttribute(N,H)
}}else{domSetAttribute(N,H,STRING_empty+K)
}}}}}};
JstProcessor.prototype.jstContent_=function(B,C,D){var E=STRING_empty+B.jsexec(D,C);
if(C.innerHTML==E){return 
}while(C.firstChild){domRemoveNode(C.firstChild)
}var A=domCreateTextNode(this.document_,E);
domAppendChild(C,A)
};
JstProcessor.prototype.jstAttributes_=function(B){if(B[PROP_jstcache]){return B[PROP_jstcache]
}var A=domGetAttribute(B,ATT_jstcache);
if(A){return B[PROP_jstcache]=JstProcessor.jstcache_[A]
}return JstProcessor.prepareNode_(B)
};
function jstGetTemplate(B,E){var D=document;
var C;
if(E){C=jstLoadTemplateIfNotPresent(D,B,E)
}else{C=domGetElementById(D,B)
}if(C){JstProcessor.prepareTemplate_(C);
var A=domCloneElement(C);
domRemoveAttribute(A,STRING_id);
return A
}else{return null
}}function jstGetTemplateOrDie(B,C){var A=jstGetTemplate(B,C);
return(A)
}function jstLoadTemplateIfNotPresent(D,A,E,B){var C=domGetElementById(D,A);
if(C){return C
}jstLoadTemplate_(D,E(),B||STRING_jsts);
var C=domGetElementById(D,A);
if(!C){log("Error: jstGetTemplate was provided with opt_loadHtmlFn, but that function did not provide the id '"+A+"'.")
}return(C)
}function jstLoadTemplate_(D,B,A){var E=domGetElementById(D,A);
var C;
if(!E){C=domCreateElement(D,STRING_div);
C.id=A;
displayNone(C);
positionAbsolute(C);
domAppendChild(D.body,C)
}else{C=E
}var F=domCreateElement(D,STRING_div);
C.appendChild(F);
F.innerHTML=B
}function jstSetInstance(C,A,B){if(B==jsLength(A)-1){domSetAttribute(C,ATT_instance,CHAR_asterisk+B)
}else{domSetAttribute(C,ATT_instance,STRING_empty+B)
}}JstProcessor.prototype.logState_=function(A,B,C){if(MAPS_DEBUG){var D="<table>";
D+="<caption>"+A+"</caption>";
D+="<tbody>";
if(B.id){D+="<tr><td>id:</td><td>"+B.id+"</td></tr>"
}if(B.name){D+="<tr><td>name:</td><td>"+B.name+"</td></tr>"
}if(C){D+="<tr><td>attr:</td><td>"+(C)+"</td></tr>"
}D+="</tbody></table><br/>";
this.logs_.push(D)
}};
JstProcessor.prototype.getLogs=function(){return this.logs_
};