package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpslaanDB {

    private List<String> rows = new ArrayList<>();


    public List<String> ophalenScores() {
        rows.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardgame?characterEncoding=utf8", "root", "MOZs15jS!");

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT scoren, naam FROM playerlist ORDER BY scoren desc LIMIT 10");

            while (resultSet.next()) {
                rows.add(resultSet.getInt("scoren") + " "+resultSet.getString("naam"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public void opslaanScoren(int score, String naam) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CardGame?characterEncoding=utf8", "root", "MOZs15jS!");
            String sql = "INSERT INTO playerlist (scoren, naam) VALUES (" + score + naam +");";
            Statement statement = connection.createStatement();
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
