package com.example.demo.Builder;

import com.example.demo.Classes.MainSwitch;
import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;

import java.util.ArrayList;

public class SwitchMainBuilder {
    UnitBuilder unitBuilder = new UnitBuilder();
    SwitchBuilder switchBuilder = new SwitchBuilder();
    public MainSwitch createMainSwitch(Integer numUnits, String networkIP){
        MainSwitch mainSwitch = new MainSwitch(1);
        if (numUnits <=29 ) {
            for (int i = 0; i < numUnits; i++) {
                mainSwitch.addUnit(unitBuilder.createUnit(networkIP, i));
            }
        }
        else{
            int numSwitches = numUnits/29;
            for (int j=0; j<numSwitches; j++) {
                Switches newSwitch = switchBuilder.createSwitches(j+2);
                for(int k=0;k<29;k++) {
                    newSwitch.addUnit(unitBuilder.createUnit(networkIP,k));
                }
                mainSwitch.addSwitch(newSwitch);
            }
            for(int k=0;k<(numUnits-numSwitches*29);k++) {
                mainSwitch.addUnit(unitBuilder.createUnit(networkIP,k));
            }

        }
        return mainSwitch;
    }
}
