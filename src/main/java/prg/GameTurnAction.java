package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class GameTurnAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String higher;
    private String lower;

    private Deck deck;
    private Card currentCard;
    private Card nextCard;

    private int totalCards;

    public String execute() {
        deck = (Deck) session.get("deck");
        totalCards = deck.getTotalCards();
        if (nextCard == null) {
            nextCard = deck.getNextCard();
        }
        return SUCCESS;
    }

    public Map<String, Object> getSession() {
        return session;
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
    public Deck getDeck() {
        return deck;
    }
    public void setDeck(Deck deck) {
        this.deck = deck;
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
    public int getTotalCards() {
        return totalCards;
    }
    public void setTotalCards(int totalCards) {
        this.totalCards = totalCards;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}