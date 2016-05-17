package com.example.proggeo.android_app_map;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MapActivity extends Activity {

    ArrayList<ArrayList<Point>> paths = new ArrayList<ArrayList<Point>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ((Button) findViewById(R.id.button1)).setTextColor(Color.RED);
        for (int i = 0; i < 8; i++) {
            paths.add(i, new ArrayList<Point>());
        }
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

    public void switchFloors(View v) {
        MapImageView plan = (MapImageView) findViewById(R.id.imageView);
        int floorId = R.drawable.plan1;
        int floor = 1;
        switch (v.getId()) {
            case R.id.button1:
                floorId = R.drawable.plan1;
                floor = 1;
                break;
            case R.id.button2:
                floorId = R.drawable.plan2;
                floor = 2;
                break;
            case R.id.button3:
                floorId = R.drawable.plan3;
                floor = 3;
                break;
            case R.id.button4:
                floorId = R.drawable.plan4;
                floor = 4;
                break;
            case R.id.button5:
                floorId = R.drawable.plan5;
                floor = 5;
                break;
            case R.id.button6:
                floorId = R.drawable.plan6;
                floor = 6;
                break;
            case R.id.button7:
                floorId = R.drawable.plan7;
                floor = 7;
                break;
            default:
                floorId = R.drawable.plan1;
                floor = 1;
                break;
        }
        plan.setImageResource(floorId);

        ((Button) findViewById(R.id.button1)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button2)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button3)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button4)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button5)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button6)).setTextColor(Color.BLACK);
        ((Button) findViewById(R.id.button7)).setTextColor(Color.BLACK);

        ((Button) v).setTextColor(Color.RED);

//        paths.get(1).add(new Point(0, 0));
//        paths.get(1).add(new Point(100, 100));
//        paths.get(1).add(new Point(200, 100));
//        paths.get(1).add(new Point(300, 300));
//        paths.get(1).add(new Point(400, 300));
//        paths.get(1).add(new Point(500, 400));
//        paths.get(1).add(new Point(600, 400));


        paths.get(1).add(new Point(325, 5));
        paths.get(1).add(new Point(325, 218));

        paths.get(2).add(new Point(325,330));
        paths.get(2).add(new Point(325,100));
//        paths.get(2).add(new Point(275,100));



        plan.path = paths.get(floor);

    }
}
