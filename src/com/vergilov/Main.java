package com.vergilov;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Polski Bank");
        bank.addBranch("Przemysl");
        bank.addBranch("Warszawa");
        bank.addCustomer("Przemysl", "Luke", 504.02);
        bank.addCustomer("Przemysl", "Honk", 321.43);
        bank.addCustomer("Przemysl", "Nozo", 510.42);
        bank.addCustomer("Warszawa","Maciek",38218.33);

        bank.addCustomerTransaction("Przemysl","Honk",83213.12);
        bank.addCustomerTransaction("Przemysl","Honk",2134.23);
        bank.addCustomerTransaction("Przemysl","Luke",213.23);


        bank.listCustomer("Przemysl",true);
        bank.listCustomer("Warszawa",true);


        if(!bank.addCustomer("Lublin","Brajanek",5.42)){
            System.out.println("Error Lublin branch does not exist");
        }
        if(!bank.addBranch("Przemysl")){
            System.out.println("Przemysl branch already exist!");
        }

    }
}
