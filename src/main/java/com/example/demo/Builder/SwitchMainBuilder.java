package com.example.demo.Builder;

import com.example.demo.Classes.Network;
import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SwitchMainBuilder {
    SwitchBuilder switchBuilder = new SwitchBuilder();
    public Switches createMainSwitch(Integer numUnits,Network network){
        Switches mainSwitch = new Switches(ThreadLocalRandom.current().nextInt(1000,100000), network,null);
        if (numUnits <=29) {
            mainSwitch.setUnitsList(network.getUnitsList(),mainSwitch);
        }
        else{
            int numSwitches = numUnits/29;
            for (int j=0; j<numSwitches; j++) {
                Switches newSwitch = switchBuilder.createSwitches(network,mainSwitch);
                ArrayList<Unit> thisUnitsList =new ArrayList<>();
                for(int i=0; i<29;i++) {
                    thisUnitsList.add(network.getUnitsList().get(j*29+i));
                }
                newSwitch.setUnitsList(thisUnitsList,newSwitch);
                mainSwitch.addSwitch(newSwitch);

            }
            ArrayList<Unit> thisUnitsListMain =new ArrayList<>();
            for(int i=numSwitches*29;i<network.getUnitsList().size();i++){
                thisUnitsListMain.add(network.getUnitsList().get(i));
            }
            mainSwitch.setUnitsList(thisUnitsListMain,mainSwitch);


        }
        return mainSwitch;
    }
}
