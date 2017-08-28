var DOM_ELEMENT_NODE=1;
var DOM_ATTRIBUTE_NODE=2;
var DOM_TEXT_NODE=3;
var DOM_CDATA_SECTION_NODE=4;
var DOM_ENTITY_REFERENCE_NODE=5;
var DOM_ENTITY_NODE=6;
var DOM_PROCESSING_INSTRUCTION_NODE=7;
var DOM_COMMENT_NODE=8;
var DOM_DOCUMENT_NODE=9;
var DOM_DOCUMENT_TYPE_NODE=10;
var DOM_DOCUMENT_FRAGMENT_NODE=11;
var DOM_NOTATION_NODE=12;
gadgets.jsondom=(function(){var A={};
function D(I,H){if(typeof I==="string"){return E(I,H)
}else{if(typeof I==="object"){if(I.e){throw new Error(I.e)
}return B(I,H)
}}return null
}function B(R,L){var N=DOM_ELEMENT_NODE;
var I=R.n;
var M=[];
var H=[];
var K=L;
for(var P=0;
P<R.a.length;
++P){M.push(F(R.a[P].n,R.a[P].v))
}var J=[];
var O=(R.c.length>0?D(R.c[R.c.length-1]):null);
for(var P=R.c.length-2;
P>=0;
--P){var Q=D(R.c[P],O);
J.push(Q);
O=Q
}for(var P=J.length-1;
P>=0;
--P){H.push(J[P])
}return{nodeType:N,tagName:I,children:H,attributes:M,firstChild:H[0],nextSibling:K,getAttribute:function(T){for(var S=0;
S<M.length;
++S){if(M[S].nodeName==T){return M[S]
}}return null
}}
}function E(M,I,L,N){var H=N||DOM_TEXT_NODE;
var O=L||"#text";
var J=M;
var K=I;
return{nodeType:H,nodeName:O,nodeValue:J,data:J,nextSibling:K,cloneNode:function(){return E(J,O)
}}
}function F(H,I){return E(I,null,H,DOM_ATTR_NODE)
}function C(I,H){A[I]=D(H)
}function G(I,J){if(J&&A[J]){return A[J]
}var H=opensocial.xmlutil.parseXML(I);
if(J){A[J]=H
}return H
}return{parse:G,preload_:C}
})();