shindig.CookieBasedUserPrefStore=function(){gadgets.UserPrefStore.call(this)
};
shindig.CookieBasedUserPrefStore.inherits(shindig.UserPrefStore);
shindig.CookieBasedUserPrefStore.prototype.USER_PREFS_PREFIX="gadgetUserPrefs-";
shindig.CookieBasedUserPrefStore.prototype.getPrefs=function(D){var F={};
var G=this.USER_PREFS_PREFIX+D.id;
var C=shindig.cookies.get(G);
if(C){var B=C.split("&");
for(var E=0;
E<B.length;
E++){var I=B[E].split("=");
var A=decodeURIComponent(I[0]);
var H=decodeURIComponent(I[1]);
F[A]=H
}}return F
};
shindig.CookieBasedUserPrefStore.prototype.savePrefs=function(D){var C=[];
for(var A in D.getUserPrefs()){var B=D.getUserPref(A);
var F=encodeURIComponent(A)+"="+encodeURIComponent(B);
C.push(F)
}var G=this.USER_PREFS_PREFIX+D.id;
var E=C.join("&");
shindig.cookies.set(G,E)
};
shindig.Container.prototype.userPrefStore=new shindig.CookieBasedUserPrefStore();