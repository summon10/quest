package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Gun {
    public Integer getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    Integer damage;
    String name;
    public Gun(String name, Integer damage) {
        this.name = name;
        this.damage = damage;
    }

    public static List<Gun> guns = new ArrayList<>();


    public static void gunsInit()
    {
       guns.add(new Gun("Pistol", 10 ));
        guns.add(new Gun("Shotgun", 20 ));
        guns.add(new Gun("Ripper",30));
        guns.add(new Gun("RPG",40 ));
        guns.add(new Gun("BFG",50));


    }


}
