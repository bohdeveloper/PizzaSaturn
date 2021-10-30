package com.bohdeveloper.pizzasaturn.dal;

public class DalException extends RuntimeException {

    private static final long serialVersionUID = 4579272238913245625L;

    public DalException() {
    }

    public DalException(String message) {
        super(message);
    }

    public DalException(Throwable cause) {
        super(cause);
    }

    public DalException(String message, Throwable cause) {
        super(message, cause);
    }

    public DalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
