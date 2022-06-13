package prg.inlever_opdracht;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class DeckTest {
	
	private Deck deck;
	
	@BeforeEach
	void setup() {
		deck = new Deck();
	}

	@Test
	void cardCount() {
		assertTrue(deck.getCards().size() == 52);
	}
	
	//test of de kaart uit het spel wordt gehaald 
	@Test
	void getNextCard() {
		int sizeBefore = deck.getCards().size();
		deck.getNextCard();
		int sizeAfter = deck.getCards().size();
		assertTrue(sizeBefore == sizeAfter + 1);
	}
	
	@Test
	void higherCard() {
		Card lowCard = new Card("Hearts", "2 of Hearts", 2);
		Card highCard = new Card("Hearts", "King of Hearts", 13);
		assertTrue(highCard.isHigherOrEqual(lowCard));
	}
	
	@Test
	void lowerCard() {
		Card lowCard = new Card("Hearts", "2 of Hearts", 2);
		Card highCard = new Card("Hearts", "King of Hearts", 13);
		assertFalse(lowCard.isHigherOrEqual(highCard));
	}
	
	@Test
	void equalCard() {
		Card lowCard = new Card("Hearts", "2 of Hearts", 2);
		Card highCard = new Card("Diamonds", "2 of Diamonds", 2);
		assertTrue(highCard.isHigherOrEqual(lowCard));
	}
	
	//find a card in the deck
	@Test
	void checkIfExists() {
		Card found = null;
		for(Card c : deck.getCards() ) {
			if(c.getValue() == 13 && c.getSuit().toLowerCase().equals("clubs")) {
				found = c;
			}
		}
		assertNotNull(found);
	}

}
