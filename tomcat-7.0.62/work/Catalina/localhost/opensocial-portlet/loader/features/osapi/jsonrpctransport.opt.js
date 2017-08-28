(function(){function A(H,G){function F(J){if(J.errors[0]){G({error:{code:J.rc,message:J.text}})
}else{var K=J.result||J.data;
if(K.error){G(K)
}else{var I={};
for(var L=0;
L<K.length;
L++){I[K[L].id]=K[L]
}G(I)
}}}var E={POST_DATA:gadgets.json.stringify(H),CONTENT_TYPE:"JSON",METHOD:"POST",AUTHORIZATION:"SIGNED"};
var C=this.name;
var D=shindig.auth.getSecurityToken();
if(D){C+="?st=";
C+=encodeURIComponent(D)
}gadgets.io.makeNonProxiedRequest(C,F,E,"application/json")
}function B(F){var H=F["osapi.services"];
if(H){for(var E in H){if(H.hasOwnProperty(E)){if(E.indexOf("http")==0||E.indexOf("//")==0){var C=E.replace("%host%",document.location.host);
var I={name:C,execute:A};
var D=H[E];
for(var G=0;
G<D.length;
G++){osapi._registerMethod(D[G],I)
}}}}}}if(gadgets.config){gadgets.config.register("osapi.services",null,B)
}})();