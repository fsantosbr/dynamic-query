package com.fsantosinfo.exception;

public class QueryException extends RuntimeException {
    
    public QueryException(String errorMessage) {
        super(errorMessage);
    }
}
