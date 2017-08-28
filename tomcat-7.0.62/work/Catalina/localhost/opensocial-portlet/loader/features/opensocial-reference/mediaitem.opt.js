opensocial.MediaItem=function(D,B,C){this.fields_={};
if(C){for(var A in C){if(C.hasOwnProperty(A)){this.fields_[A]=C[A]
}}}this.fields_[opensocial.MediaItem.Field.MIME_TYPE]=D;
this.fields_[opensocial.MediaItem.Field.URL]=B
};
opensocial.MediaItem.Type={IMAGE:"image",VIDEO:"video",AUDIO:"audio"};
opensocial.MediaItem.Field={ALBUM_ID:"albumId",CREATED:"created",DESCRIPTION:"description",DURATION:"duration",FILE_SIZE:"fileSize",ID:"id",LANGUAGE:"language",LAST_UPDATED:"lastUpdated",LOCATION:"location",MIME_TYPE:"mimeType",NUM_COMMENTS:"numComments",NUM_VIEWS:"numViews",NUM_VOTES:"numVotes",RATING:"rating",START_TIME:"startTime",TAGGED_PEOPLE:"taggedPeople",TAGS:"tags",THUMBNAIL_URL:"thumbnailUrl",TITLE:"title",TYPE:"type",URL:"url"};
opensocial.MediaItem.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.MediaItem.prototype.setField=function(A,B){return(this.fields_[A]=B)
};