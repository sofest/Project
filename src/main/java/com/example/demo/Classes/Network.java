package com.example.demo.Classes;

import java.util.ArrayList;

public class Network{
    String ip;
    String name;
    Routers router;
    Switches mainSwitch;
    ArrayList<Unit> unitsList = new ArrayList<>();

    public Network(String ip, Routers router) {
        this.ip=ip;
        this.router=router;
        this.name="Network";
    }
    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }


    public Routers getRouter() {
        return router;
    }

    public void setMainSwitch(Switches mainSwitch) {
        this.mainSwitch=mainSwitch;
    }
    public void setUnitsList(ArrayList<Unit> unitsList) {
        this.unitsList=unitsList;
    }
    public ArrayList<Unit> getUnitsList(){return unitsList;}

    public Switches getMainSwitch(){return mainSwitch;}
    @Override
    public String toString() {
        return "Network " + ip;
    }
}
