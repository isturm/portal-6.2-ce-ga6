wave.State=function(A){this.setState_(null);
this.rpc_=A===undefined?"wave_gadget_state":A
};
wave.State.prototype.get=function(A,B){if(A in this.state_){return this.state_[A]
}return B===undefined?null:B
};
wave.State.prototype.getKeys=function(){var B=[];
for(var A in this.state_){B.push(A)
}return B
};
wave.State.prototype.submitDelta=function(A){gadgets.rpc.call(null,this.rpc_,null,A)
};
wave.State.prototype.submitValue=function(A,B){var C={};
C[A]=B;
this.submitDelta(C)
};
wave.State.prototype.reset=function(){var B={};
for(var A in this.state_){B[A]=null
}this.submitDelta(B)
};
wave.State.prototype.toString=function(){return wave.util.printJson(this.state_,true)
};
wave.State.prototype.setState_=function(A){this.state_=A||{}
};
wave.State.prototype.calculateDelta_=function(C){var D={};
for(var B in C){var A=this.state_.hasOwnProperty(B);
if(!A||(this.state_[B]!=C[B])){D[B]=C[B]
}}for(var B in this.state_){if(!C.hasOwnProperty(B)){D[B]=null
}}return D
};
wave.State.prototype.applyDelta_=function(B){this.state_=this.state_||{};
for(var A in B){if(B[A]!=null){this.state_[A]=B[A]
}else{delete this.state_[A]
}}};