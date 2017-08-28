opensocial.DataRequest=function(){this.requestObjects_=[]
};
opensocial.DataRequest.prototype.requestObjects_=null;
opensocial.DataRequest.prototype.getRequestObjects=function(){return this.requestObjects_
};
opensocial.DataRequest.prototype.add=function(B,A){return this.requestObjects_.push({key:A,request:B})
};
opensocial.DataRequest.prototype.send=function(A){var B=A||function(){};
opensocial.Container.get().requestData(this,B)
};
opensocial.DataRequest.SortOrder={TOP_FRIENDS:"topFriends",NAME:"name"};
opensocial.DataRequest.FilterType={ALL:"all",HAS_APP:"hasApp",TOP_FRIENDS:"topFriends",IS_FRIENDS_WITH:"isFriendsWith"};
opensocial.DataRequest.PeopleRequestFields={PROFILE_DETAILS:"profileDetail",SORT_ORDER:"sortOrder",FILTER:"filter",FILTER_OPTIONS:"filterOptions",FIRST:"first",MAX:"max",APP_DATA:"appData",ESCAPE_TYPE:"escapeType"};
opensocial.DataRequest.prototype.addDefaultParam=function(C,B,A){C[B]=C[B]||A
};
opensocial.DataRequest.prototype.addDefaultProfileFields=function(B){var A=opensocial.DataRequest.PeopleRequestFields;
var C=B[A.PROFILE_DETAILS]||[];
B[A.PROFILE_DETAILS]=C.concat([opensocial.Person.Field.ID,opensocial.Person.Field.NAME,opensocial.Person.Field.THUMBNAIL_URL])
};
opensocial.DataRequest.prototype.asArray=function(A){if(opensocial.Container.isArray(A)){return A
}else{return[A]
}};
opensocial.DataRequest.prototype.newCreateAlbumRequest=function(B,A){return opensocial.Container.get().newCreateAlbumRequest(B,A)
};
opensocial.DataRequest.prototype.newCreateMediaItemRequest=function(A,C,B){return opensocial.Container.get().newCreateMediaItemRequest(A,C,B)
};
opensocial.DataRequest.prototype.newDeleteAlbumRequest=function(A,B){return opensocial.Container.get().newDeleteAlbumRequest(A,B)
};
opensocial.DataRequest.prototype.newFetchPersonRequest=function(B,A){A=A||{};
this.addDefaultProfileFields(A);
return opensocial.Container.get().newFetchPersonRequest(B,A)
};
opensocial.DataRequest.prototype.newFetchPeopleRequest=function(B,C){C=C||{};
var A=opensocial.DataRequest.PeopleRequestFields;
this.addDefaultProfileFields(C);
this.addDefaultParam(C,A.SORT_ORDER,opensocial.DataRequest.SortOrder.TOP_FRIENDS);
this.addDefaultParam(C,A.FILTER,opensocial.DataRequest.FilterType.ALL);
this.addDefaultParam(C,A.FIRST,0);
this.addDefaultParam(C,A.MAX,20);
return opensocial.Container.get().newFetchPeopleRequest(B,C)
};
opensocial.DataRequest.AlbumRequestFields={FIRST:"first",MAX:"max"};
opensocial.DataRequest.MediaItemRequestFields={FIRST:"first",MAX:"max"};
opensocial.DataRequest.DataRequestFields={ESCAPE_TYPE:"escapeType"};
opensocial.DataRequest.prototype.newFetchPersonAppDataRequest=function(A,C,B){return opensocial.Container.get().newFetchPersonAppDataRequest(A,this.asArray(C),B)
};
opensocial.DataRequest.prototype.newUpdateAlbumRequest=function(A,B,C){return opensocial.Container.get().newUpdateAlbumRequest(A,B,C)
};
opensocial.DataRequest.prototype.newUpdateMediaItemRequest=function(A,C,B,D){return opensocial.Container.get().newUpdateMediaItemRequest(A,C,B,D)
};
opensocial.DataRequest.prototype.newUpdatePersonAppDataRequest=function(A,B){return opensocial.Container.get().newUpdatePersonAppDataRequest(A,B)
};
opensocial.DataRequest.prototype.newRemovePersonAppDataRequest=function(A){return opensocial.Container.get().newRemovePersonAppDataRequest(A)
};
opensocial.DataRequest.ActivityRequestFields={APP_ID:"appId",FIRST:"first",MAX:"max"};
opensocial.DataRequest.prototype.newFetchActivitiesRequest=function(B,C){C=C||{};
var A=opensocial.DataRequest.ActivityRequestFields;
this.addDefaultParam(C,A.FIRST,0);
this.addDefaultParam(C,A.MAX,20);
return opensocial.Container.get().newFetchActivitiesRequest(B,C)
};
opensocial.DataRequest.prototype.newFetchAlbumsRequest=function(B,C){C=C||{};
var A=opensocial.DataRequest.AlbumRequestFields;
this.addDefaultParam(C,A.FIRST,0);
this.addDefaultParam(C,A.MAX,20);
return opensocial.Container.get().newFetchAlbumsRequest(B,C)
};
opensocial.DataRequest.prototype.newFetchMediaItemsRequest=function(B,C,D){D=D||{};
var A=opensocial.DataRequest.MediaItemRequestFields;
this.addDefaultParam(D,A.FIRST,0);
this.addDefaultParam(D,A.MAX,20);
return opensocial.Container.get().newFetchMediaItemsRequest(B,C,D)
};
opensocial.DataRequest.prototype.newFetchMessageCollectionsRequest=function(A,B){B=B||{};
return opensocial.Container.get().newFetchMessageCollectionsRequest(A,B)
};
opensocial.DataRequest.prototype.newFetchMessagesRequest=function(A,C,B){B=B||{};
return opensocial.Container.get().newFetchMessagesRequest(A,C,B)
};