shindig.sha1=(function(){var E=[];
var B=[];
var H=[];
var J=[];
J[0]=128;
for(var D=1;
D<64;
++D){J[D]=0
}function F(){E[0]=1732584193;
E[1]=4023233417;
E[2]=2562383102;
E[3]=271733878;
E[4]=3285377520;
inbuf_=0;
total_=0
}function I(K,L){return((K<<L)|(K>>>(32-L)))&4294967295
}function A(K){var L=H;
for(var N=0;
N<64;
N+=4){var U=(K[N]<<24)|(K[N+1]<<16)|(K[N+2]<<8)|(K[N+3]);
L[N/4]=U
}for(var N=16;
N<80;
N++){L[N]=I(L[N-3]^L[N-8]^L[N-14]^L[N-16],1)
}var T=E[0];
var S=E[1];
var R=E[2];
var Q=E[3];
var P=E[4];
var O,M;
for(var N=0;
N<80;
N++){if(N<40){if(N<20){O=Q^(S&(R^Q));
M=1518500249
}else{O=S^R^Q;
M=1859775393
}}else{if(N<60){O=(S&R)|(Q&(S|R));
M=2400959708
}else{O=S^R^Q;
M=3395469782
}}var V=(I(T,5)+O+P+M+L[N])&4294967295;
P=Q;
Q=R;
R=I(S,30);
S=T;
T=V
}E[0]=(E[0]+T)&4294967295;
E[1]=(E[1]+S)&4294967295;
E[2]=(E[2]+R)&4294967295;
E[3]=(E[3]+Q)&4294967295;
E[4]=(E[4]+P)&4294967295
}function C(K,L){if(!L){L=K.length
}var M=0;
if(inbuf_==0){while(M+64<L){A(K.slice(M,M+64));
M+=64;
total_+=64
}}while(M<L){B[inbuf_++]=K[M++];
total_++;
if(inbuf_==64){inbuf_=0;
A(B);
while(M+64<L){A(K.slice(M,M+64));
M+=64;
total_+=64
}}}}function G(){var N=[];
var M=total_*8;
if(inbuf_<56){C(J,56-inbuf_)
}else{C(J,64-(inbuf_-56))
}for(var L=63;
L>=56;
L--){B[L]=M&255;
M>>>=8
}A(B);
var O=0;
for(var L=0;
L<5;
L++){for(var K=24;
K>=0;
K-=8){N[O++]=(E[L]>>K)&255
}}return N
}F();
return{reset:F,update:C,digest:G}
});