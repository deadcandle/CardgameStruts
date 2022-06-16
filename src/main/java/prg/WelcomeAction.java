package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class WelcomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private int score;
    private String choice;
    private Card currentCard;
    private Card nextCard;
    private Deck deck;

    public void print(Object o) {
        System.out.println(o);
    }

    public String execute() {
        if (!session.containsKey("deck")) {
            session.put("deck", new Deck());
            deck = (Deck) session.get("deck");
        } else {
            deck = (Deck) session.get("deck");
        }
        if (!session.containsKey("currentCard")) {
            session.put("currentCard", deck.getNextCard());
            currentCard = (Card) session.get("currentCard");
        } else {
            currentCard = (Card) session.get("currentCard");
        }
        gameTurn();
        return SUCCESS;
    }

    public void gameTurn() {
        nextCard = deck.getNextCard();
        print("next card: " + nextCard.getValue());
        if (choice != null) {
            if (choice.equals("higher") && currentCard.isHigherOrEqual(nextCard)) {
                correct();
            } else if (choice.equals("lower") && !(currentCard.isHigherOrEqual(nextCard))) {
                correct();
            } else {
                gameOver();
            }
            choice = null;
        }
    }

    public void correct() {
        score++;
        currentCard = nextCard;
        // laat currentscore en cardsLeft(int) zien aan de gebruiker
        gameTurn();
    }

    public void gameOver() {
        print("game over - score: " + score + " - cards left: " + deck.getCards().size());
    }

    public String getChoice() {
        return choice;
    }
    public void setChoice(String choice) {
        this.choice = choice;
    }
    public Map<String, Object> getSession() {
        return session;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Card getCurrentCard() {
        return currentCard;
    }
    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }
    public Card getNextCard() {
        return nextCard;
    }
    public void setNextCard(Card nextCard) {
        this.nextCard = nextCard;
    }
    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}