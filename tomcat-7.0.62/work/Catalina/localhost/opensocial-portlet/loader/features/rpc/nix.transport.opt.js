gadgets.rpctx=gadgets.rpctx||{};
if(!gadgets.rpctx.nix){gadgets.rpctx.nix=function(){var E="GRPC____NIXVBS_wrapper";
var F="GRPC____NIXVBS_get_wrapper";
var H="GRPC____NIXVBS_handle_message";
var C="GRPC____NIXVBS_create_channel";
var B=10;
var M=500;
var L={};
var D={};
var K;
var J=0;
function G(){var O=L[".."];
if(O){return 
}if(++J>B){gadgets.warn("Nix transport setup failed, falling back...");
K("..",false);
return 
}if(!O&&window.opener&&"GetAuthToken" in window.opener){O=window.opener;
if(O.GetAuthToken()==gadgets.rpc.getAuthToken("..")){var N=gadgets.rpc.getAuthToken("..");
O.CreateChannel(window[F]("..",N),N);
L[".."]=O;
window.opener=null;
K("..",true);
return 
}}window.setTimeout(function(){G()
},M)
}function I(){var O=window.location.href;
var N=O.indexOf("#");
if(N==-1){return O
}return O.substring(0,N)
}function A(P){var O=(2147483647*Math.random())|0;
var Q=[I(),O];
gadgets.rpc._createRelayIframe(P,Q);
var R=window.location.href.split("#")[1]||"";
function N(){var T=window.location.href.split("#")[1]||"";
if(T!==R){clearInterval(S);
var U=gadgets.util.getUrlParameters(window.location.href);
if(U.childtoken==O){G();
return 
}K("..",false)
}}var S=setInterval(N,100)
}return{getCode:function(){return"nix"
},isParentVerifiable:function(N){if(N){return D[N]
}return false
},init:function(O,P){K=P;
if(typeof window[F]!=="unknown"){window[H]=function(R){window.setTimeout(function(){O(gadgets.json.parse(R))
},0)
};
window[C]=function(R,T,S){if(gadgets.rpc.getAuthToken(R)===S){L[R]=T;
K(R,true)
}};
var N="Class "+E+"\n Private m_Intended\nPrivate m_Auth\nPublic Sub SetIntendedName(name)\n If isEmpty(m_Intended) Then\nm_Intended = name\nEnd If\nEnd Sub\nPublic Sub SetAuth(auth)\n If isEmpty(m_Auth) Then\nm_Auth = auth\nEnd If\nEnd Sub\nPublic Sub SendMessage(data)\n "+H+"(data)\nEnd Sub\nPublic Function GetAuthToken()\n GetAuthToken = m_Auth\nEnd Function\nPublic Sub CreateChannel(channel, auth)\n Call "+C+"(m_Intended, channel, auth)\nEnd Sub\nEnd Class\nFunction "+F+"(name, auth)\nDim wrap\nSet wrap = New "+E+"\nwrap.SetIntendedName name\nwrap.SetAuth auth\nSet "+F+" = wrap\nEnd Function";
try{window.execScript(N,"vbscript")
}catch(Q){return false
}}return true
},setup:function(S,O,N){D[S]=!!N;
if(S===".."){if(N){A(O)
}else{G()
}return true
}try{var Q=document.getElementById(S);
var R=window[F](S,O);
Q.contentWindow.opener=R
}catch(P){return false
}return true
},call:function(N,Q,P){try{if(L[N]){L[N].SendMessage(gadgets.json.stringify(P))
}}catch(O){return false
}return true
},relayOnload:function(Q,O){var P=O[0]+"#childtoken="+O[1];
var N=document.getElementById(Q);
N.src=P
}}
}()
};