package prg;

import com.opensymphony.xwork2.ActionSupport;
import model.Card;
import model.Deck;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.*;
import java.util.Map;

public class WelcomeAction extends ActionSupport implements SessionAware {

    private Map<String, Object> session;

    private boolean input;

    private String naam;

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

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
        currentCard = deck.getNextCard();
        gameTurn();
        playerList();
        return SUCCESS;
    }

    public void gameTurn() {
        nextCard = deck.getNextCard();
        if (input && currentCard.isHigherOrEqual(nextCard)) {
            correct();
        } else {
            gameOver();
        }
    }

    public void correct() {
        score++;
        currentCard = nextCard;

        gameTurn();
    }

    public void gameOver() {
        String url = "jdbc:mysql://localhost:3306/CardGame";
        String username = "root";
        String password = "MOZs15jS!";

        try {
            Connection con =  DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO playerList (scoren, naam) VALUES (?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, score);
            statement.setString(2, naam);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("nr");
            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public static void playerList() {
        String url = "jdbc:mysql://localhost:3306/CardGame";
        String username = "root";
        String password = "MOZs15jS!";
        String sql = "SELECT scoren, naam FROM playerlist ORDER BY scoren desc LIMIT 10;";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            int count = 0;

            while(rs.next()) {
                int punten = rs.getInt(1);
                int naam = rs.getInt(2);
                count++;
                System.out.println("number: " + count + " : points: " + punten + " naam: " + naam);

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String chooseHigher() {
        input = true;
        return SUCCESS;
    }

    public String chooseLower() {
        input = false;
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

    public boolean isInput() { return input; }

    public void setInput(boolean input) { this.input = input; }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}