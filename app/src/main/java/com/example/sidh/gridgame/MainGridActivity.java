package com.example.sidh.gridgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainGridActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<String> numbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);


        gridView=(GridView) findViewById(R.id.main_grid_view);
        Log.i("1","here");

        numbers=new ArrayList<String>(20);
        for(int i=2;i<22;i++)
            numbers.add(i-2,i+"");
        Log.i("2","here");
        gridView.setNumColumns((int)Math.sqrt(20));
        final CustomAdapter adapter=new CustomAdapter(getApplicationContext(),numbers);
        Log.i("2","here");
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast=Toast.makeText(getApplicationContext(),numbers.get(i)+" clicked",Toast.LENGTH_SHORT);
                toast.show();

                numbers.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
        gridView.setVisibility(View.VISIBLE);
        Log.i("1","here");

    }
}
