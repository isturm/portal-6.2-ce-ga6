opensocial.Container.prototype.requestPayment=function(A,B){if(B){window.setTimeout(function(){B(new opensocial.ResponseItem(null,A,opensocial.Payment.ResponseCode.NOT_IMPLEMENTED,null))
},0)
}};
opensocial.Container.prototype.requestPaymentRecords=function(A,B){if(A){window.setTimeout(function(){A(new opensocial.ResponseItem(null,payment,opensocial.Payment.ResponseCode.NOT_IMPLEMENTED,null))
},0)
}};
opensocial.Container.prototype.newPayment=function(A){return new opensocial.Payment(A)
};
opensocial.Container.prototype.newBillingItem=function(A){return new opensocial.BillingItem(A)
};