package com.example.proggeo.android_app_map;


import android.graphics.Point;

import java.util.ArrayList;

/**
 * Created by Proggeo on 5/22/2016.
 */
public class IndoorMapObject {

    private String name;
    private ArrayList<IndoorMapObject> connections;
    private Point coor;
    private int floor;

    public IndoorMapObject(String name, Point coor, int floor) {
        this.name = name;
        this.coor = coor;
        this.floor = floor;
        this.connections = new ArrayList<IndoorMapObject>();
    }

    public ArrayList<IndoorMapObject> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getCoor() {
        return coor;
    }

    public void setCoor(Point coor) {
        this.coor = coor;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void addConnection(IndoorMapObject connection) {
        if (!connections.contains(connection)) {
            connections.add(connection);
            connection.addConnection(this);
        }
    }

    public ArrayList<Point> buildRoute(IndoorMapObject end) {
        ArrayList<Point> route = new ArrayList<Point>();

        return route;
    }

    public double findPath(IndoorMapObject destination, ArrayList<IndoorMapObject> path, double length) {
        if (this.connections.contains(destination)) {
            path.add(this);
            path.add(destination);
            return length + this.getDistance(destination);
        } else {
            double shortest = -1;
            ArrayList<IndoorMapObject> shortPath = null;
            for (int i = 0; i < connections.size(); i++) {
                if (!path.contains(connections.get(i))) {
                    path.add(this);
                    double result = connections.get(i).findPath(destination, path, length + this.getDistance(connections.get(i)));
                    if (result != -1) {
                        if (shortest == -1 || result < shortest) {
                            shortest = result;
                            shortPath = new ArrayList<IndoorMapObject>(path);
                            shortPath.add(connections.get(i));
                            for (int j = 0; j < path.size(); j++) {
                                System.out.println(path.get(j).getName());
                            }
                            System.out.println();
                        }
                    } else path.remove(this);
                }
            }
            if (shortPath != null) {
                path = shortPath;
                return shortest;
            }
        }
        return -1;
    }

    public double getDistance(IndoorMapObject neighbour) {
        if (!connections.contains(neighbour)) return -1.0;
        return Math.sqrt(Math.pow(this.coor.x - neighbour.coor.x, 2) + Math.pow(this.coor.y - neighbour.coor.y, 2))+Math.abs(this.floor-neighbour.floor)*100000;
    }


    public static void main(String[] args) {
        IndoorMapObject aud01 = new IndoorMapObject("01", new Point(0, 1), 1);
        IndoorMapObject aud02 = new IndoorMapObject("02", new Point(1, 1), 1);
        IndoorMapObject aud03 = new IndoorMapObject("03", new Point(1, 0), 1);
        IndoorMapObject aud04 = new IndoorMapObject("04", new Point(2, 0), 1);
        IndoorMapObject aud05 = new IndoorMapObject("05", new Point(2, 1), 1);
        IndoorMapObject aud06 = new IndoorMapObject("06", new Point(2, 2), 1);

        aud01.addConnection(aud02);
        aud02.addConnection(aud03);
        aud03.addConnection(aud04);
        aud04.addConnection(aud05);
        aud05.addConnection(aud06);
        aud02.addConnection(aud06);

        ArrayList<IndoorMapObject> route = new ArrayList<IndoorMapObject>();
        System.out.println(aud01.findPath(aud06, route, 0));
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i).getName());
        }
    }

}
//
//class Point{
//    int x;
//    int y;
//
//    Point (int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}
