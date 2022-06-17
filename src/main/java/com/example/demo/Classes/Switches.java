package com.example.demo.Classes;

import java.util.ArrayList;

public class Switches {
    private String name;
    private Integer id;
    ArrayList<Unit> unitsList = new ArrayList<Unit>();

    public Switches(Integer id) {
        this.name = "Switch";
        this.id = id;
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

    public ArrayList<Unit> getUnitsList(){return unitsList;}
}
