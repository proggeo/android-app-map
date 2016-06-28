package com.example.proggeo.android_app_map;

import android.graphics.*;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by Proggeo on 5/22/2016.
 */
    public class NavigationController {

    ArrayList<IndoorMapObject> rooms;
    IndoorMapObject startRoom = null;
    IndoorMapObject endRoom = null;

    public NavigationController() {
        rooms = new ArrayList<IndoorMapObject>();
        setRooms();
    }

    public ArrayList<ArrayList<Point>> findRoute(String startName, String endName) {
        startRoom = null;
        endRoom = null;

        ArrayList<ArrayList<Point>> paths = new ArrayList<ArrayList<Point>>();
        for (int i = 0; i < 8; i++) {
            paths.add(i, new ArrayList<Point>());
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getName().equals(startName)) startRoom = rooms.get(i);
            if (rooms.get(i).getName().equals(endName)) endRoom = rooms.get(i);
        }

        ArrayList<IndoorMapObject> path = new ArrayList<IndoorMapObject>();
        if (startRoom != null && endRoom != null) {
            path = dijkstra(startRoom, endRoom);
        }
        for (int i = 0; i < path.size(); i++) {
            paths.get(path.get(i).getFloor()).add(path.get(i).getCoor());
        }

        return paths;
    }

    public void addConnection(String startName, String endName) {
        IndoorMapObject startRoom = null;
        IndoorMapObject endRoom = null;

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getName().equals(startName)) startRoom = rooms.get(i);
            if (rooms.get(i).getName().equals(endName)) endRoom = rooms.get(i);
        }

        if (startRoom != null && endRoom != null) {
            startRoom.addConnection(endRoom);
        }
    }

    public ArrayList<IndoorMapObject> dijkstra(IndoorMapObject startRoom, IndoorMapObject endRoom) {
        ArrayList<Boolean> checked = new ArrayList<Boolean>();
        for (int i = 0; i < rooms.size(); i++) checked.add(false);
        ArrayList<Double> minimumLength = new ArrayList<Double>();
        for (int i = 0; i < rooms.size(); i++) minimumLength.add(-1.0);
        ArrayList<IndoorMapObject> previousRoom = new ArrayList<IndoorMapObject>();
        for (int i = 0; i < rooms.size(); i++) previousRoom.add(null);

        int currentRoom = rooms.indexOf(startRoom);
        IndoorMapObject currentObj = startRoom;
        minimumLength.set(currentRoom, 0.0);

        for (int i = 0; i < rooms.size(); i++) {
            checked.set(currentRoom, true);
            currentObj = rooms.get(currentRoom);
            for (int j = 0; j < rooms.size(); j++) {
                if (rooms.get(j).getDistance(currentObj) > -1 && !checked.get(j)) {
                    if (minimumLength.get(j) == -1.0 || minimumLength.get(j) > (minimumLength.get(currentRoom) + currentObj.getDistance(rooms.get(j)))) {
                        minimumLength.set(j, minimumLength.get(currentRoom) + currentObj.getDistance(rooms.get(j)));
                        previousRoom.set(j, currentObj);
                    }
                }
            }
            int closest = -1; // id of closest room
            for (int j = 0; j < rooms.size(); j++) {
                if (!checked.get(j))
                    if (minimumLength.get(j) >= 0 && (closest == -1 || minimumLength.get(j) < minimumLength.get(closest)))
                        closest = j;
            }
            currentRoom = closest;
            if (closest == -1) break;
            if (rooms.indexOf(endRoom) == currentRoom) break;
        }
        ArrayList<IndoorMapObject> path = new ArrayList<IndoorMapObject>();
        IndoorMapObject current = endRoom;
        path.add(current);
        while (previousRoom.get(rooms.indexOf(current)) != null) {
            current = previousRoom.get(rooms.indexOf(current));
            path.add(0, current);
        }
        return path;
    }

    public void setRooms() {
        rooms.add(new IndoorMapObject("hall", new Point(320, 10), 1));
        rooms.add(new IndoorMapObject("stairs_hall", new Point(320, 195), 1));
        rooms.add(new IndoorMapObject("room01", new Point(320, 350), 1));
        rooms.add(new IndoorMapObject("wc1_1", new Point(240, 230), 1));
        rooms.add(new IndoorMapObject("wc1_2", new Point(430, 230), 1));
        rooms.add(new IndoorMapObject("room1", new Point(190, 350), 1));
        rooms.add(new IndoorMapObject("room2", new Point(190, 310), 1));
        rooms.add(new IndoorMapObject("room3", new Point(190, 275), 1));
        rooms.add(new IndoorMapObject("room4", new Point(190, 245), 1));
        rooms.add(new IndoorMapObject("stairs1_1", new Point(190, 220), 1));
        rooms.add(new IndoorMapObject("room5", new Point(150, 195), 1));
        rooms.add(new IndoorMapObject("room6", new Point(190, 195), 1));
        rooms.add(new IndoorMapObject("room7", new Point(220, 195), 1));
        rooms.add(new IndoorMapObject("room8", new Point(440, 195), 1));
        rooms.add(new IndoorMapObject("room9", new Point(480, 195), 1));
        rooms.add(new IndoorMapObject("room10", new Point(510, 195), 1));
        rooms.add(new IndoorMapObject("stairs1_2", new Point(480, 225), 1));
        rooms.add(new IndoorMapObject("room11", new Point(480, 250), 1));
        rooms.add(new IndoorMapObject("room12", new Point(480, 280), 1));
        rooms.add(new IndoorMapObject("room13", new Point(480, 320), 1));
        rooms.add(new IndoorMapObject("room14", new Point(480, 350), 1));
        rooms.add(new IndoorMapObject("service1", new Point(190, 570), 1));
        rooms.add(new IndoorMapObject("service2", new Point(480, 570), 1));
        rooms.add(new IndoorMapObject("room201", new Point(120, 570), 1));
        rooms.add(new IndoorMapObject("room202", new Point(235, 570), 1));
        rooms.add(new IndoorMapObject("room203", new Point(285, 570), 1));
        rooms.add(new IndoorMapObject("room204", new Point(355, 570), 1));
        rooms.add(new IndoorMapObject("room205", new Point(425, 570), 1));
        rooms.add(new IndoorMapObject("room231", new Point(235, 590), 1));
        rooms.add(new IndoorMapObject("room232", new Point(285, 590), 1));
        rooms.add(new IndoorMapObject("room233", new Point(335, 590), 1));
        rooms.add(new IndoorMapObject("room234", new Point(380, 590), 1));
        rooms.add(new IndoorMapObject("room235", new Point(425, 590), 1));
        rooms.add(new IndoorMapObject("stairs1_3", new Point(120, 620), 1));
        rooms.add(new IndoorMapObject("stairs1_4", new Point(520, 620), 1));
        rooms.add(new IndoorMapObject("room207", new Point(480, 665), 1));
        rooms.add(new IndoorMapObject("room208", new Point(480, 690), 1));
        rooms.add(new IndoorMapObject("room209", new Point(480, 720), 1));
        rooms.add(new IndoorMapObject("room210", new Point(480, 750), 1));
        rooms.add(new IndoorMapObject("room211", new Point(480, 780), 1));
        rooms.add(new IndoorMapObject("room212", new Point(480, 805), 1));
        rooms.add(new IndoorMapObject("room213", new Point(480, 840), 1));
        rooms.add(new IndoorMapObject("room214", new Point(480, 870), 1));
        rooms.add(new IndoorMapObject("room215", new Point(480, 900), 1));
        rooms.add(new IndoorMapObject("room216", new Point(480, 900), 1));
        rooms.add(new IndoorMapObject("room217", new Point(435, 900), 1));
        rooms.add(new IndoorMapObject("room218", new Point(390, 900), 1));
        rooms.add(new IndoorMapObject("room218a", new Point(335, 900), 1));
        rooms.add(new IndoorMapObject("room219", new Point(290, 900), 1));
        rooms.add(new IndoorMapObject("room220", new Point(230, 900), 1));
        rooms.add(new IndoorMapObject("room221", new Point(190, 900), 1));
        rooms.add(new IndoorMapObject("room222", new Point(190, 900), 1));
        rooms.add(new IndoorMapObject("room223", new Point(190, 870), 1));
        rooms.add(new IndoorMapObject("room224", new Point(190, 835), 1));
        rooms.add(new IndoorMapObject("room225", new Point(190, 805), 1));
        rooms.add(new IndoorMapObject("room226", new Point(190, 775), 1));
        rooms.add(new IndoorMapObject("room227", new Point(190, 745), 1));
        rooms.add(new IndoorMapObject("room228", new Point(190, 720), 1));
        rooms.add(new IndoorMapObject("room229", new Point(190, 690), 1));
        rooms.add(new IndoorMapObject("room230", new Point(190, 660), 1));
        rooms.add(new IndoorMapObject("room236", new Point(435, 870), 1));
        rooms.add(new IndoorMapObject("room237", new Point(390, 870), 1));
        rooms.add(new IndoorMapObject("stairs1_5", new Point(335, 870), 1));
        rooms.add(new IndoorMapObject("room238", new Point(280, 870), 1));
        rooms.add(new IndoorMapObject("room239", new Point(230, 870), 1));

        rooms.add(new IndoorMapObject("room25", new Point(325, 100), 2));
        rooms.add(new IndoorMapObject("room24", new Point(270, 100), 2));
        rooms.add(new IndoorMapObject("room26", new Point(390, 100), 2));
        rooms.add(new IndoorMapObject("room23", new Point(270, 100), 2));
        rooms.add(new IndoorMapObject("room27", new Point(390, 100), 2));
        rooms.add(new IndoorMapObject("room28", new Point(390, 170), 2));
        rooms.add(new IndoorMapObject("room21", new Point(150, 300), 2));
        rooms.add(new IndoorMapObject("room22", new Point(210, 300), 2));
        rooms.add(new IndoorMapObject("room30", new Point(450, 300), 2));
        rooms.add(new IndoorMapObject("room29", new Point(510, 300), 2));
        rooms.add(new IndoorMapObject("stairs2_1", new Point(325, 300), 2));
        rooms.add(new IndoorMapObject("room20", new Point(150, 340), 2));
        rooms.add(new IndoorMapObject("room19", new Point(150, 380), 2));
        rooms.add(new IndoorMapObject("room18", new Point(150, 410), 2));
        rooms.add(new IndoorMapObject("room17", new Point(150, 440), 2));
        rooms.add(new IndoorMapObject("room16", new Point(150, 480), 2));
        rooms.add(new IndoorMapObject("room15", new Point(150, 510), 2));
        rooms.add(new IndoorMapObject("room31", new Point(510, 375), 2));
        rooms.add(new IndoorMapObject("room32", new Point(510, 410), 2));
        rooms.add(new IndoorMapObject("room33", new Point(510, 460), 2));
        rooms.add(new IndoorMapObject("buffet", new Point(510, 500), 2));
        rooms.add(new IndoorMapObject("service2_1", new Point(510, 790), 2));
        rooms.add(new IndoorMapObject("service2_2", new Point(150, 790), 2));
        rooms.add(new IndoorMapObject("room301", new Point(70, 790), 2));
        rooms.add(new IndoorMapObject("room302", new Point(210, 790), 2));
        rooms.add(new IndoorMapObject("room303", new Point(280, 790), 2));
        rooms.add(new IndoorMapObject("room304", new Point(330, 790), 2));
        rooms.add(new IndoorMapObject("room305", new Point(390, 790), 2));
        rooms.add(new IndoorMapObject("room306", new Point(450, 790), 2));
        rooms.add(new IndoorMapObject("room307", new Point(580, 790), 2));
        rooms.add(new IndoorMapObject("stairs2_2", new Point(70, 820), 2));
        rooms.add(new IndoorMapObject("room312", new Point(210, 820), 2));
        rooms.add(new IndoorMapObject("room311", new Point(280, 820), 2));
        rooms.add(new IndoorMapObject("room310", new Point(330, 820), 2));
        rooms.add(new IndoorMapObject("room309", new Point(390, 820), 2));
        rooms.add(new IndoorMapObject("room308", new Point(450, 820), 2));
        rooms.add(new IndoorMapObject("stairs2_3", new Point(580, 820), 2));

        rooms.add(new IndoorMapObject("stairs3", new Point(340, 550), 3));
        rooms.add(new IndoorMapObject("room43", new Point(250, 500), 3));
        rooms.add(new IndoorMapObject("room39", new Point(400, 500), 3));
        rooms.add(new IndoorMapObject("room40", new Point(400, 440), 3));
        rooms.add(new IndoorMapObject("room42", new Point(250, 440), 3));
        rooms.add(new IndoorMapObject("service3_1", new Point(340, 500), 3));
        rooms.add(new IndoorMapObject("service3_2", new Point(340, 440), 3));

        rooms.add(new IndoorMapObject("room401", new Point(50, 502), 4));
        rooms.add(new IndoorMapObject("stairs4_1", new Point(50, 502), 4));
        rooms.add(new IndoorMapObject("room412", new Point(210, 502), 4));
        rooms.add(new IndoorMapObject("room411", new Point(275, 502), 4));
        rooms.add(new IndoorMapObject("room410", new Point(335, 502), 4));
        rooms.add(new IndoorMapObject("room409", new Point(395, 502), 4));
        rooms.add(new IndoorMapObject("room408", new Point(450, 502), 4));
        rooms.add(new IndoorMapObject("room407", new Point(600, 502), 4));
        rooms.add(new IndoorMapObject("stairs4_2", new Point(600, 502), 4));
        rooms.add(new IndoorMapObject("room402", new Point(210, 460), 4));
        rooms.add(new IndoorMapObject("room403", new Point(275, 460), 4));
        rooms.add(new IndoorMapObject("room404", new Point(335, 460), 4));
        rooms.add(new IndoorMapObject("room405", new Point(395, 460), 4));
        rooms.add(new IndoorMapObject("room406", new Point(450, 460), 4));

        rooms.add(new IndoorMapObject("room501", new Point(50, 502), 5));
        rooms.add(new IndoorMapObject("stairs5_1", new Point(50, 502), 5));
        rooms.add(new IndoorMapObject("room512", new Point(210, 502), 5));
        rooms.add(new IndoorMapObject("room511", new Point(275, 502), 5));
        rooms.add(new IndoorMapObject("room510", new Point(335, 502), 5));
        rooms.add(new IndoorMapObject("room509", new Point(395, 502), 5));
        rooms.add(new IndoorMapObject("room508", new Point(450, 502), 5));
        rooms.add(new IndoorMapObject("room507", new Point(600, 502), 5));
        rooms.add(new IndoorMapObject("stairs5_2", new Point(600, 502), 5));
        rooms.add(new IndoorMapObject("room502", new Point(210, 460), 5));
        rooms.add(new IndoorMapObject("room503", new Point(275, 460), 5));
        rooms.add(new IndoorMapObject("room504", new Point(335, 460), 5));
        rooms.add(new IndoorMapObject("room505", new Point(395, 460), 5));
        rooms.add(new IndoorMapObject("room506", new Point(450, 460), 5));

        rooms.add(new IndoorMapObject("room601", new Point(50, 502), 6));
        rooms.add(new IndoorMapObject("stairs6_1", new Point(50, 502), 6));
        rooms.add(new IndoorMapObject("room612", new Point(210, 502), 6));
        rooms.add(new IndoorMapObject("room611", new Point(275, 502), 6));
        rooms.add(new IndoorMapObject("room610", new Point(335, 502), 6));
        rooms.add(new IndoorMapObject("room609", new Point(395, 502), 6));
        rooms.add(new IndoorMapObject("room608", new Point(450, 502), 6));
        rooms.add(new IndoorMapObject("room607", new Point(600, 502), 6));
        rooms.add(new IndoorMapObject("stairs6_2", new Point(600, 502), 6));
        rooms.add(new IndoorMapObject("room602", new Point(210, 460), 6));
        rooms.add(new IndoorMapObject("room603", new Point(275, 460), 6));
        rooms.add(new IndoorMapObject("room604", new Point(335, 460), 6));
        rooms.add(new IndoorMapObject("room605", new Point(395, 460), 6));
        rooms.add(new IndoorMapObject("room606", new Point(450, 460), 6));

        rooms.add(new IndoorMapObject("room701", new Point(50, 502), 7));
        rooms.add(new IndoorMapObject("stairs7_1", new Point(50, 502), 7));
        rooms.add(new IndoorMapObject("room712", new Point(210, 502), 7));
        rooms.add(new IndoorMapObject("room711", new Point(275, 502), 7));
        rooms.add(new IndoorMapObject("room710", new Point(335, 502), 7));
        rooms.add(new IndoorMapObject("room709", new Point(395, 502), 7));
        rooms.add(new IndoorMapObject("room708", new Point(450, 502), 7));
        rooms.add(new IndoorMapObject("room707", new Point(600, 502), 7));
        rooms.add(new IndoorMapObject("stairs7_2", new Point(600, 502), 7));
        rooms.add(new IndoorMapObject("room702", new Point(210, 460), 7));
        rooms.add(new IndoorMapObject("room703", new Point(275, 460), 7));
        rooms.add(new IndoorMapObject("room704", new Point(335, 460), 7));
        rooms.add(new IndoorMapObject("room705", new Point(395, 460), 7));
        rooms.add(new IndoorMapObject("room706", new Point(450, 460), 7));

        addConnection("hall", "stairs_hall");
        addConnection("stairs_hall", "room7");
        addConnection("stairs_hall", "room8");
        addConnection("stairs_hall", "room01");
        addConnection("room7", "room6");
        addConnection("room5", "room6");
        addConnection("room6", "room4");
        addConnection("room3", "room4");
        addConnection("room3", "room2");
        addConnection("room1", "room2");
        addConnection("room1", "service1");
        addConnection("room201", "service1");
        addConnection("room201", "stairs1_3");
        addConnection("room230", "service1");
        addConnection("room202", "service1");
        addConnection("room202", "room203");
        addConnection("room202", "room231");
        addConnection("room204", "room203");
        addConnection("room232", "room203");
        addConnection("room204", "room205");
        addConnection("room235", "room205");
        addConnection("service2", "room205");
        addConnection("service2", "room14");
        addConnection("service2", "room207");
        addConnection("room232", "room231");
        addConnection("room232", "room233");
        addConnection("room234", "room233");
        addConnection("room234", "room235");
        addConnection("room235", "stairs1_4");
        addConnection("room230", "room229");
        addConnection("room228", "room229");
        addConnection("room228", "room227");
        addConnection("room226", "room227");
        addConnection("room226", "room225");
        addConnection("room224", "room225");
        addConnection("room224", "room223");
        addConnection("room222", "room223");
        addConnection("room222", "room221");
        addConnection("room220", "room221");
        addConnection("room220", "room219");
        addConnection("room220", "room239");
        addConnection("room238", "room239");
        addConnection("room238", "stairs1_5");
        addConnection("room237", "stairs1_5");
        addConnection("room237", "room236");
        addConnection("room237", "room236");
        addConnection("room219", "room218a");
        addConnection("room218", "room218a");
        addConnection("stairs1_5", "room218a");
        addConnection("room217", "room218");
        addConnection("room217", "room216");
        addConnection("room215", "room216");
        addConnection("room215", "room214");
        addConnection("room236", "room214");
        addConnection("room213", "room214");
        addConnection("room213", "room212");
        addConnection("room211", "room212");
        addConnection("room211", "room210");
        addConnection("room209", "room210");
        addConnection("room209", "room208");
        addConnection("room207", "room208");
        addConnection("room14", "room13");
        addConnection("room12", "room13");
        addConnection("room12", "room11");
        addConnection("room9", "room11");
        addConnection("room9", "room10");
        addConnection("room9", "room8");

        addConnection("stairs2_1", "room25");
        addConnection("stairs2_1", "room22");
        addConnection("stairs2_1", "room30");
        addConnection("room29", "room30");
        addConnection("room29", "room31");
        addConnection("room32", "room31");
        addConnection("room32", "room33");
        addConnection("buffet", "room33");
        addConnection("buffet", "service2_1");
        addConnection("room307", "service2_1");
        addConnection("room306", "service2_1");
        addConnection("room306", "room305");
        addConnection("room304", "room305");
        addConnection("room304", "room303");
        addConnection("room302", "room303");
        addConnection("room302", "service2_2");
        addConnection("room15", "service2_2");
        addConnection("room301", "service2_2");
        addConnection("room301", "stairs2_2");
        addConnection("room312", "stairs2_2");
        addConnection("room312", "room302");
        addConnection("room312", "room311");
        addConnection("room303", "room311");
        addConnection("room310", "room311");
        addConnection("room310", "room304");
        addConnection("room310", "room309");
        addConnection("room305", "room309");
        addConnection("room308", "room309");
        addConnection("room308", "room306");
        addConnection("room308", "stairs2_3");
        addConnection("room15", "room16");
        addConnection("room17", "room16");
        addConnection("room17", "room18");
        addConnection("room19", "room18");
        addConnection("room19", "room20");
        addConnection("room21", "room20");
        addConnection("room21", "room22");
        addConnection("room23", "room24");
        addConnection("room24", "room25");
        addConnection("room26", "room25");
        addConnection("room26", "room27");
        addConnection("room28", "room27");

        addConnection("stairs3", "service3_1");
        addConnection("service3_2", "service3_1");
        addConnection("room43", "service3_1");
        addConnection("room39", "service3_1");
        addConnection("room40", "service3_2");
        addConnection("room42", "service3_2");


        addConnection("room401", "stairs4_1");
        addConnection("room401", "room412");
        addConnection("room411", "room412");
        addConnection("room402", "room412");
        addConnection("room411", "room403");
        addConnection("room411", "room410");
        addConnection("room404", "room410");
        addConnection("room409", "room410");
        addConnection("room409", "room405");
        addConnection("room409", "room408");
        addConnection("room406", "room408");
        addConnection("room407", "room408");
        addConnection("stairs4_2", "room408");
        addConnection("stairs4_2", "room407");
        addConnection("room406", "room405");
        addConnection("room404", "room405");
        addConnection("room404", "room403");
        addConnection("room402", "room403");


        addConnection("room501", "stairs4_1");
        addConnection("room501", "room512");
        addConnection("room511", "room512");
        addConnection("room502", "room512");
        addConnection("room511", "room503");
        addConnection("room511", "room510");
        addConnection("room504", "room510");
        addConnection("room509", "room510");
        addConnection("room509", "room505");
        addConnection("room509", "room508");
        addConnection("room506", "room508");
        addConnection("room507", "room508");
        addConnection("stairs5_2", "room508");
        addConnection("stairs5_2", "room507");
        addConnection("room506", "room505");
        addConnection("room504", "room505");
        addConnection("room504", "room503");
        addConnection("room502", "room503");


        addConnection("room601", "stairs6_1");
        addConnection("room601", "room612");
        addConnection("room611", "room612");
        addConnection("room602", "room612");
        addConnection("room611", "room603");
        addConnection("room611", "room610");
        addConnection("room604", "room610");
        addConnection("room609", "room610");
        addConnection("room609", "room605");
        addConnection("room609", "room608");
        addConnection("room606", "room608");
        addConnection("room607", "room608");
        addConnection("stairs6_2", "room608");
        addConnection("stairs6_2", "room607");
        addConnection("room606", "room605");
        addConnection("room604", "room605");
        addConnection("room604", "room603");
        addConnection("room602", "room603");


        addConnection("room701", "stairs7_1");
        addConnection("room701", "room712");
        addConnection("room711", "room712");
        addConnection("room702", "room712");
        addConnection("room711", "room703");
        addConnection("room711", "room710");
        addConnection("room704", "room710");
        addConnection("room709", "room710");
        addConnection("room709", "room705");
        addConnection("room709", "room708");
        addConnection("room706", "room708");
        addConnection("room707", "room708");
        addConnection("stairs7_2", "room708");
        addConnection("stairs7_2", "room707");
        addConnection("room706", "room705");
        addConnection("room704", "room705");
        addConnection("room704", "room703");
        addConnection("room702", "room703");

        addConnection("stairs_hall","stairs2_1");
        addConnection("stairs_hall","stairs3");
        addConnection("stairs3","stairs2_1");

        addConnection("stairs1_3","stairs2_2");
        addConnection("stairs1_4","stairs2_3");
        addConnection("stairs1_3","stairs4_1");
        addConnection("stairs1_4","stairs4_2");
        addConnection("stairs1_3","stairs5_1");
        addConnection("stairs1_4","stairs5_2");
        addConnection("stairs1_3","stairs6_1");
        addConnection("stairs1_4","stairs6_2");
        addConnection("stairs1_3","stairs7_1");
        addConnection("stairs1_4","stairs7_2");

        addConnection("stairs2_2","stairs4_1");
        addConnection("stairs2_3","stairs4_2");
        addConnection("stairs2_2","stairs5_1");
        addConnection("stairs2_3","stairs5_2");
        addConnection("stairs2_2","stairs6_1");
        addConnection("stairs2_3","stairs6_2");
        addConnection("stairs2_2","stairs7_1");
        addConnection("stairs2_3","stairs7_2");

        addConnection("stairs5_1","stairs4_1");
        addConnection("stairs5_2","stairs4_2");
        addConnection("stairs6_1","stairs4_1");
        addConnection("stairs6_2","stairs4_2");
        addConnection("stairs5_1","stairs6_1");
        addConnection("stairs5_2","stairs6_2");
        addConnection("stairs5_1","stairs7_1");
        addConnection("stairs5_2","stairs7_2");

        addConnection("stairs7_1","stairs6_1");
        addConnection("stairs7_2","stairs6_2");

    }
}
