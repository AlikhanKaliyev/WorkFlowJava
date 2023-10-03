package org.example.classes.impl;

import org.example.abtract_classes.Account;
import org.example.interfaces.InterestCalculationStrategy;

public class SimpleInterestCalculation implements InterestCalculationStrategy {
    @Override
    public void calculateInterest(Account account) {
        if (account instanceof SavingAccount) {
            SavingAccount savingsAccount = (SavingAccount) account;
            double balance = savingsAccount.getBalance();
            double interestRate = savingsAccount.getInterestRate();

            double interest = (balance * 0.75) * interestRate;
            savingsAccount.deposit(interest);
        } else {
            System.out.println("Interest calculation not supported for this account type.");
        }
    }
}
