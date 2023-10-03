package org.example;

import org.example.classes.Bank;
import org.example.classes.impl.*;


public class Main {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();

        SavingAccount customer1SavingsAccount = new SavingAccount(1000, 0.05);
        customer1SavingsAccount.setInterestStrategy(new CompoundInterestCalculation());
        CheckingAccount customer1CheckingAccount = new CheckingAccount(2000);

        Customer customer1 = new Customer("Alikhan Kaliyev");
        customer1.addAccount(customer1SavingsAccount);
        customer1.addAccount(customer1CheckingAccount);

        bank.addAccount(customer1SavingsAccount);
        bank.addAccount(customer1CheckingAccount);

        SavingAccount customer2SavingsAccount = new SavingAccount(1500, 0.04);
        customer2SavingsAccount.setInterestStrategy(new SimpleInterestCalculation());
        CheckingAccount customer2CheckingAccount = new CheckingAccount(2500);

        Customer customer2 = new Customer("Timur Zhamangarin");
        customer2.addAccount(customer2SavingsAccount);
        customer2.addAccount(customer2CheckingAccount);

        bank.addAccount(customer2SavingsAccount);
        bank.addAccount(customer2CheckingAccount);

        customer1SavingsAccount.deposit(500);
        customer1SavingsAccount.withdraw(200);
        customer1SavingsAccount.addInterest();
        customer1CheckingAccount.deposit(1000);
        customer1CheckingAccount.transfer(customer1SavingsAccount, 500);

        customer2SavingsAccount.deposit(300);
        customer2SavingsAccount.withdraw(100);
        customer2SavingsAccount.addInterest();
        customer2CheckingAccount.deposit(800);
        customer2CheckingAccount.transfer(customer2SavingsAccount, 200);
    }
}