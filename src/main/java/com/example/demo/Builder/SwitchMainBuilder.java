package com.example.demo.Builder;

import com.example.demo.Classes.Network;
import com.example.demo.Classes.Switches;

import java.util.concurrent.ThreadLocalRandom;

public class SwitchMainBuilder {
    UnitBuilder unitBuilder = new UnitBuilder();
    SwitchBuilder switchBuilder = new SwitchBuilder();
    public Switches createMainSwitch(Integer numUnits, Integer ipRouter, Network network){
        Switches mainSwitch = new Switches(ThreadLocalRandom.current().nextInt(1000,100000), network,null);
        if (numUnits <=29 ) {
                mainSwitch.setUnitsList(unitBuilder.createListUnits(numUnits, ipRouter, 0,mainSwitch));
            }
        else{
            int numSwitches = numUnits/29;
            for (int j=0; j<numSwitches; j++) {
                Switches newSwitch = switchBuilder.createSwitches(network,mainSwitch);
                newSwitch.setUnitsList(unitBuilder.createListUnits(29, ipRouter, j,newSwitch));
                mainSwitch.addSwitch(newSwitch);
            }
                mainSwitch.setUnitsList(unitBuilder.createListUnits(numUnits-numSwitches*29,ipRouter, numSwitches, mainSwitch));


        }
        return mainSwitch;
    }
}
