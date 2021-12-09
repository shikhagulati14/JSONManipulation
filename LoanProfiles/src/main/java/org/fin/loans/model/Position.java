package org.fin.loans.model;

public class Position{
    public String id;
    public int quantity;

    public Position(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
