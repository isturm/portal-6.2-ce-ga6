wave.Participant=function(C,A,B){this.id_=C||"";
this.displayName_=A||"";
this.thumbnailUrl_=B||""
};
wave.Participant.prototype.getId=function(){return this.id_
};
wave.Participant.prototype.getDisplayName=function(){return this.displayName_
};
wave.Participant.prototype.getThumbnailUrl=function(){return this.thumbnailUrl_
};
wave.Participant.fromJson_=function(A){var B=new wave.Participant();
B.id_=A.id;
B.displayName_=A.displayName;
B.thumbnailUrl_=A.thumbnailUrl;
return B
};