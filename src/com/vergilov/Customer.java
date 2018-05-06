package com.vergilov;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transaction;

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransaction() {
        return transaction;
    }

    public Customer(String name, double amount) {
        this.name = name;
        this.transaction=new ArrayList<Double>();
        addAmount(amount);
    }
    public void addAmount(double amount){
        this.transaction.add(amount);

    }
}
