package model;

//import com.mysql.jdbc.PreparedStatement;

import prg.GameTurnAction;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Db_connectie {
    private ArrayList<String> rows;
    private LocalDate date;
    GameTurnAction gta;


    public List<String> ophalenScores() {
        rows = new ArrayList<>();
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


    public void opslaanScoren(int score) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CardGame?characterEncoding=utf8", "root", "MOZs15jS!");
            String sql = "INSERT INTO playerlist (id, scoren, naam) VALUES (null, ?, ?);";
            PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql);

            statement.setInt(1, score);
            statement.setString(2, "player1" );

            statement.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> getRows() {
        return rows;
    }

    public void setRows(ArrayList<String> rows) {
        this.rows = rows;
    }

}
