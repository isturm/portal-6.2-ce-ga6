shindig._uri=shindig.uri;
shindig.uri=(function(){var C=shindig._uri;
shindig._uri=null;
function A(E,D){return E.getOrigin()==D.getOrigin()
}function B(E,G){if(E.getSchema()==""){E.setSchema(G.getSchema())
}if(E.getAuthority()==""){E.setAuthority(G.getAuthority())
}var F=E.getPath();
if(F==""||F.charAt(0)!="/"){var H=G.getPath();
var D=H.lastIndexOf("/");
if(D!=-1){H=H.substring(0,D+1)
}E.setPath(G.getPath()+F)
}}return function(D){var E=C(D);
E.hasSameOrigin=function(F){return A(E,F)
};
E.resolve=function(F){return B(E,F)
};
return E
}
})();