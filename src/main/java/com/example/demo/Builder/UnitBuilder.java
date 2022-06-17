package com.example.demo.Builder;

import com.example.demo.Classes.Unit;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UnitBuilder {
    public ArrayList<Unit> createListUnits(Integer numUnits, Integer ipRouter, Integer num) {
        ArrayList<Unit> unitsList = new ArrayList<>();
        for (int i = 1; i <= numUnits; i++) {
            Unit unit = new Unit("196.168." + ipRouter + "." + (num*29+ i + 1), i);
            unitsList.add(unit);
        }
        return unitsList;
    }
}
//public class UnitBuilder {
    //    int numUnits;
//    public Unit createUnit(String networkIP, Integer i) {
//        int index = networkIP.lastIndexOf(".");
//        int k = Integer.valueOf(networkIP.substring(index+1, networkIP.length()));
//        String partIP = networkIP.substring(0, index);
//        Unit unit = new Unit(partIP + "." + (k + i), (k+i));
//        return unit;
//    }
////    public Integer getNumUnits(){
////        return numUnits;
////    }
//}
//    public ArrayList<Unit> createListUnits(Integer numUnits, String networkIP) {
//        ArrayList<Unit> unitsList = new ArrayList<>();
////        numUnits = ThreadLocalRandom.current().nextInt(2, maxNumUnits - 1); //тут будет использоваться номер маски
//        for (int i = 1; i <= numUnits; i++) {
//            Unit unit = new Unit(networkIP.substring(0, 8) + networkIP.substring(8,networkIP.lastIndexOf("."))+"."+(i+1), i);
//            unitsList.add(unit);
//        }
//        return unitsList;
//    }
//}
//    ArrayList<Unit> unitsList = new ArrayList<>();
////        numUnits = ThreadLocalRandom.current().nextInt(2, maxNumUnits - 1); //тут будет использоваться номер маски
//        for (int i = 1; i <= numUnits; i++) {
//                Unit unit = new Unit(networkIP.substring(0, 8) + networkIP.substring(8,networkIP.lastIndexOf("."))+"."+(i+1), i);
//                unitsList.add(unit);
//                }
//                return unitsList;