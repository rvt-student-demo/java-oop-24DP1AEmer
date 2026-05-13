package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sample {

    public static void main(String[] args) {
        String url = "jdbc:sqlite:todo.db";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS todo ("
                            + "id INTEGER PRIMARY KEY,"
                            + "task TEXT NOT NULL"
                            + ")"
            );

            stmt.executeUpdate(
                    "INSERT INTO todo(task) VALUES('Make a dance!')"
            );

            System.out.println("Todo table created and row inserted.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
