package com.example.clientside;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private TextView locked;
    private TextView attempts;
    private TextView numberAttempts;
    int attempt = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupVariables();
    }
    @SuppressLint("SetTextI18n")
    public void authenticateLogin(View view) {
        if (username.getText().toString().equals("admin") &&
                password.getText().toString().equals("admin")) {
            Toast.makeText(getApplicationContext(), "Login OK !",
                    Toast.LENGTH_SHORT).show();
            SliderViewer.isAuthorize = true;
            this.finish();
        } else {
            username.setText("");
            password.setText("");
            Toast.makeText(getApplicationContext(), "Login not OK !",
                    Toast.LENGTH_SHORT).show();
            attempt--;
            attempts.setVisibility(View.VISIBLE);
            numberAttempts.setVisibility(View.VISIBLE);
            numberAttempts.setText(Integer.toString(attempt));
            if (attempt == 0) {
                loginBtn.setEnabled(false);
                locked.setVisibility(View.VISIBLE);
                locked.setBackgroundColor(Color.RED);
                locked.setText("Login Locked !");
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private void setupVariables() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        locked = findViewById(R.id.locked);
        attempts = findViewById(R.id.attempts);
        numberAttempts = findViewById(R.id.numberAttempts);
        numberAttempts.setText(Integer.toString(attempt));
    }
}