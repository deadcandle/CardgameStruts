package prg.game;

import prg.game.Card;

import java.util.*;



public class Deck {
	private ArrayList<Card> cards = new ArrayList<>();

	public Deck() {
		
		for (int i = 0; i < 4; i++) {
			String suit = null;
			switch(i) {
			case 0 -> {
	            suit = "hearts";
	        }
			case 1 -> {
	            suit = "clubs";
	        }
			case 2 -> {
	            suit = "spades";
	        }
			case 3 -> {
				suit = "diamonds";
				}
			}
			for (int j = 2; j <= 10; j++) {
				 Card c = new Card(suit, suit, j);
				cards.add(c);
			}
			Card jack = new Card(suit, "jack", 11);
			Card queen = new Card(suit, "queen", 12);
			Card king = new Card(suit, "king", 13);
			Card ace = new Card(suit, "ace", 11);

			cards.add(jack);
			cards.add(queen);
			cards.add(king);
			cards.add(ace);

		}
		Collections.shuffle(cards);
	}

	public Card getNextCard() {
		int next;
		next = 0;
		Card nextCard = cards.remove(next);
		return nextCard;
	}

	public ArrayList<Card> getCards() {	
		return cards;
	}

}