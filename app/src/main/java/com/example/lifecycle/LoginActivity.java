package com.example.lifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button buttonHint;
    private Button buttonLogin;
    private EditText login_name, login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        buttonHint = (Button) findViewById(R.id.login_hint_button);
        buttonLogin = (Button) findViewById(R.id.login_button);
        login_name = (EditText) findViewById(R.id.login_name);
        login_password = (EditText) findViewById(R.id.login_password);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String namn = login_name.getText().toString();
                final String pass = login_password.getText().toString();

                if (namn.equals("Admin") && pass.equals("123")) {
                    openActivityDataInput();
                } else {
                    Toast.makeText(LoginActivity.this, "Felaktigt, prova igen.", Toast.LENGTH_LONG).show();
                };
            };
        });

        buttonHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(LoginActivity.this, "Användarnamn: Admin, Lösenord: 123", Toast.LENGTH_LONG).show();

            };
        });

    }

    public void openActivityDataInput() {

        Intent intent = new Intent(this, InputMainActivity.class);
        startActivity(intent);
    };
}