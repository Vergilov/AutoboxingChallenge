package com.vergilov;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> arrayListBranch;

    public Bank(String name) {
        this.name = name;
        this.arrayListBranch = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        Branch newBranch = new Branch(branchName);
        if (findBranch(branchName) >= 0) {
            System.out.println("Branch is already on file");
            return false;
        }
        this.arrayListBranch.add(newBranch);
        return true;
    }


    private int fintBranch(Branch branch) {
        return this.arrayListBranch.indexOf(branch);
    }


    private int findBranch(String branchName) {
        for (int i = 0; i < this.arrayListBranch.size(); i++) {
            Branch branch = this.arrayListBranch.get(i);
            if (branch.getName().equals(branchName)) {
                return i;
            }
        }
        return -1;
    }

    private Branch queryBranch(String branchName) {
        int position = findBranch(branchName);
        if (position >= 0) {
            return this.arrayListBranch.get(position);
        }
        return null;
    }

    public boolean addCustomer(String branchName, String customerName, double amount) {
        Branch branch = queryBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, amount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = queryBranch(branchName);
        if (branch != null) {
            return branch.addTransaction(customerName, amount);
        }
        return false;
    }

    public boolean listCustomer(String branchName,boolean showTransaction) {
        Branch branch = queryBranch(branchName);
        if (branch != null) {
            System.out.println("Customers details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getArrayListCustomer();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransaction) {
                    System.out.println("Transaction: ");
                    ArrayList<Double> transaction = branchCustomer.getTransaction();
                    for (int j = 0; j < transaction.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transaction.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}


