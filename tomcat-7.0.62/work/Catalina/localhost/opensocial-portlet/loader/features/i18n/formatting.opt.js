gadgets.i18n=gadgets.i18n||{};
gadgets.i18n.dtFormatter_=null;
gadgets.i18n.dtParser_=null;
gadgets.i18n.numFormatter_=null;
gadgets.i18n.formatDateTime=function(B,A){if(!gadgets.i18n.dtFormatter_){gadgets.i18n.dtFormatter_=new gadgets.i18n.DateTimeFormat(gadgets.i18n.DateTimeConstants);
typeof B=="string"?gadgets.i18n.dtFormatter_.applyPattern(B):gadgets.i18n.dtFormatter_.applyStandardPattern(B);
gadgets.i18n.dtFormatter_.patternInUse_=B
}else{if(gadgets.i18n.dtFormatter_.patternInUse_!=B){typeof B=="string"?gadgets.i18n.dtFormatter_.applyPattern(B):gadgets.i18n.dtFormatter_.applyStandardPattern(B);
gadgets.i18n.dtFormatter_.patternInUse_=B
}}return gadgets.i18n.dtFormatter_.format(A)
};
gadgets.i18n.parseDateTime=function(B,C,D,A){if(!gadgets.i18n.dtParser_){gadgets.i18n.dtParser_=new gadgets.i18n.DateTimeParse(gadgets.i18n.DateTimeConstants);
typeof B=="string"?gadgets.i18n.dtParser_.applyPattern(B):gadgets.i18n.dtParser_.applyStandardPattern(B);
gadgets.i18n.dtParser_.patternInUse_=B
}else{if(gadgets.i18n.dtParser_.patternInUse_!=B){typeof B=="string"?gadgets.i18n.dtParser_.applyPattern(B):gadgets.i18n.dtParser_.applyStandardPattern(B);
gadgets.i18n.dtParser_.patternInUse_=B
}}return gadgets.i18n.dtParser_.parse(C,D,A)
};
gadgets.i18n.formatNumber=function(B,A,C){if(!gadgets.i18n.numFormatter_){gadgets.i18n.numFormatter_=new gadgets.i18n.NumberFormat(gadgets.i18n.NumberFormatConstants);
typeof B=="string"?gadgets.i18n.numFormatter_.applyPattern(B,C):gadgets.i18n.numFormatter_.applyStandardPattern(B,C);
gadgets.i18n.numFormatter_.patternInUse_=B
}else{if(gadgets.i18n.numFormatter_.patternInUse_!=B){typeof B=="string"?gadgets.i18n.numFormatter_.applyPattern(B,C):gadgets.i18n.numFormatter_.applyStandardPattern(B,C);
gadgets.i18n.numFormatter_.patternInUse_=B
}}return gadgets.i18n.numFormatter_.format(A)
};
gadgets.i18n.parseNumber=function(A,D,C,B){if(!gadgets.i18n.numFormatter_){gadgets.i18n.numFormatter_=new gadgets.i18n.NumberFormat();
typeof A=="string"?gadgets.i18n.numFormatter_.applyPattern(A,B):gadgets.i18n.numFormatter_.applyStandardPattern(A,B);
gadgets.i18n.numFormatter_.patternInUse_=A;
gadgets.i18n.numFormatter_.currencyCodeInUse_=B
}else{if(gadgets.i18n.numFormatter_.patternInUse_!=A||gadgets.i18n.numFormatter_.currencyCodeInUse_!=B){typeof A=="string"?gadgets.i18n.numFormatter_.applyPattern(A,B):gadgets.i18n.numFormatter_.applyStandardPattern(A,B);
gadgets.i18n.numFormatter_.patternInUse_=A;
gadgets.i18n.numFormatter_.currencyCodeInUse_=B
}}return gadgets.i18n.numFormatter_.parse(D,C)
};
gadgets.i18n.FULL_DATE_FORMAT=0;
gadgets.i18n.LONG_DATE_FORMAT=1;
gadgets.i18n.MEDIUM_DATE_FORMAT=2;
gadgets.i18n.SHORT_DATE_FORMAT=3;
gadgets.i18n.FULL_TIME_FORMAT=4;
gadgets.i18n.LONG_TIME_FORMAT=5;
gadgets.i18n.MEDIUM_TIME_FORMAT=6;
gadgets.i18n.SHORT_TIME_FORMAT=7;
gadgets.i18n.FULL_DATETIME_FORMAT=8;
gadgets.i18n.LONG_DATETIME_FORMAT=9;
gadgets.i18n.MEDIUM_DATETIME_FORMAT=10;
gadgets.i18n.SHORT_DATETIME_FORMAT=11;
gadgets.i18n.DECIMAL_PATTERN=1;
gadgets.i18n.SCIENTIFIC_PATTERN=2;
gadgets.i18n.PERCENT_PATTERN=3;
gadgets.i18n.CURRENCY_PATTERN=4;