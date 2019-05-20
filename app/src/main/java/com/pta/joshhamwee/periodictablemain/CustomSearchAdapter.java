package com.pta.joshhamwee.periodictablemain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomSearchAdapter extends ArrayAdapter {
    private List<String> elementList;
    private Context mContext;
    private int searchResultItemLayout;

    //Class to handle our custom search
    public CustomSearchAdapter(Context context, int resource, List<String> storeSourceDataLst) {
        super(context, resource, storeSourceDataLst);
        elementList = storeSourceDataLst;
        mContext = context;
        searchResultItemLayout = resource;
    }

    @Override
    public int getCount() {
        return elementList.size();
    }

    @Override
    public String getItem(int position) {
        return elementList.get(position);
    }

    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(searchResultItemLayout, parent, false);
        }

        //Set the new resulting items in the specific TextViews
        TextView resultItem = (TextView) view.findViewById(android.R.id.text1);
        resultItem.setText(getItem(position));
        return view;
    }

}

