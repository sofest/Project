package com.example.demo.Builder;

import com.example.demo.Classes.Network;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class NetworkBuilder {
    ArrayList<Network> networkList = new ArrayList<>();
    SwitchMainBuilder switchMainBuilder = new SwitchMainBuilder();
    public ArrayList<Network> createNetworkList(Integer ipRouter, Integer numMask){
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
            Network network = new Network("196.168."+ ipRouter+"."+ k, i);
            network.setMainSwitch(switchMainBuilder.createMainSwitch(getNumUnits(numMask),network.getIp()));
//            network.setUnitsList(unitBuilder.createListUnits(getMaxNumUnits(numMask), ipRouter,k));
            networkList.add(network);
            k+=256/i;
        }
        return networkList;
    }
    public Integer getNumUnits(Integer numMask){
        int maxNumUnits = (int) Math.pow(2, 32-numMask);
        int numUnits = ThreadLocalRandom.current().nextInt(1,maxNumUnits);
        return maxNumUnits;
    }
//    public Integer getNumSwitches(Integer numUnits){
//        Integer numSwitches = numUnits/29+1;
//        return numSwitches;
//    }
    public ArrayList<String> getNetworksIP(){
        ArrayList<String> networkIP = new ArrayList<>();
        for(int j=0;j<networkList.size();j++){
           networkIP.add(networkList.get(j).getIp());
        }
        return networkIP;
    }
}
