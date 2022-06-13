package prg.game;

public class Card {
	private String suit;
	private String name;
	private int value;

	Card(String suit, String name, int value) {
		this.suit = suit;
		this.name = name;
		this.value = value;
	}

	@Override
	public String toString() {
		if(name == "jack" || name == "queen" || name == "king" || name == "ace") {
			return name + " of "+ suit;
		}
		return value + " of " + suit;
	}

	public boolean isHigherOrEqual(Card c) {
		if (c.value <= value) {
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
