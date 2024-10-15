package com.entity;

public class Character {
    Integer hp;
   public static String name;
    Integer armor;
    private static volatile Character instance;

    private Character(Integer hp, Integer armor) {
        this.hp = hp;
        this.armor = armor;
    }

    public static Character getInstance() {
        if (instance == null) {
            synchronized (Character.class) {
                if (instance == null) {
                    instance = new Character(100,100);
                }
            }
        }
        return instance;
    }
}
