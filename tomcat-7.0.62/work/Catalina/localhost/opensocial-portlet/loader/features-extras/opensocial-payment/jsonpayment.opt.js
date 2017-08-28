var JsonPayment=function(A,B){A=A||{};
if(!B){JsonPayment.constructArrayObject(A,"items",JsonBillingItem)
}opensocial.Payment.call(this,A)
};
JsonPayment.inherits(opensocial.Payment);
JsonPayment.prototype.toJsonObject=function(){var C=JsonPayment.copyFields(this.fields_);
var A=C.items||[];
var D=[];
for(var B=0;
B<A.length;
B++){D[B]=A[B].toJsonObject()
}C.items=D;
return C
};
var JsonBillingItem=function(A){opensocial.BillingItem.call(this,A)
};
JsonBillingItem.inherits(opensocial.BillingItem);
JsonBillingItem.prototype.toJsonObject=function(){return JsonPayment.copyFields(this.fields_)
};
JsonPayment.constructArrayObject=function(D,E,B){var C=D[E];
if(C){for(var A=0;
A<C.length;
A++){C[A]=new B(C[A])
}}};
JsonPayment.copyFields=function(A){var B={};
for(var C in A){B[C]=A[C]
}return B
};