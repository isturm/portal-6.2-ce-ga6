var JsonMessageCollection=function(A){A=A||{};
opensocial.MessageCollection.call(this,A)
};
JsonMessageCollection.inherits(opensocial.MessageCollection);
JsonMessageCollection.prototype.toJsonObject=function(){return JsonMessageCollection.copyFields(this.fields_)
};
JsonMessageCollection.copyFields=function(A){var B={};
for(var C in A){B[C]=A[C]
}return B
};