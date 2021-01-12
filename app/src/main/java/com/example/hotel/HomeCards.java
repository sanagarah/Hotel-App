package com.example.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

public class HomeCards extends AppCompatActivity {
    MaterialCardView searchCard;
    MaterialCardView listCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchCard = findViewById(R.id.searchCard);
        listCard = findViewById(R.id.listCard);



        searchCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2Intent = new Intent(HomeCards.this, Search.class);
                startActivity(activity2Intent);
            }
        });

        listCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity2Intent = new Intent(HomeCards.this, Home.class);
                startActivity(activity2Intent);
            }
        });

    }
}
