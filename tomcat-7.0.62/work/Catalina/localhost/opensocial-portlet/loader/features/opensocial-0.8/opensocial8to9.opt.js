opensocial.DataRequest.prototype.newUpdatePersonAppDataRequest_09=opensocial.DataRequest.prototype.newUpdatePersonAppDataRequest;
opensocial.DataRequest.prototype.newUpdatePersonAppDataRequest=function(C,A,B){if(C!==opensocial.IdSpec.PersonId.VIEWER){throw Error("Cannot update app data for person "+C)
}return this.newUpdatePersonAppDataRequest_09(A,B)
};
opensocial.DataRequest.prototype.newRemovePersonAppDataRequest_09=opensocial.DataRequest.prototype.newRemovePersonAppDataRequest;
opensocial.DataRequest.prototype.newRemovePersonAppDataRequest=function(B,A){if(B!==opensocial.IdSpec.PersonId.VIEWER){throw Error("Cannot remove app data for person "+B)
}return this.newRemovePersonAppDataRequest_09(A)
};