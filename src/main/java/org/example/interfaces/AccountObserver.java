package org.example.interfaces;

import org.example.abtract_classes.Account;

public interface AccountObserver {
    void update(Account account, double amount);
}
