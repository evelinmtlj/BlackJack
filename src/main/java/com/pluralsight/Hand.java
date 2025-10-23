package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards = new ArrayList<>();

    //constructor
    public Hand (){
        cards = new ArrayList<>();
    }

    //add card to hand
    public void deal(Card card) {
        cards.add(card);
    }
    //get the number of cards
    public int getSize(){
        return cards.size();
    }
    //calculate total blackjack value of the hand

    // calculate total
    public int getValue(){
        int totalValue = 0;
        int aceCount = 0;

        for(Card card: cards) {
            //flip to check value
            boolean wasFaceUp = card.isFaceUp();
            if (!wasFaceUp) card.flip(); //flip to read value

            int cardValue = card.getPointValue();
            totalValue += cardValue;

            if(card.getValue().equals("A")) {
                aceCount++; //count how many aces
            }
            if (!wasFaceUp) card.flip();
        } //handle the ace card
        while(totalValue >21 && aceCount > 0) {
            totalValue -= 10; //treat one ace as 1 instead of 11
            aceCount--;
        }
        return totalValue;
    }
    //show all cards in the hand
    public void showHand(){
        for (Card card: cards) {
            System.out.println(card);
        }
    }
    //check if the hand is a blackjack
    public boolean isBlackjack(){
        return getValue() == 21 && cards.size() == 2;
    }
    //check if the hand has over 21
    public boolean isBust(){
        return getValue() > 21;
    }

    @Override
    public String toString() {
        return cards.toString() + "(Value: " + getValue() + ")";
    }
}
