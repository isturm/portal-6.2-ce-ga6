os.trim=function(A){return A.replace(/^\s+|\s+$/g,"")
};
os.isAlphaNum=function(A){return((A>="a"&&A<="z")||(A>="A"&&A<="Z")||(A>="0"&&A<="9")||A=="_")
};
os.removeChildren=function(A){while(A.firstChild){A.removeChild(A.firstChild)
}};
os.appendChildren=function(A,B){if(A==B){return 
}while(A.firstChild){B.appendChild(A.firstChild)
}};
os.getPropertyGetterName=function(B){var A="get"+B.charAt(0).toUpperCase()+B.substring(1);
return A
};
os.convertToCamelCase=function(G){var E=G.toUpperCase();
var F=G.toLowerCase().split("_");
var B=[];
var A=F[0].length+1;
B.push(F[0]);
for(var C=1;
C<F.length;
++C){if(F[C].length>0){var D=E.charAt(A)+F[C].substring(1);
B.push(D)
}A+=F[C].length+1
}return B.join("")
};