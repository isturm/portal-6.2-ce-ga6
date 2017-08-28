wave.checkWaveContainer_=function(){var A=gadgets.util.getUrlParameters();
wave.inWaveContainer_=(A.hasOwnProperty(wave.API_PARAM_)&&A[wave.API_PARAM_]);
wave.id_=(A.hasOwnProperty(wave.ID_PARAM_)&&A[wave.ID_PARAM_])
};
wave.isInWaveContainer=function(){return wave.inWaveContainer_
};
wave.receiveWaveParticipants_=function(C){wave.viewer_=null;
wave.host_=null;
wave.participants_=[];
wave.participantMap_={};
var B=C.myId;
var E=C.authorId;
var A=C.participants;
for(var F in A){var D=wave.Participant.fromJson_(A[F]);
if(F==B){wave.viewer_=D
}if(F==E){wave.host_=D
}wave.participants_.push(D);
wave.participantMap_[F]=D
}if(!wave.viewer_&&B){var D=new wave.Participant(B,B);
wave.viewer_=D;
wave.participants_.push(D);
wave.participantMap_[B]=D
}wave.participantCallback_.invoke(wave.participants_)
};
wave.receiveState_=function(A){wave.state_=wave.state_||new wave.State("wave_gadget_state");
var B=wave.state_.calculateDelta_(A);
wave.state_.setState_(A);
wave.stateCallback_.invoke(wave.state_,B)
};
wave.receivePrivateState_=function(A){wave.privateState_=wave.privateState_||new wave.State("wave_private_gadget_state");
var B=wave.privateState_.calculateDelta_(A);
wave.privateState_.setState_(A);
wave.privateStateCallback_.invoke(wave.privateState_,B)
};
wave.receiveStateDelta_=function(A){wave.state_=wave.state_||new wave.State("wave_gadget_state");
wave.state_.applyDelta_(A);
wave.stateCallback_.invoke(wave.state_,A)
};
wave.receivePrivateStateDelta_=function(A){wave.privateState_=wave.privateState_||new wave.State("wave_private_gadget_state");
wave.privateState_.applyDelta_(A);
wave.privateStateCallback_.invoke(wave.privateState_,A)
};
wave.receiveMode_=function(A){wave.mode_=A||{};
wave.modeCallback_.invoke(wave.getMode())
};
wave.getViewer=function(){return wave.viewer_
};
wave.getHost=function(){return wave.host_
};
wave.getParticipants=function(){return wave.participants_
};
wave.getParticipantById=function(A){return wave.participantMap_[A]
};
wave.getState=function(){return wave.state_
};
wave.getPrivateState=function(){return wave.privateState_
};
wave.getMode=function(){if(wave.mode_){var A=wave.mode_["${playback}"];
var B=wave.mode_["${edit}"];
if((A!=null)&&(B!=null)){if(A=="1"){return wave.Mode.PLAYBACK
}else{if(B=="1"){return wave.Mode.EDIT
}else{return wave.Mode.VIEW
}}}}return wave.Mode.UNKNOWN
};
wave.isPlayback=function(){var A=wave.getMode();
return(A==wave.Mode.PLAYBACK)||(A==wave.Mode.UNKNOWN)
};
wave.setStateCallback=function(B,A){wave.stateCallback_=new wave.Callback(B,A);
if(wave.state_){wave.stateCallback_.invoke(wave.state_,wave.state_.state_)
}};
wave.setPrivateStateCallback=function(B,A){wave.privateStateCallback_=new wave.Callback(B,A);
if(wave.privateState_){wave.privateStateCallback_.invoke(wave.privateState_,wave.privateState_.state_)
}};
wave.setParticipantCallback=function(B,A){wave.participantCallback_=new wave.Callback(B,A);
if(wave.participants_){wave.participantCallback_.invoke(wave.participants_)
}};
wave.setModeCallback=function(B,A){wave.modeCallback_=new wave.Callback(B,A);
if(wave.mode_){wave.modeCallback_.invoke(wave.getMode())
}};
wave.getTime=function(){return new Date().getTime()
};
wave.log=function(A){gadgets.rpc.call(null,"wave_log",null,A||"")
};
wave.setSnippet=function(A){gadgets.rpc.call(null,"set_snippet",null,A||"")
};
wave.getWaveId=function(){return wave.id_
};
wave.internalInit_=function(){wave.checkWaveContainer_();
if(wave.isInWaveContainer()){gadgets.rpc.register("wave_participants",wave.receiveWaveParticipants_);
gadgets.rpc.register("wave_gadget_state",wave.receiveState_);
gadgets.rpc.register("wave_state_delta",wave.receiveStateDelta_);
gadgets.rpc.register("wave_private_gadget_state",wave.receivePrivateState_);
gadgets.rpc.register("wave_private_state_delta",wave.receivePrivateStateDelta_);
gadgets.rpc.register("wave_gadget_mode",wave.receiveMode_);
gadgets.rpc.call(null,"wave_enable",null,"1.0")
}};
(wave.init_=function(){if(window.gadgets){gadgets.util.registerOnLoadHandler(function(){wave.internalInit_()
})
}})();