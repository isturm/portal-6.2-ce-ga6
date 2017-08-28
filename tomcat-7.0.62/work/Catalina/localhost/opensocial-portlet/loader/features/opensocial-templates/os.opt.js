os.defineBuiltinTags=function(){var C=os.getNamespace("os")||os.createNamespace("os","http://ns.opensocial.org/2008/markup");
C.Render=function(F,J,D){var L=D.getVariable(os.VAR_parentnode);
var H=F.getAttribute("content")||"*";
var N=os.getValueFromNode_(L,H);
if(!N){return""
}else{if(typeof (N)=="string"){var G=document.createTextNode(N);
N=[];
N.push(G)
}else{if(!os.isArray(N)){var M=[];
for(var I=0;
I<N.childNodes.length;
I++){M.push(N.childNodes[I])
}N=M
}else{if(H!="*"&&N.length==1&&N[0].nodeType==DOM_ELEMENT_NODE){var M=[];
for(var E=N[0].firstChild;
E;
E=E.nextSibling){M.push(E)
}N=M
}}}}if(os.isIe){for(var I=0;
I<N.length;
I++){if(N[I].nodeType==DOM_TEXT_NODE){var K=os.trimWhitespaceForIE_(N[I].nodeValue,(I==0),(I==N.length-1));
if(K!=N[I].nodeValue){N[I].parentNode.removeChild(N[I]);
N[I]=document.createTextNode(K)
}}}}return N
};
C.render=C.RenderAll=C.renderAll=C.Render;
C.Html=function(E){var D=E.code?""+E.code:E.getAttribute("code")||"";
return D
};
function B(D,E){return function(){E.apply(D)
}
}function A(H,G,I,D){var F=D.getVariable(os.VAR_callbacks);
var E=new Function(G);
F.push(B(H,E))
}os.registerAttribute_("onAttach",A);
os.registerAttribute_("onCreate",A);
os.registerAttribute_("oncreate",A);
os.registerAttribute_("x-oncreate",A);
os.registerAttribute_("x-onCreate",A)
};
os.defineBuiltinTags();
os.resolveOpenSocialIdentifier=function(D,C){if(typeof (D[C])!="undefined"){return D[C]
}var G=os.getPropertyGetterName(C);
if(D[G]){return D[G]()
}if(D.getField){var B=D.getField(C);
if(B){return B
}}if(D.get){var E=D.get(C);
if(E&&E.getData){var F=E.getData();
return F.array_||F
}return E
}var A;
return A
};
os.setIdentifierResolver(os.resolveOpenSocialIdentifier);
os.createOpenSocialGetMethods_=function(C,B){if(C&&B){for(var D in B){var E=B[D];
var A=os.getPropertyGetterName(E);
C.prototype[A]=function(){this.getField(D)
}
}}};
os.registerOpenSocialFields_=function(){var A=os.resolveOpenSocialIdentifier.FIELDS;
if(opensocial){if(opensocial.Person){}}};
os.registerOpenSocialFields_();