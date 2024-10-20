package com.utils;

import java.util.Random;

public class getRandomNumberFromInterval {

    public static Integer GetRandomNumber(Integer end)
    {
        Integer number;
        Random random = new Random();
        number = random.nextInt(end);
        return number;
    }
}
