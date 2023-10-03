package org.example.classes;

import org.example.abtract_classes.Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank instance;
    private List<Account> accounts;

    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
