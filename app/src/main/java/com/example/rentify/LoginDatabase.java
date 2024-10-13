package com.example.rentify;

import java.util.ArrayList;

public class LoginDatabase {
    private static ArrayList<Account> accounts = new ArrayList<Account>();

    public LoginDatabase() {
    }

    public LoginDatabase(ArrayList<Account> accountList) {
        accounts = accountList;
    }

    /**
     * Registers an account to the account database, otherwise throws an illegal argument exception
     * for an invalid input field.
     *
     * Constraints:
     * - firstName length >= 3
     * - lastName length >= 2
     * - username is alphanumeric including underscores, and 3 <= length <= 12
     * - password is between 8 and 16 characters
     *
     * @param account
     */
    public static boolean registerAccount(Account account) {
        // Username alphanumeric with underscores validation regex: https://stackoverflow.com/questions/336210/regular-expression-for-alphanumeric-and-underscores
        String usernameValidation = "^[a-zA-Z0-9_]*$";
        java.util.regex.Pattern usernamePattern = java.util.regex.Pattern.compile(usernameValidation);

        String username = account.getUsername();
        String password = account.getPassword();
        String firstName = account.getFirstName();
        String lastName = account.getLastName();

        java.util.regex.Matcher emailMatcher = usernamePattern.matcher(username);
        if (!emailMatcher.find() || username.length() > 12 || username.length() < 3) throw new IllegalArgumentException("Username must be alphanumeric with underscores and between 3 and 12 characters.");
        if (password.length() < 8 || password.length() > 16) throw new IllegalArgumentException("Password must be between 8 and 16 characters.");
        if (!(firstName.length() >= 3)) throw new IllegalArgumentException("First name must be at least 3 characters");
        if (!(lastName.length() >= 2)) throw new IllegalArgumentException("Last name must be at least 2 characters");

        accounts.add(account);
        return true;
    }

    /**
     * Returns an account if the login was successful
     *
     * @param username The user's username
     * @param password the user's password
     *
     * @return boolean
     */
    public static Account login(String username, String password) {
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                if (account.getPassword().equals(password)) return account;
                else break;
            }
        }

        return null;
    }

    /**
     * Returns an array list of users if the account is an admin, otherwise null
     *
     * @param account An admin account
     *
     * @return accounts
     */
    public static ArrayList<Account> listUsers(Account account) {
        if (account.type == Account.AccountType.Admin) {
            return accounts;
        }

        return null;
    }
}
