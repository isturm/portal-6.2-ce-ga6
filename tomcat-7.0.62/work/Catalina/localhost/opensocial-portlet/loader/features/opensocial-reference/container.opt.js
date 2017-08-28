opensocial.Container=function(){};
opensocial.Container.container_=null;
opensocial.Container.setContainer=function(A){opensocial.Container.container_=A
};
opensocial.Container.get=function(){return opensocial.Container.container_
};
opensocial.Container.prototype.getEnvironment=function(){};
opensocial.Container.prototype.requestSendMessage=function(A,D,B,C){gadgets.rpc.call(null,"requestSendMessage",B,A,D,B,C)
};
opensocial.Container.prototype.requestShareApp=function(A,D,B,C){if(B){window.setTimeout(function(){B(new opensocial.ResponseItem(null,null,opensocial.ResponseItem.Error.NOT_IMPLEMENTED,null))
},0)
}};
opensocial.Container.prototype.requestCreateActivity=function(C,B,A){if(A){window.setTimeout(function(){A(new opensocial.ResponseItem(null,null,opensocial.ResponseItem.Error.NOT_IMPLEMENTED,null))
},0)
}};
opensocial.Container.prototype.hasPermission=function(A){return false
};
opensocial.Container.prototype.requestPermission=function(B,C,A){if(A){window.setTimeout(function(){A(new opensocial.ResponseItem(null,null,opensocial.ResponseItem.Error.NOT_IMPLEMENTED,null))
},0)
}};
opensocial.Container.prototype.requestData=function(A,B){};
opensocial.Container.prototype.newCreateAlbumRequest=function(B,A){};
opensocial.Container.prototype.newCreateMediaItemRequest=function(A,C,B){};
opensocial.Container.prototype.newDeleteAlbumRequest=function(A,B){};
opensocial.Container.prototype.newFetchPersonRequest=function(B,A){};
opensocial.Container.prototype.newFetchPeopleRequest=function(A,B){};
opensocial.Container.prototype.newFetchPersonAppDataRequest=function(A,C,B){};
opensocial.Container.prototype.newUpdatePersonAppDataRequest=function(A,B){};
opensocial.Container.prototype.newRemovePersonAppDataRequest=function(A){};
opensocial.Container.prototype.newUpdateAlbumRequest=function(B,C,A){};
opensocial.Container.prototype.newUpdateMediaItemRequest=function(B,D,C,A){};
opensocial.Container.prototype.newFetchActivitiesRequest=function(A,B){};
opensocial.Container.prototype.newFetchAlbumsRequest=function(A,B){};
opensocial.Container.prototype.newFetchMediaItemsRequest=function(A,B){};
opensocial.Container.prototype.newFetchMessageCollectionsRequest=function(A,B){};
opensocial.Container.prototype.newFetchMessagesRequest=function(A,C,B){};
opensocial.Container.prototype.newCollection=function(C,B,A){return new opensocial.Collection(C,B,A)
};
opensocial.Container.prototype.newPerson=function(A,B,C){return new opensocial.Person(A,B,C)
};
opensocial.Container.prototype.newActivity=function(A){return new opensocial.Activity(A)
};
opensocial.Container.prototype.newAlbum=function(A){return new opensocial.Album(A)
};
opensocial.Container.prototype.newMediaItem=function(C,A,B){return new opensocial.MediaItem(C,A,B)
};
opensocial.Container.prototype.newMessage=function(A,B){return new opensocial.Message(A,B)
};
opensocial.Container.prototype.newIdSpec=function(A){return new opensocial.IdSpec(A)
};
opensocial.Container.prototype.newNavigationParameters=function(A){return new opensocial.NavigationParameters(A)
};
opensocial.Container.prototype.newResponseItem=function(A,C,B,D){return new opensocial.ResponseItem(A,C,B,D)
};
opensocial.Container.prototype.newDataResponse=function(A,B){return new opensocial.DataResponse(A,B)
};
opensocial.Container.prototype.newDataRequest=function(){return new opensocial.DataRequest()
};
opensocial.Container.prototype.newEnvironment=function(B,A){return new opensocial.Environment(B,A)
};
opensocial.Container.prototype.invalidateCache=function(){};
opensocial.Container.isArray=function(A){return A instanceof Array
};
opensocial.Container.getField=function(A,B,C){var D=A[B];
return opensocial.Container.escape(D,C,false)
};
opensocial.Container.escape=function(C,B,A){if(B&&B[opensocial.DataRequest.DataRequestFields.ESCAPE_TYPE]==opensocial.EscapeType.NONE){return C
}else{return gadgets.util.escape(C,A)
}};