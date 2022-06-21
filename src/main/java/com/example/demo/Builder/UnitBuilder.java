package com.example.demo.Builder;

import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;


import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class UnitBuilder {
    public ArrayList<Unit> createListUnits(Integer numUnits, Integer ipRouter, Integer k) {
        ArrayList<Unit> unitsList = new ArrayList<>();

        for (int i = 1; i <= numUnits; i++) {
            Unit unit = new Unit("196.168." + ipRouter + "." + (k+i+1), ThreadLocalRandom.current().nextInt(1000,100000));
            unitsList.add(unit);

        }
        setPrinters(unitsList);
        return unitsList;
    }

    public void setPrinters(ArrayList<Unit>unitsList){
        int numPrinters = ThreadLocalRandom.current().nextInt(0,3);
        for(int i=0;i<numPrinters;i++){
            int indexPrinter = ThreadLocalRandom.current().nextInt(0,unitsList.size());
            unitsList.get(indexPrinter).changeName("Printer");
        }
    }
}
