package org.fin.loans.main;

import org.fin.loans.exception.LoanAlertExceptions;
import org.fin.loans.service.LoanAlertService;
import org.fin.loans.service.factory.LoanServiceFactory;

/**
 * This class is used to generate loan alerts.
 */
public class GenerateLoanAlerts {
    public static void main(String[] args) {
        GenerateLoanAlerts generateLoanAlerts = new GenerateLoanAlerts();
        //it will ignore all the arguments other than first 2
        if(args != null && args.length>=2 ){
          generateLoanAlerts(args);
        }
    }

    /**
     * @param args
     */
    private static void generateLoanAlerts(String[] args) {
        try {
            LoanAlertService loanAlertService = LoanServiceFactory.getLoanAlertAService();
            loanAlertService.generateLoanAlerts(args[0],args[1]);
        } catch (LoanAlertExceptions loanAlertExceptions) {
            loanAlertExceptions.printStackTrace();
        }
    }
}
