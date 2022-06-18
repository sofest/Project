package com.example.demo.Builder;

import com.example.demo.Classes.Network;
import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class SwitchBuilder {

public Switches createSwitches(Network network, Switches mainSwitch){
   Switches switches = new Switches(ThreadLocalRandom.current().nextInt(1000,100000), network, mainSwitch);
    return switches;
}
}
