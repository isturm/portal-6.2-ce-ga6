opensocial.Payment=function(A){this.fields_=A||{};
this.fields_[opensocial.Payment.Field.PAYMENT_TYPE]=this.fields_[opensocial.Payment.Field.PAYMENT_TYPE]||opensocial.Payment.PaymentType.PAYMENT
};
opensocial.Payment.prototype.isPayment=function(){return this.fields_[opensocial.Payment.Field.PAYMENT_TYPE]==opensocial.Payment.PaymentType.PAYMENT
};
opensocial.Payment.prototype.isCredit=function(){return this.fields_[opensocial.Payment.Field.PAYMENT_TYPE]==opensocial.Payment.PaymentType.CREDIT
};
opensocial.Payment.prototype.isComplete=function(){return !!this.fields_[opensocial.Payment.Field.PAYMENT_COMPLETE]
};
opensocial.Payment.Field={SANDBOX:"sandbox",ITEMS:"items",AMOUNT:"amount",MESSAGE:"message",PARAMETERS:"parameters",PAYMENT_TYPE:"paymentType",ORDER_ID:"orderId",ORDERED_TIME:"orderedTime",SUBMITTED_TIME:"submittedTime",EXECUTED_TIME:"executedTime",RESPONSE_CODE:"responseCode",RESPONSE_MESSAGE:"responseMessage",PAYMENT_COMPLETE:"paymentComplete"};
opensocial.Payment.prototype.getField=function(A,B){return opensocial.Container.getField(this.fields_,A,B)
};
opensocial.Payment.prototype.setField=function(A,B){return this.fields_[A]=B
};
opensocial.Payment.PaymentType={PAYMENT:"payment",CREDIT:"credit"};
opensocial.Payment.ResponseCode={APP_LOGIC_ERROR:"appLogicError",APP_NETWORK_FAILURE:"appNetworkFailure",INSUFFICIENT_MONEY:"insufficientMoney",INVALID_TOKEN:"invalidToken",MALFORMED_REQUEST:"malformedRequest",NOT_IMPLEMENTED:"notImplemented",OK:"ok",PAYMENT_ERROR:"paymentError",PAYMENT_PROCESSOR_ALREADY_OPENED:"paymentProcessorAlreadyOpened",UNKNOWN_ERROR:"unknownError",USER_CANCELLED:"userCancelled"};
opensocial.Payment.RecordsRequestFields={SANDBOX:"sandbox",MAX:"max",INCOMPLETE_ONLY:"incompleteOnly"};