package org.example.classes.impl;

import org.example.abtract_classes.Account;
import org.example.interfaces.AccountObserver;

import java.util.ArrayList;
import java.util.List;

public class Customer implements AccountObserver {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.addObserver(this);
    }

    public void update(Account account, double amount) {
        System.out.println(name + " received a notification: Transaction of $" + amount + " in " + account.getClass().getSimpleName() + " account.");
    }
}
