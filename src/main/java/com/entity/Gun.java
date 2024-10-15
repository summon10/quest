package com.entity;

import java.util.HashMap;

public class Gun {
    private static volatile Gun instance;
    public static HashMap<Integer,String> guns = new HashMap<>();
    private Gun()
    {

    }
    private static void gunsInit()
    {
       guns.put(10,"Pistol" );
       guns.put(20, "Shotgun" );
       guns.put(30, "Ripper");
       guns.put(40,"RPG");
       guns.put(50, "BFG");
    }
    public static Gun getInstance() {
        if (instance == null) {
            synchronized (Gun.class) {
                if (instance == null) {
                    instance = new Gun();
                    gunsInit();
                }
            }
        }
        return instance;
    }

}
