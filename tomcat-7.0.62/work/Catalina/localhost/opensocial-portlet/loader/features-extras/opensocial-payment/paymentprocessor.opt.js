var shindig=shindig||{};
shindig.paymentprocessor=(function(){var D=false;
var H=null;
var E={};
function G(K){var M=null;
if(shindig.container&&shindig.container.gadgetService){M={};
M.frameId=K;
M.appTitle="Unknown Title";
M.appSpec="Unknown SpecUrl";
var L=shindig.container.getGadget(shindig.container.gadgetService.getGadgetIdFromModuleId(K));
if(L){M.appTitle=L.title;
M.appSpec=L.specUrl;
M.stoken=L.securityToken
}}return M
}function I(L,K){if(D){K.responseCode="PAYMENT_PROCESSOR_ALREADY_OPENED"
}if(!K.amount||K.amount<=0){K.responseCode="MALFORMED_REQUEST"
}if(!E.paymentOpen){K.responseCode="NOT_IMPLEMENTED"
}H=G(this.f);
if(H==null){K.responseCode="NOT_IMPLEMENTED"
}if(K.responseCode&&K.responseCode!="OK"){try{gadgets.rpc.call(this.f,"shindig.requestPayment_callback",null,L,K)
}finally{return 
}}D=true;
K.orderedTime=new Date().getTime();
K.message=gadgets.util.escapeString(K.message);
H.callbackId=L;
H.payment=K;
E.paymentOpen()
}function C(){if(!D){return 
}if(E.paymentClose){E.paymentClose()
}try{gadgets.rpc.call(H.frameId,"shindig.requestPayment_callback",null,H.callbackId,H.payment)
}catch(K){}finally{D=false;
H=null
}}function A(M,K){var L={payments:{}};
if(D){L.responseCode="PAYMENT_PROCESSOR_ALREADY_OPENED"
}if(!E.paymentRecordsOpen){L.responseCode="NOT_IMPLEMENTED"
}if(L.responseCode&&L.responseCode!="OK"){try{gadgets.rpc.call(this.f,"shindig.requestPaymentRecords_callback",null,M,L)
}finally{return 
}}D=true;
H=G(this.f);
H.callbackId=M;
H.records=L;
H.reqParams=K;
E.paymentRecordsOpen()
}function B(){if(!D){return 
}if(E.paymentRecordsClose){E.paymentRecordsClose()
}try{gadgets.rpc.call(H.frameId,"shindig.requestPaymentRecords_callback",null,H.callbackId,H.records)
}finally{D=false;
H=null
}}function F(M){if(!M){return null
}var N=null;
try{var K=M.split(".");
if(K.length>0){var P=H;
for(var L=0;
L<K.length;
L++){P=P[K[L]]
}N=P
}}catch(O){N=null
}return N
}function J(M,N){if(!M){return 
}try{var K=M.split(".");
if(K.length>1){var O=H;
for(var L=0;
L<K.length-1;
L++){O=O[K[L]]
}O[K[K.length-1]]=N
}}finally{return 
}}return{initPayment:function(K,L){E.paymentOpen=K;
E.paymentClose=L;
gadgets.rpc.register("shindig.requestPayment",I)
},initPaymentRecords:function(K,L){E.paymentRecordsOpen=K;
E.paymentRecordsClose=L;
gadgets.rpc.register("shindig.requestPaymentRecords",A)
},openPayment:I,closePayment:C,openPaymentRecords:A,closePaymentRecords:B,getParam:F,setParam:J}
})();