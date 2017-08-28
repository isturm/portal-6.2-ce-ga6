(function(){gadgets.HubSettings={params:{HubClient:{onSecurityAlert:function(A,B){alert("Gadget stopped attempted security breach: "+B);
window.location.href="about:blank"
}},IframeHubClient:{}}};
if(gadgets.util.getUrlParameters().forcesecure){gadgets.HubSettings.params.IframeHubClient.requireParentVerifiable=true
}gadgets.util.registerOnLoadHandler(function(){try{gadgets.Hub=new OpenAjax.hub.IframeHubClient(gadgets.HubSettings.params);
gadgets.Hub.connect(gadgets.HubSettings.onConnect)
}catch(A){gadgets.error("ERROR creating or connecting IframeHubClient in gadgets.Hub ["+A.message+"]")
}})
})();