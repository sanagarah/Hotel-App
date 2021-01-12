package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class infoHotel extends AppCompatActivity {
    TextView hotelNameText;
    EditText roomsText1;
    EditText adultText2;
    EditText childrenText3;
    DatePicker checkInDate;
    DatePicker chckOutDate;

    HotelModel hotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hotel);
        Intent intent = getIntent();
        DBConnection db = new DBConnection(infoHotel.this);
        //String name = intent.getStringExtra("name");
        int hotelId = (int) getIntent().getSerializableExtra("hotelId");
        hotel = db.getHotelById(hotelId);
        if (hotel != null) {
            hotelNameText = findViewById(R.id.text8);
            hotelNameText.setText(hotel.getName());
        }

        int im = intent.getIntExtra("img", 0);


        roomsText1 = findViewById(R.id.roomsNum);
        adultText2 = findViewById(R.id.adultNum);
        childrenText3 = findViewById(R.id.childrenNum);
        checkInDate = findViewById(R.id.checkInDate);
        chckOutDate = findViewById(R.id.checkOutDate);

    }

    public void next1(View view) {
        if (roomsText1.getText().toString().isEmpty() || adultText2.getText().toString().isEmpty() || childrenText3.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please fill the empty field", Toast.LENGTH_LONG).show();
        } else {
            String rooms = roomsText1.getText().toString();
            String adultNum = adultText2.getText().toString();
            String childrenNum = childrenText3.getText().toString();
            int checkInday = checkInDate.getDayOfMonth();
            int checkInmonth = checkInDate.getMonth() + 1;
            int checkInyear = checkInDate.getYear();


            String strCheckInDate = checkInday + "-" + checkInmonth + "-" + checkInyear;

            int checkOutday = chckOutDate.getDayOfMonth();
            int checkOutmonth = chckOutDate.getMonth() + 1;
            int checkOutyear = chckOutDate.getYear();

            String strCheckOutDate = checkOutday + "-" + checkOutmonth + "-" + checkOutyear;

            ReservationModel hotelReservation = new ReservationModel(hotel, rooms, adultNum, childrenNum, strCheckInDate, strCheckOutDate);

            Intent activity2Intent = new Intent(this, Payment.class);
            activity2Intent.putExtra("hotelReservation", hotelReservation);
            startActivity(activity2Intent);
        }
    }
}