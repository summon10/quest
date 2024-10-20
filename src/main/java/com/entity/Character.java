package com.entity;

public class Character {
    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

   private static Integer hp;

    public  String getName() {
        return name;
    }

    public  void setName(String name) {
        Character.name = name;
    }

    private static String name;

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    private static Integer armor;
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
