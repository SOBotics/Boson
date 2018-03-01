package org.sobotics.boson.framework.exceptions;

import org.sobotics.boson.framework.services.StackExchangeApiService;

public class StackExchangeApiException extends ApiException {
    public StackExchangeApiException(String message){
        super(message);
    }
}
