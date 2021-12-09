package org.fin.loans.model;

import java.util.List;

public class Loan {
    public Double amount;
    public String creditpolicy;
    public String id;
    public List<Position> positions;

    public Loan(Double amount, String creditpolicy, String id, List<Position> positions) {
        this.amount = amount;
        this.creditpolicy = creditpolicy;
        this.id = id;
        this.positions = positions;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCreditpolicy() {
        return creditpolicy;
    }

    public String getId() {
        return id;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
