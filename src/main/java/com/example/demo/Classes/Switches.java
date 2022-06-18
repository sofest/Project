package com.example.demo.Classes;

import java.util.ArrayList;

public class Switches {
    private String name;
    private Integer id;
    Switches mainSwitch;
    Network network;
    ArrayList<Unit> unitsList = new ArrayList<Unit>();
    ArrayList<Switches> switchesList = new ArrayList<>();

    public Switches(Integer id, Network network, Switches mainSwitch) {
        this.name = "Switch";
        this.id = id;
        this.network=network;
        this.mainSwitch=mainSwitch;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setUnitsList(ArrayList<Unit> unitsList) {
        this.unitsList=unitsList;
    }

    public Network getNetwork() {
        return network;
    }

    public Switches getMainSwitch() {
        return mainSwitch;
    }

    public ArrayList<Unit> getUnitsList(){return unitsList;}
    public void addSwitch(Switches switches){
        switchesList.add(switches);
    }
    public ArrayList<Switches> getSwitchesList(){
        return switchesList;
    }
    @Override
    public String toString() {
        return "Switch " + id;
    }}
