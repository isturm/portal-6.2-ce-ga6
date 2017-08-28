os.nsmap_={};
os.createNamespace=function(C,B){var A=os.nsmap_[C];
if(!os.nsmap_.hasOwnProperty(C)){A={};
os.nsmap_[C]=A;
opensocial.xmlutil.NSMAP[C]=B
}else{if(opensocial.xmlutil.NSMAP[C]==null){opensocial.xmlutil.NSMAP[C]=B
}else{if(opensocial.xmlutil.NSMAP[C]!=B){throw ("Namespace "+C+" already defined with url "+opensocial.xmlutil.NSMAP[C])
}}}return A
};
os.getNamespace=function(A){return os.nsmap_[A]
};
os.addNamespace=function(C,B,A){if(!os.nsmap_.hasOwnProperty(C)){if(opensocial.xmlutil.NSMAP[C]==null){opensocial.xmlutil.NSMAP[C]=B;
return 
}else{throw ("Namespace '"+C+"' already exists!")
}}os.nsmap_[C]=A;
opensocial.xmlutil.NSMAP[C]=B
};
os.getCustomTag=function(C,B){if(!os.nsmap_.hasOwnProperty(C)){return null
}var A=os.nsmap_[C];
if(A.getTag){return A.getTag(B)
}else{return A[B]
}};