package com.example.demo.Classes;

import java.util.ArrayList;

public class MainRouter {
    Integer id;
    ArrayList<String> ip=new ArrayList<>();
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

    public void setIp(String ips) {
        ip.add(ips);
    }

    public ArrayList<String> getIp() {
        return ip;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Main Router " +id+" ("+ ip+")";
    }
}
