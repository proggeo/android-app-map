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

    HashMap <String, Point> rooms = new HashMap<String, Point>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ((Button) findViewById(R.id.button1)).setTextColor(Color.RED);
        for (int i = 0; i < 8; i++) {
            paths.add(i, new ArrayList<Point>());
        }
        NavigationController navigationController = new NavigationController();
        paths = navigationController.findRoute("room1","room6");
//        rooms.put("hall",new Point(320,10));
//        rooms.put("stairs_hall",new Point(320,195));
//        rooms.put("room01", new Point(320, 350));
//        rooms.put("wc1_1", new Point(240, 230));
//        rooms.put("wc1_2", new Point(430, 230));
//        rooms.put("room1", new Point(190, 350));
//        rooms.put("room2", new Point(190, 310));
//        rooms.put("room3",new Point(190,275));
//        rooms.put("room4",new Point(190,245));
//        rooms.put("stairs1_1",new Point(190,220));
//        rooms.put("room5",new Point(150,195));
//        rooms.put("room6",new Point(190,195));
//        rooms.put("room7",new Point(220,195));
//        rooms.put("room8",new Point(440,195));
//        rooms.put("room9",new Point(480,195));
//        rooms.put("room10",new Point(510,195));
//        rooms.put("stairs1_2",new Point(480,225));
//        rooms.put("room11",new Point(480,250));
//        rooms.put("room12",new Point(480,280));
//        rooms.put("room13",new Point(480,320));
//        rooms.put("room14",new Point(480,350));
//        rooms.put("room201",new Point(120,570));
//        rooms.put("room202",new Point(235,570));
//        rooms.put("room203",new Point(285,570));
//        rooms.put("room204",new Point(355,570));
//        rooms.put("room205",new Point(425,570));
//        rooms.put("room231",new Point(235,590));
//        rooms.put("room232",new Point(285,590));
//        rooms.put("room233",new Point(335,590));
//        rooms.put("room234",new Point(380,590));
//        rooms.put("room235",new Point(425,590));
//        rooms.put("stairs1_3",new Point(120,620));
//        rooms.put("stairs1_4",new Point(520,620));
//        rooms.put("room207",new Point(480,665));
//        rooms.put("room208",new Point(480,690));
//        rooms.put("room209",new Point(480,720));
//        rooms.put("room210",new Point(480,750));
//        rooms.put("room211",new Point(480,780));
//        rooms.put("room212",new Point(480,805));
//        rooms.put("room213",new Point(480,840));
//        rooms.put("room214",new Point(480,870));
//        rooms.put("room215",new Point(480,900));
//        rooms.put("room216",new Point(480,900));
//        rooms.put("room217",new Point(435,900));
//        rooms.put("room218",new Point(390,900));
//        rooms.put("room218a",new Point(335,900));
//        rooms.put("room219",new Point(290,900));
//        rooms.put("room220",new Point(230,900));
//        rooms.put("room221",new Point(190,900));
//        rooms.put("room222",new Point(190,900));
//        rooms.put("room223",new Point(190,870));
//        rooms.put("room224",new Point(190,835));
//        rooms.put("room225",new Point(190,805));
//        rooms.put("room226",new Point(190,775));
//        rooms.put("room227",new Point(190,745));
//        rooms.put("room228",new Point(190,720));
//        rooms.put("room229",new Point(190,690));
//        rooms.put("room230",new Point(190,660));
//        rooms.put("room236",new Point(435,870));
//        rooms.put("room237",new Point(390,870));
//        rooms.put("stairs1_5",new Point(335,870));
//        rooms.put("room238",new Point(280,870));
//        rooms.put("room239",new Point(230,870));
//        rooms.put("room25",new Point(325,100));
//        rooms.put("room24",new Point(270,100));
//        rooms.put("room26",new Point(390,100));
//        rooms.put("room23",new Point(270,100));
//        rooms.put("room27",new Point(390,100));
//        rooms.put("room28",new Point(390,170));
//        rooms.put("room21",new Point(150,300));
//        rooms.put("room22",new Point(210,300));
//        rooms.put("room30",new Point(450,300));
//        rooms.put("room29",new Point(510,300));
//        rooms.put("stairs2_1",new Point(325,300));
//        rooms.put("room20",new Point(150,340));
//        rooms.put("room19",new Point(150,380));
//        rooms.put("room18",new Point(150,410));
//        rooms.put("room17",new Point(150,440));
//        rooms.put("room16",new Point(150,480));
//        rooms.put("room15",new Point(150,510));
//        rooms.put("room31",new Point(510,375));
//        rooms.put("room32",new Point(510,410));
//        rooms.put("room33",new Point(510,460));
//        rooms.put("buffet",new Point(510,500));
//        rooms.put("room301",new Point(70,790));
//        rooms.put("room302",new Point(210,790));
//        rooms.put("room303",new Point(280,790));
//        rooms.put("room304",new Point(330,790));
//        rooms.put("room305",new Point(390,790));
//        rooms.put("room306",new Point(450,790));
//        rooms.put("room307",new Point(580,790));
//        rooms.put("stairs2_2",new Point(70,820));
//        rooms.put("room312",new Point(210,820));
//        rooms.put("room311",new Point(280,820));
//        rooms.put("room310",new Point(330,820));
//        rooms.put("room309",new Point(390,820));
//        rooms.put("room308",new Point(450,820));
//        rooms.put("stairs2_3",new Point(580,820));
//        rooms.put("stairs3",new Point(340,550));
//        rooms.put("room43",new Point(250,500));
//        rooms.put("room39",new Point(400,500));
//        rooms.put("room40",new Point(400,440));
//        rooms.put("room42",new Point(250,440));
//        rooms.put("room401",new Point(50,480));
//        rooms.put("stairs4_1",new Point(50,480));
//        rooms.put("room412",new Point(210,480));
//        rooms.put("room411",new Point(275,480));
//        rooms.put("room410",new Point(335,480));
//        rooms.put("room409",new Point(395,480));
//        rooms.put("room408",new Point(450,480));
//        rooms.put("room407",new Point(600,480));
//        rooms.put("stairs4_2",new Point(600,480));
//        rooms.put("room402",new Point(210,440));
//        rooms.put("room403",new Point(275,440));
//        rooms.put("room404",new Point(335,440));
//        rooms.put("room405",new Point(395,440));
//        rooms.put("room406",new Point(450,440));

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


