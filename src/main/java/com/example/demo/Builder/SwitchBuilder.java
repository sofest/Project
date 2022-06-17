package com.example.demo.Builder;

import com.example.demo.Classes.Switches;
import com.example.demo.Classes.Unit;

import java.util.ArrayList;

public class SwitchBuilder {
    UnitBuilder unitBuilder = new UnitBuilder();

public Switches createSwitches(Integer i){
   Switches switches = new Switches(i);
    return switches;
}
}
