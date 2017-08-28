gadgets.window=gadgets.window||{};
(function(){gadgets.window.getViewportDimensions=function(){var A=0;
var B=0;
if(self.innerHeight){A=self.innerWidth;
B=self.innerHeight
}else{if(document.documentElement&&document.documentElement.clientHeight){A=document.documentElement.clientWidth;
B=document.documentElement.clientHeight
}else{if(document.body){A=document.body.clientWidth;
B=document.body.clientHeight
}}}return{width:A,height:B}
}
})();