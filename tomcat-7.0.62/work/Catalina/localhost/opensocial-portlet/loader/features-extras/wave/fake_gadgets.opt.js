var gadgets=gadgets||{};
gadgets.util={};
gadgets.util.registerOnLoadHandler=function(A){A.call()
};
gadgets.util.getUrlParameters=function(){var B={};
var A="wave";
B[A]=true;
B.hasOwnProperty=function(C){return !!this[C]
};
return B
};
gadgets.json={};
gadgets.json.parse=function(A){return A
};
gadgets.rpc={};
gadgets.rpc.register=function(){};
gadgets.rpc.call=function(){};