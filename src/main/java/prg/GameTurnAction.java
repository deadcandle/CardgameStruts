package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Db_connectie;
import model.Deck;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class GameTurnAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String higher;
    private String lower;

    private Deck deck;
    private Card currentCard;
    private Card nextCard;

    private int totalCards;
    private int score = 0;

    private Db_connectie db = new Db_connectie();

    private ArrayList<ArrayList<String>> rij = new ArrayList<ArrayList<String>>();


    public String execute() {
        deck = (Deck) session.get("deck");
        currentCard = (Card) session.get("currentCard");
        nextCard = (Card) session.get("nextCard");
        score = (int) session.get("score");
        db = (Db_connectie) session.get("db");
        db.ophalenScores();
        rij.add(db.getRows());

        if (lower != null && nextCard.isHigherOrEqual(currentCard)) {
            db.opslaanScoren(getScore());
            session.clear();
            return ERROR;
        }
        if (higher != null && !nextCard.isHigherOrEqual(currentCard)) {
            db.opslaanScoren(getScore());
            session.clear();
            return ERROR;
        }
        totalCards = deck.getTotalCards();
        {
            currentCard = nextCard;
            nextCard = deck.getNextCard();
            score++;
            session.put("currentCard", currentCard);
            session.put("nextCard", nextCard);
            session.put("score", score);
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
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public ArrayList<ArrayList<String>> getRij() {
        return rij;
    }

    public void setRij(ArrayList<ArrayList<String>> rij) {
        this.rij = rij;
    }
}