gadgets.i18n=gadgets.i18n||{};
gadgets.i18n.DateTimeFormat=function(A){this.symbols_=A
};
gadgets.i18n.DateTimeFormat.TOKENS_=[/^\'(?:[^\']|\'\')*\'/,/^(?:G+|y+|M+|k+|S+|E+|a+|h+|K+|H+|c+|L+|Q+|d+|m+|s+|v+|z+|Z+)/,/^[^\'GyMkSEahKHcLQdmsvzZ]+/];
gadgets.i18n.DateTimeFormat.PartTypes={QUOTED_STRING:0,FIELD:1,LITERAL:2};
gadgets.i18n.DateTimeFormat.padNumber_=function(B,D){var C=String(B);
var A=C.indexOf(".");
if(A==-1){A=C.length
}var E=new Array(Math.max(0,D-A)+1);
return E.join("0")+C
};
gadgets.i18n.DateTimeFormat.prototype.applyPattern=function(D){this.patternParts_=[];
while(D){for(var C=0;
C<gadgets.i18n.DateTimeFormat.TOKENS_.length;
++C){var A=D.match(gadgets.i18n.DateTimeFormat.TOKENS_[C]);
if(A){var B=A[0];
D=D.substring(B.length);
if(C==gadgets.i18n.DateTimeFormat.PartTypes.QUOTED_STRING){if(B=="''"){B="'"
}else{B=B.substring(1,B.length-1);
B=B.replace(/\'\'/,"'")
}}this.patternParts_.push({text:B,type:C});
break
}}}};
gadgets.i18n.DateTimeFormat.prototype.format=function(B){var A=[];
for(var C=0;
C<this.patternParts_.length;
++C){var D=this.patternParts_[C].text;
if(gadgets.i18n.DateTimeFormat.PartTypes.FIELD==this.patternParts_[C].type){A.push(this.formatField_(D,B))
}else{A.push(D)
}}return A.join("")
};
gadgets.i18n.DateTimeFormat.prototype.applyStandardPattern=function(B){var A;
if(B<4){A=this.symbols_.DATEFORMATS[B]
}else{if(B<8){A=this.symbols_.TIMEFORMATS[B-4]
}else{if(B<12){A=this.symbols_.DATEFORMATS[B-8]+" "+this.symbols_.TIMEFORMATS[B-8]
}else{this.applyStandardPattern(gadgets.i18n.MEDIUM_DATETIME_FORMAT)
}}}return this.applyPattern(A)
};
gadgets.i18n.DateTimeFormat.prototype.formatEra_=function(B,A){var C=A.getFullYear()>0?1:0;
return B>=4?this.symbols_.ERANAMES[C]:this.symbols_.ERAS[C]
};
gadgets.i18n.DateTimeFormat.prototype.formatYear_=function(B,A){var C=A.getFullYear();
if(C<0){C=-C
}return B==2?gadgets.i18n.DateTimeFormat.padNumber_(C%100,2):String(C)
};
gadgets.i18n.DateTimeFormat.prototype.formatMonth_=function(B,A){var C=A.getMonth();
switch(B){case 5:return this.symbols_.NARROWMONTHS[C];
case 4:return this.symbols_.MONTHS[C];
case 3:return this.symbols_.SHORTMONTHS[C];
default:return gadgets.i18n.DateTimeFormat.padNumber_(C+1,B)
}};
gadgets.i18n.DateTimeFormat.prototype.format24Hours_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getHours()||24,B)
};
gadgets.i18n.DateTimeFormat.prototype.formatFractionalSeconds_=function(B,A){var C=A.getTime()%1000/1000;
return C.toFixed(Math.min(3,B)).substr(2)+(B>3?gadgets.i18n.DateTimeFormat.padNumber_(0,B-3):"")
};
gadgets.i18n.DateTimeFormat.prototype.formatDayOfWeek_=function(B,A){var C=A.getDay();
return B>=4?this.symbols_.WEEKDAYS[C]:this.symbols_.SHORTWEEKDAYS[C]
};
gadgets.i18n.DateTimeFormat.prototype.formatAmPm_=function(C,B){var A=B.getHours();
return this.symbols_.AMPMS[A>=12&&A<24?1:0]
};
gadgets.i18n.DateTimeFormat.prototype.format1To12Hours_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getHours()%12||12,B)
};
gadgets.i18n.DateTimeFormat.prototype.format0To11Hours_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getHours()%12,B)
};
gadgets.i18n.DateTimeFormat.prototype.format0To23Hours_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getHours(),B)
};
gadgets.i18n.DateTimeFormat.prototype.formatStandaloneDay_=function(B,A){var C=A.getDay();
switch(B){case 5:return this.symbols_.STANDALONENARROWWEEKDAYS[C];
case 4:return this.symbols_.STANDALONEWEEKDAYS[C];
case 3:return this.symbols_.STANDALONESHORTWEEKDAYS[C];
default:return gadgets.i18n.DateTimeFormat.padNumber_(C,1)
}};
gadgets.i18n.DateTimeFormat.prototype.formatStandaloneMonth_=function(B,A){var C=A.getMonth();
switch(B){case 5:return this.symbols_.STANDALONENARROWMONTHS[C];
case 4:return this.symbols_.STANDALONEMONTHS[C];
case 3:return this.symbols_.STANDALONESHORTMONTHS[C];
default:return gadgets.i18n.DateTimeFormat.padNumber_(C+1,B)
}};
gadgets.i18n.DateTimeFormat.prototype.formatQuarter_=function(B,A){var C=Math.floor(A.getMonth()/3);
return B<4?this.symbols_.SHORTQUARTERS[C]:this.symbols_.QUARTERS[C]
};
gadgets.i18n.DateTimeFormat.prototype.formatDate_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getDate(),B)
};
gadgets.i18n.DateTimeFormat.prototype.formatMinutes_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getMinutes(),B)
};
gadgets.i18n.DateTimeFormat.prototype.formatSeconds_=function(B,A){return gadgets.i18n.DateTimeFormat.padNumber_(A.getSeconds(),B)
};
gadgets.i18n.DateTimeFormat.prototype.formatTimeZoneRFC_=function(C,B){if(C<4){var D=B.getTimezoneOffset();
var A="-";
if(D<0){D=-D;
A="+"
}D=D/3*5+D%60;
return A+gadgets.i18n.DateTimeFormat.padNumber_(D,4)
}return this.formatGMT_(C,B)
};
gadgets.i18n.DateTimeFormat.prototype.formatGMT_=function(C,B){var D=B.getTimezoneOffset();
var A=[];
if(D>0){A.push("GMT-")
}else{D=-D;
A.push("GMT+")
}A.push(gadgets.i18n.DateTimeFormat.padNumber_(D/60,2));
A.push(":");
A.push(gadgets.i18n.DateTimeFormat.padNumber_(D%60,2));
return A.join("")
};
gadgets.i18n.DateTimeFormat.prototype.formatField_=function(C,A){var B=C.length;
switch(C.charAt(0)){case"G":return this.formatEra_(B,A);
case"y":return this.formatYear_(B,A);
case"M":return this.formatMonth_(B,A);
case"k":return this.format24Hours_(B,A);
case"S":return this.formatFractionalSeconds_(B,A);
case"E":return this.formatDayOfWeek_(B,A);
case"a":return this.formatAmPm_(B,A);
case"h":return this.format1To12Hours_(B,A);
case"K":return this.format0To11Hours_(B,A);
case"H":return this.format0To23Hours_(B,A);
case"c":return this.formatStandaloneDay_(B,A);
case"L":return this.formatStandaloneMonth_(B,A);
case"Q":return this.formatQuarter_(B,A);
case"d":return this.formatDate_(B,A);
case"m":return this.formatMinutes_(B,A);
case"s":return this.formatSeconds_(B,A);
case"v":return this.formatGMT_(B,A);
case"z":return this.formatGMT_(B,A);
case"Z":return this.formatTimeZoneRFC_(B,A);
default:return""
}};