package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import model.OpslaanDB;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameTurnAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;
    private String higher;
    private String lower;
    private Deck deck;
    private Card currentCard;
    private Card nextCard;
    private OpslaanDB db;
    private int totalCards;
    private List<Integer> rij = new ArrayList<>();
    private int score = 0;
    public String execute() {
        deck = (Deck) session.get("deck");
        currentCard = (Card) session.get("currentCard");
        nextCard = (Card) session.get("nextCard");
        score = (int) session.get("score");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardgame?characterEncoding=utf8", "root", "MOZs15jS!");

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT scoren FROM playerlist ORDER BY scoren desc LIMIT 10");

// limit niet werkt --> for loop gebruiken met 10 itterations
            while (resultSet.next()) {
                rij.add(resultSet.getInt("scoren"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (lower != null && nextCard.isHigherOrEqual(currentCard)) {
            opslaanScoren(score);
            session.clear();
            return ERROR;
        }
        if (higher != null && !nextCard.isHigherOrEqual(currentCard)) {
            opslaanScoren(score);
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

    public void opslaanScoren(int score) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CardGame?characterEncoding=utf8", "root", "MOZs15jS!");
            String sql = "INSERT INTO playerlist (scoren) VALUES (" + score + ");";
            Statement statement = connection.createStatement();
            statement.execute(sql);
            System.out.print("ja");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    public OpslaanDB getDb() {
        return db;
    }

    public void setDb(OpslaanDB db) {
        this.db = db;
    }

    public List<Integer> getRij() {
        return rij;
    }
}