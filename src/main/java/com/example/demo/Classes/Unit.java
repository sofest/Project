package com.example.demo.Classes;

import java.util.ArrayList;

public class Unit{
    String ip;
    Integer id;
    String name;
    Switches switches;

    public Unit(String ip, Integer id, Switches switches){
        this.ip=ip;
        this.id=id;
        this.switches=switches;
        this.name="Unit";
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }
    public Switches getSwitches(){return switches;}

    @Override
    public String toString() {
        return "Unit " + id;
    }
}
