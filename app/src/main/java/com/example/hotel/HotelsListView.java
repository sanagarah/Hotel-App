package com.example.hotel;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class HotelsListView extends ArrayAdapter<String> {
    private final Activity context;
    private final List<HotelModel> hotelList;
    private final String[] hotelsNames;
    private final Integer[] imgid;
    private DBConnection db;



    public HotelsListView(Activity context, String[] hotelsNames, Integer[] imgid, List<HotelModel> hotelList) {

        super(context,R.layout.hotels_list_item,  hotelsNames);

        db = new DBConnection(context);

        this.context=context;
        this.hotelList = hotelList;
        this.hotelsNames=hotelsNames;
        this.imgid=imgid;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.hotels_list_item, null, true);

        TextView nameText = (TextView) rowView.findViewById(R.id.hotelName);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.hotelImg);
        TextView cityText = (TextView) rowView.findViewById(R.id.hotelCity);
        TextView distanceText = (TextView) rowView.findViewById(R.id.hotelDistance);
        TextView priceText = (TextView) rowView.findViewById(R.id.hotelPrice);
        RatingBar starsRating = (RatingBar) rowView.findViewById(R.id.hotelStars);


        nameText.setText(hotelList.get(position).getName());
        imageView.setImageResource(imgid[position]);
        cityText.setText(hotelList.get(position).getCity());
        distanceText.setText(hotelList.get(position).getDistance());
        priceText.setText(hotelList.get(position).getPrice());
        starsRating.setRating(hotelList.get(position).getRating());

        return rowView;

    }




}
