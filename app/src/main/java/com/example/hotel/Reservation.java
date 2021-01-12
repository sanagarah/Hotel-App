package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Reservation extends AppCompatActivity {

    TextView hotelName;
    TextView hotelRooms;
    TextView hotelCheckin;
    TextView hotelCheckout;
    TextView hotelPrice;
    ReservationModel hotelReservation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
         hotelName = findViewById(R.id.hotelNameReservation);
         hotelRooms= findViewById(R.id.roomNumReseration);
         hotelCheckin= findViewById(R.id.checkInDateReservation);
         hotelCheckout= findViewById(R.id.checkOutDateReservation);
         hotelPrice= findViewById(R.id.priceReservation);
        hotelReservation = (ReservationModel) getIntent().getSerializableExtra("reservationModel");

        hotelName.setText(hotelReservation.getHotel().getName());
        hotelRooms.setText(hotelReservation.getRooms());
        hotelCheckin.setText(hotelReservation.getCheckIn());
        hotelCheckout.setText(hotelReservation.getCheckOut());
        hotelPrice.setText(hotelReservation.getHotel().getPrice());
    }



    public void goToHome(View view) {


            Intent activity2Intent = new Intent(this, HomeCards.class);
            startActivity(activity2Intent);

    }
}