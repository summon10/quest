package com.services;

import com.entity.Gun;
import com.entity.Monster;
import com.utils.getRandomNumberFromInterval;

public class Fight {
    public static Integer fightExecutor (Integer gun, Integer characterHP)
    {
        if (gun==5) return characterHP;

        Monster monst = new Monster(getRandomNumberFromInterval.GetRandomNumber(140), getRandomNumberFromInterval.GetRandomNumber(90));
        System.out.println("Gun danage from fight: " + Gun.guns.get(gun).getDamage());
        System.out.println("Monster damage: " + monst.damage);
        System.out.println("CharacterHP : " + characterHP);
        System.out.println("Monster level: " + monst.level);


       while (monst.level >= 0 && characterHP > 0) {
            characterHP = characterHP - monst.damage;
            monst.level =  - Gun.guns.get(gun).getDamage();
            System.out.println("CharacterHP in fight: " +characterHP);
            System.out.println("monstrHP in fight: " + monst.level);

        }
        System.out.println("CharacterHP after fight: " +characterHP);
        System.out.println("monstrHP after fight: " + monst.level);
        if (characterHP <= 0) return -1;
            else return characterHP;


    }
}
