package com.example.demo.Classes;

import java.util.ArrayList;

public class Unit{
    String ip;
    Integer id;
    String name;

    public Unit(String ip, Integer id){
        this.ip=ip;
        this.id=id;
        this.name="Router";
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
}
