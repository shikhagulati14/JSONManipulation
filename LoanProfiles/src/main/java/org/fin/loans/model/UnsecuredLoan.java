package org.fin.loans.model;

public class UnsecuredLoan {
    public String id;
    public String creditpolicy;
    public Double amount;
    public Double eligible_collateral;

    public UnsecuredLoan(String id, String creditpolicy, Double amount, Double eligible_collateral) {
        this.id = id;
        this.creditpolicy = creditpolicy;
        this.amount = amount;
        this.eligible_collateral = eligible_collateral;
    }

    public String getId() {
        return id;
    }

    public String getCreditpolicy() {
        return creditpolicy;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getEligible_collateral() {
        return eligible_collateral;
    }
}
