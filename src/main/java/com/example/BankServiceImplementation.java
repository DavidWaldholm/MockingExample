package com.example;

public class BankServiceImplementation implements BankService {
    private int payment;

    public BankServiceImplementation() {
        this.payment = 0;
    }

    @Override
    public void pay(String id, double amount) {
        this.payment++;
    }


}