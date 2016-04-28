package com.example.proggeo.android_app_map;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void switchFloors(View v){
        ImageView plan = (ImageView)findViewById(R.id.imageView);
        int floorId=R.drawable.plan1;
        switch(v.getId()){
            case R.id.button1:
                floorId=R.drawable.plan1;
                break;
            case R.id.button2:
                floorId=R.drawable.plan2;
                break;
            case R.id.button3:
                floorId=R.drawable.plan3;
                break;
            case R.id.button4:
                floorId=R.drawable.plan4;
                break;
            case R.id.button5:
                floorId=R.drawable.plan5;
                break;
            case R.id.button6:
                floorId=R.drawable.plan6;
                break;
            case R.id.button7:
                floorId=R.drawable.plan7;
                break;
        }
        plan.setImageResource(floorId);

        ((Button)findViewById(R.id.button1)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button2)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button3)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button4)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button5)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button6)).setTextColor(Color.BLACK);
        ((Button)findViewById(R.id.button7)).setTextColor(Color.BLACK);

        ((Button)v).setTextColor(Color.RED);

    }
}
