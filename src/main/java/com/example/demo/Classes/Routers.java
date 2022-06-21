package com.example.demo.Classes;

import java.util.ArrayList;

public class Routers {
    ArrayList<String> ip = new ArrayList<>();
    Integer id;
    Integer mask;
    String name;
    MainRouter mainRouter;
    ArrayList<Network> networkList = new ArrayList<Network>();
//    ArrayList<String> networkIP = new ArrayList<>();

    public Routers(Integer id, Integer mask) {
        this.id = id;
        this.mask = mask;
        this.name = "Router";
    }

    public void setIp(String ips) {
        ip.add(ips);
        }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMask() {
        return mask;
    }

    public ArrayList<String> getIp() {
        return ip;
    }

        public void setNetworkList (ArrayList < Network > networkList) {
            this.networkList = networkList;
        }
        public ArrayList<Network> getNetworkList () {
            return networkList;
        }
    @Override
    public String toString() {
        return "Router " + id;
    }

    public MainRouter getMainRouter() {
        return mainRouter;
    }

    public void setMainRouter(MainRouter mainRouter) {
        this.mainRouter = mainRouter;
    }
}

