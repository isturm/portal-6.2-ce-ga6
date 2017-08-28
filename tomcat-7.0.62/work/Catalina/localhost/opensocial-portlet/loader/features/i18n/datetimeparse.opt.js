gadgets.i18n=gadgets.i18n||{};
gadgets.i18n.DateTimeParse=function(A){this.symbols_=A
};
gadgets.i18n.DateTimeParse.prototype.year=0;
gadgets.i18n.DateTimeParse.prototype.month=0;
gadgets.i18n.DateTimeParse.prototype.dayOfMonth=0;
gadgets.i18n.DateTimeParse.prototype.hours=0;
gadgets.i18n.DateTimeParse.prototype.minutes=0;
gadgets.i18n.DateTimeParse.prototype.seconds=0;
gadgets.i18n.DateTimeParse.prototype.milliseconds=0;
gadgets.i18n.DateTimeParse.ambiguousYearCenturyStart=80;
gadgets.i18n.DateTimeParse.prototype.applyPattern=function(E){this.patternParts_=[];
var F=false;
var A="";
for(var B=0;
B<E.length;
B++){var C=E.charAt(B);
if(C==" "){if(A.length>0){this.patternParts_.push({text:A,count:0,abutStart:false});
A=""
}this.patternParts_.push({text:" ",count:0,abutStart:false});
while(B+1<E.length&&E.charAt(B+1)==" "){B++
}}else{if(F){if(C=="'"){if(B+1<E.length&&E.charAt(B+1)=="'"){A+=C;
++B
}else{F=false
}}else{A+=C
}}else{if(gadgets.i18n.DateTimeParse.PATTERN_CHARS_.indexOf(C)>=0){if(A.length>0){this.patternParts_.push({text:A,count:0,abutStart:false});
A=""
}var D=this.getNextCharCount_(E,B);
this.patternParts_.push({text:C,count:D,abutStart:false});
B+=D-1
}else{if(C=="'"){if(B+1<E.length&&E.charAt(B+1)=="'"){A+="'";
B++
}else{F=true
}}else{A+=C
}}}}}if(A.length>0){this.patternParts_.push({text:A,count:0,abutStart:false})
}this.markAbutStart_()
};
gadgets.i18n.DateTimeParse.prototype.applyStandardPattern=function(B){var A;
if(B<4){A=this.symbols_.DATEFORMATS[B]
}else{if(B<8){A=this.symbols_.TIMEFORMATS[B-4]
}else{if(B<12){A=this.symbols_.DATEFORMATS[B-8];
A+=" ";
A+=this.symbols_.TIMEFORMATS[B-8]
}else{return this.applyStandardPattern(gadgets.i18n.MEDIUM_DATETIME_FORMAT)
}}}return this.applyPattern(A)
};
gadgets.i18n.DateTimeParse.prototype.parse=function(B,C,A){return this.internalParse_(B,C,A,false)
};
gadgets.i18n.DateTimeParse.prototype.internalParse_=function(J,B,D,E){var A=new gadgets.i18n.DateTimeParse.MyDate_();
var K=[B];
var I=-1;
var C=0;
var H=0;
for(var F=0;
F<this.patternParts_.length;
++F){if(this.patternParts_[F].count>0){if(I<0&&this.patternParts_[F].abutStart){I=F;
C=B;
H=0
}if(I>=0){var G=this.patternParts_[F].count;
if(F==I){G-=H;
H++;
if(G==0){return 0
}}if(!this.subParse_(J,K,this.patternParts_[F],G,A)){F=I-1;
K[0]=C;
continue
}}else{I=-1;
if(!this.subParse_(J,K,this.patternParts_[F],0,A)){return 0
}}}else{I=-1;
if(this.patternParts_[F].text.charAt(0)==" "){var L=K[0];
this.skipSpace_(J,K);
if(K[0]>L){continue
}}else{if(J.indexOf(this.patternParts_[F].text,K[0])==K[0]){K[0]+=this.patternParts_[F].text.length;
continue
}}return 0
}}return A.calcDate_(D,E)?K[0]-B:0
};
gadgets.i18n.DateTimeParse.prototype.getNextCharCount_=function(C,D){var B=C.charAt(D);
var A=D+1;
while(A<C.length&&C.charAt(A)==B){++A
}return A-D
};
gadgets.i18n.DateTimeParse.PATTERN_CHARS_="GyMdkHmsSEDahKzZv";
gadgets.i18n.DateTimeParse.NUMERIC_FORMAT_CHARS_="MydhHmsSDkK";
gadgets.i18n.DateTimeParse.prototype.isNumericField_=function(A){if(A.count<=0){return false
}var B=gadgets.i18n.DateTimeParse.NUMERIC_FORMAT_CHARS_.indexOf(A.text.charAt(0));
return B>0||B==0&&A.count<3
};
gadgets.i18n.DateTimeParse.prototype.markAbutStart_=function(){var B=false;
for(var A=0;
A<this.patternParts_.length;
A++){if(this.isNumericField_(this.patternParts_[A])){if(!B&&A+1<this.patternParts_.length&&this.isNumericField_(this.patternParts_[A+1])){B=true;
this.patternParts_[A].abutStart=true
}}else{B=false
}}};
gadgets.i18n.DateTimeParse.prototype.skipSpace_=function(B,C){var A=B.substring(C[0]).match(/^\s+/);
if(A){C[0]+=A[0].length
}};
gadgets.i18n.DateTimeParse.prototype.subParse_=function(F,H,B,A,E){this.skipSpace_(F,H);
var G=H[0];
var C=B.text.charAt(0);
var D=-1;
if(this.isNumericField_(B)){if(A>0){if((G+A)>F.length){return false
}D=this.parseInt_(F.substring(0,G+A),H)
}else{D=this.parseInt_(F,H)
}}switch(C){case"G":E.era=this.matchString_(F,H,this.symbols_.ERAS);
return true;
case"M":return this.subParseMonth_(F,H,E,D);
case"E":return this.subParseDayOfWeek_(F,H,E);
case"a":E.ampm=this.matchString_(F,H,this.symbols_.AMPMS);
return true;
case"y":return this.subParseYear_(F,H,G,D,B,E);
case"d":E.day=D;
return true;
case"S":return this.subParseFractionalSeconds_(D,H,G,E);
case"h":if(D==12){D=0
}case"K":case"H":case"k":E.hours=D;
return true;
case"m":E.minutes=D;
return true;
case"s":E.seconds=D;
return true;
case"z":case"Z":case"v":return this.subparseTimeZoneInGMT_(F,H,E);
default:return false
}};
gadgets.i18n.DateTimeParse.prototype.subParseYear_=function(E,G,F,C,A,D){var B;
if(C<0){B=E.charAt(G[0]);
if(B!="+"&&B!="-"){return false
}G[0]++;
C=this.parseInt_(E,G);
if(C<0){return false
}if(B=="-"){C=-C
}}if(B==null&&(G[0]-F)==2&&A.count==2){D.setTwoDigitYear_(C)
}else{D.year=C
}return true
};
gadgets.i18n.DateTimeParse.prototype.subParseMonth_=function(C,D,B,A){if(A<0){A=this.matchString_(C,D,this.symbols_.MONTHS);
if(A<0){A=this.matchString_(C,D,this.symbols_.SHORTMONTHS)
}if(A<0){return false
}B.month=A;
return true
}else{B.month=A-1;
return true
}};
gadgets.i18n.DateTimeParse.prototype.subParseDayOfWeek_=function(C,D,B){var A=this.matchString_(C,D,this.symbols_.WEEKDAYS);
if(A<0){A=this.matchString_(C,D,this.symbols_.SHORTWEEKDAYS)
}if(A<0){return false
}B.dayOfWeek=A;
return true
};
gadgets.i18n.DateTimeParse.prototype.subParseFractionalSeconds_=function(B,E,D,C){var A=E[0]-D;
C.milliseconds=A<3?B*Math.pow(10,3-A):Math.round(B/Math.pow(10,A-3));
return true
};
gadgets.i18n.DateTimeParse.prototype.subparseTimeZoneInGMT_=function(B,C,A){if(B.indexOf("GMT",C[0])==C[0]){C[0]+=3;
return this.parseTimeZoneOffset_(B,C,A)
}return this.parseTimeZoneOffset_(B,C,A)
};
gadgets.i18n.DateTimeParse.prototype.parseTimeZoneOffset_=function(F,G,D){if(G[0]>=F.length){D.tzOffset=0;
return true
}var A=1;
switch(F.charAt(G[0])){case"-":A=-1;
case"+":G[0]++
}var B=G[0];
var C=this.parseInt_(F,G);
if(C==0&&G[0]==B){return false
}var E;
if(G[0]<F.length&&F.charAt(G[0])==":"){E=C*60;
G[0]++;
B=G[0];
C=this.parseInt_(F,G);
if(C==0&&G[0]==B){return false
}E+=C
}else{E=C;
if(E<24&&(G[0]-B)<=2){E*=60
}else{}E=E%100+E/100*60
}E*=A;
D.tzOffset=-E;
return true
};
gadgets.i18n.DateTimeParse.prototype.parseInt_=function(B,C){var A=B.substring(C[0]).match(/^\d+/);
if(!A){return -1
}C[0]+=A[0].length;
return parseInt(A[0],10)
};
gadgets.i18n.DateTimeParse.prototype.matchString_=function(G,H,F){var C=0;
var E=-1;
var D=G.substring(H[0]).toLowerCase();
for(var B=0;
B<F.length;
++B){var A=F[B].length;
if(A>C&&D.indexOf(F[B].toLowerCase())==0){E=B;
C=A
}}if(E>=0){H[0]+=C
}return E
};
gadgets.i18n.DateTimeParse.MyDate_=function(){};
gadgets.i18n.DateTimeParse.MyDate_.prototype.setTwoDigitYear_=function(B){var A=new Date();
var D=A.getFullYear()-gadgets.i18n.DateTimeParse.ambiguousYearCenturyStart;
var C=D%100;
this.ambiguousYear=(B==C);
B+=Math.floor(D/100)*100+(B<C?100:0);
return this.year=B
};
gadgets.i18n.DateTimeParse.MyDate_.prototype.calcDate_=function(D,A){if(this.era!=undefined&&this.year!=undefined&&this.era==0&&this.year>0){this.year=-(this.year-1)
}if(this.year!=undefined){D.setFullYear(this.year)
}var E=D.getDate();
D.setDate(1);
if(this.month!=undefined){D.setMonth(this.month)
}if(this.day!=undefined){D.setDate(this.day)
}else{D.setDate(E)
}if(this.hours==undefined){this.hours=D.getHours()
}if(this.ampm!=undefined&&this.ampm>0){if(this.hours<12){this.hours+=12
}}D.setHours(this.hours);
if(this.minutes!=undefined){D.setMinutes(this.minutes)
}if(this.seconds!=undefined){D.setSeconds(this.seconds)
}if(this.milliseconds!=undefined){D.setMilliseconds(this.milliseconds)
}if(A&&(this.year!=undefined&&this.year!=D.getFullYear()||this.month!=undefined&&this.month!=D.getMonth()||this.dayOfMonth!=undefined&&this.dayOfMonth!=D.getDate()||this.hours>=24||this.minutes>=60||this.seconds>=60||this.milliseconds>=1000)){return false
}if(this.tzOffset!=undefined){var G=D.getTimezoneOffset();
D.setTime(D.getTime()+(this.tzOffset-G)*60*1000)
}if(this.ambiguousYear){var C=new Date();
C.setFullYear(C.getFullYear()-gadgets.i18n.DateTimeParse.ambiguousYearCenturyStart);
if(D.getTime()<C.getTime()){D.setFullYear(C.getFullYear()+100)
}}if(this.dayOfWeek!=undefined){if(this.day==undefined){var B=(7+this.dayOfWeek-D.getDay())%7;
if(B>3){B-=7
}var F=D.getMonth();
D.setDate(D.getDate()+B);
if(D.getMonth()!=F){D.setDate(D.getDate()+(B>0?-7:7))
}}else{if(this.dayOfWeek!=D.getDay()){return false
}}}return true
};