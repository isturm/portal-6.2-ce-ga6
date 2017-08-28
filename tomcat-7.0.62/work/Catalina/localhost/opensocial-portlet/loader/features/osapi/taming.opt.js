var tamings___=tamings___||[];
tamings___.push(function(A){___.tamesTo(osapi.newBatch,___.markFuncFreeze(function(){var C=osapi.newBatch();
___.markInnocent(C.add,"add");
___.markInnocent(C.execute,"execute");
return ___.tame(C)
}));
A.outers.osapi=___.tame(osapi);
___.grantRead(A.outers,"osapi");
var B=A;
gadgets.util.registerOnLoadHandler(function(){if(osapi&&osapi.people&&osapi.people.get){caja___.whitelistFuncs([[osapi.people,"getViewer"],[osapi.people,"getViewerFriends"],[osapi.people,"getOwner"],[osapi.people,"getOwnerFriends"]]);
B.outers.osapi.people.getViewer=___.tame(osapi.people.getViewer);
B.outers.osapi.people.getViewerFriends=___.tame(osapi.people.getViewerFriends);
B.outers.osapi.people.getOwner=___.tame(osapi.people.getOwner);
B.outers.osapi.people.getOwnerFriends=___.tame(osapi.people.getOwnerFriends)
}})
});