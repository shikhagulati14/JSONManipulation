package org.fin.loans.model;

public class MarketData {

    public String currency;
    public String ticker;
    public String exchange;
    public String id;
    public double price;
    public String name;

    public MarketData(String currency, String ticker, String exchange, String id, double price, String name) {
        this.currency = currency;
        this.ticker = ticker;
        this.exchange = exchange;
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public String getTicker() {
        return ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
