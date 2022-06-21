package com.example.demo.Classes;

import java.util.ArrayList;

public class Unit{
    String ip;
    Integer id;
    String name;
    Boolean status;
    Switches switches;

    public Unit(String ip, Integer id){
        this.ip=ip;
        this.id=id;
        this.status=Boolean.TRUE;
        this.name="Computer";
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void changeName(String name) {
        this.name=name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Switches getSwitches(){return switches;}

    @Override
    public String toString() {
        return "Unit " +id+" ("+ ip+")";
    }

    public void setSwitches(Switches switches) {
        this.switches=switches;
    }
}
