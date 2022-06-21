package com.example.demo.Builder;

import com.example.demo.Classes.MainRouter;
import com.example.demo.Classes.Network;
import com.example.demo.Classes.Routers;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RouterBuilder {
    NetworkBuilder networkBuilder = new NetworkBuilder();
    ArrayList<Routers> routersList = new ArrayList<>();

public ArrayList<Routers> createListRouters(Integer numRouters, String[] arrayMasks, MainRouter mainRouter){
    if(numRouters==1){
        int numMask = Integer.valueOf(arrayMasks[numRouters - 1]);
        genRouter(numMask,numRouters, mainRouter);
    }
    else if(numRouters==2){
        for (int ipRouter=1; ipRouter<=numRouters; ipRouter++){
            int numMask = Integer.valueOf(arrayMasks[ipRouter - 1]);
            genRouter(numMask,ipRouter, mainRouter);
    }}
        else if(numRouters>2){
        for (int ipRouter=1; ipRouter<=numRouters-1; ipRouter++) {
            int numMask = Integer.valueOf(arrayMasks[ipRouter - 1]);
            genRouter(numMask,ipRouter, mainRouter);
        }
        }

    return routersList;
}
public Routers genRouter(Integer numMask, Integer ipRouter, MainRouter mainRouter){
    Routers router = new Routers( ThreadLocalRandom.current().nextInt(1000,100000), numMask);
    router.setNetworkList(networkBuilder.createNetworkList(ipRouter, numMask, router));
    for(int i=0; i<router.getNetworkList().size();i++)
    {
        Integer lastIndex = router.getNetworkList().get(i).getIp().lastIndexOf(".");
        Integer lastNumber = Integer.valueOf(router.getNetworkList().get(i).getIp().substring(lastIndex+1,router.getNetworkList().get(i).getIp().length()));
        String ip = router.getNetworkList().get(i).getIp().substring(0,lastIndex+1)+String.valueOf(lastNumber+1);
        router.setIp(ip);
        router.setMainRouter(mainRouter);
    }
    routersList.add(router);
    return router;
}
}
