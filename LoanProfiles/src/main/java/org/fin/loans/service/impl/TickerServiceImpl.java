package org.fin.loans.service.impl;

import org.fin.loans.exception.TickerException;
import org.fin.loans.model.MarketData;
import org.fin.loans.service.TickerService;
import org.fin.loans.utils.TickerUtils;

import java.net.URL;
import java.util.List;

/**
 * Implementation for Ticker service
 */
public class TickerServiceImpl implements TickerService {

    @Override
    public void generateTicker(URL url) throws TickerException {
       //download File
       String jsonResponse = TickerUtils.downloadPayload(url);

       //parse
       List<MarketData> marketDataList = TickerUtils.parseResponse(jsonResponse);

       //Restructure
       String tickerData = TickerUtils.generateTickerData(marketDataList);

       //generate output MarketData.json
       TickerUtils.generateTickerResponse(tickerData);

       //System.out.println("Ticker Response: MarketData.json \n " + tickerData);
       System.out.println(tickerData);
    }
}
