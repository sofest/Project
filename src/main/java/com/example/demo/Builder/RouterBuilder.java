package com.example.demo.Builder;

import com.example.demo.Classes.Network;
import com.example.demo.Classes.Routers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RouterBuilder {
    NetworkBuilder networkBuilder = new NetworkBuilder();
    ArrayList<Routers> routersList = new ArrayList<>();

public ArrayList<Routers> createListRouters(Integer numRouters, String[] arrayMasks){
    int finalNumRouters;
    if (numRouters.equals(1)){finalNumRouters=1;}
    else{finalNumRouters=numRouters-1;}
    for (int ipRouter=1; ipRouter<=finalNumRouters; ipRouter++){
        int numMask = Integer.valueOf(arrayMasks[ipRouter - 1]);
        Routers router = new Routers("10.0." +ipRouter + "."+ numRouters, ipRouter, numMask);
        router.setNetworkList(networkBuilder.createNetworkList(ipRouter, numMask));
        router.setNetworkRouterIP(networkBuilder.getNetworksIP());
        routersList.add(router);
    }
    return routersList;
}
}
