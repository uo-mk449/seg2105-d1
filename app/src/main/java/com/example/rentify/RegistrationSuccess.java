package com.example.rentify;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

import java.util.ArrayList;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationSuccess extends AppCompatActivity {
    Account userAccount;

    public void onReturn(View view) {
        Intent returnIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(returnIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration_success);
        TextView successText = (TextView) findViewById(R.id.successText);

        Intent intent = getIntent();

        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        userAccount = LoginDatabase.login(username, password);

        if (userAccount.getType() == Account.AccountType.Admin) {
            ArrayList<Account> accounts = LoginDatabase.listUsers(userAccount);

            String userList = "";

            for (Account account : accounts) {
                userList += "\n";
                userList += account.getType() + ": " + account.getUsername();
            }

            successText.setText("Welcome " + userAccount.getFirstName() + ", " + "you are registered as an admin! Here are the users: \n" + userList);
        } else {
            successText.setText("Welcome " + userAccount.getFirstName() + ", " + "you are registered as a " + (userAccount.getType() == Account.AccountType.Renter ? "renter" : "lessor") + "!");
        }
    }
}
