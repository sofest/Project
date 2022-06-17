package com.example.demo.Classes;

import java.util.ArrayList;

public class MainRouter {
    Integer id;
    Integer mask;
    String name;
    ArrayList<Routers> routers = new ArrayList<Routers>();

    public MainRouter(Integer id, Integer mask) {
        this.id = id;
        this.mask = mask;
        this.name = "Main Router";
    }
    public void setRouters(ArrayList<Routers> routers) {
        this.routers = routers;
    }
    public ArrayList<Routers> getRouters () {
        return routers;
    }

    public Integer getMask() {
        return mask;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
