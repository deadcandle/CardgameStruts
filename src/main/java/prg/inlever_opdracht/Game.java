package prg.inlever_opdracht;

import java.util.*;

public class Game {
	private static int score = 0;
	private static Card currentCard;
	private static Card nextCard;
	private static Deck deck;

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		deck = new Deck();
		nextCard = deck.getNextCard();
		currentCard = deck.getNextCard();
		gameTurn();
	}

	public static void gameTurn() {
		nextCard = deck.getNextCard();
		System.out.println("the card is " + currentCard + "\n" + "higher or lower?");
		String awnser = sc.nextLine();
		if (awnser.equalsIgnoreCase("higher") && nextCard.isHigherOrEqual(currentCard)) {
			System.out.println("correct! ");
			correct();
			return;
		}
		if (awnser.equalsIgnoreCase("lower") && !nextCard.isHigherOrEqual(currentCard)) {
			System.out.println("correct! ");
			correct();
		} else {
			gameOver();
		}
	}

	public static void correct() {
		score += 1;
		System.out.println("your points are now: " + score);
		currentCard = nextCard;
		gameTurn();
	}

	public static void gameOver() {
		System.out.println("the next card was: " + nextCard);
		System.out.println("game over! \nyour total points are: " + score);
	}

}
