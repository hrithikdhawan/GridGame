package com.example.sidh.gridgame;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainGridActivity extends AppCompatActivity {
    GridView gridView;
    int arrayLength;
    ArrayList<String> numbers;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_settings)
        {
            Intent intent=new Intent(this,SettingActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
/*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        int newOrientation = newConfig.orientation;

        if (newOrientation == Configuration.ORIENTATION_LANDSCAPE) {
            double d=Math.sqrt(arrayLength)*16.0/9;
            Toast.makeText(this, "ln", Toast.LENGTH_SHORT).show();

            gridView.setNumColumns((int)d);
        }
        else {
            double d=Math.sqrt(arrayLength)*9.0/16;
            Toast.makeText(this, "prt", Toast.LENGTH_SHORT).show();

            gridView.setNumColumns((int)d);

        }
        adapter.notifyDataSetChanged();
    }
    */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.option_menu,menu);
       return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grid);
        getArrayLength();
        gridView=(GridView) findViewById(R.id.main_grid_view);

        //Log.i("1","here");

        numbers=new ArrayList<String>(arrayLength);
        for(int i=1;i<arrayLength+1;i++)
            numbers.add(i-1,i+"");
        double d=Math.sqrt(arrayLength);
        gridView.setNumColumns((int)d);
        final CustomAdapter adapter=new CustomAdapter(getApplicationContext(),numbers);
        //Log.i("2","here");

        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                numbers.remove(i);
                //        AnimatorSet set=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.view_flip);
//        set.setTarget(gridView);
//        set.start();

                adapter.notifyDataSetChanged();
            }
        });
        gridView.setVisibility(View.VISIBLE);

    }
    private void getArrayLength()
    {
        SharedPreferences sharedPreference= PreferenceManager.getDefaultSharedPreferences(this);
        String length=sharedPreference.getString(getString(R.string.setting_length_key),getString(R.string.default_array_length));
        arrayLength=Integer.parseInt(length);
    }
}
