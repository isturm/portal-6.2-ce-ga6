var JsonMediaItem=function(A){A=A||{};
opensocial.MediaItem.call(this,A.mimeType,A.url,A)
};
JsonMediaItem.inherits(opensocial.MediaItem);
JsonMediaItem.prototype.toJsonObject=function(){return JsonMediaItem.copyFields(this.fields_)
};
JsonMediaItem.copyFields=function(A){var B={};
for(var C in A){B[C]=A[C]
}return B
};