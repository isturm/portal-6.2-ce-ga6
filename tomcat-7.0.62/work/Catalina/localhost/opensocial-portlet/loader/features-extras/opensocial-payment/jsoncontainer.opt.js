gadgets.rpc.register("shindig.requestPayment_callback",JsonRpcContainer.requestPaymentCallback_);
gadgets.rpc.register("shindig.requestPaymentRecords_callback",JsonRpcContainer.requestPaymentRecordsCallback_);
JsonRpcContainer.prototype.requestPayment=function(A,B){if(!A){if(B){B(new opensocial.ResponseItem(null,A,opensocial.Payment.ResponseCode.MALFORMED_REQUEST,"Payment object is undefined."))
}return 
}var C="cId_"+Math.random();
callbackIdStore[C]=B;
gadgets.rpc.call("..","shindig.requestPayment",null,C,A.toJsonObject())
};
JsonRpcContainer.requestPaymentCallback_=function(E,C){callback=callbackIdStore[E];
if(callback){var F=opensocial.Payment.ResponseCode[C[opensocial.Payment.Field.RESPONSE_CODE]];
var D=C[opensocial.Payment.Field.RESPONSE_MESSAGE];
C[opensocial.Payment.Field.RESPONSE_CODE]=F;
var A=new JsonPayment(C,false);
var B=new opensocial.ResponseItem(null,A,(F==opensocial.Payment.ResponseCode.OK?null:F),D);
callback(B)
}};
JsonRpcContainer.prototype.requestPaymentRecords=function(A,B){var C="cId_"+Math.random();
callbackIdStore[C]=A;
gadgets.rpc.call("..","shindig.requestPaymentRecords",null,C,B)
};
JsonRpcContainer.requestPaymentRecordsCallback_=function(F,C){callback=callbackIdStore[F];
if(callback){var H=opensocial.Payment.ResponseCode[C[opensocial.Payment.Field.RESPONSE_CODE]];
var E=C[opensocial.Payment.Field.RESPONSE_MESSAGE];
var B=[];
var G=C.payments;
for(var A in G){B.push(new JsonPayment(G[A],false))
}var D=new opensocial.ResponseItem(null,B,(H==opensocial.Payment.ResponseCode.OK?null:H),E);
callback(D)
}};
JsonRpcContainer.prototype.newPayment=function(A){return new JsonPayment(A,true)
};
JsonRpcContainer.prototype.newBillingItem=function(A){return new JsonBillingItem(A)
};