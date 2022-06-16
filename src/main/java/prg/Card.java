package prg;

public class Card {
    private String suit;
    private String name;
    private int value;

    // Test commit

    public Card(String suit, String name, int value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isHigherOrEqual(Card c) {
        if (value >= c.value) {
            return true;
        }
        return false;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }
}