package com.example.rentify;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public LoginDatabase database = new LoginDatabase();
    Account userAccount;

    public void onRegister(View view) {
        TextView errorText = (TextView) findViewById(R.id.errorText);
        errorText.setText("");

        Account account;

        RadioGroup radioButtonGroup = (RadioGroup) findViewById(R.id.accountTypeRadioGroup);

        String username = ((TextView) findViewById(R.id.usernameInput)).getText().toString();
        String password = ((TextView) findViewById(R.id.passwordInput)).getText().toString();
        String firstName = ((TextView) findViewById(R.id.firstNameInput)).getText().toString();
        String lastName = ((TextView) findViewById(R.id.lastNameInput)).getText().toString();

        int checkedButtonId = radioButtonGroup.getCheckedRadioButtonId();

        if (checkedButtonId == R.id.admin) {
            account = new Admin(username, password, firstName, lastName);
        } else if (checkedButtonId == R.id.renter) {
            account = new Renter(username, password, firstName, lastName);
        } else {
            account = new Lessor(username, password, firstName, lastName);
        }

        try {
            boolean isSuccessfulRegistration = database.registerAccount(account);
            if (isSuccessfulRegistration) {
                userAccount = account;

                Intent successIntent = new Intent(view.getContext(), RegistrationSuccess.class);

                successIntent.putExtra("username", username);
                successIntent.putExtra("password", password);

                startActivity(successIntent);
            }
        } catch (IllegalArgumentException e) {
            errorText.setText(e.getMessage());
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}