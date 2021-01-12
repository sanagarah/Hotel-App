package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class Search extends AppCompatActivity  implements SearchView.OnQueryTextListener {
    List<HotelModel> hotelList;
    ListView list;
    DBConnection db;
    SearchView editsearch;
    SearchListView adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);




        db = new DBConnection(Search.this);
        hotelList = db.getHotelData();
        ListView list;
        String[] hotelNames = new String[hotelList.size()];
        for (int i = 0; i < hotelList.size(); i++) {
            hotelNames[i] = hotelList.get(i).getName();
        }


        Integer[] imgid = {
                R.drawable.room1, R.drawable.room2,
                R.drawable.room3, R.drawable.room3, R.drawable.room3
        };

        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        adapter = new SearchListView(this,  hotelList);
        list = (ListView) findViewById(R.id.hotelsSearch);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getApplicationContext(), infoHotel.class);
                int hotelId = (int) position + 1;
                //Toast.makeText(getApplicationContext(), hotelId, Toast.LENGTH_SHORT).show();
                intent.putExtra("hotelId", hotelId);
                startActivity(intent);


            }
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}