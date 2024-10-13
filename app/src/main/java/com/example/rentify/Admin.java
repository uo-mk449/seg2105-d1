package com.example.rentify;

public class Admin extends Account {
    public Admin(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, Account.AccountType.Admin);
    }
}
