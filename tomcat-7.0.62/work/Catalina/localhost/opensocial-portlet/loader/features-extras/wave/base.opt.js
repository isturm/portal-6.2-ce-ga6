var wave=wave||{};
wave.Callback=function(B,A){this.callback_=B;
this.context_=A||null
};
wave.Callback.prototype.invoke=function(A){if(this.callback_){this.callback_.apply(this.context_,arguments)
}};
wave.Mode={UNKNOWN:0,VIEW:1,EDIT:2,DIFF_ON_OPEN:3,PLAYBACK:4};
wave.API_PARAM_="wave";
wave.ID_PARAM_="waveId";
wave.id_=null;
wave.viewer_=null;
wave.host_=null;
wave.participants_=[];
wave.participantMap_={};
wave.participantCallback_=new wave.Callback(null);
wave.state_=null;
wave.stateCallback_=new wave.Callback(null);
wave.privateState_=null;
wave.privateStateCallback_=new wave.Callback(null);
wave.mode_=null;
wave.modeCallback_=new wave.Callback(null);
wave.inWaveContainer_=false;