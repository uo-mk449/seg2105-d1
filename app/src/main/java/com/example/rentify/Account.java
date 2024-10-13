package com.example.rentify;

public abstract class Account {
    private String email, username, password, firstName, lastName;
    public enum AccountType {Admin, Lessor, Renter, Account}
    public AccountType type;

    public Account(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = AccountType.Account;
    }

    public Account(String username, String password, String firstName, String lastName, AccountType type) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    /**
     * Returns the user's username
     * @return username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the user's password
     * @return username
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the user's first name
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the user's last name
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns the user's account type
     * @return account type
     */
    public AccountType getType() {
        return this.type;
    }
}
