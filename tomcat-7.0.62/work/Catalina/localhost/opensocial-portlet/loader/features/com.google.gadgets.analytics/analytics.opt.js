(function(){gadgets.analytics=function(A){this.tracker=_gat._getTracker(A)
};
gadgets.analytics.prototype.reportPageview=function(A){this.tracker._trackPageview(A)
};
gadgets.analytics.prototype.reportEvent=function(B,D,A,C){this.tracker._trackEvent(B,D,A,C)
}
}());
var _IG_GA=gadgets.analytics;