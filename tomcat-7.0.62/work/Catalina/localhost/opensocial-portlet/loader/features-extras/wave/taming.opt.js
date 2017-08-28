var tamings___=tamings___||[];
var caja___;
var ___;
tamings___.push(function(A){___.grantRead(wave,"Mode");
function B(E,C){var D={apply:___.markFuncFreeze(function(F,G){return ___.callPub(E,"apply",[C,G])
})};
return new wave.Callback(D,___.USELESS)
}B.prototype=wave.Callback.prototype;
wave.Callback.prototype.constructor=B;
___.markCtor(B,Object,"Callback");
___.primFreeze(B);
___.tamesTo(wave.Callback,B);
___.handleGenericMethod(B.prototype,"invoke",function(C){return ___.callPub(this.callback_,"apply",[___.tame(this.context_),Array.slice(arguments,0)])
});
caja___.whitelistCtors([[wave,"Participant",Object],[wave,"State",Object]]);
caja___.whitelistMeths([[wave.Participant,"getDisplayName"],[wave.Participant,"getId"],[wave.Participant,"getThumbnailUrl"],[wave.State,"get"],[wave.State,"getKeys"],[wave.State,"reset"],[wave.State,"submitDelta"],[wave.State,"submitValue"],[wave.State,"toString"]]);
caja___.whitelistFuncs([[wave,"getHost"],[wave,"getMode"],[wave,"getParticipantById"],[wave,"getParticipants"],[wave,"getState"],[wave,"getTime"],[wave,"getViewer"],[wave,"isInWaveContainer"],[wave,"log"],[wave,"setModeCallback"],[wave,"setParticipantCallback"],[wave,"setStateCallback"],[wave.util,"printJson"]]);
A.outers.wave=___.tame(wave);
___.grantRead(A.outers,"wave")
});