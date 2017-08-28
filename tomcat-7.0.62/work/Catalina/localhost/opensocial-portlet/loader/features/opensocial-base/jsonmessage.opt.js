var JsonMessage=function(A,B){B=B||{};
opensocial.Message.call(this,A,B)
};
JsonMessage.inherits(opensocial.Message);
JsonMessage.prototype.toJsonObject=function(){return JsonMessage.copyFields(this.fields_)
};
JsonMessage.copyFields=function(A){var B={};
for(var C in A){B[C]=A[C]
}return B
};