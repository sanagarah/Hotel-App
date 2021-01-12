package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText phone;
    EditText password;
    DBConnection db = new DBConnection(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        name = findViewById(R.id.edit3);
        email = findViewById(R.id.edit4);
        phone = findViewById(R.id.edit5);
        password = findViewById(R.id.edit6);
    }


    public void createAccount(View view) {
        if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill the empty field", Toast.LENGTH_LONG).show();
        } else {
            String username = name.getText().toString();
            String userEmail = email.getText().toString();
            int userPhone = Integer.parseInt(phone.getText().toString());
            int userPassword = Integer.parseInt(password.getText().toString());
            boolean success = db.insert_data(username, userEmail, userPhone, userPassword);
            if (success) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
                Intent activity2Intent = new Intent(this, HomeCards.class);
                startActivity(activity2Intent);
            } else {
                Toast.makeText(this, "an error has occurred" + success, Toast.LENGTH_SHORT).show();
            }
        }
    }
}