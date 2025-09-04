package in.todoservlet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Tododbcon {

    private static final String URL = "jdbc:mysql://localhost:3306/todoitems";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public boolean insertTodoItem(Todoitemsmain todo) {
        String query = "INSERT INTO todoitems (currentDate, todoDesc, targetDate, todoStatus, credited_by, credited_date) VALUES (?, ?, ?, ?, ?, NEW())";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setTimestamp(1, new Timestamp(todo.getCurrentDate().getTime()));
            ps.setString(2, todo.getTodoDesc());
            ps.setTimestamp(3, new Timestamp(todo.getTargetDate().getTime()));
            ps.setString(4, todo.getTodoStatus());
            ps.setString(5, "admin"); 

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
