package com.example.demo.Builder;

import com.example.demo.Classes.Network;
import com.example.demo.Classes.Routers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NetworkBuilder {
    SwitchMainBuilder switchMainBuilder = new SwitchMainBuilder();
    UnitBuilder unitBuilder = new UnitBuilder();

    public ArrayList<Network> createNetworkList(Integer ipRouter, Integer numMask, Routers router){
        ArrayList<Network> networkList = new ArrayList<>();
        int i;
        switch(numMask){
            case(24): i=1; break;
            case(25): i=2; break;
            case(26): i=4; break;
            case(27): i=8; break;
            case(28): i=16; break;
            case(29): i=32; break;
            default:
                throw new IllegalStateException("Unexpected value: " + numMask);
        }
        int k=0;
        for (int j=0; j<i; j++){
            int numUnits = getNumUnits(numMask);
            Network network = new Network("196.168."+ ipRouter+"."+ k, router);
            network.setUnitsList(unitBuilder.createListUnits(numUnits,ipRouter,k));
            network.setMainSwitch(switchMainBuilder.createMainSwitch(network.getUnitsList().size(),network));
            networkList.add(network);
            k+=256/i;
        }
        return networkList;
    }
    public Integer getNumUnits(Integer numMask){
        int maxNumUnits = (int) Math.pow(2, 32-numMask);
        int numUnits = ThreadLocalRandom.current().nextInt(1,maxNumUnits);
        return numUnits;
    }
}
