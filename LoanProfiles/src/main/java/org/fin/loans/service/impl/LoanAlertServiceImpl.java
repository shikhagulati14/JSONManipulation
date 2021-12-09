package org.fin.loans.service.impl;

import org.fin.loans.exception.LoanAlertExceptions;
import org.fin.loans.model.Loan;
import org.fin.loans.model.Ticker;
import org.fin.loans.model.UnsecuredLoan;
import org.fin.loans.service.LoanAlertService;
import org.fin.loans.utils.LoanAlertUtils;

import java.util.List;
import java.util.Map;

public class LoanAlertServiceImpl implements LoanAlertService {
    @Override
    public void generateLoanAlerts(String marketDataFile, String loanDatafile) throws LoanAlertExceptions {

        //read the Input files
            //1. Read Market data file
        List<Ticker> tickerList = LoanAlertUtils.loadAndParseTickerData(marketDataFile);

            //2. Read Loan Data File
        List<Loan> loanList = LoanAlertUtils.loadAndParseLoanData(loanDatafile);

        //Create a key value par for ISIN and Price
        Map<String, Double> tickerMap = LoanAlertUtils.extractMapFromTicker(tickerList);

        // In-case in future Tickerdata changes and we need to use additional fields other than price
        // Map<String, Ticker> tickerMap = new HashMap<>();

       //Calculate Portfolio Values
        List<UnsecuredLoan> loanAlerts =  LoanAlertUtils.findUnsecuredLoans(loanList, tickerMap);

        //output the Response
        LoanAlertUtils.generateUnsecuredLoanAlertReport(loanAlerts);

    }
}
