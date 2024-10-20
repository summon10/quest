package com.entity;

import java.util.ArrayList;
import java.util.List;

public class Card {
    String color;
    boolean availability;
    public Card(String color, boolean availability) {
        this.color = color;
        this.availability = availability;
    }
    static List<Card> cards = new ArrayList<>();
    public static void cardsInit()
    {
        cards.add(new Card("green",false));
        cards.add(new Card("yellow",false));
        cards.add(new Card("red",false));

    }





}
