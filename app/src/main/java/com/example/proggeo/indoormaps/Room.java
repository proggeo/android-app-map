package com.example.proggeo.indoormaps;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Proggeo on 3/22/2016.
 */
public class Room {
    private ArrayList<Room> connections;
    private int id;
    private String name;
    private LatLng coordinates;
    private int floor;

    Room(double lat, double lng, int id, int floor, String name) {
        coordinates = new LatLng(lat, lng);
        this.id = id;
        this.name = name;
        connections = new ArrayList<Room>();
        this.floor = floor;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Room> getConnections() {
        return connections;
    }

    public void addConnection(Room neighbour) {
        if (!connections.contains(neighbour)) {
            connections.add(neighbour);
            neighbour.addConnection(this);
        }
    }

    public boolean isConnected(Room neighbour) {
        return connections.contains(neighbour);
    }

    public double route(Room destination, ArrayList<Room> path, double length) {
        if (this.isConnected(destination)) {
            path.add(this);
            path.add(destination);

            return length + this.getDistance(destination);
        } else {
            double shortest = -1;
            ArrayList<Room> shortPath = null;
            for (int i = 0; i < connections.size(); i++) {
                if (!path.contains(connections.get(i))) {
                    path.add(this);
                    double result = connections.get(i).route(destination, path, length + this.getDistance(connections.get(i)));
                    if (result != -1) {
                        if (shortest == -1 || result < shortest) {
                            shortest = result;
                            shortPath = new ArrayList<Room>(path);
                            shortPath.add(connections.get(i));
                            for (int j = 0; j < path.size(); j++) {
                                System.out.print(path.get(j).getName());
                            }
                            System.out.println();
                        }
                    }
                    else path.remove(this);
                }
            }
            if (shortPath != null) {
                path = shortPath;
                return shortest;
            }
        }
        return -1;
    }

    public void print() {
        System.out.println("-------------------------");
        System.out.println("Room " + name + "(" + id + ")");
        if (connections.size() > 0) {
            System.out.println("Neighbours:");
            for (int i = 0; i < connections.size(); i++) {
                System.out.println(connections.get(i).getName());
            }
        }
        System.out.println("-------------------------");
    }

    public double getDistance(Room neighbour) {
        if (!connections.contains(neighbour)) return -1.0;
        return Math.sqrt(Math.pow(this.coordinates.latitude - neighbour.coordinates.latitude, 2) + Math.pow(this.coordinates.longitude - neighbour.coordinates.longitude, 2));
    }

    public static void main(String[] args) {
        Room aud01 = new Room(0.0, 1.0, 123, 1, "01");
        Room aud02 = new Room(1.0, 1.0, 124, 1, "02");
        Room aud03 = new Room(1.0, 0.0, 125, 1, "03");
        Room aud04 = new Room(2.0, 0.0, 126, 1, "04");
        Room aud05 = new Room(2.0, 1.0, 126, 1, "05");
        Room aud06 = new Room(2.0, 2.0, 126, 1, "06");
        aud01.addConnection(aud02);
        aud02.addConnection(aud03);
        aud03.addConnection(aud04);
        aud04.addConnection(aud05);
        aud05.addConnection(aud06);
        aud02.addConnection(aud06);

        ArrayList<Room> route = new ArrayList<Room>();
        System.out.println(aud01.route(aud06, route, 0));
        for (int i = 0; i < route.size(); i++) {
            System.out.println(route.get(i).getName());
        }
    }
}
