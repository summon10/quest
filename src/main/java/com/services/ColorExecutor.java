package com.services;

import com.entity.Quest;

public class ColorExecutor {

    public static String ColorGetter(Integer num)
    {
        String question = Quest.questions.get(num);
        if (question.contains("green")) return "green";
        if (question.contains("yellow")) return "yellow";
        if (question.contains("red")) return "red";
        else return "not found";
    }
}
