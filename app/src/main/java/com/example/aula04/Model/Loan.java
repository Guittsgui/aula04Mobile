package com.example.aula04.Model;

import java.io.Serializable;

public class Loan implements Serializable {

    Integer quantityOfMonths;
    Double loanValue, loanFees, entryValue, feeValue ;


    public Loan(Integer quantityOfMonths, Double loanValue, Double loanFees, Double entryValue) {
        this.quantityOfMonths = quantityOfMonths;
        this.loanValue = loanValue;
        this.loanFees = loanFees;
        this.entryValue = entryValue;
    }

    public Integer getQuantityOfMonths() {
        return quantityOfMonths;
    }

    public void setQuantityOfMonths(Integer quantityOfMonths) {
        this.quantityOfMonths = quantityOfMonths;
    }

    public Double getLoanValue() {
        return loanValue;
    }

    public void setLoanValue(Double loanValue) {
        this.loanValue = loanValue;
    }

    public Double getLoanFees() {
        return loanFees;
    }

    public void setLoanFees(Double loanFees) {
        this.loanFees = loanFees;
    }

    public Double getEntryValue() {
        return entryValue;
    }

    public void setEntryValue(Double entryValue) {
        this.entryValue = entryValue;
    }

    public Double getFeeValue(){
        Double feeValue = (this.loanFees / 100) * this.loanValue;
        return feeValue;
    }

    public Double getFullLoanValueWithFees(){
        return this.loanValue + getFeeValue();
    }

    public Double getTotalWithoutEntry(){
        return getFullLoanValueWithFees() - this.entryValue;
    }

    public Double getMonthlyPriceToPay(){
        return getTotalWithoutEntry() / this.getQuantityOfMonths();
    }

}