//        paths.get(1).add(new Point(325, 5));
//        paths.get(1).add(new Point(325, 218));

//        if(paths.get(1).size()<1) {
//            paths.get(1).add(rooms.get("hall"));
//            paths.get(1).add(rooms.get("stairs_hall"));
//            paths.get(1).add(rooms.get("room7"));
//            paths.get(1).add(rooms.get("room6"));
//            paths.get(1).add(rooms.get("room5"));
//            paths.get(1).add(rooms.get("room6"));
//            paths.get(1).add(rooms.get("room4"));
//            paths.get(1).add(rooms.get("room3"));
//            paths.get(1).add(rooms.get("room2"));
//            paths.get(1).add(rooms.get("room1"));
//            paths.get(1).add(rooms.get("room201"));
//            paths.get(1).add(rooms.get("room202"));
//            paths.get(1).add(rooms.get("room203"));
//            paths.get(1).add(rooms.get("room204"));
//            paths.get(1).add(rooms.get("room205"));
//            paths.get(1).add(rooms.get("stairs1_4"));
//            paths.get(1).add(rooms.get("room235"));
//            paths.get(1).add(rooms.get("room234"));
//            paths.get(1).add(rooms.get("room233"));
//            paths.get(1).add(rooms.get("room232"));
//            paths.get(1).add(rooms.get("room231"));
//            paths.get(1).add(rooms.get("stairs1_3"));
//            paths.get(1).add(rooms.get("room230"));
//            paths.get(1).add(rooms.get("room229"));
//            paths.get(1).add(rooms.get("room228"));
//            paths.get(1).add(rooms.get("room227"));
//            paths.get(1).add(rooms.get("room226"));
//            paths.get(1).add(rooms.get("room225"));
//            paths.get(1).add(rooms.get("room224"));
//            paths.get(1).add(rooms.get("room223"));
//            paths.get(1).add(rooms.get("room222"));
//            paths.get(1).add(rooms.get("room221"));
//            paths.get(1).add(rooms.get("room220"));
//            paths.get(1).add(rooms.get("room239"));
//            paths.get(1).add(rooms.get("room238"));
//            paths.get(1).add(rooms.get("stairs1_5"));
//            paths.get(1).add(rooms.get("room237"));
//            paths.get(1).add(rooms.get("room236"));
//            paths.get(1).add(rooms.get("room238"));
//            paths.get(1).add(rooms.get("room219"));
//            paths.get(1).add(rooms.get("room218a"));
//            paths.get(1).add(rooms.get("room218"));
//            paths.get(1).add(rooms.get("room217"));
//            paths.get(1).add(rooms.get("room216"));
//            paths.get(1).add(rooms.get("room215"));
//            paths.get(1).add(rooms.get("room214"));
//            paths.get(1).add(rooms.get("room213"));
//            paths.get(1).add(rooms.get("room212"));
//            paths.get(1).add(rooms.get("room211"));
//            paths.get(1).add(rooms.get("room210"));
//            paths.get(1).add(rooms.get("room209"));
//            paths.get(1).add(rooms.get("room208"));
//            paths.get(1).add(rooms.get("room207"));
//            paths.get(1).add(rooms.get("room14"));
//            paths.get(1).add(rooms.get("room13"));
//            paths.get(1).add(rooms.get("room12"));
//            paths.get(1).add(rooms.get("room11"));
//            paths.get(1).add(rooms.get("room9"));
//            paths.get(1).add(rooms.get("room10"));
//            paths.get(1).add(rooms.get("room8"));
//            paths.get(1).add(rooms.get("stairs_hall"));
//            paths.get(1).add(rooms.get("room01"));
//        }
//        paths.get(2).add(new Point(325,330));
//        paths.get(2).add(new Point(325,100));
//        paths.get(2).add(new Point(275,100));



        plan.path = paths.get(floor);

    }

}
