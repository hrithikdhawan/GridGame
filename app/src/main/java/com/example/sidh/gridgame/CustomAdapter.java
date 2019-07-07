package com.example.sidh.gridgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    LayoutInflater layoutInflater;
    ArrayList<String> numbers;
    public CustomAdapter(Context application, ArrayList<String> list) {
        layoutInflater=LayoutInflater.from(application);
        numbers=list;
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public Object getItem(int i) {
        return numbers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=layoutInflater.inflate(R.layout.single_element_view,null);
        TextView textView= (TextView) view.findViewById(R.id.texting);
        textView.setText(numbers.get(i));
        return view;
    }
}
