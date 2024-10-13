package com.example.rentify;

public class Renter extends Account {
    public Renter(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, AccountType.Renter);
    }
}
