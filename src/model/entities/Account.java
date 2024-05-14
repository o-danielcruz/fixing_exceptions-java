package model.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {
    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }


    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }


    public Double getWithdrawLimit() {
        return withdrawLimit;
    }


    public void deposit (Double amount){
        balance+=amount;
    }

    public void withdraw (Double amount){

        if (amount < 0) {
            throw new DomainException("Error. Value must be higher than 0");
        }
        else if (amount > withdrawLimit) {
           throw new DomainException("Error. Value exceed withdraw limit");
        }
        else {
            balance -= amount;
        }
    }
}
