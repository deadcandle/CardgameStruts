package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class WelcomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private boolean choseHigher;

    private int score;
    private Card currentCard;
    private Card nextCard;
    private Deck deck;

    public String execute() {
        if (!session.containsKey("deck")) {
            session.put("deck", new Deck());
            deck = (Deck) session.get("deck");
        } else {
            deck = (Deck) session.get("deck");
        }
        gameTurn();

        return SUCCESS;
    }

    public void gameTurn() {
        nextCard = deck.getNextCard();
        // laat currentCard zien aan de gebruiker
        // vraag hoger of lager
        if (choseHigher && currentCard.isHigherOrEqual(nextCard)) {
            correct();
        } else {
            gameOver();
        }
    }

    public void correct() {
        score++;
        currentCard = nextCard;
        // laat currentscore en cardsLeft(int) zien aan de gebruiker
        gameTurn();
    }

    public void gameOver() {
        // laat zien wat de volgende card was, wat de score is, en hoeveel kaarten de speler nog over had
    }

    public String chooseHigher() {
        choseHigher = true;
        return SUCCESS;
    }

    public String chooseLower() {
        choseHigher = false;
        return SUCCESS;
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