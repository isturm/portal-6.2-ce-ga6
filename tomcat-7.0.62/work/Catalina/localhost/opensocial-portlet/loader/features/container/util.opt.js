shindig.container.util={};
shindig.container.util.getSafeJsonValue=function(C,B,A){return(C[B]!=undefined&&C[B]!=null)?C[B]:A
};
shindig.container.util.mergeJsons=function(D,C){var A={};
for(var B in D){A[B]=D[B]
}for(var B in C){A[B]=C[B]
}return A
};
shindig.container.util.cloneJson=function(A){};
shindig.container.util.newMetadataRequest=function(A){return{container:window.__CONTAINER,ids:A,fields:["iframeUrl","modulePrefs.*","needsTokenRefresh","userPrefs.*","views.preferredHeight","views.preferredWidth"]}
};
shindig.container.util.newTokenRequest=function(A){return{container:window.__CONTAINER,ids:A,fields:["token"]}
};
shindig.container.util.toArrayOfJsonKeys=function(C){var A=[];
for(var B in C){A.push(B)
}return A
};