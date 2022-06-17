package com.example.demo.Builder;

import com.example.demo.Classes.MainRouter;
import com.example.demo.Classes.Routers;

import java.util.ArrayList;

public class RouterMainBuilder {
    RouterBuilder routerBuilder = new RouterBuilder();

public MainRouter createMainRouter(Integer numRouters,String[] arrayMasks){
    MainRouter mainRouter = new MainRouter(numRouters, Integer.valueOf(arrayMasks[numRouters-1]));
   ArrayList<Routers> listRouters = routerBuilder.createListRouters(numRouters, arrayMasks);
       mainRouter.setRouters(listRouters);
    if (numRouters.equals(1)){
        mainRouter.setName("Main Network");
    }
    return mainRouter;
}
}
