package com.jo.healthcare.errorHandling;

import com.jo.healthcare.logger.MyLogger;

public final class ErrorHandler extends Exception{
	
	
    public ErrorHandler(String messege)
    {
    	super(messege);
    	MyLogger.logger.error(messege);
    	
    }
    
    public ErrorHandler(String message, Throwable cause) {
        super(message, cause);
        MyLogger.logger.error(message, cause);
    }
}
