package model;

import java.sql.*;

public class OpslaanDB {

    private int scoren;

    public void ophalenScores() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CardGame", "root", "MOZs15jS!");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT scoren FROM playerlist ORDER BY scoren desc LIMIT 10;");

            while (resultSet.next()) {
                setScoren(resultSet.getInt("scoren"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void gameOver(int score) {
//        String url = "jdbc:mysql://localhost:3306/CardGame";
//        String username = "root";
//        String password = "MOZs15jS!";
//
//        try {
//            Connection con =  DriverManager.getConnection(url, username, password);
//            String sql = "INSERT INTO playerList (scoren) VALUES (?)";
//
//            PreparedStatement statement = con.prepareStatement(sql);
//            statement.setInt(1, score);
//
//            int rows = statement.executeUpdate();
//            if (rows > 0) {
//                System.out.println("nr");
//            }
//            statement.close();
//            con.close();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
//
//    public static void playerList() {
//        String url = "jdbc:mysql://localhost:3306/CardGame";
//        String username = "root";
//        String password = "MOZs15jS!";
//        String sql = "SELECT scoren FROM playerlist ORDER BY scoren desc LIMIT 10;";
//
//        try {
//            Connection con = DriverManager.getConnection(url, username, password);
//
//            Statement statement = con.createStatement();
//
//            ResultSet rs = statement.executeQuery(sql);
//
//            int count = 0;
//
//            while(rs.next()) {
//                int punten = rs.getInt(1);
//                count++;
//                System.out.println("number: " + count + " : points: " + punten);
//
//            }
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public int getScoren() {
        return scoren;
    }

    public void setScoren(int scoren) {
        this.scoren = scoren;
    }
}
