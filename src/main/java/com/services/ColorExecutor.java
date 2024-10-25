package com.services;

import com.entity.Quest;

import java.io.IOException;

public class ColorExecutor {

    public static String ColorGetter(Integer num) throws IOException {
        String question = Quest.getInstance().questions.get(num);
        if (question.contains("green")) return "green";
        if (question.contains("yellow")) return "yellow";
        if (question.contains("red")) return "red";
        else return "not found";
    }
}
