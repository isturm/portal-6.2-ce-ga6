gadgets.util.registerOnLoadHandler(function(){if(osapi&&osapi.people&&osapi.people.get){osapi.people.getViewer=function(A){A=A||{};
A.userId="@viewer";
A.groupId="@self";
return osapi.people.get(A)
};
osapi.people.getViewerFriends=function(A){A=A||{};
A.userId="@viewer";
A.groupId="@friends";
return osapi.people.get(A)
};
osapi.people.getOwner=function(A){A=A||{};
A.userId="@owner";
A.groupId="@self";
return osapi.people.get(A)
};
osapi.people.getOwnerFriends=function(A){A=A||{};
A.userId="@owner";
A.groupId="@friends";
return osapi.people.get(A)
}
}});