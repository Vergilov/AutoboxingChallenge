package com.vergilov;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer>arrayListCustomer;

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getArrayListCustomer() {
        return arrayListCustomer;
    }

    public Branch(String name) {
        this.name = name;
        this.arrayListCustomer = new ArrayList<Customer>();
    }

    public boolean newCustomer(String customerName,double amount){
        Customer newCustomer=new Customer(customerName,amount);
        if(findCustomer(customerName) >=0) {
            System.out.println("Customer is already on file");
            return false;
        }

        this.arrayListCustomer.add(newCustomer);
        return true;
    }

    public boolean addTransaction(String customerName, double amount){
        Customer existingCustomer=queryCustomer(customerName);
        if(findCustomer(customerName)>=0){
        existingCustomer.addAmount(amount);
        return true;
        }
            return false;
    }

    private int fintCustomer(Customer customer){
        return this.arrayListCustomer.indexOf(customer);
    }


    private int findCustomer(String customerName){
        for(int i=0; i<this.arrayListCustomer.size(); i++) {
            Customer customer = this.arrayListCustomer.get(i);
            if(customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }
    private Customer queryCustomer(String customerName) {
        int position = findCustomer(customerName);
        if(position >=0) {
            return this.arrayListCustomer.get(position);
        }
        return null;
    }
}
