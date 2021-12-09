package org.fin.loans.model;

public class Ticker {

    public String ticker;
    public double price;
    public String isin;

    public Ticker(String ticker, double price, String isin) {
        this.ticker = ticker;
        this.price = price;
        this.isin = isin;
    }

    public String getTicker() {
        return ticker;
    }

    public double getPrice() {
        return price;
    }

    public String getIsin() {
        return isin;
    }
}
