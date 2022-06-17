package com.example.demo.Builder;

import com.example.demo.Classes.Unit;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

//public class UnitBuilder {
//    public ArrayList<Units> createListUnits(Integer numUnits, Integer ipRouter) {
//        ArrayList<Units> unitsList = new ArrayList<>();
//        for (int i = 1; i <= numUnits; i++) {
//            Units unit = new Units("196.168." + ipRouter + "." + (i + 1), i);
//            unitsList.add(unit);
//        }
//        return unitsList;
//    }
//}
public class UnitBuilder {
    int numUnits;
    public Unit createUnit(String networkIP, Integer i) {
        int index = networkIP.lastIndexOf(".");
        int k = Integer.valueOf(networkIP.substring(index+1, networkIP.length()));
        String partIP = networkIP.substring(0, index);
        Unit unit = new Unit(partIP + "." + (k + i), (k+i));
        return unit;
    }
//    public Integer getNumUnits(){
//        return numUnits;
//    }
}