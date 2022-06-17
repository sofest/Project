package com.example.demo.Classes;

import java.util.ArrayList;

public class Network{
    String ip;
    Integer id;
    String name;
    MainSwitch mainSwitch;
    ArrayList<Unit> unitsList = new ArrayList<>();

    public Network(String ip, Integer id) {
        this.ip=ip;
        this.id=id;
        this.name="Network";
    }
    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setMainSwitch(MainSwitch mainSwitch) {
        this.mainSwitch=mainSwitch;
    }
    public void setUnitsList(ArrayList<Unit> unitsList) {
        this.unitsList=unitsList;
    }

    public MainSwitch getMainSwitch(){return mainSwitch;}
}
