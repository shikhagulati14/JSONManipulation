package org.fin.loans.exception;

public class LoanAlertExceptions extends Exception{
    public LoanAlertExceptions() {
        super();
    }

    public LoanAlertExceptions(String message) {
        super(message);
    }

    public LoanAlertExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public LoanAlertExceptions(Throwable cause) {
        super(cause);
    }

    protected LoanAlertExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
