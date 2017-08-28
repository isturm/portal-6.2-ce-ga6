opensocial.Message=function(A,B){if(typeof A=="string"){this.fields_=B||{};
this.fields_[opensocial.Message.Field.BODY]=A
}else{this.fields_=A||{}
}};
opensocial.Message.Field={APP_URL:"appUrl",BODY:"body",BODY_ID:"bodyId",COLLECTION_IDS:"collectionIds",ID:"id",PARENT_ID:"parentId",RECIPIENTS:"recipients",SENDER_ID:"senderId",STATUS:"status",TIME_SENT:"timeSent",TITLE:"title",TITLE_ID:"titleId",TYPE:"type",UPDATED:"updated",URLS:"urls"};
opensocial.Message.Type={EMAIL:"email",NOTIFICATION:"notification",PRIVATE_MESSAGE:"privateMessage",PUBLIC_MESSAGE:"publicMessage"};
opensocial.Message.Status={NEW:"new",DELETED:"deleted",FLAGGED:"flagged"};
opensocial.Message.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.Message.prototype.setField=function(A,B){return(this.fields_[A]=B)
};