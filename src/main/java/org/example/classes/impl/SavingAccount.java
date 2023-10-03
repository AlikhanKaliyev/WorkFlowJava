package org.example.classes.impl;

import lombok.Data;
import org.example.abtract_classes.Account;
import org.example.interfaces.InterestCalculationStrategy;

@Data
public class SavingAccount extends Account {
    private double interestRate;

    private InterestCalculationStrategy interestStrategy;

    public SavingAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
        interestStrategy = new SimpleInterestCalculation();
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
        interestStrategy.calculateInterest(this);
    }
}
