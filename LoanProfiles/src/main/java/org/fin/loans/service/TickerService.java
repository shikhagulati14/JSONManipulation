package org.fin.loans.service;

import org.fin.loans.exception.TickerException;

import java.net.URL;

public interface TickerService {

    public void generateTicker(URL url) throws TickerException;

}
