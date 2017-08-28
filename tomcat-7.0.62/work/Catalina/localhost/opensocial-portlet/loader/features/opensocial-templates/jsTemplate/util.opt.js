var MAPS_DEBUG=false;
function log(A){}var STRING_empty="";
var CSS_display="display";
var CSS_position="position";
var TYPE_boolean="boolean";
var TYPE_number="number";
var TYPE_object="object";
var TYPE_string="string";
var TYPE_function="function";
var TYPE_undefined="undefined";
function jsEval(expr){try{return eval("["+expr+"][0]")
}catch(e){log("EVAL FAILED "+expr+": "+e);
return null
}}function jsLength(A){return A.length
}function assert(A){}function copyProperties(C,B){for(var A in B){C[A]=B[A]
}}function getDefaultObject(B,A){if(typeof B!=TYPE_undefined&&B!=null){return(B)
}else{return A
}}function isArray(A){return A!=null&&typeof A==TYPE_object&&typeof A.length==TYPE_number
}function arraySlice(C,B,A){return Function.prototype.call.apply(Array.prototype.slice,arguments)
}function parseInt10(A){return parseInt(A,10)
}function arrayClear(A){A.length=0
}function bindFully(B,D,C){var A=arraySlice(arguments,2);
return function(){return D.apply(B,A)
}
}function domGetElementById(A,B){return A.getElementById(B)
}function domCreateElement(B,A){return B.createElement(A)
}function domTraverseElements(B,C){var A=new DomTraverser(C);
A.run(B)
}function DomTraverser(A){this.callback_=A
}DomTraverser.prototype.run=function(A){var B=this;
B.queue_=[A];
while(jsLength(B.queue_)){B.process_(B.queue_.shift())
}};
DomTraverser.prototype.process_=function(B){var A=this;
A.callback_(B);
for(var C=B.firstChild;
C;
C=C.nextSibling){if(C.nodeType==DOM_ELEMENT_NODE){A.queue_.push(C)
}}};
function domGetAttribute(B,A){return B.getAttribute(A)
}function domSetAttribute(B,A,C){B.setAttribute(A,C)
}function domRemoveAttribute(B,A){B.removeAttribute(A)
}function domCloneNode(A){return A.cloneNode(true)
}function domCloneElement(A){return(domCloneNode(A))
}function ownerDocument(A){if(!A){return document
}else{if(A.nodeType==DOM_DOCUMENT_NODE){return(A)
}else{return A.ownerDocument||document
}}}function domCreateTextNode(A,B){return A.createTextNode(B)
}function domAppendChild(A,B){return A.appendChild(B)
}function displayDefault(A){A.style[CSS_display]=""
}function displayNone(A){A.style[CSS_display]="none"
}function positionAbsolute(A){A.style[CSS_position]="absolute"
}function domInsertBefore(A,B){return B.parentNode.insertBefore(A,B)
}function domReplaceChild(A,B){return B.parentNode.replaceChild(A,B)
}function domRemoveNode(A){return domRemoveChild(A.parentNode,A)
}function domRemoveChild(A,B){return A.removeChild(B)
}function stringTrim(A){return stringTrimRight(stringTrimLeft(A))
}function stringTrimLeft(A){return A.replace(/^\s+/,"")
}function stringTrimRight(A){return A.replace(/\s+$/,"")
};