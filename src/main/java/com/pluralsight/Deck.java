package com.pluralsight;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    //constructor
    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts","Spades","Diamonds","Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};


    //create all 52 cards and add to deck
    for (String suit: suits) {
        for (String value : values) {
            cards.add(new Card(suit, value));
        }
    }  }
    //shuffle the deck
        public void shuffle(){
            Collections.shuffle(cards);
        }


        public Card deal(){
            if (!cards.isEmpty()) {
                return cards.removeFirst(); //remove
            } else {
                System.out.println("No more cards");
                return null;
            }
        }
     //get the number of cards remaining
    public int getSize(){
        return cards.size();
    }


}
