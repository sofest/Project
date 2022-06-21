package com.example.demo.Builder;

import com.example.demo.Classes.MainRouter;
import com.example.demo.Classes.Routers;

import java.util.ArrayList;

public class RouterMainBuilder {
    RouterBuilder routerBuilder = new RouterBuilder();

public MainRouter createMainRouter(Integer numRouters,String[] arrayMasks){
    MainRouter mainRouter;
    mainRouter = new MainRouter(numRouters, Integer.valueOf(arrayMasks[numRouters-1]));
   ArrayList<Routers> listRouters = routerBuilder.createListRouters(numRouters, arrayMasks, mainRouter);
       mainRouter.setRouters(listRouters);
       if(numRouters>2) {
           for (int i = 1; i < numRouters; i++) {
               mainRouter.setIp("10.0." + numRouters + "." + i);
           }
       }
    else {
        mainRouter.setName("Main Network");
        mainRouter.setIp("");
    }
    return mainRouter;
}
}
