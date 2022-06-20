package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnector {
    public void connect() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardgame", "root", "boris");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
