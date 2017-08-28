var JsonAlbum=function(A){A=A||{};
JsonAlbum.constructObject(A,"location",opensocial.Address);
opensocial.Album.call(this,A)
};
JsonAlbum.inherits(opensocial.Album);
JsonAlbum.prototype.toJsonObject=function(){return JsonAlbum.copyFields(this.fields_)
};
JsonAlbum.constructObject=function(C,D,A){var B=C[D];
if(B){C[D]=new A(B)
}};
JsonAlbum.copyFields=function(A){var B={};
for(var C in A){B[C]=A[C]
}return B
};