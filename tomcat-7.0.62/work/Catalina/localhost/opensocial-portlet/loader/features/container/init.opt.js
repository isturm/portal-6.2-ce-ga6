(function(){function B(){gadgets.config.init({rpc:{parentRelayUrl:""},"core.io":{jsonProxyUrl:"http://%host%/gadgets/makeRequest",proxyUrl:"http://%host%/gadgets/proxy?refresh=%refresh%&container=%container%%rewriteMime%&gadget=%gadget%/%rawurl%"}})
}function C(){window.__API_URI=A();
window.__CONTAINER=window.__API_URI?window.__API_URI.getQP("container"):"default";
window.__CONTAINER_URI=shindig.uri(document.location.href)
}function A(){var E=document.getElementsByTagName("script");
var D=null;
if(E.length>0){D=shindig.uri(E[E.length-1].src);
D.resolve(shindig.uri(window.location))
}return D
}B();
C()
})();