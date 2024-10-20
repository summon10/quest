package com.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quest {

    private Quest() {
    }

    String description = "Shooter after Duke Nukem";
    private static volatile Quest instance;
    public static ArrayList<String> questions = new ArrayList<>();
    public static Map<Integer,String[]> answers;

    private static void questionsInit() {


            questions.add("You met a monster level. What will you do?");
            questions.add("You picked up a first aid kit, +10 HP");
            questions.add("You picked up a armor, your armor is full now");
            questions.add("You found green door.  What will you do?");
            questions.add("You found yellow door.  What will you do?");
            questions.add("You found red door.  What will you do?");
            questions.add("You picked up green card!");
            questions.add("You picked up yellow card!");
            questions.add("You picked up red card!");

    }

    private static void answersInit() {
        answers = new HashMap<>(questions.size());
        String[] answerForMonster = {"Finish him with pistol", "Finish him with Shotgun","Finish him with Ripper",
                "Finish him with RPG","Finish him with BFG", "Run away"};

        String[] answerJustNext = {"Great, Go Next Step"};

        String[] answerForDoor = {"Try To Open it with Card", "Run away"};

            answers.put(0, answerForMonster);
            answers.put(1, answerJustNext);
            answers.put(2, answerJustNext);
            answers.put(3, answerForDoor);
            answers.put(4, answerForDoor);
            answers.put(5, answerForDoor);
            answers.put(6, answerJustNext);
            answers.put(7, answerJustNext);
            answers.put(8, answerJustNext);

        }

    public static Quest getInstance() {
        if (instance == null) {
            synchronized (Quest.class) {
                if (instance == null) {
                    instance = new Quest();
                    questionsInit();
                    answersInit();
                }
            }
        }
        return instance;
    }


}

