package org.example.abtract_classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.interfaces.AccountObserver;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Account {
    protected double balance;
    protected int accountNumber;

    private List<AccountObserver> observers = new ArrayList<>();

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void transfer(Account toAccount, double amount);

    public abstract void addInterest();

    public void addObserver(AccountObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(AccountObserver observer) {
        observers.remove(observer);
    }
    protected void notifyObservers(double amount, String transactionType) {
        for (AccountObserver observer : observers) {
            observer.update(this, amount);
        }
    }

}
