gadgets.pubsub2router=function(){return{init:function(A){if(A.hub){this.hub=A.hub
}else{this.hub=new OpenAjax.hub.ManagedHub({onPublish:A.onPublish,onSubscribe:A.onSubscribe,onUnsubscribe:A.onUnsubscribe})
}}}
}();