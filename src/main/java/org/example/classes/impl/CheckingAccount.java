package org.example.classes.impl;

import org.example.abtract_classes.Account;

public class CheckingAccount extends Account {
    public CheckingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        notifyObservers(amount, "Deposit");
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            notifyObservers(amount, "Withdrawal");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public void transfer(Account toAccount, double amount) {
        if (balance >= amount) {
            balance -= amount;
            toAccount.deposit(amount);
            notifyObservers(amount, "Transfer");
        } else {
            System.out.println("Insufficient balance for transfer.");
        }
    }

    @Override
    public void addInterest() {
        //не обязательно прописывать
    }

}
