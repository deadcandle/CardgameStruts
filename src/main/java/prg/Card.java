package prg;

public class Card {

    private String suit;
    private String name;
    private int value;

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return name + " " + suit;
    }

    public boolean isHigherorEqual(Card C) {
        if (value >= C.value || value == C.value) {
            return true;
        }
        return false;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }
}



