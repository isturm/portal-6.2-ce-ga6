gadgets.i18n=gadgets.i18n||{};
gadgets.i18n.NumberFormat=function(A){this.symbols_=A
};
gadgets.i18n.NumberFormat.prototype.applyStandardPattern=function(B,A){switch(B){case gadgets.i18n.DECIMAL_PATTERN:this.applyPattern(this.symbols_.DECIMAL_PATTERN,A);
break;
case gadgets.i18n.SCIENTIFIC_PATTERN:this.applyPattern(this.symbols_.SCIENTIFIC_PATTERN,A);
break;
case gadgets.i18n.PERCENT_PATTERN:this.applyPattern(this.symbols_.PERCENT_PATTERN,A);
break;
case gadgets.i18n.CURRENCY_PATTERN:this.applyPattern(this.symbols_.CURRENCY_PATTERN,A);
break;
default:throw Error("Unsupported pattern type.")
}};
gadgets.i18n.NumberFormat.prototype.applyPattern=function(B,A){this.pattern_=B;
this.intlCurrencyCode_=A||this.symbols_.DEF_CURRENCY_CODE;
this.currencySymbol_=gadgets.i18n.CurrencyCodeMap[this.intlCurrencyCode_];
this.maximumIntegerDigits_=40;
this.minimumIntegerDigits_=1;
this.maximumFractionDigits_=3;
this.minimumFractionDigits_=0;
this.minExponentDigits_=0;
this.positivePrefix_="";
this.positiveSuffix_="";
this.negativePrefix_="-";
this.negativeSuffix_="";
this.multiplier_=1;
this.groupingSize_=3;
this.decimalSeparatorAlwaysShown_=false;
this.isCurrencyFormat_=false;
this.useExponentialNotation_=false;
this.parsePattern_(this.pattern_)
};
gadgets.i18n.NumberFormat.prototype.parse=function(E,D){var G=D||[0];
var F=G[0];
var A=0;
var B=E.indexOf(this.positivePrefix_,G[0])==G[0];
var C=E.indexOf(this.negativePrefix_,G[0])==G[0];
if(B&&C){if(this.positivePrefix_.length>this.negativePrefix_.length){C=false
}else{if(this.positivePrefix_.length<this.negativePrefix_.length){B=false
}}}if(B){G[0]+=this.positivePrefix_.length
}else{if(C){G[0]+=this.negativePrefix_.length
}}if(E.indexOf(this.symbols_.INFINITY,G[0])==G[0]){G[0]+=this.symbols_.INFINITY.length;
A=Infinity
}else{A=this.parseNumber_(E,G)
}if(B){if(!(E.indexOf(this.positiveSuffix_,G[0])==G[0])){G[0]=F;
return 0
}G[0]+=this.positiveSuffix_.length
}else{if(C){if(!(E.indexOf(this.negativeSuffix_,G[0])==G[0])){G[0]=F;
return 0
}G[0]+=this.negativeSuffix_.length
}}return C?-A:A
};
gadgets.i18n.NumberFormat.prototype.parseNumber_=function(L,J){var K=false;
var H=false;
var B=false;
var F=1;
var G=this.isCurrencyFormat_?this.symbols_.MONETARY_SEP:this.symbols_.DECIMAL_SEP;
var D=this.isCurrencyFormat_?this.symbols_.MONETARY_GROUP_SEP:this.symbols_.GROUP_SEP;
var C=this.symbols_.EXP_SYMBOL;
var E="";
for(;
J[0]<L.length;
J[0]++){var A=L.charAt(J[0]);
var I=this.getDigit_(A);
if(I>=0&&I<=9){E+=I;
B=true
}else{if(A==G.charAt(0)){if(K||H){break
}E+=".";
K=true
}else{if(A==D.charAt(0)||"\u00a0"==D.charAt(0)&&A==" "&&J[0]+1<L.length&&this.getDigit_(L.charAt(J[0]+1))>=0){if(K||H){break
}continue
}else{if(A==C.charAt(0)){if(H){break
}E+="E";
H=true
}else{if(A=="+"||A=="-"){E+=A
}else{if(A==this.symbols_.PERCENT.charAt(0)){if(F!=1){break
}F=100;
if(B){J[0]++;
break
}}else{if(A==this.symbols_.PERMILL.charAt(0)){if(F!=1){break
}F=1000;
if(B){J[0]++;
break
}}else{break
}}}}}}}}return parseFloat(E)/F
};
gadgets.i18n.NumberFormat.prototype.format=function(B){if(isNaN(B)){return this.symbols_.NAN
}var C=[];
var A=B<0||B==0&&1/B<0;
C.push(A?this.negativePrefix_:this.positivePrefix_);
if(!isFinite(B)){C.push(this.symbols_.INFINITY)
}else{B*=A?-1:1;
B*=this.multiplier_;
this.useExponentialNotation_?this.subformatExponential_(B,C):this.subformatFixed_(B,this.minimumIntegerDigits_,C)
}C.push(A?this.negativeSuffix_:this.positiveSuffix_);
return C.join("")
};
gadgets.i18n.NumberFormat.prototype.subformatFixed_=function(G,F,I){var C=Math.pow(10,this.maximumFractionDigits_);
G=Math.round(G*C);
var B=Math.floor(G/C);
var H=Math.floor(G-B*C);
var L=this.minimumFractionDigits_>0||H>0;
var A="";
var P=B;
while(P>100000000000000000000){A="0"+A;
P=Math.round(P/10)
}A=P+A;
var K=this.isCurrencyFormat_?this.symbols_.MONETARY_SEP:this.symbols_.DECIMAL_SEP;
var D=this.isCurrencyFormat_?this.symbols_.MONETARY_GROUP_SEP:this.symbols_.GROUP_SEP;
var O=this.symbols_.ZERO_DIGIT.charCodeAt(0);
var N=A.length;
if(B>0||F>0){for(var J=N;
J<F;
J++){I.push(this.symbols_.ZERO_DIGIT)
}for(var J=0;
J<N;
J++){I.push(String.fromCharCode(O+A.charAt(J)*1));
if(N-J>1&&this.groupingSize_>0&&((N-J)%this.groupingSize_==1)){I.push(D)
}}}else{if(!L){I.push(this.symbols_.ZERO_DIGIT)
}}if(this.decimalSeparatorAlwaysShown_||L){I.push(K)
}var E=""+(H+C);
var M=E.length;
while(E.charAt(M-1)=="0"&&M>this.minimumFractionDigits_+1){M--
}for(var J=1;
J<M;
J++){I.push(String.fromCharCode(O+E.charAt(J)*1))
}};
gadgets.i18n.NumberFormat.prototype.addExponentPart_=function(B,C){C.push(this.symbols_.EXP_SYMBOL);
if(B<0){B=-B;
C.push(this.symbols_.MINUS_SIGN)
}var D=""+B;
for(var A=D.length;
A<this.minExponentDigits_;
A++){C.push(this.symbols_.ZERO_DIGIT)
}C.push(D)
};
gadgets.i18n.NumberFormat.prototype.subformatExponential_=function(A,D){if(A==0){this.subformatFixed_(A,this.minimumIntegerDigits_,D);
this.addExponentPart_(0,D);
return 
}var B=Math.floor(Math.log(A)/Math.log(10));
A/=Math.pow(10,B);
var C=this.minimumIntegerDigits_;
if(this.maximumIntegerDigits_>1&&this.maximumIntegerDigits_>this.minimumIntegerDigits_){while((B%this.maximumIntegerDigits_)!=0){A*=10;
B--
}C=1
}else{if(this.minimumIntegerDigits_<1){B++;
A/=10
}else{B-=this.minimumIntegerDigits_-1;
A*=Math.pow(10,this.minimumIntegerDigits_-1)
}}this.subformatFixed_(A,C,D);
this.addExponentPart_(B,D)
};
gadgets.i18n.NumberFormat.prototype.getDigit_=function(B){var C=B.charCodeAt(0);
if(48<=C&&C<58){return C-48
}else{var A=this.symbols_.ZERO_DIGIT.charCodeAt(0);
return A<=C&&C<A+10?C-A:-1
}};
gadgets.i18n.NumberFormat.PATTERN_ZERO_DIGIT_="0";
gadgets.i18n.NumberFormat.PATTERN_GROUPING_SEPARATOR_=",";
gadgets.i18n.NumberFormat.PATTERN_DECIMAL_SEPARATOR_=".";
gadgets.i18n.NumberFormat.PATTERN_PER_MILLE_="\u2030";
gadgets.i18n.NumberFormat.PATTERN_PERCENT_="%";
gadgets.i18n.NumberFormat.PATTERN_DIGIT_="#";
gadgets.i18n.NumberFormat.PATTERN_SEPARATOR_=";";
gadgets.i18n.NumberFormat.PATTERN_EXPONENT_="E";
gadgets.i18n.NumberFormat.PATTERN_MINUS_="-";
gadgets.i18n.NumberFormat.PATTERN_CURRENCY_SIGN_="\u00A4";
gadgets.i18n.NumberFormat.QUOTE_="'";
gadgets.i18n.NumberFormat.prototype.parseAffix_=function(D,F){var B="";
var E=false;
var A=D.length;
for(;
F[0]<A;
F[0]++){var C=D.charAt(F[0]);
if(C==gadgets.i18n.NumberFormat.QUOTE_){if(F[0]+1<A&&D.charAt(F[0]+1)==gadgets.i18n.NumberFormat.QUOTE_){F[0]++;
B+="'"
}else{E=!E
}continue
}if(E){B+=C
}else{switch(C){case gadgets.i18n.NumberFormat.PATTERN_DIGIT_:case gadgets.i18n.NumberFormat.PATTERN_ZERO_DIGIT_:case gadgets.i18n.NumberFormat.PATTERN_GROUPING_SEPARATOR_:case gadgets.i18n.NumberFormat.PATTERN_DECIMAL_SEPARATOR_:case gadgets.i18n.NumberFormat.PATTERN_SEPARATOR_:return B;
case gadgets.i18n.NumberFormat.PATTERN_CURRENCY_SIGN_:this.isCurrencyFormat_=true;
if((F[0]+1)<A&&D.charAt(F[0]+1)==gadgets.i18n.NumberFormat.PATTERN_CURRENCY_SIGN_){F[0]++;
B+=this.intlCurrencyCode_
}else{B+=this.currencySymbol_
}break;
case gadgets.i18n.NumberFormat.PATTERN_PERCENT_:if(this.multiplier_!=1){throw Error("Too many percent/permill")
}this.multiplier_=100;
B+=this.symbols_.PERCENT;
break;
case gadgets.i18n.NumberFormat.PATTERN_PER_MILLE_:if(this.multiplier_!=1){throw Error("Too many percent/permill")
}this.multiplier_=1000;
B+=this.symbols_.PERMILL;
break;
default:B+=C
}}}return B
};
gadgets.i18n.NumberFormat.prototype.parseTrunk_=function(G,I){var H=-1;
var M=0;
var C=0;
var E=0;
var K=-1;
var F=G.length;
for(var D=true;
I[0]<F&&D;
I[0]++){var A=G.charAt(I[0]);
switch(A){case gadgets.i18n.NumberFormat.PATTERN_DIGIT_:if(C>0){E++
}else{M++
}if(K>=0&&H<0){K++
}break;
case gadgets.i18n.NumberFormat.PATTERN_ZERO_DIGIT_:if(E>0){throw Error('Unexpected "0" in pattern "'+G+'"')
}C++;
if(K>=0&&H<0){K++
}break;
case gadgets.i18n.NumberFormat.PATTERN_GROUPING_SEPARATOR_:K=0;
break;
case gadgets.i18n.NumberFormat.PATTERN_DECIMAL_SEPARATOR_:if(H>=0){throw Error('Multiple decimal separators in pattern "'+G+'"')
}H=M+C+E;
break;
case gadgets.i18n.NumberFormat.PATTERN_EXPONENT_:if(this.useExponentialNotation_){throw Error('Multiple exponential symbols in pattern "'+G+'"')
}this.useExponentialNotation_=true;
this.minExponentDigits_=0;
while((I[0]+1)<F&&G.charAt(I[0]+1)==this.symbols_.ZERO_DIGIT.charAt(0)){I[0]++;
this.minExponentDigits_++
}if((M+C)<1||this.minExponentDigits_<1){throw Error('Malformed exponential pattern "'+G+'"')
}D=false;
break;
default:I[0]--;
D=false;
break
}}if(C==0&&M>0&&H>=0){var B=H;
if(B==0){B++
}E=M-B;
M=B-1;
C=1
}if(H<0&&E>0||H>=0&&(H<M||H>M+C)||K==0){throw Error('Malformed pattern "'+G+'"')
}var L=M+C+E;
this.maximumFractionDigits_=H>=0?L-H:0;
if(H>=0){this.minimumFractionDigits_=M+C-H;
if(this.minimumFractionDigits_<0){this.minimumFractionDigits_=0
}}var J=H>=0?H:L;
this.minimumIntegerDigits_=J-M;
if(this.useExponentialNotation_){this.maximumIntegerDigits_=M+this.minimumIntegerDigits_;
if(this.maximumFractionDigits_==0&&this.minimumIntegerDigits_==0){this.minimumIntegerDigits_=1
}}this.groupingSize_=Math.max(0,K);
this.decimalSeparatorAlwaysShown_=H==0||H==L
};
gadgets.i18n.NumberFormat.prototype.parsePattern_=function(B){var D=[0];
this.positivePrefix_=this.parseAffix_(B,D);
var C=D[0];
this.parseTrunk_(B,D);
var A=D[0]-C;
this.positiveSuffix_=this.parseAffix_(B,D);
if(D[0]<B.length&&B.charAt(D[0])==gadgets.i18n.NumberFormat.PATTERN_SEPARATOR_){D[0]++;
this.negativePrefix_=this.parseAffix_(B,D);
D[0]+=A;
this.negativeSuffix_=this.parseAffix_(B,D)
}};