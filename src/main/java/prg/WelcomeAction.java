package prg;

import com.opensymphony.xwork2.ActionSupport;
public class WelcomeAction extends ActionSupport {

    private static int score;
    private static Card currentCard;
    private static Card nextCard;
    private static Deck deck;

    public String execute() {

        if (currentCard == null) {

        }

        return SUCCESS;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        WelcomeAction.score = score;
    }

    public static Card getCurrentCard() {
        return currentCard;
    }

    public static void setCurrentCard(Card currentCard) {
        WelcomeAction.currentCard = currentCard;
    }

    public static Card getNextCard() {
        return nextCard;
    }

    public static void setNextCard(Card nextCard) {
        WelcomeAction.nextCard = nextCard;
    }

    public static Deck getDeck() {
        return deck;
    }

    public static void setDeck(Deck deck) {
        WelcomeAction.deck = deck;
    }
}
