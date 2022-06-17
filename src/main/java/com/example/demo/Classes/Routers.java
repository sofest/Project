package com.example.demo.Classes;

import java.util.ArrayList;

public class Routers {
    String ip;
    Integer id;
    Integer mask;
    String name;
    ArrayList<Network> networkList = new ArrayList<Network>();
    ArrayList<String> networkIP = new ArrayList<>();

    public Routers(String ip, Integer id, Integer mask) {
        this.ip=ip;
        this.id = id;
        this.mask = mask;
        this.name = "Router";
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

    public String getIp() {
        return ip;
    }

        public void setNetworkList (ArrayList < Network > networkList) {
            this.networkList = networkList;
        }
        public ArrayList<Network> getNetworkList () {
            return networkList;
        }

    public void setNetworkRouterIP(ArrayList <String> networkIP) {
        ArrayList<String> networkRoputerIP = new ArrayList<>();
        int k=1;
        for(int j=0;j<networkList.size();j++){
            int index = networkList.get(j).getIp().lastIndexOf(".");
            String newIP = networkList.get(j).getIp().substring(0,index);
            newIP=newIP+"."+k;
            networkRoputerIP.add(newIP);
            k=256/networkList.size()+1;
        }
        this.networkIP = networkRoputerIP;
    }
    public ArrayList<String> getNetworkRouterIP () {
        return networkIP;
    }

}

