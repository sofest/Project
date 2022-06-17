package com.example.demo.Builder;

import com.example.demo.Classes.MainSwitch;
import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SwitchMainBuilder {
    UnitBuilder unitBuilder = new UnitBuilder();
    SwitchBuilder switchBuilder = new SwitchBuilder();
    public MainSwitch createMainSwitch(Integer numUnits, Integer ipRouter){
        MainSwitch mainSwitch = new MainSwitch(ThreadLocalRandom.current().nextInt(1000,100000));
        if (numUnits <=29 ) {
                mainSwitch.setUnitList(unitBuilder.createListUnits(numUnits, ipRouter, 0));
            }
        else{
            int numSwitches = numUnits/29;
            for (int j=0; j<numSwitches; j++) {
                Switches newSwitch = switchBuilder.createSwitches();
                newSwitch.setUnitsList(unitBuilder.createListUnits(29, ipRouter, j));
                mainSwitch.addSwitch(newSwitch);
            }
                mainSwitch.setUnitList(unitBuilder.createListUnits(numUnits-numSwitches*29,ipRouter, numSwitches));


        }
        return mainSwitch;
    }
}
