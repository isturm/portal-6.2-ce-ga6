gadgets.rpctx=gadgets.rpctx||{};
if(!gadgets.rpctx.frameElement){gadgets.rpctx.frameElement=function(){var E="__g2c_rpc";
var B="__c2g_rpc";
var D;
var C;
function A(G,K,J){try{if(K!==".."){var F=window.frameElement;
if(typeof F[E]==="function"){if(typeof F[E][B]!=="function"){F[E][B]=function(L){D(gadgets.json.parse(L))
}
}F[E](gadgets.json.stringify(J));
return true
}}else{var I=document.getElementById(G);
if(typeof I[E]==="function"&&typeof I[E][B]==="function"){I[E][B](gadgets.json.stringify(J));
return true
}}}catch(H){}return false
}return{getCode:function(){return"fe"
},isParentVerifiable:function(){return false
},init:function(F,G){D=F;
C=G;
return true
},setup:function(J,F){if(J!==".."){try{var I=document.getElementById(J);
I[E]=function(K){D(gadgets.json.parse(K))
}
}catch(H){return false
}}if(J===".."){C("..",true);
var G=function(){window.setTimeout(function(){gadgets.rpc.call(J,gadgets.rpc.ACK)
},500)
};
gadgets.util.registerOnLoadHandler(G)
}return true
},call:function(F,H,G){return A(F,H,G)
}}
}()
};