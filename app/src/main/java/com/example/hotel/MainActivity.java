package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText password;
    String username = "admin";
    String pass = "1234";
    Button button;
    DBConnection db;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);
        button = findViewById(R.id.button1);

        db = new DBConnection(MainActivity.this);
    }

    public void login(View view) {

        String userEmail = name.getText().toString();
        boolean userExist = db.checkUserLogin(userEmail);
        Toast.makeText(this, userExist + "sf", Toast.LENGTH_LONG).show();

        if (name.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill the empty field", Toast.LENGTH_LONG).show();
        } else if (userExist || (name.getText().toString().equals(username) && password.getText().toString().equals(pass))) {

            Intent activityIntent1 = new Intent(this, HomeCards.class);
            startActivity(activityIntent1);
        } else {
            Toast.makeText(this, "Wrong name or password", Toast.LENGTH_LONG).show();
            counter++;
            if (counter == 3) {
                button.setEnabled(false);
                button.setBackgroundColor(Color.GRAY);
                Toast.makeText(this, "Login disabled, You have entered wrong inputs 3 times", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void createAccount(View view) {
        Intent activityIntent2 = new Intent(this, CreateAccount.class);
        startActivity(activityIntent2);
    }
}