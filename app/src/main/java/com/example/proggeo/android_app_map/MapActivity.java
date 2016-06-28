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
import java.util.HashMap;

public class MapActivity extends Activity {

    ArrayList<ArrayList<Point>> paths = new ArrayList<ArrayList<Point>>();
    HashMap<Integer, Integer> floorButtons = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Bundle extras = getIntent().getExtras();
        NavigationController navigationController = new NavigationController();
        if (extras != null) {
            String startRoom = extras.getString("START_ROOM");
            String endRoom = extras.getString("END_ROOM");
            paths = navigationController.findRoute(startRoom, endRoom);
        }
        fillFloors();
        setContentView(R.layout.activity_map);
        ((Button) findViewById(R.id.button1)).setTextColor(Color.RED);
        ((Button) findViewById(floorButtons.get(navigationController.startRoom.getFloor()))).performClick();

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
        plan.destroyDrawingCache();
        plan.setImageResource(floorId);

        for (int i = 1; i < paths.size(); i++) {
            if (paths.get(i).size() > 0)
                ((Button) findViewById(floorButtons.get(i))).setTextColor(Color.BLUE);
            else ((Button) findViewById(floorButtons.get(i))).setTextColor(Color.BLACK);
        }

        ((Button) v).setTextColor(Color.RED);
        plan.path = (ArrayList)paths.get(floor).clone();

    }

    private void fillFloors() {
        floorButtons.put(1, R.id.button1);
        floorButtons.put(2, R.id.button2);
        floorButtons.put(3, R.id.button3);
        floorButtons.put(4, R.id.button4);
        floorButtons.put(5, R.id.button5);
        floorButtons.put(6, R.id.button6);
        floorButtons.put(7, R.id.button7);
    }

}
