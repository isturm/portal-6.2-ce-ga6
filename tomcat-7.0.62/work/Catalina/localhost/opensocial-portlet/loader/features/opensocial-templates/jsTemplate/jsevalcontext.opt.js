var VAR_index="Index";
var VAR_count="Count";
var VAR_this="$this";
var VAR_context="$context";
var VAR_top="$top";
var VAR_loop="$loop";
var GLOB_default="$default";
var CHAR_colon=":";
var REGEXP_semicolon=/\s*;\s*/;
function JsEvalContext(A,B){this.constructor_.apply(this,arguments)
}JsEvalContext.prototype.constructor_=function(A,B){var C=this;
if(!C.vars_){C.vars_={}
}if(B){copyProperties(C.vars_,B.vars_)
}else{copyProperties(C.vars_,JsEvalContext.globals_)
}C.vars_[VAR_this]=A;
C.vars_[VAR_context]=C;
C.data_=getDefaultObject(A,STRING_empty);
if(!B){C.vars_[VAR_top]=C.data_
}};
JsEvalContext.globals_={};
JsEvalContext.setGlobal=function(A,B){JsEvalContext.globals_[A]=B
};
JsEvalContext.setGlobal(GLOB_default,null);
JsEvalContext.recycledInstances_=[];
JsEvalContext.create=function(B,C){if(jsLength(JsEvalContext.recycledInstances_)>0){var A=JsEvalContext.recycledInstances_.pop();
JsEvalContext.call(A,B,C);
return A
}else{return new JsEvalContext(B,C)
}};
JsEvalContext.recycle=function(A){for(var B in A.vars_){delete A.vars_[B]
}A.data_=null;
JsEvalContext.recycledInstances_.push(A)
};
JsEvalContext.prototype.jsexec=function(B,A){try{return B.call(A,this.vars_,this.data_)
}catch(C){log("jsexec EXCEPTION: "+C+" at "+A+" with "+B);
return JsEvalContext.globals_[GLOB_default]
}};
JsEvalContext.prototype.clone=function(E,B,D){var A=JsEvalContext.create(E,this);
if(typeof (B)=="number"||typeof (D)=="number"){var C={};
C[VAR_index]=B;
C[VAR_count]=D;
A.setVariable(VAR_loop,C)
}return A
};
JsEvalContext.prototype.setVariable=function(A,B){this.vars_[A]=B
};
JsEvalContext.prototype.getVariable=function(A){return this.vars_[A]
};
JsEvalContext.prototype.evalExpression=function(C,B){var A=jsEvalToFunction(C);
return this.jsexec(A,B)
};
var STRING_a="a_";
var STRING_b="b_";
var STRING_with="with (a_) with (b_) return ";
JsEvalContext.evalToFunctionCache_={};
function jsEvalToFunction(B){if(!JsEvalContext.evalToFunctionCache_[B]){try{JsEvalContext.evalToFunctionCache_[B]=new Function(STRING_a,STRING_b,STRING_with+B)
}catch(A){log("jsEvalToFunction ("+B+") EXCEPTION "+A)
}}return JsEvalContext.evalToFunctionCache_[B]
}function jsEvalToSelf(A){return A
}function jsEvalToValues(H){var D=[];
var A=H.split(REGEXP_semicolon);
for(var E=0,C=jsLength(A);
E<C;
++E){var F=A[E].indexOf(CHAR_colon);
if(F<0){continue
}var B=stringTrim(A[E].substr(0,F));
var G=jsEvalToFunction(A[E].substr(F+1));
D.push(B,G)
}return D
}function jsEvalToExpressions(F){var C=[];
var A=F.split(REGEXP_semicolon);
for(var D=0,B=jsLength(A);
D<B;
++D){if(A[D]){var E=jsEvalToFunction(A[D]);
C.push(E)
}}return C
};