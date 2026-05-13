package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {

    private static final String DB_URL = "jdbc:sqlite:sample.db";

    public static void main(String[] args) {
        String createSql = "CREATE TABLE IF NOT EXISTS todo (id INTEGER PRIMARY KEY, task TEXT NOT NULL)";
        String insertSql = "INSERT INTO todo (id, task) VALUES (1, 'Make dance!')";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement()) {
            statement.execute(createSql);
            statement.executeUpdate(insertSql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
