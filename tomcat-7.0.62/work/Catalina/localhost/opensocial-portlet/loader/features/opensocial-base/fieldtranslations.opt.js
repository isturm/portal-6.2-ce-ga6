window.FieldTranslations=(function(){function B(C){if(C){C.key=C.value
}}function A(C){if(C){C.address=C.value
}}return{translateEnumJson:B,translateUrlJson:A,translateServerPersonToJsPerson:function(J,D){if(J.emails){for(var G=0;
G<J.emails.length;
G++){J.emails[G].address=J.emails[G].value
}}if(J.phoneNumbers){for(var C=0;
C<J.phoneNumbers.length;
C++){J.phoneNumbers[C].number=J.phoneNumbers[C].value
}}if(J.birthday){J.dateOfBirth=J.birthday
}if(J.utcOffset){J.timeZone=J.utcOffset
}if(J.addresses){for(var F=0;
F<J.addresses.length;
F++){J.addresses[F].unstructuredAddress=J.addresses[F].formatted
}}if(J.gender){var H=J.gender=="male"?"MALE":(J.gender=="female")?"FEMALE":null;
J.gender={key:H,displayValue:J.gender}
}A(J.profileSong);
A(J.profileVideo);
if(J.urls){for(var I=0;
I<J.urls.length;
I++){A(J.urls[I])
}}B(J.drinker);
B(J.lookingFor);
B(J.networkPresence);
B(J.smoker);
if(J.organizations){J.jobs=[];
J.schools=[];
for(var E=0;
E<J.organizations.length;
E++){var K=J.organizations[E];
if(K.type=="job"){J.jobs.push(K)
}else{if(K.type=="school"){J.schools.push(K)
}}}}if(J.name){J.name.unstructured=J.name.formatted
}if(J.appData){J.appData=opensocial.Container.escape(J.appData,D,true)
}},translateJsPersonFieldsToServerFields:function(C){for(var D=0;
D<C.length;
D++){if(C[D]=="dateOfBirth"){C[D]="birthday"
}else{if(C[D]=="timeZone"){C[D]="utcOffset"
}else{if(C[D]=="jobs"){C[D]="organizations"
}else{if(C[D]=="schools"){C[D]="organizations"
}}}}}C.push("id");
C.push("displayName")
},translateIsoStringToDate:function(C){var E="([0-9]{4})(-([0-9]{2})(-([0-9]{2})(T([0-9]{2}):([0-9]{2})(:([0-9]{2})(.([0-9]+))?)?(Z|(([-+])([0-9]{2}):([0-9]{2})))?)?)?)?";
var H=C.match(new RegExp(E));
var G=0;
var D=new Date(H[1],0,1);
if(H[3]){D.setMonth(H[3]-1)
}if(H[5]){D.setDate(H[5])
}if(H[7]){D.setHours(H[7])
}if(H[8]){D.setMinutes(H[8])
}if(H[10]){D.setSeconds(H[10])
}if(H[12]){D.setMilliseconds(Number("0."+H[12])*1000)
}if(H[14]){G=(Number(H[16])*60)+Number(H[17]);
G*=((H[15]=="-")?1:-1)
}G-=D.getTimezoneOffset();
var F=(Number(D)+(G*60*1000));
return new Date(Number(F))
},addAppDataAsProfileFields:function(F){if(F){if(F.appData){var C=F.appData;
if(typeof C==="string"){C=[C]
}var E=F.profileDetail||[];
for(var D=0;
D<C.length;
D++){if(C[D]==="*"){E.push("appData")
}else{E.push("appData."+C[D])
}}F.appData=C
}}},translateStandardArguments:function(D,C){if(D.first){C.startIndex=D.first
}if(D.max){C.count=D.max
}if(D.sortOrder){C.sortBy=D.sortOrder
}if(D.filter){C.filterBy=D.filter
}if(D.filterOp){C.filterOp=D.filterOp
}if(D.filterValue){C.filterValue=D.filterValue
}if(D.fields){C.fields=D.fields
}},translateNetworkDistance:function(C,D){if(C.getField("networkDistance")){D.networkDistance=C.getField("networkDistance")
}}}
})();