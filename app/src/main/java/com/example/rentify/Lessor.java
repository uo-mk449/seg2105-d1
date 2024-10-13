package com.example.rentify;

public class Lessor extends Account {
    public Lessor(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, AccountType.Lessor);
    }
}
