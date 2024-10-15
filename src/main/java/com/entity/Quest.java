package com.entity;

import java.util.ArrayList;

public class Quest {
    // Monster monster = new Monster(10, 50);
    private Quest() {
    }

    String description = "Shooter after Duke Nukem";
    private static volatile Quest instance;
    static ArrayList<String> questions = new ArrayList<>();

    private static void questionsInit() {

        try {
            questions.add("You met " + Monster.class.getField("level") + "level. What will you do?");
            questions.add("You picked up a first aid kit, your hp is full now");
            questions.add("You picked up a armor, your armor is full now");
            questions.add("You found door" + Card.cards.entrySet().iterator().next() + ". What will you do?");

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


    }

    public static Quest getInstance() {
        if (instance == null) {
            synchronized (Quest.class) {
                if (instance == null) {
                    instance = new Quest();
                }
            }
        }
        return instance;
    }


}

