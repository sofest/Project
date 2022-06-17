package com.example.demo.Builder;

import com.example.demo.Classes.Unit;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UnitBuilder {
    public ArrayList<Unit> createListUnits(Integer numUnits, Integer ipRouter, Integer num) {
        ArrayList<Unit> unitsList = new ArrayList<>();
        for (int i = 1; i <= numUnits; i++) {
            Unit unit = new Unit("196.168." + ipRouter + "." + (num*29+ i + 1), ThreadLocalRandom.current().nextInt(1000,100000));
            unitsList.add(unit);
        }
        return unitsList;
    }
}
