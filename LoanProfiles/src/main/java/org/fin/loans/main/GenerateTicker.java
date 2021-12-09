package org.fin.loans.main;

import org.fin.loans.exception.TickerException;
import org.fin.loans.service.factory.LoanServiceFactory;
import org.fin.loans.service.TickerService;
import org.fin.loans.service.impl.TickerServiceImpl;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is used to generate marketdata.json
 */
public class GenerateTicker {
    TickerService tickerService = LoanServiceFactory.getTickerService();

    /**
     * @param args
     */
    public static void main(String[] args) {
        GenerateTicker ticker = new GenerateTicker();
        //it will ignore all the arguments other than first one
        if(args!=null && args.length>=1){
            ticker.generateTicker(args);
        }
    }

    /**
     * @param args
     */
    private void generateTicker(String[] args) {
        try {
            TickerService tickerService = new TickerServiceImpl();
            URL url = new URL(args[0]);
            tickerService.generateTicker(url);
        }
        catch (TickerException | MalformedURLException tex){
           tex.printStackTrace();
        }
    }
}
