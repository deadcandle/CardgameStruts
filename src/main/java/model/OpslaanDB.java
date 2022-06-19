package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpslaanDB {

    private List<Integer> rows = new ArrayList<>();

// kan niet method in
    public List<Integer> ophalenScores() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cardgame?characterEncoding=utf8","root","MOZs15jS!");

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT scoren FROM playerlist ORDER BY scoren desc LIMIT 10");

            System.out.println(resultSet);
// limit niet werkt --> for loop gebruiken met 10 itterations
            while (resultSet.next()) {
                rows.add(resultSet.getInt("scoren"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rows;
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


    public List<Integer> getRows() {
        return rows;
    }

    public void setRows(List<Integer> rows) {
        this.rows = rows;
    }
}
