package com.example.proggeo.android_app_map;

import android.graphics.*;
import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by Proggeo on 5/22/2016.
 */
public class NavigationController {

    ArrayList<IndoorMapObject> rooms;

    public NavigationController() {
        rooms = new ArrayList<IndoorMapObject>();
        setRooms();
    }

    public ArrayList<ArrayList<Point>> findRoute(String startName, String endName) {
        IndoorMapObject startRoom = null;
        IndoorMapObject endRoom = null;

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
                    if (minimumLength.get(j) >= 0 && (closest==-1 || minimumLength.get(j) < minimumLength.get(closest)))
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
        addConnection("stairs1_3", "room231");
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

    }
}
