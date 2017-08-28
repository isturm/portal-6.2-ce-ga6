var gadgets;
var JSON=window.JSON||gadgets.json;
var _IG_Prefs=(function(){var A=null;
var B=function(){if(!A){A=new gadgets.Prefs();
A.setDontEscape_()
}return A
};
B._parseURL=gadgets.Prefs.parseUrl;
return B
})();
function _IG_Fetch_wrapper(B,A){B(A.data?A.data:"")
}function _IG_FetchContent(B,G,C){var F=C||{};
if(F.refreshInterval){F.REFRESH_INTERVAL=F.refreshInterval
}else{F.REFRESH_INTERVAL=3600
}for(var E in F){var D=F[E];
delete F[E];
F[E.toUpperCase()]=D
}var A=gadgets.util.makeClosure(null,_IG_Fetch_wrapper,G);
gadgets.io.makeRequest(B,A,F)
}function _IG_FetchXmlContent(B,E,C){var D=C||{};
if(D.refreshInterval){D.REFRESH_INTERVAL=D.refreshInterval
}else{D.REFRESH_INTERVAL=3600
}D.CONTENT_TYPE="DOM";
var A=gadgets.util.makeClosure(null,_IG_Fetch_wrapper,E);
gadgets.io.makeRequest(B,A,D)
}function _IG_FetchFeedAsJSON(B,F,C,A,D){var E=D||{};
E.CONTENT_TYPE="FEED";
E.NUM_ENTRIES=C;
E.GET_SUMMARIES=A;
gadgets.io.makeRequest(B,function(J){J.data=J.data||{};
if(J.errors&&J.errors.length>0){J.data.ErrorMsg=J.errors[0]
}if(J.data.link){J.data.URL=B
}if(J.data.title){J.data.Title=J.data.title
}if(J.data.description){J.data.Description=J.data.description
}if(J.data.link){J.data.Link=J.data.link
}if(J.data.items&&J.data.items.length>0){J.data.Entry=J.data.items;
for(var H=0;
H<J.data.Entry.length;
++H){var I=J.data.Entry[H];
I.Title=I.title;
I.Link=I.link;
I.Summary=I.summary||I.description;
I.Date=I.pubDate
}}for(var G=0;
G<J.data.Entry.length;
++G){var I=J.data.Entry[G];
I.Date=(I.Date/1000)
}F(J.data)
},E)
}function _IG_GetCachedUrl(A,B){var C=B||{};
C.REFRESH_INTERVAL=3600;
if(C.refreshInterval){C.REFRESH_INTERVAL=C.refreshInterval
}return gadgets.io.getProxyUrl(A,C)
}function _IG_GetImageUrl(A,B){return _IG_GetCachedUrl(A,B)
}function _IG_GetImage(B){var A=document.createElement("img");
A.src=_IG_GetCachedUrl(B);
return A
}function _IG_RegisterOnloadHandler(A){gadgets.util.registerOnLoadHandler(A)
}function _IG_Callback(B,C){var A=arguments;
return function(){var D=Array.prototype.slice.call(arguments);
B.apply(null,D.concat(Array.prototype.slice.call(A,1)))
}
}var _args=gadgets.util.getUrlParameters;
function _gel(A){return document.getElementById?document.getElementById(A):null
}function _gelstn(A){if(A==="*"&&document.all){return document.all
}return document.getElementsByTagName?document.getElementsByTagName(A):[]
}function _gelsbyregex(D,F){var C=_gelstn(D);
var E=[];
for(var B=0,A=C.length;
B<A;
++B){if(F.test(C[B].id)){E.push(C[B])
}}return E
}function _esc(A){return window.encodeURIComponent?encodeURIComponent(A):escape(A)
}function _unesc(A){return window.decodeURIComponent?decodeURIComponent(A):unescape(A)
}function _hesc(A){return gadgets.util.escapeString(A)
}function _striptags(A){return A.replace(/<\/?[^>]+>/g,"")
}function _trim(A){return A.replace(/^\s+|\s+$/g,"")
}function _toggle(A){A=(typeof A==="string")?_gel(A):A;
if(A!==null){if(A.style.display.length===0||A.style.display==="block"){A.style.display="none"
}else{if(A.style.display==="none"){A.style.display="block"
}}}}var _uid=(function(){var A=0;
return function(){return A++
}
})();
function _min(B,A){return(B<A?B:A)
}function _max(B,A){return(B>A?B:A)
}function _exportSymbols(A,C){var I=window;
var F=A.split(".");
for(var H=0,G=F.length;
H<G;
H++){var B=F[H];
I[B]=I[B]||{};
I=I[B]
}for(var E=0,D=C.length;
E<D;
E+=2){I[C[E]]=C[E+1]
}}function _IG_AddDOMEventHandler(C,B,A){gadgets.warn("_IG_AddDOMEventHandler not implemented - see SHINDIG-198")
};