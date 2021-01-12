package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;


public class DBConnection extends SQLiteOpenHelper {


    public DBConnection(@Nullable Context context) {
        super(context, "nazeel.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "Create Table user(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, phone INTEGER, password INTEGER)";
        db.execSQL(createUserTable);
        String createHotelTable = "Create Table hotel(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, city TEXT, distance TEXT, price TEXT, rating INTEGER)";
        db.execSQL(createHotelTable);

        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Meruila', 'Bercelona', '1.5km to city center', '$168', 3)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Botique Hotel', 'Berlin', '0.5km to city center', '$200', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Atlantic', 'Bercelon', '1km to city center', '$632', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('South Ocean', 'Bercelona', '3km to city center', '$120', 2)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Meruila', 'Bercelona', '1.5km to city center', '$168', 3)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Botique Hotel', 'Berlin', '0.5km to city center', '$200', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Atlantic', 'Bercelon', '1km to city center', '$632', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('South Ocean', 'Bercelona', '3km to city center', '$120', 2)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Marriott', 'Glasgow', '1km to city center', '$119', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Four Seasons', 'Paris', '4km to city center', '$1243',5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Sheraton', 'Dubai', '4.1km to city center', '$132', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Radisson', 'Istanbul', '750m to city center', '$79', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Novotel', 'Paris', '5km to city center', '$200', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Millennium', 'Dubai', '2.6km to city center', '$128', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Narcissus', 'Jeddah', '21km to city center', '$840', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Ritz-Carlton', 'Riyadh', '6km to city center', '$400', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Alexander Inn', 'Philadelphia', '750m to city center', '$99', 3)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Park Hyatt', 'Tokyo', '3.5km to city center', '$657', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Louis', 'Munich', '200m to city center', '$316', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Tanjung Rhu Resort', 'Langkawi', '1.4km to city center', '$440', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('‪The Stylel‬', 'Rome', '2.5km to city center', '$200', 3)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Karma', 'Istanbul', '300m to city center', '$150', 3.7)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Nordstern', 'Istanbul', '1km to city center', '$500', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Dorsett', 'London', '3km to city center', '$217', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Four Seasons', 'Riyadh', '2km to city center', '$350', 5)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Crown Plaza', 'Jeddah', '200m to city center', '$147', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('Shaza', 'Makkah', '1.5km to city center', '$103', 4)");
        db.execSQL("INSERT INTO hotel(name, city, distance, price, rating) VALUES ('park inn', 'Dammam', '4km to city center', '$152', 4)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public boolean insert_data(String username, String userEmail, int userPhone, int userPassword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", username);
        values.put("email", userEmail);
        values.put("phone", userPhone);
        values.put("password", userPassword);
        long insert = db.insert("user", null, values);

        // check if insert was successful
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }


    public List<HotelModel> getHotelData() {
        List<HotelModel> hotelData = new ArrayList();

        String query = "SELECT * FROM hotel";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // check if there are returned results
        if (cursor.moveToFirst()) {
            // create a new hotel object for each result in the cursor

            do {
                // retrieve record data from cursor results
                int hotelId = cursor.getInt(0);
                String hotelName = cursor.getString(1);
                String hotelCity = cursor.getString(2);
                String hotelDistance = cursor.getString(3);
                String hotelPrice = cursor.getString(4);
                int hotelRating = cursor.getInt(5);
                HotelModel hotel = new HotelModel(hotelId, hotelName, hotelDistance, hotelCity, hotelPrice, hotelRating);
                hotelData.add(hotel);
            } while (cursor.moveToNext());
        }

        // cursor and db connection
        cursor.close();
        db.close();
        return hotelData;
    }


    public HotelModel getHotelById(int id) {

        String query = "SELECT * FROM hotel WHERE id=" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // check if there are returned results
        if (cursor.moveToFirst()) {
            // create a new hotel object for each result in the cursor

            int hotelId = cursor.getInt(0);
            String hotelName = cursor.getString(1);
            String hotelCity = cursor.getString(2);
            String hotelDistance = cursor.getString(3);
            String hotelPrice = cursor.getString(4);
            int hotelRating = cursor.getInt(5);
            HotelModel hotel = new HotelModel(hotelId, hotelName, hotelDistance, hotelCity, hotelPrice, hotelRating);
            cursor.close();
            db.close();
            return hotel;
        } else {
            return null;
        }

    }

    public List<HotelModel> searchHotels(String searchTerm) {
        List<HotelModel> hotelData = new ArrayList();
        String query = "SELECT * FROM hotel WHERE name LIKE '%" + searchTerm + "%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // check if there are returned results
        if (cursor.moveToFirst()) {
            // create a new hotel object for each result in the cursor

            do {
                // retrieve record data from cursor results
                int hotelId = cursor.getInt(0);
                String hotelName = cursor.getString(1);
                String hotelCity = cursor.getString(2);
                String hotelDistance = cursor.getString(3);
                String hotelPrice = cursor.getString(4);
                int hotelRating = cursor.getInt(5);
                HotelModel hotel = new HotelModel(hotelId, hotelName, hotelDistance, hotelCity, hotelPrice, hotelRating);
                hotelData.add(hotel);
            } while (cursor.moveToNext());
        }

        // cursor and db connection
        cursor.close();
        db.close();
        return hotelData;

    }


    public boolean checkUserLogin(String email) {
        String query = "SELECT * FROM user WHERE email LIKE '%" + email + "%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        // check if there are returned results
        if (cursor.moveToFirst()) {
            String dbEmail = cursor.getString(2);
            cursor.close();
            db.close();
            return true;
        } else {
            return false;
        }

    }


    /** public String get_data(){
     String username;
     SQLiteDatabase DB = this.getReadableDatabase();
     Cursor result=DB.rawQuery("select name from user", null);
     result.moveToFirst();
     String name =result.getString(1);
     username = name;
     return username;}**/

}

