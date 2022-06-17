package com.example.demo.Classes;

import java.util.ArrayList;

public class MainSwitch {
    private String name;
    private Integer id;
    ArrayList<Switches> switchesList = new ArrayList<>();
    ArrayList<Unit> unitsList = new ArrayList<Unit>();

    public MainSwitch(Integer id) {
        this.name = "Switch";
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void addSwitch(Switches switches){
        switchesList.add(switches);
    }
    public ArrayList<Switches> getSwitchesList(){
        return switchesList;
    }

    public void addUnit(Unit unit) {
        unitsList.add(unit);
    }

    public ArrayList<Unit> getUnitsList(){return unitsList;}
}
