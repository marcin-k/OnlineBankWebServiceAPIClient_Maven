package com.mycompany.onlinebankwebserviceapi.model;

import java.util.ArrayList;

/**
 *
 * @author marcin
 */
public class Account {
    
    //account's sort code
    private int sortCode;
    //account's number
    private int accountNumber;
    //account's balance
    private double balance;
    //customer's id that the account belong to
    private String customerId;
    
    //stores the last account number created so any new account gets an
    //incremented value of that account   
    public static int LAST_ACCOUNT_CREATED = 100000000;
    //stores branch code
    public static int BRANCH_CODE = 770777;

    //the constructor will use the initial deposit to initialize balance
    //the sort code will use the static value from Bank class
    //account number will be incremented number from Bank class
    public Account(double balance, String customerId) {
        this.sortCode = BRANCH_CODE;
        this.accountNumber = LAST_ACCOUNT_CREATED+1;
        LAST_ACCOUNT_CREATED = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    public Account() {
    }

    
//------------------------------Getters-----------------------------------------    
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getSortCode() {
        return sortCode;
    }

    public String getCustomerId() {
        return customerId;
    }
    
//------------------------------Setters-----------------------------------------    
    public void setSortCode(int sortCode) {
        this.sortCode = sortCode;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
        
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomerId(String customerLogin) {
        this.customerId = customerLogin;
    }
   
}
