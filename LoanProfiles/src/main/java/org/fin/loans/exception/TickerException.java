package org.fin.loans.exception;

public class TickerException extends Exception{
    public TickerException() {
        super();
    }

    public TickerException(String message) {
        super(message);
    }

    public TickerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TickerException(Throwable cause) {
        super(cause);
    }

    protected TickerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
