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
    private String higher;
    private String lower;

    private int score;
    private Card currentCard;
    private Card nextCard;
    private Deck deck;

    public String execute() {
        session.putIfAbsent("deck", new Deck());
        deck = (Deck) session.get("deck");

        session.putIfAbsent("currentCard", deck.getNextCard());
        currentCard = (Card) session.get("currentCard");
        nextCard = deck.getNextCard();
        if (choseHigher && currentCard.isHigherOrEqual(nextCard)) {
            score++;
            currentCard = nextCard;
            return SUCCESS;
        } else if (!choseHigher && !currentCard.isHigherOrEqual(nextCard)) {
            score++;
            currentCard = nextCard;
            return SUCCESS;
        } else {
            gameOver();
            return ERROR;
        }
    }

    public void gameOver() {
        System.out.println("je ging dood in een tragisch ongeval");
        // System.exit(0);
        // laat zien wat de volgende card was, wat de score is, en hoeveel kaarten de speler nog over had
    }

    public String chooseHigher() {
        choseHigher = true;
        System.out.println("choose higher");
        execute();
        return SUCCESS;
    }

    public String chooseLower() {
        choseHigher = false;
        System.out.println("choose lower");
        execute();
        return SUCCESS;
    }

    public String getHigher() {
        return higher;
    }

    public void setHigher(String higher) {
        this.higher = higher;
    }

    public String getLower() {
        return lower;
    }

    public void setLower(String lower) {
        this.lower = lower;
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