package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels_list);

        DBConnection db = new DBConnection(Home.this);
        List<HotelModel> hotelList = db.getHotelData();
        ListView list;
        String[] hotelNames = new String[hotelList.size()];
        for (int i = 0; i < hotelList.size(); i++) {
            hotelNames[i] = hotelList.get(i).getName();
        }


        Integer[] imgid = {
                R.drawable.room1, R.drawable.room2, R.drawable.parkinn, R.drawable.radisson,
                R.drawable.room3, R.drawable.crowan_plaza, R.drawable.dorsett, R.drawable.narcissus,
                R.drawable.four, R.drawable.karma, R.drawable.louis, R.drawable.marriott,
                R.drawable.millennim, R.drawable.narcissus, R.drawable.nordstern, R.drawable.novotel,
                R.drawable.park_hayatt, R.drawable.parkinn, R.drawable.radisson, R.drawable.ritz_carlton,
                R.drawable.shazaa, R.drawable.sheraton, R.drawable.tanjung_rhu_resort, R.drawable.the_style_hotel,
                R.drawable.room1, R.drawable.room2, R.drawable.parkinn, R.drawable.radisson,
        };

        // tesing db data
//        String size = "size" + hotelList.size() + "content " + hotelList.toString();
//        Toast.makeText(Home.this, size, Toast.LENGTH_LONG).show();

        HotelsListView adapter = new HotelsListView(this, hotelNames, imgid, hotelList);
        list = (ListView) findViewById(R.id.hotels_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(), infoHotel.class);
                int hotelId = (int) position + 1;
                intent.putExtra("hotelId", hotelId);
                startActivity(intent);


            }
        });

    }
}