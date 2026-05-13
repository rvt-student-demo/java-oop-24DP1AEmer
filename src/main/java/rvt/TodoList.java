package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> tasks;
    private static final String DB_URL = "jdbc:sqlite:todolist.db";

    public TodoList() {
        this.tasks = new ArrayList<>();
        initDatabase();
        loadTasksFromDatabase();
    }

    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS todo ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "task TEXT NOT NULL"
                + ")";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Error initializing database: " + e.getMessage());
        }
    }

    private void loadTasksFromDatabase() {
        String sql = "SELECT task FROM todo ORDER BY id";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                tasks.add(rs.getString("task"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

    public void add(String task) {
        this.tasks.add(task);

        String sql = "INSERT INTO todo (task) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             var pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void remove(int number) {
        // number is 1-based in the exercise
        if (number > 0 && number <= tasks.size()) {
            String taskToRemove = tasks.get(number - 1);
            this.tasks.remove(number - 1);

            String sql = "DELETE FROM todo WHERE task = ?";

            try (Connection conn = DriverManager.getConnection(DB_URL);
                 var pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, taskToRemove);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error removing task: " + e.getMessage());
            }
        }
    }

    // Small demo showing the sample behavior from the exercise
    public static void main(String[] args) {
        TodoList list = new TodoList();
        list.add("go to the store");
        list.add("vacuum clean");
        list.print();

        list.remove(2);
        System.out.println();
        list.print();

        list.add("program");
        System.out.println();
        list.print();
    }
}

