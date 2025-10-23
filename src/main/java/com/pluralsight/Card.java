package com.pluralsight;

public class Card {

    private String suit;
    private String value;
    private boolean isFaceUp;

//getters
    public String getSuit() {
        if(isFaceUp) {
            return suit;
        } else {
            return "#";
        }

    }

    public String getValue() {
        if(isFaceUp){
            return value;
        } else {
            return "#";
        }

    }

    public int getPointValue(){
        if (isFaceUp) {
            switch (value) {
                case "A":
                    return 11;
                case "K":
                case "Q":
                case "J":
                    return 10;
                default:

                    try {
                        return Integer.parseInt(value);
                    } catch (NumberFormatException e) {
                        return 0;
                            }
            }
        } else {
            return 0;
        }
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip(){
        isFaceUp = !isFaceUp;
    }

    //constructor
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
        this.isFaceUp = false; //face down
    }


}
