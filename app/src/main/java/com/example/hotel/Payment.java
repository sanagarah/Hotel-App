package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    TextView priceText;
    ImageView hotelImagePayment;
    ReservationModel reservationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        editText1 = findViewById(R.id.edit7);
        editText2 = findViewById(R.id.edit8);
        editText3 = findViewById(R.id.edit9);
        editText4 = findViewById(R.id.edit10);
        priceText = findViewById(R.id.price);
        hotelImagePayment = findViewById(R.id.hotelImagePayment);


        String uri = "@drawable/room1";  // where myresource (without the extension) is the file

        int imageResource = getResources().getIdentifier(uri, null, getPackageName());


        Drawable res = getResources().getDrawable(imageResource);
        hotelImagePayment.setImageDrawable(res);

        Intent intent = getIntent();
        reservationModel = (ReservationModel) getIntent().getSerializableExtra("hotelReservation");
        priceText.setText(reservationModel.getHotel().getPrice());
    }

    public void next2(View view) {
        if (editText1.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty()){
            Toast.makeText(this, "Please fill the empty field", Toast.LENGTH_LONG).show();
        }
        else {

            Intent activity2Intent = new Intent(this, Reservation.class);
            activity2Intent.putExtra("reservationModel", reservationModel);
            startActivity(activity2Intent);
        }
    }
}