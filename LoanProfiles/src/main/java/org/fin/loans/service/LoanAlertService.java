package org.fin.loans.service;

import org.fin.loans.exception.LoanAlertExceptions;

/**
 * LoanAlertService
 */
public interface LoanAlertService {

    /**
     * @param marketDataFile
     * @param loanDatafile
     * @throws LoanAlertExceptions
     */
    public void generateLoanAlerts(String marketDataFile, String loanDatafile) throws LoanAlertExceptions;
}
