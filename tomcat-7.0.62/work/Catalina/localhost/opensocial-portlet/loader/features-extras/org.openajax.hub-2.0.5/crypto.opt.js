if(typeof OpenAjax._smash=="undefined"){OpenAjax._smash={}
}OpenAjax._smash.crypto={strToWA:function(D,E){var C=Array();
var A=(1<<E)-1;
for(var B=0;
B<D.length*E;
B+=E){C[B>>5]|=(D.charCodeAt(B/E)&A)<<(32-E-B%32)
}return C
},hmac_sha1:function(D,G,F){var A=Array(16),C=Array(16);
for(var B=0;
B<16;
B++){A[B]=D[B]^909522486;
C[B]=D[B]^1549556828
}var E=this.sha1(A.concat(this.strToWA(G,F)),512+G.length*F);
return this.sha1(C.concat(E),512+160)
},newPRNG:function(A){var G=this;
if((typeof A!="string")||(A.length<12)){alert("WARNING: Seed length too short ...")
}var C=[43417,15926,18182,33130,9585,30800,49772,40144,47678,55453,4659,38181,65340,6787,54417,65301];
var B=[];
var E=0;
function F(H){return G.hmac_sha1(C,H,8)
}function D(H){var J=F(H);
for(var I=0;
I<5;
I++){B[I]^=J[I]
}}D(A);
return{addSeed:function(H){D(H)
},nextRandomOctets:function(H){var I=[];
while(H>0){E+=1;
var J=G.hmac_sha1(B,(E).toString(16),8);
for(i=0;
(i<20)&(H>0);
i++,H--){I.push((J[i>>2]>>(i%4))%256)
}}return I
},nextRandomB64Str:function(H){var L="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
var K=this.nextRandomOctets(H);
var I="";
for(var J=0;
J<H;
J++){I+=L.charAt(K[J]&63)
}return I
}}
},sha1:function(){var D=function(E,H){var G=(E&65535)+(H&65535);
var F=(E>>16)+(H>>16)+(G>>16);
return(F<<16)|(G&65535)
};
var C=function(E,F){return(E<<F)|(E>>>(32-F))
};
function B(F,E,H,G){if(F<20){return(E&H)|((~E)&G)
}if(F<40){return E^H^G
}if(F<60){return(E&H)|(E&G)|(H&G)
}return E^H^G
}function A(E){return(E<20)?1518500249:(E<40)?1859775393:(E<60)?-1894007588:-899497514
}return function(U,F){U[F>>5]|=128<<(24-F%32);
U[((F+64>>9)<<4)+15]=F;
var E=Array(80);
var S=1732584193;
var R=-271733879;
var Q=-1732584194;
var O=271733878;
var M=-1009589776;
for(var I=0;
I<U.length;
I+=16){var P=S;
var N=R;
var L=Q;
var K=O;
var J=M;
for(var H=0;
H<80;
H++){E[H]=((H<16)?U[I+H]:C(E[H-3]^E[H-8]^E[H-14]^E[H-16],1));
var G=D(D(C(P,5),B(H,N,L,K)),D(D(J,E[H]),A(H)));
J=K;
K=L;
L=C(N,30);
N=P;
P=G
}S=D(P,S);
R=D(N,R);
Q=D(L,Q);
O=D(K,O);
M=D(J,M)
}return Array(S,R,Q,O,M)
}
}()};