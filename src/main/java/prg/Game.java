package prg;



import java.util.*;
import java.sql.*;


public class Game {
    private static int score = 0;
    private static String name;
    private static Card currentCard;
    private static Card nextCard;
    private static Deck deck;



    private static Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        System.out.println("Wat is je naam?");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        deck = new Deck();
        nextCard = deck.getNextCard();
        currentCard = deck.getNextCard();

        gameTurn();
    }



    public static void gameTurn() {
        nextCard = deck.getNextCard();
        System.out.println("the card is " + currentCard + "\n" + "Hoger of lager?");
        String awnser = sc.nextLine();
        if (awnser.equalsIgnoreCase("hoger") && nextCard.isHigherorEqual(currentCard)) {
            System.out.println("Goed! ");
            correct();
            return;
        }
        if (awnser.equalsIgnoreCase("lager") && !nextCard.isHigherorEqual(currentCard)) {
            System.out.println("Goed! ");
            correct();
        } else {
            gameOver();
        }
    }



    public static void correct() {
        score += 1;
        System.out.println("Je punten zijn nu: " + score);
        currentCard = nextCard;
        gameTurn();
    }



    public static void gameOver() {
        System.out.println("Je volgende kaart was: " + nextCard);
        System.out.println("Game over! \nJe totaal aantal punten zijn nu: " + score);
        String url = "jdbc:mysql://localhost:3306/CardGame";
        String username = "root";
        String password = "boris";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO playerList (scoren, naam) VALUES (?, ?)";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, score);
            statement.setString(2, name);

            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("nr");
            }
            statement.close();
            con.close();
            playerList();
        } catch (SQLException e) {
            System.out.println(e);
        }



    }
    public static void playerList() {
        String url = "jdbc:mysql://localhost:3306/CardGame";
        String username = "root";
        String password = "boris";

        try {
            Connection con = DriverManager.getConnection(url, username, password);

            String sql = "SELECT scoren, naam FROM playerlist ORDER BY scoren desc;";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultaat = statement.executeQuery(sql);

            int count = 0;

            while(resultaat.next()) {
                int punten = resultaat.getInt(1);
                String naam = resultaat.getString(2);
                count++;
                System.out.println("number: " + count + " : points: " + punten + ", name: " + naam);

            }
            con.close();

        } catch (SQLException e) {
            System.out.println(e);
        }



    }
}