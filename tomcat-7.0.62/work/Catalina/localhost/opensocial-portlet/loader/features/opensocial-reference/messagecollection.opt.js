opensocial.MessageCollection=function(A){this.fields_=A||{}
};
opensocial.MessageCollection.Field={ID:"id",TITLE:"title",TOTAL:"total",UNREAD:"unread",UPDATED:"updated",URLS:"urls"};
opensocial.MessageCollection.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.MessageCollection.prototype.setField=function(A,B){return this.fields_[A]=B
};