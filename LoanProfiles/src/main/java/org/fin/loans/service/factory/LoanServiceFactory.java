package org.fin.loans.service.factory;

import org.fin.loans.service.LoanAlertService;
import org.fin.loans.service.TickerService;
import org.fin.loans.service.impl.LoanAlertServiceImpl;
import org.fin.loans.service.impl.TickerServiceImpl;

public final class LoanServiceFactory {

    /**
     * @return TickerServiceImpl
     */
    public static final TickerService getTickerService(){
        TickerService service = new TickerServiceImpl();
        return service;
    }

    /**
     * @return LoanAlertServiceImpl
     */
    public static final LoanAlertService getLoanAlertAService(){
        LoanAlertService loanAlertService = new LoanAlertServiceImpl();
        return loanAlertService;
    }
}
