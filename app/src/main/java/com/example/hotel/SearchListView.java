package com.example.hotel;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SearchListView extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<HotelModel> hotelList = null;
    private ArrayList<HotelModel> hotelsNames;

    public SearchListView(Context context, List<HotelModel> hotelList) {
        mContext = context;
        this.hotelList = hotelList;
        inflater = LayoutInflater.from(mContext);
        this.hotelsNames = new ArrayList<HotelModel>();
        this.hotelsNames.addAll(hotelList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return hotelList.size();
    }

    @Override
    public HotelModel getItem(int position) {
        return hotelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.search_list_item, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(hotelList.get(position).getName());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        hotelList.clear();
        if (charText.length() == 0) {
            hotelList.addAll(hotelsNames);
        } else {
            for (HotelModel hotel : hotelsNames) {
                if (hotel.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    hotelList.add(hotel);
                }
            }
        }
        notifyDataSetChanged();
    }

}
