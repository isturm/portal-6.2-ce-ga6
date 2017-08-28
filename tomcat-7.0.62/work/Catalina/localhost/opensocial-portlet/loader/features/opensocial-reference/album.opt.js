opensocial.Album=function(A){this.fields_=A||{}
};
opensocial.Album.Field={DESCRIPTION:"description",ID:"id",LOCATION:"location",MEDIA_ITEM_COUNT:"mediaItemCount",MEDIA_MIME_TYPE:"mediaMimeType",MEDIA_TYPE:"mediaType",OWNER_ID:"ownerId",THUMBNAIL_URL:"thumbnailUrl",TITLE:"title"};
opensocial.Album.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.Album.prototype.setField=function(A,B){return this.fields_[A]=B
};