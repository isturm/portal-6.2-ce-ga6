var opensocial=opensocial||{};
opensocial.xmlutil=opensocial.xmlutil||{};
opensocial.xmlutil.parser_=null;
opensocial.xmlutil.parseXML=function(B){if(typeof (DOMParser)!="undefined"){opensocial.xmlutil.parser_=opensocial.xmlutil.parser_||new DOMParser();
var A=opensocial.xmlutil.parser_.parseFromString(B,"text/xml");
if(A.firstChild&&A.firstChild.tagName=="parsererror"){throw Error(A.firstChild.firstChild.nodeValue)
}return A
}else{if(typeof (ActiveXObject)!="undefined"){var A=new ActiveXObject("MSXML2.DomDocument");
A.validateOnParse=false;
A.loadXML(B);
if(A.parseError&&A.parseError.errorCode){throw Error(A.parseError.reason)
}return A
}}throw Error("No XML parser found in this browser.")
};
opensocial.xmlutil.NSMAP={os:"http://opensocial.org/"};
opensocial.xmlutil.getRequiredNamespaces=function(B,A){var D=A?opensocial.xmlutil.getNamespaceDeclarations_(A):{};
for(var C in opensocial.xmlutil.NSMAP){if(opensocial.xmlutil.NSMAP.hasOwnProperty(C)&&!D.hasOwnProperty(C)&&B.indexOf("<"+C+":")>=0&&B.indexOf("xmlns:"+C+":")<0){D[C]=opensocial.xmlutil.NSMAP[C]
}}return opensocial.xmlutil.serializeNamespaces_(D)
};
opensocial.xmlutil.serializeNamespaces_=function(C){var A=[];
for(var B in C){if(C.hasOwnProperty(B)){A.push(" xmlns:",B,'="',C[B],'"')
}}return A.join("")
};
opensocial.xmlutil.getNamespaceDeclarations_=function(C){var D={};
for(var B=0;
B<C.attributes.length;
B++){var A=C.attributes[B].nodeName;
if(A.substring(0,6)!="xmlns:"){continue
}D[A.substring(6,A.length)]=C.getAttribute(A)
}return D
};
opensocial.xmlutil.ENTITIES='<!ENTITY nbsp "&#160;">';
opensocial.xmlutil.prepareXML=function(B,A){var C=opensocial.xmlutil.getRequiredNamespaces(B,A);
return"<!DOCTYPE root ["+opensocial.xmlutil.ENTITIES+']><root xml:space="preserve"'+C+">"+B+"</root>"
};