opensocial.BillingItem=function(A){this.fields_=A||{};
this.fields_[opensocial.BillingItem.Field.COUNT]=this.fields_[opensocial.BillingItem.Field.COUNT]||1
};
opensocial.BillingItem.Field={SKU_ID:"skuId",PRICE:"price",COUNT:"count",DESCRIPTION:"description"};
opensocial.BillingItem.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.BillingItem.prototype.setField=function(A,B){return this.fields_[A]=B
};